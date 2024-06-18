package com.zero.zengy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zero.zengy.mapper") // 这里填写你的Mapper接口所在的包名
public class ZengyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZengyApplication.class, args);
    }

}
