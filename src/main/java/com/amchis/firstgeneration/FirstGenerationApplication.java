package com.amchis.firstgeneration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.amchis.firstgeneration")
public class FirstGenerationApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstGenerationApplication.class, args);
    }

}
