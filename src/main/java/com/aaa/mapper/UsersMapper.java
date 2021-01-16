package com.aaa.mapper;

import com.aaa.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {
    Users find(Users users);
}
