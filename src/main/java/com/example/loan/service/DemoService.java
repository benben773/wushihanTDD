package com.example.loan.service;

import com.example.loan.mapper.entity.DemoEntity;
import com.example.loan.service.input.DemoForm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DemoService {
    private ThirdService thirdService;

    public DemoService(ThirdService thirdService) {
        this.thirdService = thirdService;
    }


    public String sayHello() {
        return thirdService.sayHello();
    }

    public DemoEntity add(DemoForm demoForm) {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName("demo");
        demoEntity.setCreatedAt(LocalDateTime.now());
        demoEntity.setUpdatedAt(LocalDateTime.now());
        demoEntity.setId(1L);
        return demoEntity;
    }
}
