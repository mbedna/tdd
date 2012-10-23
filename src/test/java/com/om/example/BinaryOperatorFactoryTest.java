package com.om.example;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BinaryOperatorFactoryTest {

	private RpnCalculator rpnCalculator;

	@Before
	public void init() {
		rpnCalculator = new RpnCalculator();
	}

	@Test
	public void shouldHaveAPossibilityToRegisterAddOperator() {
		rpnCalculator.execute("+");	
	}

	@Test
	public void shouldHaveAPossibilityToRegisterMinusOperator() {
		rpnCalculator.execute("-");	
	}
		
	@Test
	public void shouldHaveAPossibilityToRegisterFactorialOperator() {
		rpnCalculator.execute("!");	
	}

	@Test
	public void shouldHaveAPossibilityToRegisterMultiplyOperator() {
		rpnCalculator.execute("*");	
	}

	@Test
	public void shouldHaveAPossibilityToRegisterDivideOperator() {
		rpnCalculator.setAccumulator(BigDecimal.ONE);
		rpnCalculator.execute("/");	
	}
		
	@Test(expected = UnsupportedOperationException.class)
	public void shouldThrowExceptionWhenNotRegisteredOperatorUsed() {
		rpnCalculator.execute("not registered operator");	
	}
}
