package com.om.example;

import java.math.BigDecimal;

public class Sum implements MathOperator {

	@Override
	public void execute(OperandStack operandStack) {
		BigDecimal sum = BigDecimal.ZERO;
		while (operandStack.size() > 1) {
			new Add().execute(operandStack);
		}
	}
}
