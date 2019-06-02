package com.yuan.springcloud.scsrv.web.Feign.impl;

import com.yuan.springcloud.scsrv.dao.entity.User;
import com.yuan.springcloud.scsrv.web.Feign.FeignScsrv;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FeignScsrvFallback
 *
 * @author yuanqing
 * @create 2019-04-07 07:38
 **/

@Component
public class FeignScsrvFallback implements FeignScsrv {

    @Override
    public User findById(String id) {
        User user = new User();
        user.setId("0");
        user.setName("0");
        return user;
    }

    @Override
    public String hello() {
        return "call hello fail";
    }

    @Override
    public String test() {
        return "call test fail";
    }
}
