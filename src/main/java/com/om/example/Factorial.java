package com.om.example;

import java.math.BigDecimal;

public class Factorial implements MathOperator {

	private OperandStack values;

	public Factorial(OperandStack operandStack) {
		values = operandStack;
	}

	@Override
	public void execute() {
		BigDecimal value = this.values.peek();
		BigDecimal result = BigDecimal.ONE;
		while (value.compareTo(BigDecimal.ZERO) > 0) {
			result = result.multiply(value);	
			value = value.subtract(BigDecimal.ONE);
		}	
		this.values.top(result);
	}
}