package com.om.example;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ANewlyCreatedRpnCalculatorShould {

	private RpnCalculator rpnCalculator;

	@Before
	public void init() {
		rpnCalculator = new RpnCalculator();
	}

	@Test
	public void Have0InItsAccumulator() {
		assertEquals(BigDecimal.ZERO, rpnCalculator.getAccumulator());
	}

	@Test
	public void AllowItsAccumulatorToBeSet() {
		BigDecimal value = new BigDecimal(42);
		rpnCalculator.setAccumulator(value);
		assertEquals(value, rpnCalculator.getAccumulator());
	}

	@Test
	public void AllowMultipleValuesToBeStored() {
		BigDecimal value = new BigDecimal(42);
		BigDecimal value2 = new BigDecimal(2);
		BigDecimal value3 = new BigDecimal(3);
		this.rpnCalculator.setAccumulator(value);
		this.rpnCalculator.enter();
		this.rpnCalculator.setAccumulator(value2);
		this.rpnCalculator.enter();
		this.rpnCalculator.setAccumulator(value3);
		assertEquals(value3, rpnCalculator.getAccumulator());
		this.rpnCalculator.drop();
		assertEquals(value2, rpnCalculator.getAccumulator());
		this.rpnCalculator.drop();
		assertEquals(value, rpnCalculator.getAccumulator());
		this.rpnCalculator.drop();
		assertEquals(BigDecimal.ZERO, rpnCalculator.getAccumulator());
	}
}
