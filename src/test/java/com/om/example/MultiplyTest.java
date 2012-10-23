package com.om.example;

import java.math.BigDecimal;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MultiplyTest {

	@Test
	public void whenMultiplyIsInvokedthenProductShouldBeReturned() {
		OperandStack operandStack = new OperandStack();
		operandStack.push(new BigDecimal(4));
		operandStack.push(new BigDecimal(6));
		Multiply multiply = new Multiply(operandStack);
		multiply.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(24)));
	}	
}
