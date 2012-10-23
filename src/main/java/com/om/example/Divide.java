package com.om.example;

import java.math.BigDecimal;

public class Divide extends BinaryMathOperator {
	@Override
	public BigDecimal operation(BigDecimal value1, BigDecimal value2) {
		return value2.divide(value1);
	}
}

