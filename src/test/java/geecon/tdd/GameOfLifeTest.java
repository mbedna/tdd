package geecon.tdd;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.HashSet;

public class GameOfLifeTest {
    
    //Rules
    //
    //    Martwa komórka, która ma dokładnie 3 żywych sąsiadów, staje się żywa w następnej jednostce czasu (rodzi się)
    //        Żywa komórka z 2 albo 3 żywymi sąsiadami pozostaje nadal żywa; przy innej liczbie sąsiadów umiera (z "samotności" albo "zatłoczenia").
    //

    private Cell cell;

	@Before
	public void setUp() {
        this.cell = new Cell(0, 0); 
	}
	
	@Test
	public void it_can_be_in_alive_state() {
        cell.setAlive();
		assertThat(cell.getState(), equalTo(Cell.STATE.ALIVE));
	}

	@Test
	public void it_can_be_in_dead_state() {
        cell.setDead();
		assertThat(cell.getState(), equalTo(Cell.STATE.DEAD));
	}
      
    @Test
    public void it_has_position() {
        cell = new Cell(3, 4);
        assertThat(cell.getX(), equalTo(3));
        assertThat(cell.getY(), equalTo(4));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void position_X_should_be_greater_or_equal_0() {
        cell = new Cell(-1, 0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void position_Y_should_be_greater_or_equal_0() {
        cell = new Cell(0, -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_be_possible_to_have_2_cells_with_same_position() {
        Cell cell1 = new Cell(0, 5);
        Cell cell2 = new Cell(0, 5);
        Board board = new Board();
        board.add(cell1);
        board.add(cell2);
        System.out.println(board.size());
    }
    
    private static class Board {  
        private Set set = new HashSet();        
        
        
        public void add(Cell cell) {
            if (set.contains(cell)) throw new IllegalArgumentException();
            set.add(cell);
        }

        public int size() {
            return set.size();
        }
    }
}

