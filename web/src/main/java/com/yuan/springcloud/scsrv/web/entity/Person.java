package com.yuan.springcloud.scsrv.web.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Person
 *
 * @author yuanqing
 * @create 2019-02-13 10:01
 **/


@Setter
@Getter
public class Person implements Serializable {
    private String name;
    private Integer age;
    private String addr;

    public Person(){
    }

    public Person(String name, Integer age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age='" + age + '\'' +
                ", addr=" + addr +
                '}';
    }
}
