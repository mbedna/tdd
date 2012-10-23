package com.om.example;

import java.math.BigDecimal;

public abstract class BinaryMathOperator implements MathOperator {

	private OperandStack values;
	
	public BinaryMathOperator(OperandStack operandStack) {
		this.values = operandStack;
	}

	@Override	
	public void execute(OperandStack operandStack) {
		this.values = operandStack; 
		BigDecimal value1 = values.peek();
		values.pop();
		BigDecimal value2 = values.peek();
		BigDecimal result = this.operation(value1, value2);	
		this.values.top(result); 
	}

	public abstract BigDecimal operation(BigDecimal value1, BigDecimal value2);
}
