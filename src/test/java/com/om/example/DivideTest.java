package com.om.example;

import java.math.BigDecimal;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DivideTest {

	@Test
	public void whenDivideIsInvokedthenQuotientShouldBeReturned() {
		OperandStack operandStack = new OperandStack();
		operandStack.push(new BigDecimal(24));
		operandStack.push(new BigDecimal(6));
		Divide divide = new Divide();
		divide.execute(operandStack);
		assertThat(operandStack.peek(), equalTo(new BigDecimal(4)));
	}	
}

