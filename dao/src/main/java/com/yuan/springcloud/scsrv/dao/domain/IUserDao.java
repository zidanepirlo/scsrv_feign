package com.yuan.springcloud.scsrv.dao.domain;



import com.yuan.springcloud.scsrv.dao.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {

    String insert(User user);
    User findById(@Param("id") String id);
    List<User> findByName(@Param("name") String name);
    List<User> findByIdAndName(@Param("id") String id, @Param("name") String name);
}
