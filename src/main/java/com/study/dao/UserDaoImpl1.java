package com.study.dao;

import javax.inject.Singleton;

@Singleton
public class UserDaoImpl1 implements UserDao {

    @Override
    public String getUser() {
        return "get user name is ac";
    }

}
