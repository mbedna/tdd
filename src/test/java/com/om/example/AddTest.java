package com.om.example;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class AddTest {

	private Add add;
	private BigDecimal value;
	private BigDecimal value2;
	private OperandStack operandStack;

	@Before
	public void init() {
		operandStack = new OperandStack();
		add = new Add();
		value = new BigDecimal(11);
		operandStack.push(value);
		value2 = new BigDecimal(5);
		operandStack.push(value2);
	}

	@Test
	public void checkAddition() {
		add.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(16)));
	}
}
