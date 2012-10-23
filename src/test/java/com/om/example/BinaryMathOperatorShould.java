package com.om.example;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BinaryMathOperatorShould {

	private OperandStack operandStack;
	private BinaryMathOperator binaryMathOperator;

	@Before
	public void init() {
		operandStack = spy(new OperandStack());
		binaryMathOperator = spy(new BinaryMathOperator(operandStack) {
			public BigDecimal operation(BigDecimal value1, BigDecimal value2) {
				BigDecimal result = value1.add(value2);
				return result;
			}
		});
	}

	@Test
	public void getTwoValuesFromStack() {
		binaryMathOperator.execute(operandStack);	
		verify(operandStack, times(2)).peek();
		verify(operandStack, times(2)).pop();
	}

	@Test
	public void invokeOperation() {
		binaryMathOperator.execute(operandStack);
		verify(binaryMathOperator).operation((BigDecimal) any(), (BigDecimal) any());
	}

	@Test
	public void checkThatResultIsOnTopOfTheStack() {
		operandStack.push(new BigDecimal(10));
		operandStack.push(new BigDecimal(11));
		binaryMathOperator.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(21)));	
	}
}
