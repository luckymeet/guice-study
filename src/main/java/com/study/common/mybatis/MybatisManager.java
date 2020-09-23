package com.study.common.mybatis;

import com.study.common.config.MapperConfig;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.inject.Singleton;
import javax.sql.DataSource;

@Singleton
public class MybatisManager extends MapperConfig {

    @Override
    public String mapperPackage() {
        return "com.study";
    }

    @Override
    public DataSource dataSource() {
        return new PooledDataSource("com.mysql.cj.jdbc.Driver", "jdbc:mysql://39.105.58.23:3306/test?serverTimezone=UTC", "root", "root.ycw");
    }
}
