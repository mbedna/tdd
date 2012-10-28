package com.om.example;

import java.math.BigDecimal;

public abstract class BinaryMathOperator implements MathOperator {

	@Override	
	public void execute(OperandStack values) {
		BigDecimal value1 = values.peek();
		values.pop();
		BigDecimal value2 = values.peek();
		BigDecimal result = this.operation(value1, value2);	
		values.top(result); 
	}

	public abstract BigDecimal operation(BigDecimal value1, BigDecimal value2);
}
