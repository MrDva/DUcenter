package com.itjizhiyong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.itjizhiyong.spring.mapper")
public class SpringServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringServiceApplication.class,args);
    }
}
