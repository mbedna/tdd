package com.om.example;

import java.math.BigDecimal;

public class Multiply extends BinaryMathOperator {

	public Multiply(OperandStack operandStack) {
		super(operandStack);
	}

	@Override
	public BigDecimal operation(BigDecimal value1, BigDecimal value2) {
		return value1.multiply(value2);
	}

}
