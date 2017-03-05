import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * the program is used to test the output format and whether the array has 0 inside.
 * @version 2016-11-30
 * @author ChuanheLiu
 *
 */
public class TestForEx1 {


	/**
	 * test 1
	 * use an array and a string to test
	 */
	@Test
	public void test1(){


		int[][] array= {
				{1,2,3,4,5,6,7,8,9},
				{4,5,6,7,8,9,1,2,3},
				{7,8,9,1,2,3,4,5,6},
				{2,3,4,5,6,7,8,9,1},
				{5,6,7,8,9,1,2,3,4},
				{8,9,1,2,3,4,5,6,7},
				{3,4,5,6,7,8,9,1,2},
				{6,7,8,9,1,2,3,4,5},
				{9,1,2,3,4,5,6,7,8}};	

		Sudoku sudoku = new Sudoku(array);

		String expected 
		= "++===+===+===++===+===+===++===+===+===++\n"
				+ "|| 1 | 2 | 3 || 4 | 5 | 6 || 7 | 8 | 9 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 4 | 5 | 6 || 7 | 8 | 9 || 1 | 2 | 3 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 7 | 8 | 9 || 1 | 2 | 3 || 4 | 5 | 6 ||\n"
				+ "++===+===+===++===+===+===++===+===+===++\n"
				+ "|| 2 | 3 | 4 || 5 | 6 | 7 || 8 | 9 | 1 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 5 | 6 | 7 || 8 | 9 | 1 || 2 | 3 | 4 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 8 | 9 | 1 || 2 | 3 | 4 || 5 | 6 | 7 ||\n"
				+ "++===+===+===++===+===+===++===+===+===++\n"
				+ "|| 3 | 4 | 5 || 6 | 7 | 8 || 9 | 1 | 2 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 6 | 7 | 8 || 9 | 1 | 2 || 3 | 4 | 5 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 9 | 1 | 2 || 3 | 4 | 5 || 6 | 7 | 8 ||\n"
				+ "++===+===+===++===+===+===++===+===+===++";
		String actual =sudoku.toString();

		assertEquals(expected, actual);
	}



	/**
	 * test 2
	 * there are 0 in the array the output should be space respectively
	 */


	@Test
	public void test2(){


		int[][] array= {
				{1,2,3,4,5,6,7,8,9},
				{4,5,0,0,8,0,0,2,3},
				{7,0,0,0,0,0,0,0,6},
				{2,0,0,0,0,0,0,0,1},
				{5,6,0,0,0,0,0,3,4},
				{8,9,1,0,0,0,5,6,7},
				{3,4,5,6,0,8,9,1,2},
				{6,7,8,9,1,2,3,4,5},
				{9,1,2,3,4,5,6,7,8}};	

		Sudoku sudoku = new Sudoku(array);

		String expected 
		= "++===+===+===++===+===+===++===+===+===++\n"
				+ "|| 1 | 2 | 3 || 4 | 5 | 6 || 7 | 8 | 9 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 4 | 5 |   ||   | 8 |   ||   | 2 | 3 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 7 |   |   ||   |   |   ||   |   | 6 ||\n"
				+ "++===+===+===++===+===+===++===+===+===++\n"
				+ "|| 2 |   |   ||   |   |   ||   |   | 1 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 5 | 6 |   ||   |   |   ||   | 3 | 4 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 8 | 9 | 1 ||   |   |   || 5 | 6 | 7 ||\n"
				+ "++===+===+===++===+===+===++===+===+===++\n"
				+ "|| 3 | 4 | 5 || 6 |   | 8 || 9 | 1 | 2 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 6 | 7 | 8 || 9 | 1 | 2 || 3 | 4 | 5 ||\n"
				+ "++---+---+---++---+---+---++---+---+---++\n"
				+ "|| 9 | 1 | 2 || 3 | 4 | 5 || 6 | 7 | 8 ||\n"
				+ "++===+===+===++===+===+===++===+===+===++";
		String actual =sudoku.toString();

		assertEquals(expected, actual);
	}
	
	

	
	/**
	 * test 3
	 * to test whether the array contents 0
	 *  * it should be true because without 0 in the array
	 */
	@Test
	public void test3(){


		int[][] array= {
				{1,2,3,4,5,6,7,8,9},
				{4,5,6,7,8,9,1,2,3},
				{7,8,9,1,2,3,4,5,6},
				{2,3,4,5,6,7,8,9,1},
				{5,6,7,8,9,1,2,3,4},
				{8,9,1,2,3,4,5,6,7},
				{3,4,5,6,7,8,9,1,2},
				{6,7,8,9,1,2,3,4,5},
				{9,1,2,3,4,5,6,7,8}};	

		Sudoku sudoku = new Sudoku(array);

		boolean expected = true;
		boolean actual =sudoku.isFilled();

		assertEquals(expected, actual);
	}



	/**
	 * test 3
	 * to test whether the array contents 0
	 * it should be false because with 0 in the array
	 */

	@Test
	public void test4(){


		int[][] array= {
				{1,2,3,4,5,6,7,8,9},
				{4,5,0,0,8,0,0,2,3},
				{7,0,0,0,0,0,0,0,6},
				{2,0,0,0,0,0,0,0,1},
				{5,6,0,0,0,0,0,3,4},
				{8,9,1,0,0,0,5,6,7},
				{3,4,5,6,0,8,9,1,2},
				{6,7,8,9,1,2,3,4,5},
				{9,1,2,3,4,5,6,7,8}};	

		Sudoku sudoku = new Sudoku(array);

		boolean expected = false;
		boolean actual =sudoku.isFilled();


		assertEquals(expected, actual);
	}

}