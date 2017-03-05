/**
 * The program can check whether the row, column and 3X3 square is qualified.
 * and check the array and return an boolean array to describe all the rows, columns and small squares.
 * @version 2016-11-30
 * @author ChuanheLiu
 *
 */
public class SudokuCheck {
	
	/**
	 * The method can check an array if there are same elements.
	 * All other methods in this class based on this method.
	 * @param array
	 * @return true means all elements are different and false means not.
	 */
	public static boolean checkArray(int[] array){
		for(int i = 0; i < 9; i++){
			for(int j = i + 1; j < 9; j++){
				if(array[i] == array[j] && array[i]!=0)
					return false;
			}
		}
		return true;
	}
	
	
	/**
	 * The method can check the certain row whether there are same elements
	 * @param sudoku
	 * @param row
	 * @return true means all elements are different and false means not.
	 */
	public static boolean checkRow(Sudoku sudoku,int row){
		int[][] array = sudoku.getArray();
		return checkArray(array[row]);
	}
	
	
	/**
	 * The method can check the certain column whether there are same elements
	 * @param sudoku
	 * @param column
	 * @return true means all elements are different and false means not.
	 */
	public static boolean checkColumn(Sudoku sudoku,int column){
		int[] a = new int[9];
		int[][] array = sudoku.getArray();
		//Extract all column elements to an array
		for(int i = 0; i < 9; i++){
			a[i] = array[i][column];
		}
		return checkArray(a);
	}
	
	/**
	 * The method can check the certain 3X3 square whether there are same elements
	 * @param sudoku
	 * @param square
	 * @return true means all elements are different and false means not.
	 */
	public static boolean checkSquare(Sudoku sudoku,int square){
		int[] a = new int[9];
		int[][] array = sudoku.getArray();
		
		int x = square / 3;
		int y = square % 3;
		//Extract all 3X3 square elements to an array
		for(int i = 0; i < 3; i++){
			for(int j = 0; j< 3; j++)
				a[i*3+j] = array[x*3 + i][y*3 + j];	

		}
		return checkArray(a);
	}
	
	/**
	 * The method can describe a suduku with the two-dimensional boolean array
	 * and the first row check all the rows, the second row check all the column and the last row check all the 3X3 squares
	 * @param sudoku
	 * @return two-dimensional boolean array
	 */
	public static boolean[][] check(Sudoku sudoku){
		boolean[][] b = new boolean[3][9];
		for (int i = 0; i < 9; i++) {
			b[0][i] = checkRow(sudoku, i) ;
			b[1][i] = checkColumn(sudoku, i);
			b[2][i] = checkSquare(sudoku, i);
		}
		return b;
	}
	
	
}
