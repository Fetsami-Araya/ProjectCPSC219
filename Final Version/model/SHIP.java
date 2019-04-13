package model;
//setting up different ships
public enum SHIP {
	
	YELLOW ("view/resources/shipchooser/yellowShit.png"),
	RED ("view/resources/shipchooser/redShit.png");
	
	private String urlShip;
	
	private SHIP(String urlShip) {
		this.urlShip = urlShip;
		
		
	}
	
	public String getUrl() {
		return this.urlShip;
		
	}

}
