package com.om.example;

import java.util.HashMap;
import java.util.Map;

public class BinaryOperatorFactoryImpl implements OperatorFactory {

	Map<String, MathOperator> operators;

	public BinaryOperatorFactoryImpl() {
		this.operators = new HashMap<String, MathOperator>(); 
		registerOperators();
	}
	
	private void registerOperators() {
		this.addOperator("+", new Add());
		this.addOperator("-", new Substract());
		this.addOperator("*", new Multiply());
		this.addOperator("/", new Divide());
		this.addOperator("!", new Factorial());
		this.addOperator("primefactors", new PrimeFactors());
	}
	
	public void addOperator(String operator, MathOperator mathOperator) {
		if (this.operators.containsKey(operator)) 
			throw new IllegalArgumentException(); 
		this.operators.put(operator, mathOperator);				
	}

	public MathOperator create(String operatorName) {
		MathOperator op = this.operators.get(operatorName);
		if (op == null) {
			throw new UnsupportedOperationException();
		}
		return op;
	}
}
