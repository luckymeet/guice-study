package com.study.module;

import com.google.inject.AbstractModule;
import com.study.common.mybatis.MybatisManager;
import com.study.common.mybatis.SqlSessionTemplate;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Set;

public class PublicMoudle extends AbstractModule {
    @Override
    protected void configure() {
        mapperConfig();
    }

    private void mapperConfig() {
        MybatisManager mybatisManager = new MybatisManager();
        SqlSessionFactory sqlSessionFactory = mybatisManager.createSqlSessionFactory();
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        Set<Class<? extends Class<?>>> mapperClassSet = mybatisManager.getMapperClassSet();
        for (Class clazz : mapperClassSet) {
            bind(clazz).toInstance(sqlSessionTemplate.getMapper(clazz));
        }
        bind(SqlSessionFactory.class).toInstance(sqlSessionFactory);
        bind(SqlSession.class).toInstance(sqlSessionTemplate);
    }
}
