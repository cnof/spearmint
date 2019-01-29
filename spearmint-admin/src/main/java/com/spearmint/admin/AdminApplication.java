package com.spearmint.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 33992
 * @date 2019/1/29 14:40
 */
@SpringBootApplication
@ComponentScan("com.spearmint.admin")
@MapperScan("com.spearmint.admin.mapper")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
