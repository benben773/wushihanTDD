package com.example.loan.controller;

import com.example.loan.mapper.entity.DemoEntity;
import com.example.loan.service.DemoService;
import com.example.loan.service.input.DemoForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo")
public class DemoController {
    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }


    @GetMapping
    public String test() {
        return demoService.sayHello();
    }

    @PostMapping
    public DemoEntity add(@RequestBody DemoForm demoForm) {
        return demoService.add(demoForm);
    }

}
