package com.om.example;

public interface OperatorFactory {
	public MathOperator create(String operatorName); 
	public void addOperator(String operator, MathOperator mathOperator); 
}
