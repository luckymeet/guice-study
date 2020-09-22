package com.study.service;

import com.google.inject.ImplementedBy;
import com.study.entity.User;

import java.util.List;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {

    List<User> selectUser();

}
