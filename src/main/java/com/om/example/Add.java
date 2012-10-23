package com.om.example;

import java.math.BigDecimal;

public class Add extends BinaryMathOperator {

	public Add(OperandStack operandStack) {
		super(operandStack);
	}		
	
	@Override
	public BigDecimal operation(BigDecimal value1, BigDecimal value2) {
		BigDecimal result = value1.add(value2);
		return result;
	}
}
