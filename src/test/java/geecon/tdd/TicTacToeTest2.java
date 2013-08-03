package geecon.tdd;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.Before;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//TODO  zmienic singlejunitrunner by sie nie wywalal jak wywolny na innej metodzie niz test np na before
public class TicTacToeTest2 {
    //private static final List[] WINNING_SEQ = {Arrays.asList(1, 2, 3)""};
    //winning sequences: | 123 |     |     | 1    |  2  |   3 | 1   |   3 |
    //                   |     | 456 |     | 4    |  5  |   6 |  5  |  5  |
    //                   |     |     | 789 | 7    |  8  |   9 |   9 | 7   |

    private static final int MAX_MOVES_NUMBER = 9;
    private List<Integer> moves;

    @Before
    public void givenStartOfGame() {
        moves = new ArrayList<Integer>();
    }

    @Test
    public void afterStartingAGameWhenPlayerMovesNumberOfMovesIsIncreased() {
        whenPlayerMadeNextMove(givenRandomMove());
        thenNumberOfMovesIsIncreasedBy(1);
    }
    
    @Test
    public void afterStartingAGameWhenPlayerMoves2TimesNumberOfMovesIsIncreasedBy2() {
        whenPlayerMadeNextMove(givenRandomMove());
        whenPlayerMadeNextMove(givenRandomMove());
        thenNumberOfMovesIsIncreasedBy(2);
    }

    private void thenNumberOfMovesIsIncreasedBy(int increasedBy) {
         assertThat(moves.size(), equalTo(increasedBy)); 
    }

    @Test
    public void itShouldBePossibleToMove() {
        int move = givenRandomMove();
        whenPlayerMadeNextMove(move);
        thenMoveShouldBeRegistered(move);
    }

    
    private int givenRandomMove() {
        Random r = new Random();
        return generateRandomMoveWithExclusion(moves);
    }

    public int generateRandomMoveWithExclusion(List<Integer> excludeRows) {
        Random rand = new Random();
        int range = MAX_MOVES_NUMBER;
    
        int random = rand.nextInt(range) + 1;
        while(excludeRows.contains(random)) {
            random = rand.nextInt(range) + 1;
        }
    
        return random;
    }
    
    private void whenPlayerMadeNextMove(int move) { 
        moves.add(move); 
    }
    
    private void thenMoveShouldBeRegistered(int move) { 
        assertThat(moves, contains(move));
    }

    @Test
    public void checkIfThereIsAWinner() {
        List<Integer> playerMoves = givenPlayerMoves(1, 2, 3); 
        whenPlayerMadeNextMove(1);
        whenPlayerMadeNextMove(generateRandomMoveWithExclusion(playerMoves));
        whenPlayerMadeNextMove(2);
        whenPlayerMadeNextMove(generateRandomMoveWithExclusion(playerMoves));
        whenPlayerMadeNextMove(3);
        thenThereShouldBeAWinner();
    }
    
    private List<Integer> givenPlayerMoves(int... ints) {
        List<Integer> m = new ArrayList<Integer>();
        for (int i = 0; i < ints.length; i++) {
            m.add(ints[i]);    
        }
        return m;
    }
    
    private void thenThereShouldBeAWinner() {
        List<Integer> movesOfPlayer1 = movesOfPlayerNr(1);
        List<Integer> movesOfPlayer2 = movesOfPlayerNr(2);
        assertThat(movesOfPlayer1, contains(1, 2, 3)); 
    }
    
    private List<Integer> movesOfPlayerNr(int playerNr) {
        List<Integer> movesOfOnePlayer = new ArrayList<Integer>();
        for (int i = 0; i < moves.size(); i++) {
            if (i % 2 == playerNr - 1) {
                movesOfOnePlayer.add(moves.get(i));   
            } 
        }
        return movesOfOnePlayer;
    }
}
