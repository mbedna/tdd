package com.om.example;

import java.math.BigDecimal;

public class Add implements MathOperator {

	private OperandStack values;

	public Add(OperandStack operandStack) {
		values = operandStack;
	}

	@Override
	public void execute() {
		BigDecimal value1 = values.peek();
		values.pop();
		BigDecimal value2 = values.peek();
		BigDecimal result = value1.add(value2);
		values.top(result); 
	}
}
