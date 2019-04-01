package com.yuan.springcloud.scsrv.web.controller;

import com.yuan.springcloud.scsrv.service.ICacheService;
import com.yuan.springcloud.scsrv.web.Utils.TestUtils;
import com.yuan.springcloud.scsrv.web.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * TestController
 *
 * @author yuanqing
 * @create 2019-02-12 21:12
 **/
@Controller
@RequestMapping("/Test/*")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private ICacheService iCacheService;

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "test_for_jrebel_1_2";
//        return "test";
    }

    @RequestMapping("add")
    @ResponseBody
    public Integer add(int a, int b) {
        return a + b;
    }

    @RequestMapping(value = "/welcome")
    @ResponseBody
    public String hello() {
        logger.info("hello,springmvc");
        return "hello";
    }

    @RequestMapping(value = "/getPerson")
    @ResponseBody
    public Person getPerson() {

        Person person = new Person();
        person.setName("yuanqing");
        person.setAddr("shanghai");
        return person;
    }

    @RequestMapping(value = "/findAllPersons")
    @ResponseBody
    public List<Person> findAllPersons() {
        return TestUtils.persons;
    }

    @RequestMapping(value = "/RbEntity")
    @ResponseBody
    public void RbEntity(@RequestBody Person perosn) {
        logger.info("person={}",perosn);
    }

    @RequestMapping(value = "/RbList")
    @ResponseBody
    public void RbList(@RequestBody List<Person> personns) {
        for (Person person : personns) {
            logger.info("person={}", person);
        }
    }

}
