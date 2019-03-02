package com.yuan.springcloud.scsrv.service.impl;

import com.yuan.springcloud.scsrv.dao.domain.IUserDao;
import com.yuan.springcloud.scsrv.dao.entity.User;
import com.yuan.springcloud.scsrv.service.IMUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * MUserServiceImpl
 *
 * @author yuanqing
 * @create 2019-02-20 14:05
 **/
@Service
public class MUserServiceImpl implements IMUserService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserDao userDao;

    @Override
    public Mono<User> getById(String userId) throws Exception {
        Mono<User> user = Mono.justOrEmpty(userDao.findById(userId));
        return user;
    }

    @Override
    public Flux<User> getByName(String name) throws Exception {
        return Flux.fromIterable(userDao.findByName(name));
    }

}
