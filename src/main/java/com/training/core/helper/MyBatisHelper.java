package com.training.core.helper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import javax.annotation.Resource;

/**
 * Created by Athos on 2016-07-02.
 */
@Repository
public class MyBatisHelper {
    @Resource
    @Qualifier("sessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    public synchronized SqlSession getSqlSession(){
        System.out.println(sqlSessionFactory);
        if (null == sqlSession){
            this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
        }
        return this.sqlSession;
    }

    public <T extends BaseMapper> T getMapper(Class<T> cls){
       return getSqlSession().getMapper(cls);
    }
}
