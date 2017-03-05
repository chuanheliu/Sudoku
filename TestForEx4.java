import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * this is the test for ex4 
 * @version 2016--
 * @author ChuanheLiu
 *
 */
public class TestForEx4 {
	
	
	@Test
	public void test1() throws IllegalArgumentException, IOException, UnexpectedNumberException, InsufficientCharactersException{

		int[][] array = SudokuRead.readSudoku("sudoku-ex4.txt").getArray();
		
		SudokuInteractive sudoku = new SudokuInteractive(array);

		String actual = sudoku.toString();

		

		String expected =
				"      1   2   3    4   5   6    7   8   9\n"
				+ "   ++===+===+===++===+===+===++===+===+===++\n"
				+ "a  ||   |*1*|   ||   |   |*2*||*3*|   |*6*||\n"
				+ "   ++---+---+---++---+---+---++---+---+---++\n"
				+ "b  ||   |   |*8*||*9*|   |   ||*7*|   |   ||\n"
				+ "   ++---+---+---++---+---+---++---+---+---++\n"
				+ "c  ||   |*2*|   ||*1*|   |   ||   |*4*| 8 ||\n"
				+ "   ++===+===+===++===+===+===++===+===+===++\n"
				+ "d  ||   |*4*|   || 2 |*7*|   ||   |*3*|   ||\n"
				+ "   ++---+---+---++---+---+---++---+---+---++\n"
				+ "e  ||*8*|   |   ||   |*9*|   ||   |   |*5*||\n"
				+ "   ++---+---+---++---+---+---++---+---+---++\n"
				+ "f  ||   |   |*2*||   | 1 |*5*||*8*|*6*|   ||\n"
				+ "   ++===+===+===++===+===+===++===+===+===++\n"
				+ "g  ||*1*|*8*|   ||   |   |*6*||   |*9*|   ||\n"
				+ "   ++---+---+---++---+---+---++---+---+---++\n"
				+ "h  ||   |   |*3*||   |*4*|*9*||   |   |*1*||\n"
				+ "   ++---+---+---++---+---+---++---+---+---++\n"
				+ "i  || 6 |   |*9*||*8*|   |   ||*4*|   |*7*||\n"
				+ "   ++===+===+===++===+===+===++===+===+===++";
	

		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test2() throws IllegalArgumentException, IOException, UnexpectedNumberException, InsufficientCharactersException{

		int[][] array = SudokuRead.readSudoku("sudoku-ex3.txt").getArray();
		
		SudokuInteractive sudoku = new SudokuInteractive(array);

		String actual = sudoku.toString();

		

		String expected =
			        "      1   2   3    4   5   6    7   8   9\n"
			      + "   ++===+===+===++===+===+===++===+===+===++\n"
			      + "a  ||   |*4*|   ||   |   |*7*||   | 9 |   ||\n"
			      + "   ++---+---+---++---+---+---++---+---+---++\n"
			      + "b  ||*2*|   |   ||   |   |   ||   |*8*| 4 ||\n"
			      + "   ++---+---+---++---+---+---++---+---+---++\n"
			      + "c  ||   |   |   ||*6*|*9*|   ||   |   |   ||\n"
			      + "   ++===+===+===++===+===+===++===+===+===++\n"
			      + "d  ||   |   |*7*||   |*4*|   ||   |   |*9*||\n"
			      + "   ++---+---+---++---+---+---++---+---+---++\n"
			      + "e  ||   |   |*5*||*9*|   |*3*|| 2 |   |   ||\n"
			      + "   ++---+---+---++---+---+---++---+---+---++\n"
			      + "f  ||*4*|   |   ||   | 8 |   ||*3*|   |   ||\n"
			      + "   ++===+===+===++===+===+===++===+===+===++\n"
			      + "g  ||   |   |   ||   |*7*|*6*||   |   |   ||\n"
			      + "   ++---+---+---++---+---+---++---+---+---++\n"
			      + "h  ||*7*| 2 |   ||   |   |   ||   |   |*5*||\n"
			      + "   ++---+---+---++---+---+---++---+---+---++\n"
			      + "i  ||   |*5*|   ||*2*|   |   ||   |*1*|   ||\n"
			      + "   ++===+===+===++===+===+===++===+===+===++";

	

		assertEquals(expected, actual);
	}

}
