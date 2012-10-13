package com.om.example;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RpnCalculatorRegisteredOperatorsTest {

	private RpnCalculator rpnCalculator;

	private	BigDecimal value = BigDecimal.TEN;
	private BigDecimal value2 = new BigDecimal(4);
		
	@Before
	public void init() {
		rpnCalculator = new RpnCalculator();
		rpnCalculator.setAccumulator(value);
		rpnCalculator.enter();
		rpnCalculator.setAccumulator(value2);
	}

	@Test
	public void shouldHaveAPossibilityToRegisterAddOperator() {
		rpnCalculator.execute("+");	
		assertThat(this.rpnCalculator.getAccumulator(), equalTo(new BigDecimal(14)));
	}

	@Test
	public void shouldHaveAPossibilityToRegisterMinusOperator() {
		rpnCalculator.execute("-");	
		assertThat(this.rpnCalculator.getAccumulator(), equalTo(new BigDecimal(6)));
	}
		
	@Test
	public void shouldHaveAPossibilityToRegisterFactorialOperator() {
		rpnCalculator.execute("!");	
		assertThat(this.rpnCalculator.getAccumulator(), equalTo(new BigDecimal(24)));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldThrowExceptionWhenNotRegisteredOperatorUsed() {
		rpnCalculator.execute("not registered operator");	
	}
}
