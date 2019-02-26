import java.lang.Math;

/**
 * 
 * Represents an asteroid, which is the obstacle of our game
 */

public class Asteroid {
/**
 * Character that will represent the asteroid on the grid	
 */
	private char asteroid;
/**
 * Row number of the asteroid
 */
	private int xcoord;
/**
 * Column number of the asteroid
 */
	private int ycoord;

/**
 * Constructor for asteroid 
 * @param ast character for asteroid
 * @param x row number
 * @param y column number
 */
	public Asteroid(char ast, int x, int y) {
		this.asteroid = ast;
		this.xcoord = x;
		this.ycoord = y;
	}

/**
 * @return asteroid which is character representing the asteroid
 */
	public char getAsteroid(){
		return asteroid;
	}
/**
 * Sets a new character to represent the asteroid
 * @param newChar
 */
	public void setAsteroid(char newChar) {
		this.asteroid = newChar;
	}
/**
 * Getter for the row number of the asteroid
 * @return xcoord which represents the row number of the asteroid
 */
	public int getX() {
		return xcoord;
	}
/**
 * Getter for the column number of the asteroid
 * @return ycoord which reprents the column number of the asteorid
 */
	public int getY() {
		return ycoord;
	}
	
/**
 * Creates a random row starting point on the board for the asteroid
 */
	public void randomX() {
		double randomDub = Math.random();
		int randomIntX = (int)randomDub*4;
		this.xcoord = randomIntX;
	}
/**
 * Setter for the row coordinate,
 * if the current coordinate is on the board, the position remains the same
 * @param current row number of the asteroid
 */
	public void setX(int position) {
		if(position<5 && position>=0) {
			this.xcoord = position;
		}
		else {
			randomX();
		}
	}
/**
 * Creates a random column starting point on the board for the asteroid
 */
	public void randomY() {
		double randomDub = Math.random();
		int randomIntY = (int)randomDub*4;
		this.ycoord = randomIntY;
	}
/**
 * Setter for the column coordinate,
 * if the current coordinate is on the board, the position remains the same
 * @param position current column number of the asteroid
 */
	public void setY(int position) {
		if(position<5 && position>=0) {
			this.ycoord = position;
		}
		else {
			randomY();
		}
	}
/**
 * Moves the asteroid left to right by incrementing the column position by 1	
 */
	public void moveAsteroidLeftToRight() {	
		setY(this.getY()+1);
	}

/**
 * Moves the asteroid left to right by incrementing the row position
 */
	public void moveAsteroidUpandDown() {			
		setX(this.getX()+1);
	}
	


}
