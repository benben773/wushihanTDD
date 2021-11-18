package com.example.loan.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("together_lender")
public class TogetherLenderEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long loanPlanMaterialId;
    private String idCard;
    private String name;
    private BigDecimal income;
}
