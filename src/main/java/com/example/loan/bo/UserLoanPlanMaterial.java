package com.example.loan.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoanPlanMaterial {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String idCard;
    private String name;
    private Gender gender;
    private BigDecimal income;
    private Integer lenderAge;

    private TogetherLender togetherLender;
    private HouseMaterial houseMaterial;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
