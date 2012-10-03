package org.test;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TicTacToeTest {
	private Object x = new Object();
	private Object y = new Object();
	private char xmoves;  	
	private char ymoves;  	
	private int numberOfMoves = 0;
	private int MIN_NUMBER_OF_MOVES = 5;	
	private char CROSS = 'X';
	private char NOUGHT = 'O'; 

	@Test
	public void checkThatNumberOfMovesIncreases() {
		moves();
		assertEquals(MIN_NUMBER_OF_MOVES, numberOfMoves);
	}
	
	@Test
	public void checkWhetherXIsAWinner() {
		moves();
		Object winner = getWinner(x);
		assertEquals(x, winner);
	}

	@Test
	public void checkWhetherYIsAWinner() {
		moves();
		Object winner = getWinner(y);
		assertEquals(y, winner);
	}

	@Test(expected = RuntimeException.class)
	public void whenThereIsLessThan5movesThenThereIsNoWinner() {
		moveX(CROSS);
		getWinner(null);
	}
	
	private void moves() {
		moveX(CROSS);
		moveY(CROSS);
		moveX(CROSS);
		moveY(CROSS);
		moveX(CROSS);
	}

	private void moveX(char character) {
		numberOfMoves++;
		xmoves = character; 
	}

	private void moveY(char character) {
		numberOfMoves++;
		ymoves = character;
	}

	private Object getWinner(Object o) {
		if (numberOfMoves >= MIN_NUMBER_OF_MOVES){
			return o;
		} else {
			throw new RuntimeException();	
		}
	}

	@Test
	public void checkThatPlayerChoosenNought() {
		moveX(NOUGHT);		
		assertThat(xmoves, equalTo(NOUGHT)); 
	} 	

	@Test
	public void checkThatPlayerChoosenCross() {
		moveX(CROSS);		
		assertThat(xmoves, equalTo(CROSS)); 
	} 	

	@Test
	public void checkThatPlayerYChoosenNought() {
		moveY(NOUGHT);		
		assertThat(ymoves, equalTo(NOUGHT)); 
	} 	

	@Test
	public void checkThatPlayerYChoosenCross() {
		moveY(CROSS);		
		assertThat(ymoves, equalTo(CROSS)); 
	} 	
}
