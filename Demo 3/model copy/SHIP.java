package model;

public enum SHIP {
	
	YELLOW ("view/resources/shipchooser/ufoYellow.png"),
	RED ("view/resources/shipchooser/playerShip3_red.png");
	
	private String urlShip;
	
	private SHIP(String urlShip) {
		this.urlShip = urlShip;
		
		
	}
	
	public String getUrl() {
		return this.urlShip;
		
	}

}
