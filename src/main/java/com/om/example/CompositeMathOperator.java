package com.om.example;

import java.util.List;
import java.util.ArrayList;

public class CompositeMathOperator implements MathOperator {
	
	List<MathOperator> mathOperators;
	private OperatorFactory operatorFactory;

	public CompositeMathOperator() {
		this.mathOperators = new ArrayList<MathOperator>();
		this.operatorFactory = new BinaryOperatorFactoryImpl();
	}

	@Override
	public void execute(OperandStack operandStack) {
		for(int i = 0; i < mathOperators.size(); i++) {
			MathOperator mathOperator = mathOperators.get(i);
			System.out.println( mathOperator);
			mathOperator.execute(operandStack);
		}	
	}
	
	public void register(String op) {
		this.mathOperators.add(operatorFactory.create(op));
	}
}
