package com.yuan.springcloud.scsrv.web.Feign;

import com.yuan.springcloud.scsrv.dao.entity.User;
import com.yuan.springcloud.scsrv.web.Feign.impl.FeignScsrvFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="scsrv",fallback = FeignScsrvFallback.class)
public interface FeignScsrv {

    @RequestMapping(value="User/findById",method = RequestMethod.GET)
    @ResponseBody
    public User findById(@RequestParam(value = "id") String id);

    @RequestMapping(value="Test/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello();

    @RequestMapping(value="Test/test",method = RequestMethod.GET)
    @ResponseBody
    public String test();
}
