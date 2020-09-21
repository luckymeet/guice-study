package com.study.service;

import com.google.inject.ImplementedBy;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {

    String getUser();

}
