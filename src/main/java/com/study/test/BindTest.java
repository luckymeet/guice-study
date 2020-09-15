package com.study.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.study.module.UserModule;
import com.study.service.UserServiceImpl;

public class BindTest {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new UserModule());
        UserServiceImpl service1 = injector.getInstance(UserServiceImpl.class);
        service1.getUser();
        UserServiceImpl service2 = injector.getInstance(UserServiceImpl.class);
        service2.getUser();
    }

}
