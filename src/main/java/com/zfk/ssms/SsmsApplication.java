package com.zfk.ssms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zfk.ssms.mapper")
@SpringBootApplication
public class SsmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmsApplication.class, args);
    }

}
