package com.yuan.springcloud.scsrv.web.controller;

import com.yuan.springcloud.scsrv.dao.entity.User;
import com.yuan.springcloud.scsrv.service.IMUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * UserController
 *
 * @author yuanqing
 * @create 2019-02-19 14:20
 **/

@Controller
@RequestMapping("/WFUser/*")
public class UserWFController {

    private static final Logger logger = LoggerFactory.getLogger(UserWFController.class);

    @Autowired
    private IMUserService imUserService;


    @RequestMapping("findById")
    @ResponseBody
    public Mono<User> findById(String id) throws Exception {

        try{
            Mono<User> user = imUserService.getById(id);
            logger.info("findById user={}",user);
            return user;
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
    }
    @RequestMapping("findByName")
    @ResponseBody
    public Flux<User> findByName(String name) throws Exception {

        try{
            Flux<User> user = imUserService.getByName(name);
            logger.info("findById user={}",user);
            return user;
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
    }


}
