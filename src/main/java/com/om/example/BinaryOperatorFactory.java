package com.om.example;

public class BinaryOperatorFactory {
	public void create(String operatorName, OperandStack values) {
		MathOperator op = null;
		if (operatorName.equals("+")) {
			op = new Add();
		} else if (operatorName.equals("-")) {
			op = new Substract();
		} else if (operatorName.equals("*")) {
			op = new Multiply();
		} else if (operatorName.equals("!")) {
			op = new Factorial();
		} else if (operatorName.equals("/")) {
			op = new Divide();
		} else {
			throw new UnsupportedOperationException();
		}
		op.execute(values);
	}
}
