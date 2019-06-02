package com.yuan.springcloud.scsrv.web.controller;

import com.yuan.springcloud.scsrv.dao.entity.User;
import com.yuan.springcloud.scsrv.web.Feign.FeignScsrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * FeignController
 *
 * @author yuanqing
 * @create 2019-04-06 18:45
 **/
@Controller
@RequestMapping("/Feign/*")
public class FeignController {

    @Autowired
    private FeignScsrv feignScsrv;

    @GetMapping("/User/findById")
    @ResponseBody
    public User findById( String id){
        return feignScsrv.findById(id);
    }

    @GetMapping("/Test/hello")
    @ResponseBody
    public String hello(){
        return feignScsrv.hello();
    }

    @GetMapping("/Test/test")
    @ResponseBody
    public String test(){
        return feignScsrv.test();
    }
}
