import java.util.*;

/**
 * Represents the Spaceship, which is the avatar in our game
 * 
 */

public class Spaceship {
/**
 * Character that represents the avatar
 */
	private char ship;
/**
 * Row coordinate of the spaceship
 */
	private int initialX;
/**
 * Column coordinate of the spaceship
 */
	private int initialY;
	
/**
 * Constructor for the spaceship
 * @param i character representing the avatar
 * @param xcoord row position of the spaceship
 * @param ycoord column position of the spaceship
 */
	public Spaceship(char i, int xcoord, int ycoord) {
		this.ship = i;
		this.initialX = xcoord;
		this.initialY = ycoord;
	}
/**
 * Getter for the character which represents the spaceship avatar
 * @return the character that represents the spaceship avatar
 */
	
	public char getShip(){
		return ship;
	}
/**
 * 	Getter for the row number of the spaceship
 * @return the row number of the spaceship
 */
	public int getX() {
		return initialX;
	}
/**
 * Sets a new row number for the spaceship	
 * @param newX the new row number of the spaceship
 */
	public void setX(int newX) {
		this.initialX = newX;
	}
/**
 * Getter for the column number of the spaceship	
 * @return the column number of the spaceship
 */
	public int getY() {
		return initialY;
	}
/**
 * 	Setter for the column number of the spaceship
 * @param newY the new column number of the spaceship
 */
	public void setY(int newY) {
		this.initialY = newY;
	}
/**
 * 	Changes the row and column coordinates of the ship 
 * @param userChar user input into the board
 */
	public void moveShip(char userChar) {	
/**
 * If the user presses w, spaceship moves up a row, and stays in the same column
 */
		if(userChar == 'w') {
			if (this.getX()==0){
				setX(4);
			}
			else {
				setX(this.getX()-1);
			}
		}
/**
 * If the user presses s, spaceship moves down a row and stays in the same column
 */
		else if(userChar == 's') {
			if(this.getX()==4) {
				setX(0);
			}
			else {
				setX(this.getX()+1);
			}
		}
/**
 * If the user presses a, spaceship moves one column to the left and stays in the same row
 */
		else if(userChar == 'a') {
			if(this.getY()==0) {
				setY(4);
			}
			else {
				setY(this.getY()-1);
			}
		}
/**
 * If the user presses d, spaceship moves one column to the right and stays in the same row
 */
		else if (userChar == 'd') {
			if(this.getY()==4) {
				setY(0);
			}
			else {
				setY(this.getY()+1);
			}
		}
		else {

		}	
		
	}
	

}
