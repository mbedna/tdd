package com.om.example;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CompositeMathOperatorTest {
	private CompositeMathOperator compositeMathOperator;
	private OperatorFactory factory;
	private OperandStack operandStack;

	@Before
	public void init() {
		compositeMathOperator = new CompositeMathOperator();
		factory = new BinaryOperatorFactoryImpl();
		operandStack = new OperandStack();
	}

	@Test
	public void shouldBeAbleToRegisterManyOperators() {
		compositeMathOperator.register("+");
		compositeMathOperator.register("*");
		compositeMathOperator.execute(operandStack);
		assertThat(compositeMathOperator.mathOperators.size(), equalTo(2));
	}

	@Test
	public void methodExecuteForEachOperatorShouldBeInvoked() {
		operandStack.push(new BigDecimal(2));
		operandStack.push(new BigDecimal(3));
		operandStack.push(new BigDecimal(4));
		compositeMathOperator.register("+");
		compositeMathOperator.register("*");
		compositeMathOperator.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(14)));
	}

	@Test
	public void divisionAndSubstart() {
		operandStack.push(new BigDecimal(5));
		operandStack.push(new BigDecimal(8));
		operandStack.push(new BigDecimal(4));
		compositeMathOperator.register("/");
		compositeMathOperator.register("-");
		compositeMathOperator.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(3)));
	}
}
