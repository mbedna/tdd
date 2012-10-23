package com.om.example;

public class BinaryOperatorFactory {
	public static void create(String operatorName, OperandStack values) {
		MathOperator op = null;
		if (operatorName.equals("+")) {
			op = new Add(values);
		} else if (operatorName.equals("-")) {
			op = new Substract(values);
		} else if (operatorName.equals("*")) {
			op = new Multiply(values);
		} else if (operatorName.equals("!")) {
			op = new Factorial(values);
		} else if (operatorName.equals("/")) {
			op = new Divide(values);
		} else {
			throw new UnsupportedOperationException();
		}
		op.execute();
	}
}
