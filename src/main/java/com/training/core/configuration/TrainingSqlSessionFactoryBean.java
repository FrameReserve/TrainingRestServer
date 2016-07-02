package com.training.core.configuration;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.NestedIOException;

import java.io.IOException;

/**
 * Created by Athos on 2016-06-29.
 */
public class TrainingSqlSessionFactoryBean extends SqlSessionFactoryBean {

    @Override
    protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
        try {
            return super.buildSqlSessionFactory();
        } catch (NestedIOException e) {
            e.printStackTrace(); // XML 有错误时打印异常。
            throw new RuntimeException(e.getMessage());
        } finally {
            ErrorContext.instance().reset();
        }
    }
}
