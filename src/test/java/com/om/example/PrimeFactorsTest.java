package com.om.example;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class PrimeFactorsTest {
	private OperandStack operandStack = new OperandStack();

	private PrimeFactors primeFactors;

	@Before
	public void init() {
		operandStack = new OperandStack();
		primeFactors = new PrimeFactors();
	}

	@Test
	public void forZeroZeroShouldBeReturned() {
		operandStack.push(BigDecimal.ZERO);
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(BigDecimal.ZERO));
		
	}

	@Test
	public void forOneOneShouldBeReturned() {
		operandStack.push(BigDecimal.ONE);
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(BigDecimal.ONE));
	}

	@Test
	public void forTwoTwoShouldBeReturned() {
		operandStack.push(new BigDecimal(2));
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
	}

	@Test
	public void forThreeThreeShouldBeReturned() {
		operandStack.push(new BigDecimal(3));
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(3)));
	}

	@Test
	public void forFourDoubleTwosShouldBeReturned() {
		operandStack.push(new BigDecimal(4));
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
	}

	@Test
	public void forFiveFiveShouldBeReturned() {
		operandStack.push(new BigDecimal(5));
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(5)));
	}

	@Test
	public void forSixTwoAndThreeShouldBeReturned() {
		operandStack.push(new BigDecimal(6));
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(3)));
	}

	@Test
	public void forEightTripleTwosShouldBeReturned() {
		operandStack.push(new BigDecimal(8));
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
	}

	@Test
	public void forNineTripleThreesShouldBeReturned() {
		operandStack.push(new BigDecimal(9));
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(3)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(3)));
	}

	@Test
	public void forTenFiveAndTwoShouldBeReturned() {
		operandStack.push(new BigDecimal(10));
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(5)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
	}

	@Test
	public void forTwelveTenFiveAndTwoShouldBeReturned() {
		operandStack.push(new BigDecimal(12));
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(3)));
	}

	@Test
	public void forFiveTeenThreeAndFiveShouldBeReturned() {
		operandStack.push(new BigDecimal(15));
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(5)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(3)));
	}

	@Test
	public void forSixTeenThreeAndFiveShouldBeReturned() {
		operandStack.push(new BigDecimal(16));
		primeFactors.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(new BigDecimal(2)));
	}
}
