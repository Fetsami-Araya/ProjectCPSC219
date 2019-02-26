import java.util.Scanner;
/**
 * 
 * This class will control the interaction between the classes and update the field of play
 */

public class AsteroidsGame {
/**
 * Field of play
 */
	private Map AsteroidMap = new Map();
/**
 * Spacehship avatar, intialized to the middle of the board at row 2 and column 2
 */
	private Spaceship ship = new Spaceship('S',2,2);
/**
 * Two asteroids which are the obstacles, initialized at different ends of the board
 */
	private Asteroid asteroid1 = new Asteroid('A',0,0);
	private Asteroid asteroid2 = new Asteroid('a',4,4);
	
/**
 * 	Initializes the board by placing the spaceship avatar alone on the board
 */
	public void intializeBoard() {
		AsteroidMap.placeToken(ship.getShip(), ship.getX(), ship.getY());
		AsteroidMap.drawCurrentState();
	}
/**
 * Prints out the characters that are on the board
 */
	public void printCurrentState() {
		AsteroidMap.drawCurrentState();
	}
/**
 * Processes the spaceship's movement
 * @param userChar the character which the user inputs
 */
	public void ShipMove(char userChar) {
//Replaces the spaceship with an empty space token
		AsteroidMap.placeToken('.', ship.getX(), ship.getY());
//Processes the user's move by changing the spaceship's row and column coordinates
		ship.moveShip(userChar);
//Places the spaceship's token at it's new location
		AsteroidMap.placeToken(ship.getShip(), ship.getX(), ship.getY());
		
	}
	
/**
 * This function moves the asteroids
 * One asteroid moves up and down, and the other moves right to left	
 */
	public void moveAsteroid() {
//Places token at the first asteroid's current location, then moves the asteroid left to right
		AsteroidMap.placeToken('.', asteroid1.getX(), asteroid1.getY());
		asteroid1.moveAsteroidLeftToRight();
//Places token at the second asteroid's current location, then moces the asteroid up and down		
		AsteroidMap.placeToken('.', asteroid2.getX(), asteroid2.getY());
		asteroid2.moveAsteroidUpandDown();

//Places the asteroid's token at its new colliision
		AsteroidMap.placeToken(asteroid1.getAsteroid(), asteroid1.getX(), asteroid1.getY());
		AsteroidMap.placeToken(asteroid2.getAsteroid(), asteroid2.getX(), asteroid2.getY());
	}

//This function tests to see if any asteroid occupies the same space as the spaceship. If they do, the game should end
	public boolean collisionShipAsteroid() {
//Checks if the spaceship and the first asteroid occupy the same space
		if ((asteroid1.getX()==ship.getX())&&(asteroid1.getY()==ship.getY())){
			return true;
		}
//Checks if the spaceship and the second asteroid occupy the same space		
		else if ((asteroid2.getX()==ship.getX())&&(asteroid2.getY()==ship.getY())) {
			return true;
		}
//If both the above statemetns evaluate to false, the game continues
		else {
			return false;
		}
	}
	

/**
 * 	Main function executes the gameplay
 */
	public static void main(String[] args) {
//Iniital start menu
		System.out.println("Move up using 'w', down using 's', left using 'a', right using 'd'. Lowercase only");
//Initializes the game and the field of play
		AsteroidsGame newGame = new AsteroidsGame();
		newGame.intializeBoard();
//Allows the user to continue playing the game
		while (newGame.collisionShipAsteroid()==true) {
//Prompt user for input
			Scanner keyboard = new Scanner(System.in);
			char userChar = keyboard.next(".").charAt(0);

//Moves the asteroids
			newGame.moveAsteroid();
//Moves the ship in the direction chosen by the user
			newGame.ShipMove(userChar);

//Check to see if the ship has collided with an asteroid
			newGame.collisionShipAsteroid();

//If there hasn't been a collision, the current field of play is printed out and the user can enter a move again
			if (newGame.collisionShipAsteroid() == false) {
				newGame.printCurrentState();
				System.out.println("\n\n");
			}
//If there has been a collision, the game ends. Game over is printed, and the program ends.
			else {
				System.out.println("Game Over");
			}

		}
		
	}


}
