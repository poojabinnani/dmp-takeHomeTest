package com.interview.assignment.dmptakeHome.health;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public class RandomClientServiceHealthIndicatorTest {
    @Autowired
    RandomClientServiceHealthIndicator randomClientServiceHealthIndicator;

    @Test
    public void getHealthTest(){
        Assertions.assertEquals(Status.UP, Objects.requireNonNull(randomClientServiceHealthIndicator.getHealth(true).block()).getStatus());

    }
}
