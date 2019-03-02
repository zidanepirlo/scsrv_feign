package com.yuan.springcloud.scsrv.service;


import com.yuan.springcloud.scsrv.dao.entity.User;

public interface IUserService {
    void addUser(User user);
    User getUserById(String userId);
}
