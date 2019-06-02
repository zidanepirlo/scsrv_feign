package com.yuan.springcloud.scsrv.web.controller;

import com.yuan.springcloud.scsrv.dao.domain.IUserDao;
import com.yuan.springcloud.scsrv.dao.entity.User;
import com.yuan.springcloud.scsrv.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController
 *
 * @author yuanqing
 * @create 2019-02-19 14:20
 **/

@Controller
@RequestMapping("/User/*")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserService iUserService;

    @RequestMapping("findByName")
    @ResponseBody
    public List<User> findByName(String name) {
        List<User> users = userDao.findByName(name);
        logger.info("findByName");
        for (User user:users){
            logger.info("user={}",user);
        }
        return users;
    }

    @GetMapping("findById")
    @ResponseBody
    public User findById(String id) {
        User user = userDao.findById(id);
        logger.info("findById user={}",user);
        return user;
    }

    @GetMapping("findByIdAndName")
    @ResponseBody
    public List<User> findByIdAndName(String id,String name) {
        List<User> users = userDao.findByIdAndName(id,name);
        logger.info("findByIdAndName");
        for (User user:users){
            logger.info("user={}",user);
        }
        return users;
    }

    @PostMapping(value = "/addUser")
    @ResponseBody
    public boolean addUser(@RequestBody User user) {
        try{
            iUserService.addUser(user);
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            return false;
        }
        return true;
    }
}
