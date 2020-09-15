package com.study.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.study.dao.UserDao;

@Singleton
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    public void getUser() {
        userDao.getUser();
    }
}
