package com.example.loan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.loan.mapper")
public class LoanServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanServerApplication.class, args);
    }

    @GetMapping
    public String hello() {
        return "hello";
    }
}
