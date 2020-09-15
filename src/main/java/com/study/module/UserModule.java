package com.study.module;

import com.google.inject.AbstractModule;
import com.study.dao.UserDao;
import com.study.dao.UserDaoImpl;
import com.study.service.UserService;
import com.study.service.UserServiceImpl;

public class UserModule extends AbstractModule {
    protected void configure() {
        bind(UserDao.class).to(UserDaoImpl.class);
//        bind(UserService.class).to(UserServiceImpl.class);
    }
}
