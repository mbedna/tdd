package com.om.example;

import java.math.BigDecimal;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SumTest {

	@Test
	public void shouldBeAbleToSumThreeValues() {
		BigDecimal value1 = new BigDecimal(12);
		BigDecimal value2 = new BigDecimal(8);
		BigDecimal value3 = new BigDecimal(7);
		OperandStack operandStack = new OperandStack();
		operandStack.push(value1);
		operandStack.push(value2);
		operandStack.push(value3);
		Sum sum = new Sum();
		sum.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(27)));
	}
}
