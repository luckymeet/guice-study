package com.study.module;

import com.google.inject.AbstractModule;
import com.study.common.mybatis.MybatisManager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Set;

public class PublicMoudle extends AbstractModule {
    @Override
    protected void configure() {
        MybatisManager mybatisManager = new MybatisManager();
        SqlSessionFactory sqlSessionFactory = mybatisManager.createSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Set<Class<? extends Class<?>>> mapperClassSet = mybatisManager.getMapperClassSet();
        for (Class clazz : mapperClassSet) {
            bind(clazz).toInstance(sqlSession.getMapper(clazz));
        }
    }
}
