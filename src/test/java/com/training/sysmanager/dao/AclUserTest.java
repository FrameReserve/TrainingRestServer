package com.training.sysmanager.dao;

import com.training.base.BaseTest;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created by Athos on 2016-06-30.
 */
public class AclUserTest extends BaseTest {
    @Resource
    @Qualifier("sessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

//    private synchronized SqlSession getSqlSession(){
//        if(null == sqlSession){
//            this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
//        }
//        return this.sqlSession;
//    }
    private AclUserMapper getMapper(){
        sqlSession = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSession.getMapper(AclUserMapper.class);
    }

    @Test
    public void testMybatis(){
        this.getMapper().getAclUserById();
    }

}
