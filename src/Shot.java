
public class Shot {
	private char laser;
	private int xcoord;
	private int ycoord;
	
	public Shot(char las, int x, int y) {
		this.laser = las;
		this.xcoord = x;
		this.ycoord = y;
	}
	
	public int getX() {
		return this.xcoord;
	}
	
	public void setX(int newX) {
		this.xcoord = newX;
	}
	
	public int getY() {
		return this.ycoord;
	}
	
	public void setY(int newY) {
		this.ycoord = newY;
	}
	
	public char getLaser() {
		return this.laser;
	}
	
	public void setLaser(char newLas) {
		this.laser = newLas;
	}
	

	
}
