/**
 * The program can solve the sudoku problems,
 * and the program fill all the blanks and make sure to be right.
 * @version 2016-12-1
 * @author ChuanheLiu
 *
 */
public class SudokuSolve {
	
	public int[][] array;
	/**
	 * getter to get the array[][]from a SudokuSolve
	 * @return
	 */
	public int[][] getArray() {
		return array;
	}
	
	/**
	 * getter to set the array[][] of a SudokuSolve
	 * @return
	 */
	public void setArray(int[][] array) {
		this.array = array;
	}

	/**
	 * This is the constructor to create a SudokuSolve with only a two-dimensional array
	 */
	public SudokuSolve(int[][] array) {
	
		this.array = array;
	}

	/**
	 * This is the first step to solve the sudoku problems
	 * this method can find the only one possibility left for particular field.
	 * @param sudoku
	 * @param row
	 * @param column
	 * @return fill in the particular and get a new sudoku
	 */
	public static Sudoku step1(Sudoku sudoku,int row,int column){
		int count = 0;
		int x = 0;
		//define y to save the original value to in case that the sudoku change when it does not need to.
		int y = sudoku.getArray()[row][column];
		//the method to get the square number by row number and column number.
		int square = row/3 *3 + column/3;
		for(int i = 9; i > 0; i--){
			sudoku.getArray()[row][column] = i;
			if(SudokuCheck.checkRow(sudoku,row) == true 
				&& SudokuCheck.checkColumn(sudoku, column) == true
				&& SudokuCheck.checkSquare(sudoku, square) == true){
				x = i;
				//When meet the condition count +1
				count++;
			}
		}
		//Only when count = 1 means that only one blank file.
		if(count == 1){
			sudoku.getArray()[row][column] = x;
			return sudoku;	
		}
		else{
			//Else recover the value
			sudoku.getArray()[row][column] = y;
			return sudoku;
		}
	}

	/**
	 * This is the second step to solve the sudoku problems
	 * this method can find the location to a certain number.
	 * @param sudoku
	 * @param row
	 * @param column
	 * @return fill in locations with a certain number and get a new sudoku
	 */
	public static Sudoku step2(Sudoku sudoku,int x){
		int count = 0;
		int m = 0, n= 0;
		// Try the number x on every file.
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(sudoku.getArray()[i][j] == 0){
					count++;
					m=i;
					n=j;
				}
			}
			//Only when count = 1 means that only one blank file 
			if(count == 1){
				//Try x
				sudoku.getArray()[m][n] = x;
				//meet the condition
				if(SudokuCheck.checkRow(sudoku,m) == true 
						&& SudokuCheck.checkColumn(sudoku, n) == true
						&& SudokuCheck.checkSquare(sudoku, m/3*3 + n/3) == true)
					return sudoku;
				else{
					//if not meet the conditional recover the value
					sudoku.getArray()[m][n] = 0;
					return sudoku;
				}
			}
		}	
		//if not meet the conditional recover the value
		sudoku.getArray()[m][n] = 0;
		return sudoku;
	}

	/**
	 * This method can get an array[] in a particular row
	 * This method is mainly called by fillRowBlank() method
	 * Although it is necessary I still write it just in case.
	 * 
	 * @param sudoku
	 * @param the number of row
	 * @return an int array
	 */
	public static int[] rowToArray(Sudoku sudoku, int row){
		return sudoku.getArray()[row];
	}
	
	/**
	 * This method can get an array[] in a particular column
	 * This method is mainly called by fillColumnBlank() method
	 * Although it is necessary I still write it just in case.
	 * 
	 * @param sudoku
	 * @param the number of column
	 * @return an int array
	 */
	public static int[] columnToArray(Sudoku sudoku, int column){
		int[] a = new int[9];
		int[][] array = sudoku.getArray();
		//Extract all column elements to an array
		for(int i = 0; i < 9; i++){
			a[i] = array[i][column];
		}
		return a;
	}

	/**
	 * This method can get the number when the array left only one blank.
	 * The conditional is the same with the sudoku.
	 * It is not necessary but I still use it just in case.
	 * @param array
	 * @return the method does not return  but it can change the array.
	 */
	public static void fillRowBlank(int [] array){
		int count = 0, element = 0;
		for (int i = 0; i < 9; i++) {
			if(array[i] == 0){
				count++;
				element = i;
			}
		}
		if(count == 1){
			//try i
			for (int i = 1; i <= 9; i++){
				//element j
				int count2 = 0;
				for(int j = 0; j < 9; j++){
					if(array[j] == i){
						count2++;
					}
				}
				//i is not exist
				if(count2 == 0){
					array[element] = i;
				}
			}
		}

	}

	/**
	 * This method can get the number when the column left only one blank.
	 * It is not necessary but I still use it just in case.
	 * 
	 * 
	 * @param sudoku
	 * @param the number of column
	 * @return the method does not return  but it can change the array.
	 */
	public static void fillColumnBlank(Sudoku sudoku,int i){
		int [] column = columnToArray(sudoku, i);
		int count = 0;
		for (int x = 0; x < 9; x++) {
			if (column[x] == 0)
				count++;
		}
		if(count == 1){
			fillRowBlank(column);
		}
		for (int j = 0; j < 9; j++) {
			sudoku.getArray()[j][i] = column[j];

		}

	}
	
	/**
	 * This method is the solve method which is the most important part.
	 * the method can fill all the blanks in a sudoku.
	 * @param sudoku
	 * @return nothing to return but change the sudoku.
	 */
	public static void solve(Sudoku sudoku){
		//define a flag which is used to control the condition of while loop. 
		boolean flag = true;
		while(flag){
			String check = new String(sudoku.toString());
			// call the two steps one by one.
			// does not break the loop when meet the if(check.equals(sudoku.toString())) condition
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if(sudoku.getArray()[i][j]==0){
						sudoku = step1(sudoku, i, j);
					}
					sudoku = step2(sudoku, j);
				}
			}
			
			//when the sudoku does not change any more break the loop
			if(check.equals(sudoku.toString())){
				flag = false;
			}
		}	
		
		//this loop can fill rows and columns with only blank
		//it is unnecessary.
		w:while(true){
			String check = new String(sudoku.toString());
			for(int i = 0; i < 9; i++){
				fillRowBlank(sudoku.getArray()[i]);
				fillColumnBlank(sudoku, i);
			}
			if(check.equals(sudoku.toString())){
				break w;
			}
		}
	}
	
	/**
	 * main method to show and help me coding.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		int[][] array = SudokuRead.readSudoku("sudoku-difficult.txt").getArray();
		Sudoku si = new Sudoku(array);
		System.out.println(si.toString());
		solve(si);
	
		System.out.println("\n\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n\n"
				+ "RESULT:");
		System.out.println(si.toString());

	}

}


