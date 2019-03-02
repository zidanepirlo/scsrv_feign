package com.yuan.springcloud.scsrv.service;

import com.yuan.springcloud.scsrv.dao.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IMUserService {
    Mono<User> getById(String userId) throws Exception;
    Flux<User> getByName(String name) throws Exception;
}
