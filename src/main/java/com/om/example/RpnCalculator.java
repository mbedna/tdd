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

	private void add() {
		BigDecimal value1 = values.peek();
		values.pop();
		BigDecimal value2 = values.peek();
		BigDecimal result = value1.add(value2);
		values.top(result);
	}

	private void substract() {
		BigDecimal value1 = values.peek();
		values.pop();
		BigDecimal value2 = values.peek();
		BigDecimal result = value2.subtract(value1);
		values.top(result);
	}

	private void factorial() {
		BigDecimal value = this.values.peek();
		BigDecimal result = BigDecimal.ONE;
		while (value.compareTo(BigDecimal.ZERO) > 0) {
			result = result.multiply(value);	
			value = value.subtract(BigDecimal.ONE);
		}	
		this.values.top(result);
	}
	
	public void execute(String operatorName) {
		if (operatorName.equals("+")) {
			this.add();
		} else if (operatorName.equals("-")) {
			this.substract();
		} else if (operatorName.equals("!")) {
			this.factorial();
		} else {
			throw new UnsupportedOperationException();
		}
	}
}
