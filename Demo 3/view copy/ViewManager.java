package view;
import game.Asteroids; 
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.AsteroidsButton;
import model.AsteroidsSubScene;
import model.InfoLabel;
import model.SHIP;
import model.ShipPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import model.AsteroidsButton;
import javafx.event.EventHandler;




public class ViewManager {
	
	private static final int HEIGHT = 500 ;
	private static final int WIDTH = 700;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage; 
	
	private final static int MENU_BUTTONS_START_X = 50;
	private final static int MENU_BUTTONS_START_Y = 50;

	
	
	private AsteroidsSubScene credistsSubScene;
	private AsteroidsSubScene scoresSubScene;
	private AsteroidsSubScene shipChooserSubScene;
	
	
	private AsteroidsSubScene sceneToHide;

	
	List<AsteroidsButton> menuButtons;
	
	List<ShipPicker> shipsList;
	private SHIP choosenShip;
	
	
	
	public ViewManager() {
	menuButtons = new ArrayList<>();
	mainPane = new AnchorPane();
	mainScene = new Scene(mainPane, WIDTH,HEIGHT);
	mainStage = new Stage();
	mainStage.setScene(mainScene);
	createButtons();
	createBackground();
	createLogo();
	createSubScenes();
	
	}
	
	private void showSubScene(AsteroidsSubScene subScene) {
		if(sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		subScene.moveSubScene();
		sceneToHide = subScene;
	}

	
	
	
	private void createSubScenes() {
	credistsSubScene = new AsteroidsSubScene();
	mainPane.getChildren().add(credistsSubScene);
	
	scoresSubScene = new AsteroidsSubScene();
	mainPane.getChildren().add(scoresSubScene);
	
	createShipChooserSubScene();
	
	
	
	
	
	}
	
	
	
	private void createShipChooserSubScene() {
		shipChooserSubScene = new AsteroidsSubScene();
		mainPane.getChildren().add(shipChooserSubScene);
		
		//InfoLabel chooseShipLabel = new InfoLabel("PICK YOUR SHIP");
	//	chooseShipLabel.setLayoutX(50);
		//chooseShipLabel.setLayoutY(200);
		//shipChooserSubScene.getPane().getChildren().add(chooseShipLabel);
		shipChooserSubScene.getPane().getChildren().add(createShipsToChoose());
		shipChooserSubScene.getPane().getChildren().add(createButtonToStart());
		
		

	}
	
	private HBox createShipsToChoose() {
		HBox box = new HBox();
		box.setSpacing(20);
		shipsList = new ArrayList<>();
		for(SHIP ship: SHIP.values()) {
			ShipPicker shipToPick = new ShipPicker(ship); 
			
			shipsList.add(shipToPick);
			
			box.getChildren().add(shipToPick);
			
			shipToPick.setOnMouseClicked(new EventHandler <MouseEvent> () {
				
				@Override
				public void handle (MouseEvent event) {
					for(ShipPicker ship : shipsList) {
						ship.setIsCircleChoosen(false);
					}
					shipToPick.setIsCircleChoosen(true);
					choosenShip = shipToPick.getShip();
				}
			});
		}
		box.setLayoutX(50);
		box.setLayoutY(25);
		return box;
	}
	
	private AsteroidsButton createButtonToStart() {
		AsteroidsButton startButton = new AsteroidsButton ("Begin");
		startButton.setLayoutX(50);
		startButton.setLayoutY(185);
		
		startButton.setOnAction(new EventHandler<ActionEvent> () {
		
			@Override
			public void handle(ActionEvent event) {
				
			if(choosenShip != null) {
				GameViewManager gameManager = new GameViewManager();
				gameManager.createNewGame(mainStage, choosenShip);
			}
			}	
		
		});
		return startButton;
		
	}

	public Stage getMainStage() {
		return mainStage; 
	}
	
	private void addMenuButton(AsteroidsButton button) {
		button.setLayoutX(MENU_BUTTONS_START_X);
		button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}

	
	private void createButtons() {
		createStartButton();
		createScoresButton();
		createHelpButton();
		createExitButton();
		
		
	}
	
	
	private void createStartButton() {
		AsteroidsButton startButton = new AsteroidsButton ("PLAY");
		addMenuButton(startButton);
		
		startButton.setOnAction(new EventHandler <ActionEvent> () {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(shipChooserSubScene);
			}
		});
	}
	
	private void createScoresButton () {
		AsteroidsButton scoresButton = new AsteroidsButton ("SCORES"); 
		addMenuButton(scoresButton);
		

		scoresButton.setOnAction(new EventHandler <ActionEvent> () {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(scoresSubScene);
			}
		});
		
		
	}
	
	private void  createHelpButton() {
		AsteroidsButton creditsButton = new AsteroidsButton ("CREDITS");
		addMenuButton(creditsButton);

		creditsButton.setOnAction(new EventHandler <ActionEvent> () {
			
			@Override
			public void handle (ActionEvent event) {
				showSubScene(credistsSubScene);
				
			}
		});
		
	}
	
	private void createExitButton() {
		AsteroidsButton exitButton = new AsteroidsButton ("QUIT");
		addMenuButton(exitButton);
		
		exitButton.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			
			public void handle (ActionEvent event) {
				mainStage.close();
			}
		});
		
	}
	
	

	
	private void createBackground() {
		Image backgroundImage = new Image ("view/resources/black.png", 750,400,false,true);
		BackgroundImage background = new BackgroundImage (backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
		mainPane.setBackground(new Background(background));
		 
				
	}
	
	private void createLogo() {
		ImageView logo = new ImageView("view/resources/Logo.png");
		logo.setFitHeight(200);
		logo.setFitWidth(350);
		logo.setLayoutX(275);
		logo.setLayoutY(10);
		
		
		
		logo.setOnMouseEntered(new EventHandler <MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow());
			}
			
		});
		
		logo.setOnMouseExited(new EventHandler <MouseEvent> () {
			
			@Override
			public void handle (MouseEvent event) {
				logo.setEffect(null);
			}
		});
		
		
		mainPane.getChildren().add(logo);
	
		

		}
				
		
	}
	


