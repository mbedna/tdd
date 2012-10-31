package com.om.example;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
public class BinaryOperatorFactoryTest {
	
	private BinaryOperatorFactoryImpl binaryOperatorFactory;

	@Before
	public void init() {
		binaryOperatorFactory = new BinaryOperatorFactoryImpl();
	}

	@Test
	public void shouldBeAbleToaddNewOperators() {
		assertThat(binaryOperatorFactory.operators.size(), greaterThan(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenTryingToAddSameOperator() {
		binaryOperatorFactory.operators = new HashMap<String, MathOperator>();
		binaryOperatorFactory.addOperator("+", new Add());
		binaryOperatorFactory.addOperator("+", new Substract());
	}
	
	@Test
	public void shouldHaveAPossibilityToRegisterAddOperator() {
		binaryOperatorFactory.create("+");
	}

	@Test
	public void shouldHaveAPossibilityToRegisterMinusOperator() {
		binaryOperatorFactory.create("-");
	}
		
	@Test
	public void shouldHaveAPossibilityToRegisterFactorialOperator() {
		binaryOperatorFactory.create("!");
	}

	@Test
	public void shouldHaveAPossibilityToRegisterMultiplyOperator() {
		binaryOperatorFactory.create("*");
	}

	@Test
	public void shouldHaveAPossibilityToRegisterDivideOperator() {
		binaryOperatorFactory.create("/");
	}

	@Test
	public void shouldHaveAPossibilityToRegisterPrimeFactorsOperator() {
		binaryOperatorFactory.create("primefactors");
	}
		
	@Test(expected = UnsupportedOperationException.class)
	public void shouldThrowExceptionWhenNotRegisteredOperatorUsed() {
		binaryOperatorFactory.create("not registered operator");
	}
}
