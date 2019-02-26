
public class AsteroidsGame {
	private Map AsteroidMap = new Map();
	private Spaceship ship = new Spaceship('S',0,0,4);
	private Asteroid asteroid = new Asteroid('A',1,1);
	
	public void intializeBoard() {
		AsteroidMap.placeToken(ship.getShip(), ship.getX(), ship.getY());
		AsteroidMap.placeToken(asteroid.getAsteroid(), asteroid.getX(), asteroid.getY());
		AsteroidMap.drawCurrentState();
	}
	
	public void printCurrentState() {
		AsteroidMap.drawCurrentState();
	}
	
	public void ShipMove() {
		AsteroidMap.placeToken('.', ship.getX(), ship.getY());
		ship.moveShip();
		AsteroidMap.placeToken(ship.getShip(), ship.getX(), ship.getY());
		
	}
	
	
	public static void main(String[] args) {
		AsteroidsGame newGame = new AsteroidsGame();
		newGame.intializeBoard();
		newGame.ShipMove();
		newGame.printCurrentState();
	}


}
