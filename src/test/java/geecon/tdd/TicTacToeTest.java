package geecon.tdd;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {
	private Object x;
	private Object y;
	private int numberOfMoves = 0;
	private int MIN_NUMBER_OF_MOVES = 5;
	private char CROSS = 'X';
	private char NOUGHT = 'O';

	private char[] xmoves = new char[5];
	private char[] ymoves = new char[5];

	@Before
	public void setUp() {
		x = new Object();
		y = new Object();
	}
	
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
		move(x, CROSS);
		getWinner(null);
	}

	private void moves() {
		move(x, CROSS);
		move(y, CROSS);
		move(x, CROSS);
		move(y, CROSS);
		move(x, CROSS);
	}
	
	private void move(Object player, char character) {
		if (player.equals(x)) {
			xmoves[numberOfMoves] = character;	
		}
		
		if (player.equals(y)) {
			ymoves[numberOfMoves] = character;	
		}
		numberOfMoves++;
	}

	private Object getWinner(Object o) {
		if (numberOfMoves >= MIN_NUMBER_OF_MOVES) {
			return o;
		} else {
			throw new RuntimeException();
		}
	}

	@Test
	public void checkThatPlayerChoosenNought() {
		move(x, NOUGHT);
		assertThat(xmoves[getLastMove()], equalTo(NOUGHT));
	}

	@Test
	public void checkThatPlayerChoosenCross() {
		move(x, CROSS);
		assertThat(xmoves[getLastMove()], equalTo(CROSS));
	}

	@Test
	public void checkThatPlayerYChoosenNought() {
		move(y, NOUGHT);
		assertThat(ymoves[getLastMove()], equalTo(NOUGHT));
	}

	@Test
	public void checkThatPlayerYChoosenCross() {
		move(y, CROSS);
		assertThat(ymoves[getLastMove()], equalTo(CROSS));
	}

	@Test
	public void checkThatPlayerYChoosen2Crosses() {
		move(y, CROSS);
		move(y, CROSS);
		assertThat(ymoves[getOneBeforeLastMove()], equalTo(CROSS));
		assertThat(ymoves[getLastMove()], equalTo(CROSS));
	}

	@Test
	public void checkThatPlayerXChoosen2Crosses() {
		move(x, CROSS);
		move(x, CROSS);
		assertThat(xmoves[getOneBeforeLastMove()], equalTo(CROSS));
		assertThat(xmoves[getLastMove()], equalTo(CROSS));
	}

	private int getLastMove() {
		return numberOfMoves - 1;
	}

	private int getOneBeforeLastMove() {
		return numberOfMoves - 2;
	}
}

