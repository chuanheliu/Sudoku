import java.io.*;

/**
 * The program can read the file and get an array 
 * and also can handle some mistakes in the file.
 * @version 2016--
 * @author ChuanheLiu
 *
 */
public class SudokuRead {
	
	/**
	 * Read a file through the file name.
	 * and throws Exceptions
	 * and define some Exceptions.
	 * @param fileName
	 * @return a Sudoku
	 * @throws IllegalArgumentException
	 * @throws IOException
	 * @throws UnexpectedNumberException
	 * @throws InsufficientCharactersException
	 */
	public static Sudoku readSudoku(String fileName) //I defined it static because I want to see the result in the windows~~
			throws IllegalArgumentException,IOException,UnexpectedNumberException, InsufficientCharactersException{

		// The suduku should be 9X9
		int[][] array = new int[9][9];
		Sudoku s = new Sudoku(array);
		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		String tempString = null;
		
		//Read the first 9 lines in the file
		for(int i = 0; i < 9; i++){
			tempString = reader.readLine();
			//When the file does not have more than 9 lines throw the Exception,
			if(tempString == null){
				reader.close();
				//Define the InsufficientCharactersException 
				throw new InsufficientCharactersException("insufficient characters in the file");	
			}
			//Read the first characters in a line
			for (int j = 0; j < 9; j++) {
				//When the file does not have more than 9 characters throw the Exception
				if(tempString.length() < 9){
					reader.close();
					//Define the InsufficientCharactersException
					throw new InsufficientCharactersException("insufficient characters in the file");		
				}
				
				//String transfer to char, then char transfer to int.
				int sudokuNumber = tempString.charAt(j)-'0';
				//Judge the space of file
				//The space in the ASCII code is 32 and the 0 is 48
				if(tempString.charAt(j)-'0'==-16)
					array[i][j] = 0;
				else
					array[i][j] = sudokuNumber;
				
				//It is qualified only when the numbers are between 0 and 9 
				if(array[i][j] < 0 || array[i][j] > 9 || tempString.charAt(j) == '0'){
					reader.close();
					throw new UnexpectedNumberException("all charactrs should be space or 1-9(including 1 and 9)");

				}


			}
		}
		reader.close();  
		return s;
	}

	/**
	 * Use main method to do some test.
	 * @param args
	 * @throws IllegalArgumentException
	 * @throws IOException
	 * @throws UnexpectedNumberException
	 * @throws InsufficientCharactersException
	 */
	public static void main(String[] args) throws IllegalArgumentException, IOException, UnexpectedNumberException, InsufficientCharactersException{
		
		System.out.println(readSudoku("ex2Test3.txt").toString());
	}

}
