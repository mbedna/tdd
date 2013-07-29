package com.om.example;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

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

	@Test
	public void of6ShouldReturnDouble2() {
		givenValue(new BigDecimal(6));
		whenPrimeFactorsIIIsInvoked();
		thenValueOnStackShouldBe(new BigDecimal(3));
		and(new BigDecimal(2));
	}

	@Test
	public void of8ShouldReturThreeTimes2() {
		givenValue(new BigDecimal(8));
		whenPrimeFactorsIIIsInvoked();
		thenValueOnStackShouldBe(new BigDecimal(2));
		and(new BigDecimal(2));
		and(new BigDecimal(2));
	}

	@Test
	public void of9ShouldReturDouble3() {
		givenValue(new BigDecimal(9));
		whenPrimeFactorsIIIsInvoked();
		thenValueOnStackShouldBe(new BigDecimal(3));
		and(new BigDecimal(3));
	}
	
	@Test
	public void of1024ShouldReturTen2() {
		givenValue(new BigDecimal(1024));
		whenPrimeFactorsIIIsInvoked();
		thenValueOnStackShouldBe(new BigDecimal(2));
		for (int i = 0; i < 9; i++) {
			and(new BigDecimal(2));
		}
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
		operandStack.pop();
	}

	private void and(BigDecimal value) {
		thenValueOnStackShouldBe(value);
	}
}
