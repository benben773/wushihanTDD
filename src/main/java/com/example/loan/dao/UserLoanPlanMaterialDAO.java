package com.example.loan.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.loan.bo.UserLoanPlanMaterial;
import com.example.loan.mapper.HouseMaterialMapper;
import com.example.loan.mapper.TogetherLenderMapper;
import com.example.loan.mapper.UserLoanPlanMaterialMapper;
import com.example.loan.mapper.entity.HouseMaterialEntity;
import com.example.loan.mapper.entity.TogetherLenderEntity;
import com.example.loan.mapper.entity.UserLoanPlanMaterialEntity;
import org.springframework.stereotype.Service;

@Service
public class UserLoanPlanMaterialDAO {

    private final UserLoanPlanMaterialMapper userLoanPlanMaterialMapper;
    private final HouseMaterialMapper houseMaterialMapper;
    private final TogetherLenderMapper togetherLenderEntityMapper;

    public UserLoanPlanMaterialDAO(UserLoanPlanMaterialMapper userLoanPlanMaterialMapper,
                                   HouseMaterialMapper houseMaterialMapper,
                                   TogetherLenderMapper togetherLenderEntityMapper) {
        this.userLoanPlanMaterialMapper = userLoanPlanMaterialMapper;
        this.houseMaterialMapper = houseMaterialMapper;
        this.togetherLenderEntityMapper = togetherLenderEntityMapper;
    }

    public UserLoanPlanMaterial selectUserLoanPlanMaterial(String idCard) {
        UserLoanPlanMaterialEntity userLoanPlanMaterialEntity = getUserLoanPlanMaterialEntity(idCard);
        HouseMaterialEntity houseMaterialEntity = getHouseMaterialEntity(userLoanPlanMaterialEntity.getId());
        TogetherLenderEntity togetherLenderEntity = getTogetherLenderEntity(userLoanPlanMaterialEntity.getId());
        return userLoanPlanMaterialEntity.toBO(houseMaterialEntity, togetherLenderEntity);
    }

    private HouseMaterialEntity getHouseMaterialEntity(Long id) {
        QueryWrapper<HouseMaterialEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loan_plan_material_id", id);
        return houseMaterialMapper.selectOne(queryWrapper);
    }

    private TogetherLenderEntity getTogetherLenderEntity(Long id) {
        QueryWrapper<TogetherLenderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loan_plan_material_id", id);
        return togetherLenderEntityMapper.selectOne(queryWrapper);
    }

    private UserLoanPlanMaterialEntity getUserLoanPlanMaterialEntity(String idCard) {
        QueryWrapper<UserLoanPlanMaterialEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_card", idCard);
        return userLoanPlanMaterialMapper.selectOne(queryWrapper);
    }
}
