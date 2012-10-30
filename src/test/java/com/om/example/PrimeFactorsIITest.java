package com.om.example;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class PrimeFactorsIITest {

	private OperandStack operandStack;

	@Before
	public void init() {
		operandStack = new OperandStack();
	}

	@Test
	public void of0ShouldReturn0() {
		givenValue(BigDecimal.ZERO);
		whenPrimeFactorsIIIsInvoked();
		thenValueOnStackShouldBe(BigDecimal.ZERO);
	}

	@Test
	public void of1ShouldReturn1() {
		givenValue(BigDecimal.ONE);
		whenPrimeFactorsIIIsInvoked();
		thenValueOnStackShouldBe(BigDecimal.ONE);
	}

	@Test
	public void of2ShouldReturn2() {
		givenValue(new BigDecimal(2));
		whenPrimeFactorsIIIsInvoked();
		thenValueOnStackShouldBe(new BigDecimal(2));
	}

	@Test
	public void of3ShouldReturn3() {
		givenValue(new BigDecimal(3));
		whenPrimeFactorsIIIsInvoked();
		thenValueOnStackShouldBe(new BigDecimal(3));
	}

	@Test
	public void of4ShouldReturnDouble2() {
		givenValue(new BigDecimal(4));
		whenPrimeFactorsIIIsInvoked();
		thenValueOnStackShouldBe(new BigDecimal(2));
		and(new BigDecimal(2));
	}

	// @Test
	public void of6ShouldReturnDouble2() {
		givenValue(new BigDecimal(4));
		whenPrimeFactorsIIIsInvoked();
		thenValueOnStackShouldBe(new BigDecimal(2));
		and(new BigDecimal(2));
	}

	private void givenValue(BigDecimal value) {
		operandStack.push(value);
	}

	private void whenPrimeFactorsIIIsInvoked() {
		PrimeFactorsII primeFactorsII = new PrimeFactorsII();
		primeFactorsII.execute(operandStack);
	}

	private void thenValueOnStackShouldBe(BigDecimal value) {
		assertThat(operandStack.peek(), equalTo(value));
	}

	private void and(BigDecimal value) {
		thenValueOnStackShouldBe(value);
	}
}
