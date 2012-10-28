package com.om.example;

import java.math.BigDecimal;

public class PrimeFactors implements MathOperator {

	private BigDecimal TWO = new BigDecimal(2);

	private BigDecimal THREE = new BigDecimal(3);

	@Override
	public void execute(OperandStack operandStack) {
		BigDecimal value = operandStack.peek();
		operandStack.pop();
		value = divideByValue(operandStack, value, THREE);
		value = divideByValue(operandStack, value, TWO);
		operandStack.push(value);
	}

	private BigDecimal divideByValue(OperandStack operandStack, BigDecimal value,
			BigDecimal constant) {
		while (value.compareTo(THREE) == 1
				&& value.remainder(constant).equals(BigDecimal.ZERO)) {
			value = value.divide(constant);
			operandStack.push(constant);
		}
		return value;
	}
}
