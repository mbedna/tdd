package com.om.example;

import java.math.BigDecimal;

public class Substract implements MathOperator {

	private OperandStack values;

	public Substract(OperandStack operandStack) {
		values = operandStack;
	}

	@Override
	public void execute() {
		BigDecimal value1 = values.peek();
		values.pop();
		BigDecimal value2 = values.peek();
		BigDecimal result = value2.subtract(value1);
		values.top(result);
	}
}
