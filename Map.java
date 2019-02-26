
public class Map {
		
		/**
		* creating the grid for the game
		*/
		char[][] grid = {{'.','.','.','.','.'},	{'.','.','.','.','.'}, 
						{'.','.','.','.','.'}, {'.','.','.','.','.'},
						{'.','.','.','.','.'}};

		



				//Methods
		
		/**
		 * Places the token on the map
		 * @param token --> the variable for the token
		 * @param row --> the row that the token will be placed
		 * @param column --> the column that the token will be places
		 */
		public void placeToken(char token, int row, int column){
			grid[row][column] = token;
	
		}
		
		
		
		/**
		 *  Makes the value empty at a specific location
		 * @param row --> the row of the location
		 * @param column --> the column of the location
		 * @return the boolean if cell is empty at the specific row and column
		 */
		public boolean isEmpty(int row, int column){
			return grid[row][column] == '.';
		}
		
		
		/**
		 * Draws the grid and the values in each grid cell
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


