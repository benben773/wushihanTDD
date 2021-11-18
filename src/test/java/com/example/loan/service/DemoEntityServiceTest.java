package com.example.loan.service;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(JMockit.class)
public class DemoEntityServiceTest {
    @Mocked
    ThirdService thirdService;

    @Test
    public void mockProcessTest() {
        //录制预期行为
        new Expectations() {
            {
                thirdService.sayHello();
                result = "hahahaha";
            }
        };

        DemoService demoService = new DemoService(thirdService);
        //测试代码
        assertThat(demoService.sayHello()).isEqualTo("hahahaha");

        //验证
        new Verifications() {
            {
                thirdService.sayHello();
                times = 1; //执行了0次。参数一致的才会计数
            }
        };
    }
}
