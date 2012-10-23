package com.om.example;

import java.math.BigDecimal;

public class Substract extends BinaryMathOperator {

	public Substract(OperandStack operandStack) {
		super(operandStack);
	}

	@Override
	public BigDecimal operation(BigDecimal value1, BigDecimal value2) {
		return value2.subtract(value1);
	}
}
