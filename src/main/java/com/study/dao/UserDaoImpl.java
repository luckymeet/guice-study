package com.study.dao;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("userDaoImpl")
public class UserDaoImpl implements UserDao {

    @Override
    public String getUser() {
        return "get user name is ac";
    }

}
