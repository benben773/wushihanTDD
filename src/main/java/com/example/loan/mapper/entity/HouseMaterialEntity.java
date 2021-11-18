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
@TableName("house_material")
public class HouseMaterialEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long loanPlanMaterialId;
    private Integer age;
    private BigDecimal price;
}
