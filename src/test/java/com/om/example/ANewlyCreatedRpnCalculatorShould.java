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

}
