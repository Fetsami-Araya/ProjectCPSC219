
public class Asteroid {
	private char asteroid;
	private int xcoord;
	private int ycoord;
	
	public Asteroid(char ast, int x, int y) {
		this.asteroid = ast;
		this.xcoord = x;
		this.ycoord = y;
	}
	
	public char getAsteroid(){
		return asteroid;
	}
	
	public int getX() {
		return xcoord;
	}
	
	public int getY() {
		return ycoord;
	}
	
	public void moveAsteroid() {
	}


}
