package com.jiuli.liping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling
@MapperScan("com.jiuli.liping.dao")
public class LipingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LipingApplication.class, args);
    }

}
