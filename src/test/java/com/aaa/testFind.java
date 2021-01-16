package com.aaa;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aaa.entity.Users;
import com.aaa.mapper.UsersMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testFind {

    @Resource
    private UsersMapper usersMapper;

    @Test
    public void f1() {
        Users users=new Users();
        users.setUserName("test1");
        users.setPassword("test2");
        Users u=usersMapper.find(users);
        System.out.println(u.getUserName());
    }
}
