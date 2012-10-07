package com.om.example;

import java.math.BigDecimal;
import java.util.Stack;

public class RpnCalculator {
	
	private Stack<BigDecimal> values = new Stack<BigDecimal>();

	public BigDecimal getAccumulator() {
		if (this.values.size() > 0) 
			return values.peek();  
		else
			return BigDecimal.ZERO; 
	}

	public void setAccumulator(BigDecimal value) {
		if (this.values.size() > 0) {
			this.values.pop();
		}
		this.values.push(value);
	}

	public void enter() {
		this.values.push(getAccumulator());
	}	
	
	public void drop() {
		if (this.values.size() > 0) 
			this.values.pop();
	}
	
	public Stack<BigDecimal> getStack() {
		return  this.values;
	}
}
