package com.example.loan.util;

import com.example.loan.bo.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author ：shihan
 * @date ：Created in 2021/11/18 14:30
 */
@RunWith(Parameterized.class)
class LoanPlanCheckUtilTest {

    private Gender gender;
    private Integer age;
    private Integer loanYear;
    private Integer houseAge;
    private boolean returnCode;
    private String returnMessage;

    public LoanPlanCheckUtilTest(Gender gender, Integer age, Integer loanYear, Integer houseAge, boolean returnCode, String returnMessage) {
        this.gender = gender;
        this.age = age;
        this.loanYear = loanYear;
        this.houseAge = houseAge;
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Gender.MALE, 35,30,0,true,"贷款成功"},
                {Gender.MALE, 36,30,0,false,"男性_年龄_加_贷款年限_超过65_贷款失败"},
                {Gender.MALE, 30,30,11,false,"男性_贷款年限_加_房龄总_超过40年_贷款失败"},
                {Gender.FEMALE, 30,30,0,true,"贷款成功"},
                {Gender.FEMALE, 31,30,0,false,"女性_年龄_加_贷款年限_超过60_贷款失败"}
         });
    }
    @Test
    public void check()  {

        check(gender, age, loanYear, houseAge, returnCode, returnMessage);
    }

    private void check(Gender gender, Integer age, Integer loanYear, Integer houseAge, boolean returnCode, String returnMessage) {
        UserLoanPlanMaterial loaner = new UserLoanPlanMaterial(Long.valueOf(1), "idCard", "name", gender, new BigDecimal(0), age, new TogetherLender("idCard", "name", new BigDecimal(0)), new House(houseAge, new BigDecimal(0)), LocalDateTime.of(2021, Month.NOVEMBER, 12, 21, 46, 40), LocalDateTime.of(2021, Month.NOVEMBER, 12, 21, 46, 40));
        BoTest result =  LoanUtil.check(loanYear, loaner);
        Assert.assertEquals(result.getReturnCode(), returnCode);
        Assert.assertEquals(result.getReturnMessage(), returnMessage);
    }
}