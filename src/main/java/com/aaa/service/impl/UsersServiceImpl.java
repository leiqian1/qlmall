package com.aaa.service.impl;

import com.aaa.entity.Users;
import com.aaa.mapper.UsersMapper;
import com.aaa.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements IUsersService {
    //定义mapper数据库访问对象
    @Resource
    private UsersMapper usersMapper;
    @Override
    public Users adminLogin(Users users) {
        return usersMapper.find(users);
    }
}
