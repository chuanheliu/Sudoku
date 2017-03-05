
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


/**
 * The program is used to test the class SudokuRead.
 * @version 2016-11-30
 * @author ChuanheLiu
 *
 */

public class TestForEx2 {


	/**
	 * This test is used for read the files 
	 * Exception do not handled in this test.
	 * @throws Exception
	 */
	@Test

	
	/**
	 * Test 1 read the file and change the space to 0 
	 * and create the two-dimension array
	 * @throws Exception
	 */
	public void test1()throws Exception{

		String filename = "ex2Test1.txt";
		int[][] actual = SudokuRead.readSudoku(filename).getArray();

		int[][] expected= {
				{0,2,3,4,5,6,7,0,9},
				{4,5,6,7,8,9,1,2,0},
				{7,8,9,1,2,3,4,5,0},
				{2,3,4,0,6,7,8,9,1},
				{5,6,7,8,9,1,0,3,4},
				{8,9,1,2,0,4,5,6,7},
				{3,4,0,6,7,8,9,1,2},
				{6,0,8,9,1,2,3,4,5},
				{0,1,2,3,4,5,6,7,8}};

		assertArrayEquals(expected, actual);

	}


	/**
	 * test 2
	 * This test is used for read the files as well
	 * The characters out of 9X9 array is not qualified but unaffected for the array.
	 * Exception do not handled in this test.
	 * @throws Exception
	 */
	@Test

	public void test2()throws Exception{

		String filename = "ex2Test2.txt";
		int[][] actual = SudokuRead.readSudoku(filename).getArray();

		int[][] expected= {
				{0,2,3,4,5,6,7,0,9},
				{4,5,6,7,8,9,1,2,0},
				{7,8,9,1,2,3,4,5,0},
				{2,3,4,0,6,7,8,9,1},
				{5,6,7,8,9,1,0,3,4},
				{8,9,1,2,0,4,5,6,7},
				{3,4,0,6,7,8,9,1,2},
				{6,0,8,9,1,2,3,4,5},
				{0,1,2,3,4,5,6,7,8}};

		assertArrayEquals(expected, actual);

	}


	/**
	 * test 3
	 * This test is mainly for the UnexpectedNumberException which is about the wrong characters in the file
	 * I change a number to 'k' which is marked by some words 
	 * @throws Exception
	 */
	@Test

	public void test3()throws Exception{

		try{
			String filename = "ex2Test3.txt";
			
			//It is not used but I did not remove it because it may useful if everything is all right
			int[][] actual = SudokuRead.readSudoku(filename).getArray(); 
		}
		catch(UnexpectedNumberException une){
			assertTrue(une instanceof UnexpectedNumberException);
	        assertTrue(une.getMessage().contains("all charactrs should be space or 1-9(including 1 and 9)"));
		}
	}
	
	
	/**
	 * test 4
	 * This test is mainly for the IOException which is about the wrong filename or path.
	 * no file named "ex2Test4.txt"
	 * @throws UException
	 */
	
	@Test

	public void test4()throws Exception{

		try{
			String filename = "ex2Test4.txt";
			
			//It is not used but I did not remove it because it may useful if everything is all right
			int[][] actual = SudokuRead.readSudoku(filename).getArray();
		}
		catch(IOException ioe){
			assertTrue(ioe instanceof IOException);
	        assertTrue(ioe.getMessage().contains("ex2Test4.txt (No such file or directory)"));
		}
	}

	
	/**
	 * test 5
	 * This test is mainly for the Exception which is about the insufficient characters for 9X9 array.
	 * the file "ex2Test5.txt" have only one character
	 * @throws Exception
	 */
	@Test

	public void test5()throws Exception{

		try{
			String filename = "ex2Test5.txt";
			
			//It is not used but I did not remove it because it may useful if everything is all right
			int[][] actual = SudokuRead.readSudoku(filename).getArray();
		}
		catch(InsufficientCharactersException ioe){
			assertTrue(ioe instanceof InsufficientCharactersException);
	        assertTrue(ioe.getMessage().contains("insufficient characters in the file"));
		}
	}

}


