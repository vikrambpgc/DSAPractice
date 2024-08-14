package com.myjunit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {
    private SimpleCalculator simpleCalculator;

    @BeforeEach
    public void setup() {
        simpleCalculator = new SimpleCalculator();
    }

    @Test
    public void testAdd() {
        int result = simpleCalculator.add(3, 4);
        assertEquals(result, 7);
    }

}