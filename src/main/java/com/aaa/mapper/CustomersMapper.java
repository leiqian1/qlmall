package com.aaa.mapper;

import com.aaa.entity.Customers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomersMapper {
    Customers find(Customers customers);
}
