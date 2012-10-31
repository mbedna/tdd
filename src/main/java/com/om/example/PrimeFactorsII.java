package com.om.example;

import java.math.BigDecimal;

public class PrimeFactorsII implements MathOperator {

	private BigDecimal TWO = new BigDecimal(2);

	@Override
	public void execute(OperandStack operandStack) {
		BigDecimal value = operandStack.peek();
		operandStack.pop();

		if (value.compareTo(BigDecimal.ONE) == 0) {
			operandStack.push(value);
		}

		BigDecimal divisor = TWO;
		while (value.compareTo(divisor) >= 0) {
			while (value.remainder(divisor).equals(BigDecimal.ZERO)) {
				operandStack.push(divisor);
				value = value.divide(divisor);
			}
			divisor = divisor.add(BigDecimal.ONE);
		}

	}

}
