package com.example.loan.util;

import com.example.loan.bo.BoTest;
import com.example.loan.bo.Gender;
import com.example.loan.bo.UserLoanPlanMaterial;


class LoanUtil {

    private static final int MAX_LOAN_TERM = 30;
    private static final int MAX_LOAN_TERM_PLUS_HOUSE_AGE = 40;

    public static BoTest check(Integer loanTerm, UserLoanPlanMaterial loaner) {
        if (loanTerm > MAX_LOAN_TERM) {
            return new BoTest("住房贷款年限最长为" + MAX_LOAN_TERM + "年",true);
        }
        Gender gender = loaner.getGender();
        if (loaner.getLenderAge() + loanTerm > gender.getMaxAgePlusLoanTerm()) {
            return new BoTest(String.format("%s_年龄_加_贷款年限_不能超过%d", gender.getDesc(), gender.getMaxAgePlusLoanTerm()),false);
        }
        if (loaner.getHouseMaterialAge()+ loanTerm > MAX_LOAN_TERM_PLUS_HOUSE_AGE) {
            return new BoTest(String.format("贷款年限加上房龄总和不能超过%s年", MAX_LOAN_TERM_PLUS_HOUSE_AGE),false);
        }
        return new BoTest("",true);
    }

    private LoanUtil() {
        throw new IllegalStateException("Utility class");
    }
}
