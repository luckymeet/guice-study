package com.study.dao;

import com.google.inject.Singleton;

@Singleton
public class UserDaoImpl implements UserDao {

    public void getUser() {
        System.out.println("get user name is ac");
    }

}
