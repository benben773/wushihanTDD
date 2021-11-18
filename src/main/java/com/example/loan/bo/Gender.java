package com.example.loan.bo;

public enum Gender {
    FEMALE("女性",60), MALE("男性",65);

    private String desc;
    private Integer maxAgePlusLoanTerm;

    public String getDesc() {
        return desc;
    }

    public Integer getMaxAgePlusLoanTerm() {
        return maxAgePlusLoanTerm;
    }

    Gender(String desc , Integer maxAgePlusLoanTerm) {
        this.desc = desc;
        this.maxAgePlusLoanTerm = maxAgePlusLoanTerm;
    }
}
