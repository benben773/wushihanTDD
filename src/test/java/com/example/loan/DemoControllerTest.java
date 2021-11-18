package com.example.loan;

import com.alibaba.fastjson.JSON;
import com.example.loan.mapper.DemoMapper;
import com.example.loan.mapper.entity.DemoEntity;
import com.example.loan.service.input.DemoForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = LoanServerApplication.class)
@Transactional(rollbackFor = TransactionException.class)
public class DemoControllerTest {
    MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void demo_test() throws Exception {
        DemoForm demoForm = new DemoForm("demo");
        String result = mockMvc.perform(
                        post("/demo")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JSON.toJSONString(demoForm)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        DemoEntity demoResult = JSON.parseObject(result, DemoEntity.class);
        assertThat(demoResult.getName()).isEqualTo("demo");
    }

    @Autowired
    private DemoMapper demoMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName("test");
        demoEntity.setCreatedAt(LocalDateTime.now());
        demoEntity.setUpdatedAt(LocalDateTime.now());
        demoMapper.insert(demoEntity);
        List<DemoEntity> userList = demoMapper.selectList(null);
        assertEquals(1, userList.size());
        userList.forEach(System.out::println);
    }

}

