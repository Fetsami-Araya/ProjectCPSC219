package view;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.SHIP;
import javafx.scene.input.KeyCode;


public class GameViewManager {
	
	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	private static final int GAME_WIDTH = 640;
	private static final int GAME_HEIGHT = 480;
	
	private Stage menuStage;
	private ImageView ship;
	
	
	
	
	

	public GameViewManager() {
		initializeStage();
		createKeyListeners();
		
	}
	
	private void createKeyListeners() {
		gameScene.setOnKeyPressed(new EventHandler <KeyEvent>  () {
			
			@Override
			public void handle (KeyEvent event) {
				if(event.getCode() == KeyCode.LEFT) {
				}else if (event.getCode() == KeyCode.RIGHT) {
				}	
				
				
		
			}});
		
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent> () {
			@Override
			
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.LEFT) {
				}else if (event.getCode() == KeyCode.RIGHT) {
				}
		}
	});
}	
	
	
	private void initializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		
	}
	
	public void createNewGame(Stage menuStage, SHIP choosenShip) {
	this.menuStage = menuStage;
	this.menuStage.hide();
	gameStage.show();	 
	}
	
	
	
	
	
}
