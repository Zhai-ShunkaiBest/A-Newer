package com.cliffside.springboot_scaffold;


import com.cliffside.springboot_scaffold.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringBootScaffoldApplicationTests {

    @Autowired
    Person person;

    @Test
    void contextLoads1() {
        System.out.println(person);
    }

}
