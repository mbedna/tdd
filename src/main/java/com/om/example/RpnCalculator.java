package com.om.example;

import java.math.BigDecimal;

public class RpnCalculator {

	private OperandStack values = new OperandStack();

	public BigDecimal getAccumulator() {
		return this.values.peek();
	}

	public void setAccumulator(BigDecimal value) {
		this.values.top(value);
	}

	public void enter() {
		this.values.push(getAccumulator());
	}

	public void drop() {
		this.values.pop();
	}

	public void execute(String operatorName) {
		new BinaryOperatorFactory().create(operatorName, this.values);
	}
}
