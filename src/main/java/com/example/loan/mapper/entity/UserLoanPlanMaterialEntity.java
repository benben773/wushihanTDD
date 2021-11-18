package com.example.loan.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.loan.bo.Gender;
import com.example.loan.bo.HouseMaterial;
import com.example.loan.bo.TogetherLender;
import com.example.loan.bo.UserLoanPlanMaterial;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("user_loan_plan_material")
public class UserLoanPlanMaterialEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String idCard;
    private String name;
    private Gender gender;
    private BigDecimal income;
    private Integer lenderAge;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserLoanPlanMaterial toBO(HouseMaterialEntity houseMaterialEntity, TogetherLenderEntity togetherLenderEntity) {
        HouseMaterial houseMaterial = HouseMaterial.builder()
                .age(houseMaterialEntity.getAge())
                .price(houseMaterialEntity.getPrice())
                .build();
        TogetherLender togetherLender = TogetherLender.builder()
                .idCard(togetherLenderEntity.getIdCard())
                .income(togetherLenderEntity.getIncome())
                .build();
        return UserLoanPlanMaterial.builder()
                .id(this.id)
                .idCard(idCard)
                .name(name)
                .gender(gender)
                .income(income)
                .lenderAge(lenderAge)
                .houseMaterial(houseMaterial)
                .togetherLender(togetherLender)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}

