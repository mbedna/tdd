package com.om.example;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
public class RpnCalculatorProgramTest {

	private RpnCalculator rpnCalculator;

	@Before
	public void init() {
		rpnCalculator = new RpnCalculator();
	}	
	
	@Test
	public void addAndMultiplyProgram() {
		rpnCalculator.setAccumulator(new BigDecimal(2));
		rpnCalculator.enter();
		rpnCalculator.setAccumulator(new BigDecimal(3));
		rpnCalculator.enter();
		rpnCalculator.setAccumulator(new BigDecimal(4));
		rpnCalculator.startProgram();
		rpnCalculator.addToProgram("+");
		rpnCalculator.addToProgram("*");
		rpnCalculator.saveProgram("AddAndMultiply");
		rpnCalculator.executeProgram("AddAndMultiply");
		assertThat(rpnCalculator.getAccumulator(), equalTo(new BigDecimal(14)));
	}
		
}
