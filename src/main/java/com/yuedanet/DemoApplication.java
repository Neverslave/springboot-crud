package com.yuedanet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mybatis mapper 包路径
@MapperScan(basePackages = "com.yuedanet.mapper")
//扫描需要的包，包含一些自用的工具包类

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
