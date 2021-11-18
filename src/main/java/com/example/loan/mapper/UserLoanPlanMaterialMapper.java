package com.example.loan.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.loan.mapper.entity.UserLoanPlanMaterialEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoanPlanMaterialMapper extends BaseMapper<UserLoanPlanMaterialEntity> {
    UserLoanPlanMaterialEntity selectUserLoanPlanMaterial(String idCard);

}
