package com.om.example;

import java.math.BigDecimal;
import java.util.Stack;

public class OperandStack {

	private Stack<BigDecimal> values = new Stack<BigDecimal>();

	public BigDecimal peek() {
		if (values.empty()) {
			return BigDecimal.ZERO;
		} else {
			return values.peek();
		}
	}
	
	public void push(BigDecimal value) {
		values.push(value);
	}
}


