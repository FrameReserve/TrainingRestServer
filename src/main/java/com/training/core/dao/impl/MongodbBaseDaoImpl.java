package com.training.core.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Table;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.training.core.dao.MongodbBaseDao;
import com.training.core.dto.CriteriaDto;
import com.training.core.dto.FlexiPageDto;
import com.training.core.dto.QueryLike;
import com.training.core.dto.QueryLike.LikeMode;
import com.training.core.entity.MongodbBaseEntity;
import com.training.core.util.EntityColumnUtil;
import com.training.core.util.ValidateUtil;

@Repository("mongodbBaseDao")
public class MongodbBaseDaoImpl<T extends MongodbBaseEntity> implements MongodbBaseDao<T> {

	@Resource
	private MongoTemplate mongoTemplate;

	@Override
	public T getEntityById(Class<T> cls, String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), cls, getTableNameThrowException(cls));
	}

	@Override
	public void addEntity(T entity) {
		mongoTemplate.insert(entity, getTableNameThrowException(entity.getClass()));
	}

	@Override
	public void updateEntity(T entity) {
		entity.setLastModifyTime(new Date());
		List<QueryLike> queryLikes = EntityColumnUtil.generateEntityQueryLike(entity);
		
		Update update = new Update();
		for (QueryLike queryLike : queryLikes) {
			if (queryLike.getIsTransient()) {
				continue;
			}
			update.set(queryLike.getColumnName(), queryLike.getValue());
		}
		
		mongoTemplate.upsert(new Query(Criteria.where("id").is(entity.getId())), update, entity.getClass(), getTableNameThrowException(entity.getClass()));
	}

	@Override
	public void deleteEntityById(Class<T> cls, String id) {
		mongoTemplate.remove(new Query(Criteria.where("id").is(id)), cls, getTableNameThrowException(cls));
	}

	@Override
	public List<T> findAll(Class<T> cls) {
		List<T> result = mongoTemplate.find(new Query(), cls, getTableNameThrowException(cls));
		return result;
	}

	@Override
	public List<T> findByLike(CriteriaDto<T> criteriaDto) {
		Query query = this.generateCriteriaByQueryLike(criteriaDto.getQueryLikes());
		List<T> result = mongoTemplate.find(query, criteriaDto.getEntityCls(), getTableNameThrowException(criteriaDto.getEntityCls()));  
        return result;
	}

	@Override
	public List<T> findByPage(CriteriaDto<T> criteriaDto, FlexiPageDto flexiPageDto) {
		Query query = this.generateCriteriaByQueryLike(criteriaDto.getQueryLikes());
		query.skip(flexiPageDto.getOffset());// skip相当于从那条记录开始  
        query.limit(flexiPageDto.getRp());// 从skip开始,取多少条记录  
        if (!ValidateUtil.isEmpty(flexiPageDto.getSortName()) && !ValidateUtil.isEmpty(flexiPageDto.getSortOrder())) {
			if (FlexiPageDto.SORTORDER_DESC.equals(flexiPageDto.getSortOrder())) {
				query.with(new Sort(Direction.DESC, flexiPageDto.getSortName()));
			} else {
				query.with(new Sort(Direction.ASC, flexiPageDto.getSortName()));
			}
		}
		List<T> result = mongoTemplate.find(query, criteriaDto.getEntityCls(), getTableNameThrowException(criteriaDto.getEntityCls()));
		return result;
	}

	@Override
	public long findRowCount(CriteriaDto<T> criteriaDto) {
		Query query = this.generateCriteriaByQueryLike(criteriaDto.getQueryLikes());
		long count = mongoTemplate.count(query, criteriaDto.getEntityCls(), getTableNameThrowException(criteriaDto.getEntityCls()));
		return count;
	}
	
	// 生成Mongodb 查询对象
	private Query generateCriteriaByQueryLike(List<QueryLike> queryLikes) {
		Query query = new Query();
		for (QueryLike queryLike : queryLikes) {
			if (ValidateUtil.isEmpty("columnName", queryLike) || ValidateUtil.isEmpty("value", queryLike)) {
				continue;
			}
			if (LikeMode.Eq.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).regex(queryLike.getValue().toString()));
			} else if (LikeMode.NotEq.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).regex("/^(?!"+queryLike.getValue().toString()+"$)/"));
			} else if (LikeMode.Ne.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).ne(queryLike.getValue()));
			} else if (LikeMode.Gt.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).gt(queryLike.getValue()));
			} else if (LikeMode.Ge.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).gte(queryLike.getValue()));
			} else if (LikeMode.Lt.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).lt(queryLike.getValue()));
			} else if (LikeMode.Le.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).lte(queryLike.getValue()));
			} else if (LikeMode.Between.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).gte(queryLike.getValue()));
				query.addCriteria(Criteria.where(queryLike.getColumnName()).lte(queryLike.getValue2()));
			} else if (LikeMode.IsNull.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).not());
			} else if (LikeMode.IsNotNull.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).ne(null));
			} else if (LikeMode.Custom.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(queryLike.getCriteria());
			} else if (LikeMode.Like.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).regex(".*?\\" +queryLike.getValue().toString()+ ".*"));
			} else if (LikeMode.LikeSta.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).regex(".*?\\" +queryLike.getValue().toString()+ "."));
			} else if (LikeMode.LikeEnd.getCode().equals(queryLike.getLikeMode().getCode())) {
				query.addCriteria(Criteria.where(queryLike.getColumnName()).regex(".?\\" +queryLike.getValue().toString()+ ".*"));
			}
		}
		return query;
	}

	/**
	 * 根据实体注解，获取表名，如果没有则抛出异常
	 */
	private String getTableNameThrowException(Class<? extends MongodbBaseEntity> cls) {
		Table table = cls.getAnnotation(Table.class);
		if (null == table || null == table.name() || 0 == table.name().trim().length()) {
			throw new RuntimeException("实体：" + cls.getName() + "  ,  请配置注解Table");
		}
		return table.name();
	}

}
