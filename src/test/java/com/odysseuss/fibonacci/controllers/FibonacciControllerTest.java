package com.odysseuss.fibonacci.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FibonacciControllerTest {

    @Autowired
    FibonacciController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void fibonacci_baseCaseZero() {
        assertThat(restTemplate.getForObject("/fibonacci/0/1/", String.class)).isEqualTo("[0]");
    }

    @Test
    void fibonacci_baseCaseOne() {
        assertThat(restTemplate.getForObject("/fibonacci/1/1/", String.class)).isEqualTo("[1]");
    }

    @Test
    void fibonacci_firstSevenSequence() {
        assertThat(restTemplate.getForObject("/fibonacci/0/7/", String.class)).isEqualTo("[0,1,1,2,3,5,8]");
    }

    @Test
    void testCase1() {
        assertThat(restTemplate.getForObject("/fibonacci/5/5/", String.class)).isEqualTo("[5,8,13,21,34]");
    }

    @Test
    void testCase2() {
        assertThat(restTemplate.getForObject("/fibonacci/2/5/", String.class)).isEqualTo("[2,3,5,8,13]");
    }

    @Test
    void testCase3() {
        assertThat(restTemplate.getForObject("/fibonacci/4/5/", String.class)).isEqualTo("[5,8,13,21,34]");
    }
}
