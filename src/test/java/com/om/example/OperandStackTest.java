package com.om.example;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class OperandStackTest {

	private OperandStack operandStack;

	@Before
	public void init() {
		operandStack = new OperandStack();
	}

	@Test
	public void emptyStackShouldReturnZero() {
		assertThat(operandStack.peek(), equalTo(BigDecimal.ZERO));
	}

	@Test
	public void stackWithOnePushedElementShouldContainIt() {
		operandStack.push(BigDecimal.ONE);
		assertThat(operandStack.peek(), equalTo(BigDecimal.ONE));
	}

	@Test
	public void stackShouldReturnZeroWhenElementWasPushedAndPoped() {
		operandStack.push(BigDecimal.TEN);
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(BigDecimal.ZERO));
	}

	@Test
	public void shouldNotThrowExceptionWhenPopIsInvokedOnEmptyStack() {
		operandStack.pop();
		assertThat(operandStack.peek(), equalTo(BigDecimal.ZERO));
	}

	@Test
	public void valuePutOnTheTopShouldBeReturned() {
		BigDecimal value = new BigDecimal(19);
		operandStack.top(value);
		assertThat(operandStack.peek(), equalTo(value));
	}
}
