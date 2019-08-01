package com.kangswx.springbootmybatisredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages ="com.kangswx.springbootmybatisredis.mapper")
@SpringBootApplication
public class SpringbootMybatisRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisRedisApplication.class, args);
    }

}
