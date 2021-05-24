package ch02_parameter_test;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class ParameterizedTest {
	private double expected;
	private double valueOne;
	private double valueTwo;

	
	@Parameters
	public static Collection<Double[]> getTestParameters(){
		return Arrays.asList(new Double[][]{
				{2.,1.,1.},
				{3.,2.,1.},
				{4.,3.,1.},
				{320.,210.,110.},
				{120.,220.,-100.}
		});
	}

	public ParameterizedTest(double expected, double valueOne, double valueTwo) {
		super();
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}
	
	@Test
	public void sum(){
		Calculator calc = new Calculator();
		assertEquals(expected,calc.add(valueOne, valueTwo),0.0); // 0,0 은 오차?
	}
	
}
