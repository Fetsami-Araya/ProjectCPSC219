/**
 * This class makes the grid which will represnt the field of play
 *
 */

public class Map {
/**
 * This is a 5 x 5 grid where a '.' represents an empty space
 */
		char[][] grid = {{'.','.','.','.','.'},	{'.','.','.','.','.'}, 
						{'.','.','.','.','.'}, {'.','.','.','.','.'},
						{'.','.','.','.','.'}};

/**
 * 
 * @param token character to be placed
 * @param row is the row number of the character
 * @param column is the column number of the character
 */
		public void placeToken(char token, int row, int column){
			grid[row][column] = token;
	
		}
/**
 * Prints out the characters at each position on the 5 x 5 grid				
 */
		public void drawCurrentState(){
			for (int row = 0; row < 5; row++){
				for (int column = 0; column < 5; column++){
					System.out.print(grid[row][column]);
				}
				System.out.println();		
			}
		
		}

	}

