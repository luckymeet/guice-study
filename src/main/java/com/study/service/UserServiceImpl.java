package com.study.service;

import com.google.inject.Inject;
import com.study.dao.UserDao;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class UserServiceImpl implements UserService {

    @Inject
    @Named("userDaoImpl")
    private UserDao userDao;

    @Override
    public String getUser() {
        return userDao.getUser();
    }
}
