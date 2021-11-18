package com.example.loan.mapper;


import com.example.loan.mapper.entity.DemoEntity;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DemoEntityTest {
    @Test
    public void should_success() {
        int input = 1;
        Integer result = DemoEntity.of(input);
        int expected = 1;
        assertThat(result).isEqualTo(expected);
    }
}
