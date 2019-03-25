package com.httpapi.bmt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@MapperScan("com.httpapi.bmt.dao")
@EnableSwagger2
public class BmyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmyApplication.class, args);
    }

}
