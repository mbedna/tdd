package com.om.example;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RpnCalculatorWithThreeValuesShould {
	
	private RpnCalculator rpnCalculator;
	private	BigDecimal value1 = new BigDecimal(42);
	private	BigDecimal value2 = new BigDecimal(2);
	private	BigDecimal value3 = new BigDecimal(3);

	@Before
	public void init() {
		rpnCalculator = new RpnCalculator();
		this.rpnCalculator.setAccumulator(value1);
		this.rpnCalculator.enter();
		this.rpnCalculator.setAccumulator(value2);
		this.rpnCalculator.enter();
		this.rpnCalculator.setAccumulator(value3);
	}
	
	@Test
	public void haveValue3InItsAccumulator() {
		assertEquals(value3, rpnCalculator.getAccumulator());		
	} 

	@Test
	public void haveValue2InItsAccumulatorAfterOneDrop() {
		this.rpnCalculator.drop();
		assertEquals(value2, rpnCalculator.getAccumulator());
	}
	
	@Test
	public void haveValue1InItsAccumulatorAfterTwoDrops() {
		this.rpnCalculator.drop();
		this.rpnCalculator.drop();
		assertEquals(value1, rpnCalculator.getAccumulator());
	}

	@Test
	public void haveZEROValueInItsAccumulatorAfterThreeDrops() {
		this.rpnCalculator.drop();
		this.rpnCalculator.drop();
		this.rpnCalculator.drop();
		assertEquals(BigDecimal.ZERO, rpnCalculator.getAccumulator());
	}
}
