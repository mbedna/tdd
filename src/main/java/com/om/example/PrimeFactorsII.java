package com.om.example;

import java.math.BigDecimal;

public class PrimeFactorsII implements MathOperator {
	
	private BigDecimal TWO = new BigDecimal(2);

	@Override
	public void execute(OperandStack operandStack) {
		BigDecimal value = operandStack.peek();	
		operandStack.pop();		
		if (value.compareTo(TWO) == 1 && value.remainder(TWO).equals(BigDecimal.ZERO)) {
			operandStack.push(TWO);
			value = TWO;
		}
		operandStack.push(value);
	}
}
