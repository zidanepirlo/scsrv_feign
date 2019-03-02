package com.yuan.springcloud.scsrv.service.impl;


import com.yuan.springcloud.scsrv.dao.domain.IUserDao;
import com.yuan.springcloud.scsrv.dao.entity.User;
import com.yuan.springcloud.scsrv.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserDao userDao;


    public void addUser(User user) {
      String id = userDao.insert(user);
      logger.info("addUser id={}",id);
    }

    public User getUserById(String userId) {
        return userDao.findById(userId);
    }

}
