package com.om.example;

import java.math.BigDecimal;
import java.util.Stack;

public class OperandStack {

	private Stack<BigDecimal> values = new Stack<BigDecimal>();

	public BigDecimal peek() {
		if (!values.empty()) {
			return values.peek();
		} else {
			return BigDecimal.ZERO;
		}
	}
	
	public void push(BigDecimal value) {
		values.push(value);
	}
	
	public void pop() {
		if (!values.empty())
			values.pop();
	}
	
	public void top(BigDecimal value) {
		pop();
		push(value);
	}
}


