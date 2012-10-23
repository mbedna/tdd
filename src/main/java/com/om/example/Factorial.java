package com.om.example;

import java.math.BigDecimal;

public class Factorial implements MathOperator {

	private OperandStack values;

	@Override
	public void execute(OperandStack operandStack) {
		this.values = operandStack;
		BigDecimal value = this.values.peek();
		BigDecimal result = BigDecimal.ONE;
		while (value.compareTo(BigDecimal.ZERO) > 0) {
			result = result.multiply(value);	
			value = value.subtract(BigDecimal.ONE);
		}	
		this.values.top(result);
	}
}
