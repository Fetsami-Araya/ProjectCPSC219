import java.util.*;


public class Spaceship {

			// Instance Variables
	private char ship;
	private int lives;
	private int initialX;
	private int initialY;
	
	
			// Conductors
	
	/**
	 *  Conductor that takes the spaceship and makes the spaceship i. The conductor will also set the coordinates of the spaceship and also sets the number of lives
	 * @param i  --> the char that will use presented in the game
	 * @param xcoord --> the x coordinate of the spaceship 
	 * @param ycoord --> the y coordinate of the spaceship
	 * @param nlives --> the number of lives that the spaceship/ the player will have
	 */
	public Spaceship(char i, int xcoord, int ycoord, int nlives) {
		this.ship = i;
		this.initialX = xcoord;
		this.initialY = ycoord;
		this.lives = nlives;
	}
	
	
				//Getters
	/**
	 * Gets the spaceship
	 * @return the ship
	 */
	public char getShip(){
		return ship;
	}
	
	
	
	/**
	 * gets the x coordinate
	 * @return initialx --> the x coordinate
	 */
	public int getX() {
		return initialX;
	}

	
	/**
	 * Gets the y coordinate
	 * @return initialY
	 */
	public int getY() {
		return initialY;
	}
	
	
			// Setters
	
	/**
	 * Sets the x coordinate
	 * @param newX --> the new x coordinate
	 */
	public void setX(int newX) {
		this.initialX = newX;
	}
	
	
	/**
	 * Sets the new Y coordinate
	 * @param newY --> the new y coordinate
	 */
	public void setY(int newY) {
		this.initialY = newY;
	}
	
	
			// Methods
			
	
	/**
	 * THe moveShip() function will allow the player to move either directly up(w), left(a), down(s) or to the right(d).
	 * The direction that the player will move is dependent on the button that is pressed.  		
	 */
	public void moveShip() {		
		Scanner keyboard = new Scanner(System.in);
		char userChar = keyboard.next(".").charAt(0);
		
		if(userChar == 'w') {
			if (this.getX()==0){
				setX(4);
			}
			else {
				setX(this.getX()-1);
			}
		}
		else if(userChar == 's') {
			if(this.getX()==4) {
				setX(0);
			}
			else {
				setX(this.getX()+1);
			}
		}
		else if(userChar == 'a') {
			if(this.getY()==0) {
				setY(4);
			}
			else {
				setY(this.getY()-1);
			}
		}
		
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