package com.study.service;

import com.google.inject.Inject;
import com.study.entity.User;
import com.study.mapper.UserMapper;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UserServiceImpl implements UserService {

    @Inject
    private UserMapper userMapper;

    @Override
    public List<User> selectUser() {
        return userMapper.selectUser();
    }
}
