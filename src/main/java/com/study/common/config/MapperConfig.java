package com.study.common.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.Set;

public abstract class MapperConfig {

    private Set<Class<? extends Class<?>>> mapperClassSet;

    public SqlSessionFactory createSqlSessionFactory() {
        DataSource dataSource = dataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        Set<Class<? extends Class<?>>> mapperSet = this.findMapperClass();
        for (Class<?> mapperClass : mapperSet) {
            configuration.addMapper(mapperClass);
        }
        configuration.addLoadedResource("mapper");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

    protected Set<Class<? extends Class<?>>> findMapperClass() {
        ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<>();
        resolverUtil.find(new ResolverUtil.AnnotatedWith(Mapper.class), mapperPackage());
        mapperClassSet = resolverUtil.getClasses();
        return mapperClassSet;
    }

    public Set<Class<? extends Class<?>>> getMapperClassSet() {
        return mapperClassSet;
    }

    public abstract String mapperPackage();

    public abstract DataSource dataSource();
}
