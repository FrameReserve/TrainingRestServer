package com.training.core.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

import com.training.core.entity.MongodbBaseEntity;
import com.training.core.util.EntityColumnUtil;

/**
 * 查询条件集合
 */
public class CriteriaDto<T extends MongodbBaseEntity> {

	public CriteriaDto() {
		super();
	}
	
	public CriteriaDto(Class<T> entityClass) {
		super();
		Table table = entityClass.getAnnotation(Table.class);
		if (null == table) {
			throw new RuntimeException("实体："+entity.getClass().getName()+"  ,  请配置注解@Table");
		}
		this.entityCls = entityClass;
		this.tableName = table.name();
		this.primaryKey = "id";
	}
	
	public CriteriaDto(Class<T> entityClass, String entityId) {
		super();
		Table table = entityClass.getAnnotation(Table.class);
		if (null == table) {
			throw new RuntimeException("实体："+entity.getClass().getName()+"  ,  请配置注解@Table");
		}
		this.entityCls = entityClass;
		this.tableName = table.name();
		this.primaryKey = "id";
		this.entityId = entityId;
	}
	
	public CriteriaDto(T entity) {
		super();
		this.entity = entity;
		this.entityId = entity.getId()+"";
		this.entityCls = (Class<T>) entity.getClass();
		Table table = entity.getClass().getAnnotation(Table.class);
		if (null == table) {
			throw new RuntimeException("实体："+entity.getClass().getName()+"  ,  请配置注解@Table");
		}
		this.tableName = table.name();
		this.primaryKey = "id";
		this.queryLikes = EntityColumnUtil.generateEntityQueryLike(entity);
	}

	/**
	 * 实体，动态反射查询条件（表名、属性、类型）
	 */
	private T entity;
	
	/**
	 * 实体类型
	 */
	private Class<T> entityCls;
	
	/**
	 * 主键列名
	 */
	private String primaryKey;
	
	/**
	 * 实体Id
	 */
	private String entityId;
	
	/**
	 * 表名
	 */
	private String tableName;
	
	/**
	 * 查询条件集合
	 */
	private List<QueryLike> queryLikes = new ArrayList<QueryLike>();
	
	/**
	 * Group By 列名，多个以,间隔
	 */
	private String groupByName;
	
	/**
	 * 分页、排序条件
	 */
	private FlexiPageDto flexiPageDto;
	
	// -------------------------- getter and setter -----------------------------
	
	public CriteriaDto<T> addQueryLike(QueryLike queryLike){
		this.getQueryLikes().add(queryLike);
		return this;
	}
	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<QueryLike> getQueryLikes() {
		return queryLikes;
	}

	public void setQueryLikes(List<QueryLike> queryLikes) {
		this.queryLikes = queryLikes;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public FlexiPageDto getFlexiPageDto() {
		return flexiPageDto;
	}

	public void setFlexiPageDto(FlexiPageDto flexiPageDto) {
		this.flexiPageDto = flexiPageDto;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getGroupByName() {
		return groupByName;
	}

	public void setGroupByName(String groupByName) {
		this.groupByName = groupByName;
	}

	public Class<T> getEntityCls() {
		return entityCls;
	}

	public void setEntityCls(Class<T> entityCls) {
		this.entityCls = entityCls;
	}

}
