package com.om.example;

import java.math.BigDecimal;

public class Sum implements MathOperator {

	@Override
	public void execute(OperandStack operandStack) {
		System.out.println("xxxxxxxxxxxxxxxxx");
		BigDecimal sum = BigDecimal.ZERO;
		while (!operandStack.isEmpty()) {
			System.out.println(operandStack.peek());
			// new Add().execute(operandStack);
			BigDecimal value = operandStack.peek();
			operandStack.pop();
			sum = sum.add(value);
		}
		operandStack.top(sum);
	}
}
