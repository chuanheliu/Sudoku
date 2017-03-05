/**
 * The program can output an 9X9array on the screen and show in a particular
 * and it can also  judge whether there are 0 in the array which means space in the sudoku.
 * @version 2016-11-30
 * @author ChuanheLiu
 *
 */


public class Sudoku {
	private int[][] array;
	/**
	 * This is the constructor to create a Sudoku with only a two-dimensional array
	 */
	public Sudoku(int[][] array) {
		this.array = array;
	}

	
	/**
	 * This is the setter which can set the array of Sudoku 
	 * @param nothing to return
	 */
	public void setArray(int [][] array){
		this.array = array;
	}
	
	/**
	 * This is the getter which can get the array of Sudoku
	 * @return a two-dimensional array
	 */
	public int[][] getArray(){
		return this.array;
	}
	
	/**
	 * This is the toString method which can be printed
	 * 
	 * @return a String which is based on the requirement.
	 */
	public String toString(){
		
		//Use the StringBuffer to save String.
		StringBuffer sb = new StringBuffer();
		String separate1 = "++===+===+===++===+===+===++===+===+===++" + "\n" + "||";
		String separate2 = "++---+---+---++---+---+---++---+---+---++" + "\n" + "||";
		for(int i = 0; i < array.length; i++){
			//Different cut-off in different lines 
			//I do not use the for loop because there are only 3 times, and it is more efficiency by this way
			if(i == 0 || i ==3 || i==6)
				sb.append(separate1);
			else
				sb.append(separate2);
			for(int j = 0; j < array[i].length; j++){
				if(j == 2 || j == 5 || j==8){
					if(array[i][j] == 0)
						sb.append("   " + "||");
					else
						sb.append(" " + array[i][j] + " " + "||");
				}
				else{
					if(array[i][j] == 0)
						sb.append("   " + "|");
					else 
						sb.append(" " + array[i][j] + " " + "|");
				}	
			}
			sb.append("\n");
		}
		sb.append("++===+===+===++===+===+===++===+===+===++");
		return sb.toString();
	}
	
	/**
	 * This is the method which can judge whether it is all filed by numbers in the blank
	 * @return true or false
	 */
	public boolean isFilled(){
		//Use the count to count the number of 0 in the array,
		int count = 0;
		for (int i = 0; i  < array.length; i ++) {
			for (int j = 0; j < array[i].length; j++) {
				//if an element is 0 count++
				if(array[i][j]==0)
					count++;	
			}	
		}		
		//Only when the count is 0 means there is no 0 in the array.
		return count==0;	
	}
}
