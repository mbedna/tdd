package com.om.example;

import java.math.BigDecimal;

public class RpnCalculator {

	private OperatorFactory binaryOperatorFactory;
	private OperandStack values = new OperandStack();
	private CompositeMathOperator compositeMathOperator;

	public RpnCalculator() {
		binaryOperatorFactory = new BinaryOperatorFactoryImpl();
	}

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
		MathOperator mathOperator = binaryOperatorFactory.create(operatorName);
		mathOperator.execute(values);
	}

	public void startProgram() {
		this.compositeMathOperator = new CompositeMathOperator();
	}

	public void addToProgram(String operatorName) {
		this.compositeMathOperator.register(operatorName);
	}

	public void saveProgram(String programName) {
		this.binaryOperatorFactory.addOperator(programName, compositeMathOperator);	
	}

	public void executeProgram(String programName) {
		MathOperator mathOperator = this.binaryOperatorFactory.create(programName);	
		mathOperator.execute(values);
	}
}
