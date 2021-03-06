package com.example.loan.controller;

import com.example.loan.LoanServerApplication;
import com.example.loan.bo.Gender;
import com.example.loan.mapper.HouseMaterialMapper;
import com.example.loan.mapper.TogetherLenderMapper;
import com.example.loan.mapper.UserLoanPlanMaterialMapper;
import com.example.loan.mapper.entity.HouseMaterialEntity;
import com.example.loan.mapper.entity.TogetherLenderEntity;
import com.example.loan.mapper.entity.UserLoanPlanMaterialEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.skyscreamer.jsonassert.comparator.JSONComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.example.loan.bo.Gender.FEMALE;
import static com.example.loan.bo.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = LoanServerApplication.class)
@Transactional(rollbackFor = TransactionException.class)
public class LoanControllerTest {


    MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private UserLoanPlanMaterialMapper userLoanPlanMaterialMapper;
    @Autowired
    private HouseMaterialMapper houseMaterialMapper;
    @Autowired
    private TogetherLenderMapper togetherLenderEntityMapper;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                })).build();
    }

    @Test
    public void should_get_userLoanPlan_success() throws Exception {
        String idCard = "412233333333";
        givenLoanPlanMaterialData(idCard, MALE, 35, 0);
        String result = mockMvc.perform(
                        get("/loan-plans/{idCard}", idCard))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String expected = "{\"createdAt\":\"2021-10-23T00:41:49.257479\",\"gender\":\"MALE\",\"houseMaterial\":{\"age\":0,\"price\":10000},\"id\":1,\"idCard\":\""+idCard+"\",\"income\":10000,\"lenderAge\":35,\"name\":\"??????\",\"togetherLender\":{\"idCard\":\"111111111\",\"income\":10000},\"updatedAt\":\"2021-10-23T00:41:49.257512\"}";
        JSONComparator comparator = new CustomComparator(JSONCompareMode.LENIENT,
                new Customization("id", (o1, o2) -> true),
                new Customization("createdAt", (o1, o2) -> true),
                new Customization("updatedAt", (o1, o2) -> true)
        );
        JSONAssert.assertEquals(expected, result, comparator);
    }


    private void givenLoanPlanMaterialData(String idCard, Gender gender, int age, int houseAge) {
        UserLoanPlanMaterialEntity entity = new UserLoanPlanMaterialEntity();
        entity.setGender(gender);
        entity.setIncome(BigDecimal.valueOf(10000));
        entity.setLenderAge(age);
        entity.setIdCard(idCard);
        entity.setName("??????");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        userLoanPlanMaterialMapper.insert(entity);

        HouseMaterialEntity houseMaterialEntity = new HouseMaterialEntity();
        houseMaterialEntity.setLoanPlanMaterialId(entity.getId());
        houseMaterialEntity.setAge(houseAge);
        houseMaterialEntity.setPrice(BigDecimal.valueOf(10000));
        houseMaterialMapper.insert(houseMaterialEntity);

        TogetherLenderEntity togetherLenderEntity = new TogetherLenderEntity();
        togetherLenderEntity.setIdCard("111111111");
        togetherLenderEntity.setName("??????");
        togetherLenderEntity.setIncome(BigDecimal.valueOf(10000));
        togetherLenderEntity.setLoanPlanMaterialId(entity.getId());
        togetherLenderEntityMapper.insert(togetherLenderEntity);
    }

    @Test
    public void ??????_??????__????????????_??????_????????????65_????????????() throws Exception {
        String idCard = "111";
        givenLoanPlanMaterialData(idCard, MALE, 35, 0);
        Integer loanTerm = 30;
        check(idCard, loanTerm, "true", "");
    }

    @Test
    public void ??????_??????_????????????_??????_??????65_????????????() throws Exception {
        String idCard = "1112";
        givenLoanPlanMaterialData(idCard, FEMALE, 36, 0);
        check(idCard, 30, "false", "??????_??????_???_????????????_????????????65");
    }


    private void check(String idCard, Integer loanTerm, String returnCode, String returnMessage) throws Exception {
        String result = mockMvc.perform(
                get("/loan-plans/loan-plans-check/{idCard}/{loanTerm}", idCard, loanTerm))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String expected = "{\"returnCode\":\"" + returnCode + "\",\"returnMessage\":\""+returnMessage+"\"}";
        assertThat(result).isEqualTo(expected);
    }

}
