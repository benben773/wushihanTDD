package com.example.loan.controller;

import com.example.loan.bo.UserLoanPlanMaterial;
import com.example.loan.service.LoanPlanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("loan-plans")
public class LoanController {
    private final LoanPlanService loanPlanService;

    public LoanController(LoanPlanService loanPlanService) {
        this.loanPlanService = loanPlanService;
    }

    @GetMapping("/{idCard}")
    public UserLoanPlanMaterial getUserLoadPlanMaterial(@PathVariable String idCard) {
        return loanPlanService.getUserLoadPlanMaterial(idCard);
    }

}
