package com.aaa.service.impl;

import com.aaa.entity.Customers;
import com.aaa.mapper.CustomersMapper;
import com.aaa.service.ICustomersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class CustomersServiceImpl implements ICustomersService {
    @Resource
    CustomersMapper customersMapper;
    @Override
    public Customers customerslogin(Customers customers) {
        return customersMapper.find(customers);
    }
}
