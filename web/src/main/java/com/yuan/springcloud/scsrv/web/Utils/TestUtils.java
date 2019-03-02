package com.yuan.springcloud.scsrv.web.Utils;


import com.yuan.springcloud.scsrv.web.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * testUtils
 *
 * @author yuanqing
 * @create 2019-02-17 09:23
 **/

public class TestUtils {

   public static List<Person> persons = new ArrayList<>();
   static {
       Person person1 = new Person("z3",20,"shanghhai");
       Person person2 = new Person("l4",25,"beijing");
       Person person3 = new Person("w5",30,"tianjing");
       persons.add(person1);
       persons.add(person2);
       persons.add(person3);
   }

    private TestUtils(){
    }


}
