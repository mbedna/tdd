package org.test;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;
//import static org.hamcrest.Matchers.*;

public class TicTacToeTest {
	private Object x = new Object();
	private Object y = new Object();
	private int numberOfMoves = 0;
	private int MIN_NUMBER_OF_MOVES = 5;	

	private Object getWinner(Object o) {
		if (numberOfMoves >= MIN_NUMBER_OF_MOVES){
			return o;
		} else {
			return null;
		}
	}

	private void moveX() {
		numberOfMoves++;
	}

	private void moveY() {
		numberOfMoves++;
	}
	
	private void moves() {
		moveX();
		moveY();
		moveX();
		moveY();
		moveX();
	}
	
	@Test
	public void checkWhetherXIsAWinner() {
		moves();
		Object winner = getWinner(x);
		Class<?> clazz = winner.getClass();
		assertEquals(x, winner);
	}

	@Test
	public void checkWhetherYIsAWinner() {
		moves();
		Object winner = getWinner(y);
		assertEquals(y, winner);
	}

	@Test
	public void checkIfIsNoWinner() {
		moves();
		Object winner = getWinner(null);
		assertEquals(null, winner);
	}

	
	@Test
	public void checkThatNumberOfMovesIncreases() {
		moves();
		assertEquals(MIN_NUMBER_OF_MOVES, numberOfMoves);
	}

	@Test
	public void checkThatPlayer1ChoosenNought() {
	//	assertThat(x, is(x)); 
	} 	


}
