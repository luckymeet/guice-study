package com.study.dao;

import com.google.inject.Singleton;

@Singleton
public class UserDaoImpl implements UserDao {

    public String getUser() {
        System.out.println("get user name is ac");
        return null;
    }

}
