package com.example.loan.bo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(Parameterized.class)
public class BoTest {

    private int first;
    private int second;

    public BoTest(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, 3},
                {35, 35},
        });
    }

    @Test
    public void parameter_test() {
        assertThat(first).isEqualTo(second);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

//    @Test
//    public void exception_test() {
//        expectedException.expect(BusinessException.class);
//        expectedException.expectMessage("");
//    }

}


