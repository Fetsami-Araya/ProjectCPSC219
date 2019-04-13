package game;

import application.Main;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AsteroidsButton;
import model.AsteroidsSubScene;

public class GameOver extends Application{
	private int asteroidsHit;
	private int timeRemaining;
	private int livesRemaining;
	private int totalASTEROIDS;
	private String playerName;
	private AsteroidsSubScene subSceneScores = new AsteroidsSubScene(20);
	private String missionAccomplishedMessage;
	
	public void setStats(int timeLeft, int livesLeft, int totalASTS, int asts) {
		this.timeRemaining = timeLeft;
		this.livesRemaining = livesLeft;
		this.totalASTEROIDS = totalASTS;
		this.asteroidsHit = asts;
	}

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		AsteroidsButton mainButton = new AsteroidsButton("MAIN MENU");
		mainButton.setLayoutX(250);
		mainButton.setLayoutY(300);
		mainButton.setMinSize(10, 50);
		mainButton.setFont(Font.font("Verdana", 20));
		mainButton.setAlignment(Pos.CENTER);
		
		
		
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                stage.hide();
                Main newMain = new Main();
                try {
                	newMain.start(stage);
                }catch(Exception except) {
                	
                }
            } 
        };
        mainButton.setOnAction(event);
        
		AsteroidsButton exitButton = new AsteroidsButton("QUIT");
		exitButton.setLayoutX(250);
		exitButton.setLayoutY(350);
		exitButton.setMinSize(10, 50);
		exitButton.setFont(Font.font("Verdana", 20));
		exitButton.setAlignment(Pos.CENTER);
		
		
		
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	stage.close();
            }
        };
        exitButton.setOnAction(event1);
		
		

        
		Text mission = new Text(190,25,"GAME OVER");
		mission.setScaleX(1.25);
		mission.setScaleY(1.25);
		mission.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
		mission.setFill(Color.GHOSTWHITE);
		

		if(livesRemaining==0&&timeRemaining>0) {
			missionAccomplishedMessage = "You ran out of lives!\n\n"
					+ "You hit "+(totalASTEROIDS-asteroidsHit)+ " asteroids \nout of "+ totalASTEROIDS + " total \n\n"
					+ "Press MAIN MENU \nto play again or \npress QUIT to leave";
			
		}
		else {
			missionAccomplishedMessage = "You ran out of time!\n\n"
					+ "You hit "+(totalASTEROIDS-asteroidsHit)+ " asteroids \nout of "+ totalASTEROIDS + " total \n\n"
					+ "Press MAIN MENU \nto play again or \npress QUIT to leave";
		}
	    Text missionAccomplishedText = new Text(30,60,missionAccomplishedMessage);
	    missionAccomplishedText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	    missionAccomplishedText.setFill(Color.GHOSTWHITE);
	    ObservableList<Node> kids = subSceneScores.getPane().getChildren();
	    kids.addAll(missionAccomplishedText);


		
	      //Instantiating the VBox class  
	      VBox vBox = new VBox(); 
	      HBox hBox = new HBox();
	      
	      //Setting the space between the nodes of a VBox pane 
	      vBox.setSpacing(10);   
	      
	      //Setting the margin to the nodes 
	      vBox.setMargin(mission, new Insets(10, 10, 10, 10));  
	      vBox.setMargin(subSceneScores, new Insets(10, 10, 10, 10));
	      
	      hBox.setMargin(exitButton, new Insets(10, 10, 10, 10));
	      hBox.setMargin(mainButton, new Insets(10, 10, 10, 10));
	      hBox.setAlignment(Pos.BOTTOM_CENTER);
	      
	      //retrieving the observable list of the VBox 
	      ObservableList list = vBox.getChildren(); 
	      ObservableList listH = hBox.getChildren();
	      
	      listH.addAll(exitButton, mainButton);
	      //Adding all the nodes to the observable list 
	      list.addAll(mission,subSceneScores, hBox);       
	      
	      //Creating a scene object 
	      Scene scene = new Scene(vBox, 640, 480); 
	      
	      //Fixing alignment and background
	      vBox.setAlignment(Pos.CENTER);
	      BackgroundFill fill = new BackgroundFill(Color.BLACK, null, null);
	      Background background = new Background(fill);
	      vBox.setBackground(background);


	
		scene.setFill(Color.BLACK);
		
		stage.setTitle("MISSION ACCOMPLISHED");
		stage.setScene(scene);
		
		stage.show();
		
	}
	
	

}
