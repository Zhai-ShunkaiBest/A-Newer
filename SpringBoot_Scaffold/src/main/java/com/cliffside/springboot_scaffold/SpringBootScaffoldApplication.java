package com.cliffside.springboot_scaffold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringBootScaffoldApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootScaffoldApplication.class, args);

    }

}
