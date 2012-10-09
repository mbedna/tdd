package com.om.example;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
public class AnRpnCalculatorWithTwoOperandsShould {

	public RpnCalculator rpnCalculator;

	@Before
	public void init() {
		this.rpnCalculator = new RpnCalculator();
		BigDecimal value1 = new BigDecimal(3);
		this.rpnCalculator.setAccumulator(value1);
		this.rpnCalculator.enter();
		BigDecimal value2 = new BigDecimal(4);
		this.rpnCalculator.setAccumulator(value2);
	}
	
	@Test
	public void returnSumWhenTheyAreAdded() {
		this.rpnCalculator.add();
		BigDecimal value = new BigDecimal(7);
		assertThat(this.rpnCalculator.getAccumulator(), equalTo(value));
	}	

	@Test
	public void returnSubstractionWhenTheyAreSubstracted() {
		this.rpnCalculator.substract();
		BigDecimal value = new BigDecimal(-1);
		assertThat(this.rpnCalculator.getAccumulator(), equalTo(value));
	}	

}
