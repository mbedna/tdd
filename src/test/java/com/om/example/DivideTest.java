package com.om.example;

import java.math.BigDecimal;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class DivideTest {

	@Test
	public void whenDivideIsInvokedthenQuotientShouldBeReturned() {
		OperandStack operandStack = new OperandStack();
		operandStack.push(new BigDecimal(24));
		operandStack.push(new BigDecimal(6));
		Divide divide = new Divide(operandStack);
		divide.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(4)));
	}	
}

