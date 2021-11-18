package com.example.loan.service;

import com.example.loan.bo.UserLoanPlanMaterial;
import com.example.loan.dao.UserLoanPlanMaterialDAO;
import org.springframework.stereotype.Service;

@Service
public class LoanPlanService {
    private final UserLoanPlanMaterialDAO userLoanPlanMaterialDAO;

    public LoanPlanService(UserLoanPlanMaterialDAO userLoanPlanMaterialDAO) {
        this.userLoanPlanMaterialDAO = userLoanPlanMaterialDAO;
    }

    public UserLoanPlanMaterial getUserLoadPlanMaterial(String idCard) {
        return userLoanPlanMaterialDAO.selectUserLoanPlanMaterial(idCard);
    }
}
