package com.yuan.springcloud.scsrv.service;

import java.util.Date;

public interface ICacheService {

    Boolean add(String key, String value);
    Boolean add(String key, String value, Date expiry);
    Boolean set(String key, String value, Date expiry);
    String  get(String key);
}
