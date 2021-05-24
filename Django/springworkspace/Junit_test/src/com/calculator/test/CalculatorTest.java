package com.calculator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.calculator.Calculator;

class CalculatorTest {

	@Test
	public void testSum() {
		Calculator calculator = new Calculator();
		
		assertEquals(30, calculator.sum(10, 20));
	}

}
