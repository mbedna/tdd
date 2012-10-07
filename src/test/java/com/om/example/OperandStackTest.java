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
		assertThat(operandStack.peek(),equalTo(BigDecimal.ONE)); 
	}
}
