package view;
import game.Asteroids; 
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AsteroidsButton;
import model.AsteroidsSubScene;
import model.InfoLabel;
import model.SHIP;
import model.ShipPicker;
import scores.ReadHighScores;
import scores.WriteHighScores;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import model.AsteroidsButton;
import javafx.event.EventHandler;



//Creating main scene
public class ViewManager {
	
	private static final int HEIGHT = 500 ;
	private static final int WIDTH = 700;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage; 
	
	private final static int MENU_BUTTONS_START_X = 50;
	private final static int MENU_BUTTONS_START_Y = 50;

	
	
	private AsteroidsSubScene instructionsSubScene;
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

	
	
	//creating subscenes
	private void createSubScenes() {
		instructionsSubScene = new AsteroidsSubScene();
	    String message1 = "\tInstructions"
	    		+ "\n1. Space Bar: \n\t-Shoot"
	    		+ "\n2. L/R Keys: \n\t-Turn"
	    		+ "\n3. Up/Down Keys: \n\t-Accelerate"
	    		+ "\nPress play to\npick a ship and begin";
	    Text messageText1 = new Text(30,40,message1);
	    messageText1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	    messageText1.setFill(Color.GHOSTWHITE);
	    ObservableList<Node> kids1 = instructionsSubScene.getPane().getChildren();
	    kids1.addAll(messageText1);
		
	
		mainPane.getChildren().add(instructionsSubScene);
		
		
		
		
		scoresSubScene = new AsteroidsSubScene();
		ObservableList<Node> theKids = scoresSubScene.getPane().getChildren();
	    ReadHighScores scoreReader = new ReadHighScores();
	    ArrayList<String[]> top3 = scoreReader.readScores();
	    if(top3.size()>=3) {
	    	String highScores = "HIGH SCORES";
	    	Text HIGHSCORES = new Text(30,70,highScores);
	    	HIGHSCORES.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
	    	HIGHSCORES.setFill(Color.GHOSTWHITE);

	    	
	    	String firstPlace = ("1st: "+top3.get(0)[0]+", "+top3.get(0)[1]+"s\n");
	    	Text firstPlacement = new Text(30,100,firstPlace);
		    firstPlacement.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		    firstPlacement.setFill(Color.GHOSTWHITE);
		    
	    	String secondPlace = ("2nd: "+top3.get(1)[0]+", "+top3.get(1)[1]+"s\n");
	    	Text secondPlacement = new Text(30,130,secondPlace);
		    secondPlacement.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		    secondPlacement.setFill(Color.GHOSTWHITE);
		    
	    	String thirdPlace = ("3rd: "+top3.get(2)[0]+", "+top3.get(2)[1]+"s\n");
	    	Text thirdPlacement = new Text(30,160,thirdPlace);
		    thirdPlacement.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		    thirdPlacement.setFill(Color.GHOSTWHITE);

		    
		    theKids.addAll(HIGHSCORES,firstPlacement,secondPlacement,thirdPlacement);
	    	
	    }
	    else {
	    	
	    	String noScoresMessage = "Scores won't\nbe shown until\nat least 3 people\nhave played";
	    	Text noScores = new Text(40,100,noScoresMessage);
		    noScores.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		    noScores.setFill(Color.GHOSTWHITE);

		    
		    theKids.addAll(noScores);
	    	
	    }
	    
		mainPane.getChildren().add(scoresSubScene);
		
		createShipChooserSubScene();
	
	   }
	
	
	

	
	
	//creating subscene for ship picker
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
	//start button
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
	//menu button
	private void addMenuButton(AsteroidsButton button) {
		button.setLayoutX(MENU_BUTTONS_START_X);
		button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}

	
	private void createButtons() {
		createHelpButton();
		createStartButton();
		createScoresButton();
		createExitButton();
		
		
	}
	
	//start button
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
	//high score button
	private void createScoresButton() {
		AsteroidsButton scoresButton = new AsteroidsButton ("SCORES"); 
		addMenuButton(scoresButton);
		

		scoresButton.setOnAction(new EventHandler <ActionEvent> () {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(scoresSubScene);
			}
		});
		
		
	}
	//help button
	private void  createHelpButton() {
		AsteroidsButton instructionsButton = new AsteroidsButton ("GUIDE");
		addMenuButton(instructionsButton);

		instructionsButton.setOnAction(new EventHandler <ActionEvent> () {
			
			@Override
			public void handle (ActionEvent event) {
				showSubScene(instructionsSubScene);
				
			}
		});
		
	}
	//quiit button
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
	
	

	//setting up back ground
	private void createBackground() {
		Image backgroundImage = new Image ("view/resources/black.png", 750,400,false,true);
		BackgroundImage background = new BackgroundImage (backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
		mainPane.setBackground(new Background(background));
		 
				
	}
	//the logo
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
	


