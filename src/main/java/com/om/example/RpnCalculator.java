package com.om.example;

import java.math.BigDecimal;

public class RpnCalculator {

	private OperandStack values = new OperandStack();

	public BigDecimal getAccumulator() {
		return values.peek();
	}

	public void setAccumulator(BigDecimal value) {
		values.top(value);
	}

	public void enter() {
		values.push(getAccumulator());
	}

	public void drop() {
		values.pop();
	}

	public void execute(String operatorName) {
		MathOperator op = null;
		if (operatorName.equals("+")) {
			op = new Add(values);
		} else if (operatorName.equals("-")) {
			op = new Substract(values);
		} else if (operatorName.equals("*")) {
			op = new Multiply(values);
		} else if (operatorName.equals("!")) {
			op = new Factorial(values);
		} else {
			throw new UnsupportedOperationException();
		}
		op.execute();
	}
}
