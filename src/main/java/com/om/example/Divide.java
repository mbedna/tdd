package com.om.example;

import java.math.BigDecimal;

public class Divide extends BinaryMathOperator {

	public Divide(OperandStack operandStack) {
		super(operandStack);
	}

	@Override
	public BigDecimal operation(BigDecimal value1, BigDecimal value2) {
		return value2.divide(value1);
	}

}

