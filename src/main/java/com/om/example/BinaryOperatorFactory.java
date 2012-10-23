package com.om.example;

import java.util.HashMap;
import java.util.Map;

public class BinaryOperatorFactory implements OperatorFactory {

	private Map<String, MathOperator> operators;

	public BinaryOperatorFactory() {
		this.operators = new HashMap<String, MathOperator>(); 
		this.registerOperators();
	}
			
	private void registerOperators() {
		this.operators.put("+", new Add());
		this.operators.put("-", new Substract());
		this.operators.put("*", new Multiply());
		this.operators.put("/", new Divide());
		this.operators.put("!", new Factorial());
	}

	public MathOperator create(String operatorName) {
		MathOperator op = this.operators.get(operatorName);
		if (op == null) {
			throw new UnsupportedOperationException();
		}
		return op;
	}
}
