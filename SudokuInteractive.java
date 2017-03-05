import java.io.IOException;
import java.util.Scanner;

/**
 * The program is a game which you can operate the sudoku use some code like reset, exit and a1:4. 
 * @version 2016-11-30
 * @author ChuanheLiu
 *
 */
public class SudokuInteractive extends Sudoku {

	/**
	 * This is the constructor of the class and to create a SudokuInteractive with a two-dimensional array 
	 * @param array
	 */
	public SudokuInteractive(int[][] array) {
		super(array);
	}

	/**
	 * This method is toString method which is override.
	 * @return String
	 */
	@Override
	public String toString(){
		try{
			//Define a initial array to start or restart
			int[][] initialArray = SudokuRead.readSudoku("test.txt").getArray();
			SudokuInteractive initialSudoku = new SudokuInteractive(initialArray);
			StringBuffer sb = new StringBuffer();
			sb.append("      1   2   3    4   5   6    7   8   9\n");
			String separate1 = "   ++===+===+===++===+===+===++===+===+===++" + "\n" ;
			String separate2 = "   ++---+---+---++---+---+---++---+---+---++" + "\n" ;
			for(int i = 0; i < getArray().length; i++){
				//Different cut-off in different lins
				//I do not use the for loop because there are only 3 times, and it is more efficiency by this way
				if(i == 0 || i ==3 || i==6)
					sb.append(separate1 + (char)(97+i) + "  ||");
				else
					sb.append(separate2 + (char)(97+i) + "  ||");
				for(int j = 0; j < getArray()[i].length; j++){					
					//Different cut-off in different parts
					//I do not use the for loop because there are only 3 times, and it is more efficiency by this way
					if(j == 2 || j == 5 || j==8){
						if(getArray()[i][j] == 0)
							sb.append("   " + "||");
						else if(getArray()[i][j] != 0 && initialSudoku.getArray()[i][j] == 0)
							//When the initial element is 0 and then changed output without *
							sb.append(" " + getArray()[i][j] + " " + "||");
						else				
							sb.append("*" + getArray()[i][j] + "*" + "||");
					}
					else{
						if(getArray()[i][j] == 0)
							sb.append("   " + "|");
						else if(getArray()[i][j] != 0 && initialSudoku.getArray()[i][j] == 0)
							//When the initial element is 0 and then changed output without *
							sb.append(" " + getArray()[i][j] + " " + "|");
						else
							sb.append("*" + getArray()[i][j] + "*" + "|");
					}	
				}
				sb.append("\n");
			}
			sb.append("   ++===+===+===++===+===+===++===+===+===++");
			return sb.toString();
		}
		//Some exceptions
		catch(IllegalArgumentException iae){
			return "check file--------Illegal Argument Exception";
		}
		catch(IOException ioe){
			return "check file--------IO Exception";

		}
		catch(UnexpectedNumberException une){
			return "check file--------Unexpected Number Exception";

		}
		catch(InsufficientCharactersException ice){
			return "check file--------Insufficient Characters Exception";
		}
	}

	/**
	 * Call this to paly the game.
	 * @param filename
	 * @throws IllegalArgumentException
	 * @throws IOException
	 * @throws UnexpectedNumberException
	 * @throws InsufficientCharactersException
	 */
	public static void play(String file) throws IllegalArgumentException, IOException, 
	UnexpectedNumberException, InsufficientCharactersException {

		//Create a initial array to start or restart
		int[][] initialArray = SudokuRead.readSudoku(file).getArray();
		//Create a operate array to operate to make sure the initial array not be changed
		int[][] operateArray = SudokuRead.readSudoku(file).getArray();
		SudokuInteractive operatingSudoku = new SudokuInteractive(operateArray);
		System.out.println(operatingSudoku.toString());
		Scanner in = new Scanner(System.in);
		//Define a flag which is used to make choice to continue the loop or break.
		boolean flag = true;
		while(flag){
			String a = in.nextLine();
			try{
				//The format is obviously wrong, When the input string is less than 4 characters
				if(a.length()<4){
					flag = true;
					throw new WrongFormatException("Wrong Format!  Please try again!");	
				}
				int x = (int)(a.charAt(0)) - 97;
				int y = (int)(a.charAt(1)) - 49;
				int value =  (int)(a.charAt(3)-48);
				//When the String a has 4 characters and the third character of a is ':'
				//Also the locations should be a-i and 0-8 which means the numbers should between 0 and 9 
				if(a.length() == 4 && a.charAt(2)==':' 
						&& x < 9 && x >= 0 
						&& y < 9 && y >= 0 
						&& value > 0 && value <=9){
					//When the element is 0, add it immediately
					if(operateArray[x][y] == 0)
						operateArray[x][y] = value;
					//When the element has existed already, to make sure you want to change.
					else{
						System.out.println("the number in " + a.charAt(0) + a.charAt(1) + " has exist, do you want to cover it?\n"
								+ "Do you want to cover the former?\n y to yes, others to retype.");
						String option = in.nextLine();
						if (option.equals("y"))
							operateArray[x][y] = value;
					}
					System.out.println("Fill in the " + a.charAt(0) + a.charAt(1) + " with " + a.charAt(3));
					operatingSudoku.setArray(operateArray);
					System.out.println(operatingSudoku.toString()+"\n\n\n");
					flag = true;
				}
				//Input reset to restart the game.
				else if(a.equals("reset")){
					operatingSudoku.setArray(initialArray);;
					System.out.println(operatingSudoku.toString()+"\n\n\n");
					a = in.nextLine();
					flag = true;
					System.out.println("Program reset");
				}	
				//Input exit to finish this program.
				else if(a.equals("exit")){ 
					System.out.println("Program exit!");
					System.exit(0);
				}
				// Other wrong formats to retype.
				else {
					flag = true;
					throw new WrongFormatException("Wrong Format!  Please try again!");	
				}			
			}
			catch(WrongFormatException e){
				System.out.println("Wrong Format!  Please try again!"+"\n\n\n");
			}

		}
		in.close();
	}
	public static void main(String[] args){
		//		SudokuInteractive si = new SudokuInteractive(SudokuRead.readSudoku("test.txt").getArray());
		//		System.out.println(si.toString());
		try{
			play("sudoku-ex3.txt");
		}
		catch(IllegalArgumentException iae){
			System.out.println("check file--------Illegal Argument Exception");
		}
		catch(IOException ioe){
			System.out.println("check file--------IO Exception");

		}
		catch(UnexpectedNumberException une){
			System.out.println("check file--------Unexpected Number Exception");

		}
		catch(InsufficientCharactersException ice){
			System.out.println("check file--------Insufficient Characters Exception");
		}
	}
}
























