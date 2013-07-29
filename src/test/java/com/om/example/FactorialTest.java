package com.om.example;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class FactorialTest {

	public RpnCalculator rpnCalculator;

	@Before
	public void init() {
		this.rpnCalculator = new RpnCalculator();
	}

	@Test
	public void factorialForZeroShouldBeOne() {
		this.rpnCalculator.setAccumulator(BigDecimal.ZERO);
		this.rpnCalculator.execute("!");
		assertThat(BigDecimal.ONE, equalTo(this.rpnCalculator.getAccumulator()));
	}

	@Test
	public void factorialFor5ShouldBe120() {
		BigDecimal value = new BigDecimal(5);
		this.rpnCalculator.setAccumulator(value);
		this.rpnCalculator.execute("!");
		BigDecimal result = new BigDecimal(120);
		assertThat(result, equalTo(this.rpnCalculator.getAccumulator()));
	}
}
