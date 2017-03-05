import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The program is the test of class SudokuCheck
 * @version 2016-11-30
 * @author ChuanheLiu
 *
 */
public class TestForEx3 {

	
	// The array[1][1] is wrong.
	int[][] array= {
			{1,2,3,4,5,6,7,8,9},
			{4,2,6,7,8,9,1,2,3},
			{7,8,9,1,2,3,4,5,6},
			{2,3,4,5,6,7,8,9,1},
			{5,6,7,8,9,1,2,3,4},
			{8,9,1,2,3,4,5,6,7},
			{3,4,5,6,7,8,9,1,2},
			{6,7,8,9,1,2,3,4,5},
			{9,1,2,3,4,5,6,7,8}};	
	Sudoku sc = new Sudoku(array);

	@Test

	public void test1(){

		boolean actual = SudokuCheck.checkRow(sc, 7);
		boolean expected = true;

		assertEquals(expected, actual);

	}

	@Test

	public void test2(){

		boolean actual = SudokuCheck.checkColumn(sc, 7);
		boolean expected = true;

		assertEquals(expected, actual);

	}

	@Test

	public void test3(){

		boolean actual = SudokuCheck.checkSquare(sc, 8);
		boolean expected = true;

		assertEquals(expected, actual);

	}



	@Test
	public void test4(){

		boolean actual = SudokuCheck.checkRow(sc, 1);
		boolean expected = false;

		assertEquals(expected, actual);

	}

	@Test
	public void test5(){

		boolean actual = SudokuCheck.checkColumn(sc, 1);
		boolean expected = false;

		assertEquals(expected, actual);

	}


	@Test
	public void test6(){

		boolean actual = SudokuCheck.checkSquare(sc, 1);
		boolean expected = true;

		assertEquals(expected, actual);

	}


	@Test
	public void test7(){

		boolean actual = SudokuCheck.checkRow(sc, 0);
		boolean expected = true;

		assertEquals(expected, actual);

	}



	@Test
	public void test8(){

		boolean actual = SudokuCheck.checkColumn(sc, 0);
		boolean expected = true;

		assertEquals(expected, actual);

	}



	@Test
	public void test9(){

		boolean actual = SudokuCheck.checkSquare(sc, 0);
		boolean expected = false;

		assertEquals(expected, actual);

	}

	@Test
	public void test10(){

		boolean[][] actual = SudokuCheck.check(sc);
		boolean[][] expected = {
				{true,false,true,true,true,true,true,true,true,},
				{true,false,true,true,true,true,true,true,true,},
				{false,true,true,true,true,true,true,true,true,},
		};

		assertArrayEquals(expected, actual);

	}

	@Test
	public void test11(){
		int[][] array2= {
				{1,2,3,4,5,6,7,8,9},
				{4,5,6,7,8,9,1,2,3},
				{7,8,9,1,2,3,4,5,6},
				{2,3,4,5,6,7,8,9,1},
				{5,6,7,8,9,1,2,3,4},
				{8,9,1,2,3,4,5,6,7},
				{3,4,5,6,7,8,9,1,2},
				{6,7,8,9,1,2,3,4,5},
				{9,1,2,3,4,5,6,7,8}};	
		Sudoku sc2 = new Sudoku(array2);
		boolean[][] actual = SudokuCheck.check(sc2);
		boolean[][] expected = {
				{true,true,true,true,true,true,true,true,true,},
				{true,true,true,true,true,true,true,true,true,},
				{true,true,true,true,true,true,true,true,true,},
		};

		assertArrayEquals(expected, actual);

	}


}
