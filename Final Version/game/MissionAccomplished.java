package game;

import java.util.ArrayList;

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
import scores.ReadHighScores;
import scores.WriteHighScores;

public class MissionAccomplished extends Application{
	private int timeRemaining;
	private int livesRemaining;
	private String playerName;
	private AsteroidsSubScene subSceneScores = new AsteroidsSubScene(20);
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void setStats(int timeLeft, int livesLeft) {
		this.timeRemaining = timeLeft;
		this.livesRemaining = livesLeft;
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
		
		
		
	

        
		Text mission = new Text(190,25,"MISSION ACCOMPLISHED");
		mission.setScaleX(1.25);
		mission.setScaleY(1.25);
		mission.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
		mission.setFill(Color.GHOSTWHITE);
		
		Text accomplished = new Text(50,25,"Enter your name \n (Max 6 letters)");
		accomplished.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		accomplished.setFill(Color.GHOSTWHITE);
		
		TextField textField = new TextField();
		textField.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textField.textProperty().addListener((observable, oldValue, newValue) -> {
		    playerName = newValue;
		});

		// Handle TextField enter key event.
		textField.setOnAction((events) -> {
			try {
				if(!playerName.equals(null)) {
					textField.setDisable(true);
					
					ObservableList<Node> kids = subSceneScores.getPane().getChildren();
					
				    WriteHighScores scoreWriter = new WriteHighScores(playerName, (60-timeRemaining), livesRemaining);
				    ReadHighScores scoreReader = new ReadHighScores();
				   
				    scoreWriter.writeScores();

				    ArrayList<String[]> top3 = scoreReader.readScores();
				    
				    
				    if(top3.size()>=3) {
				    	String highScores = "HIGH SCORES";
				    	Text HIGHSCORES = new Text(30,50,highScores);
				    	HIGHSCORES.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
				    	HIGHSCORES.setFill(Color.GHOSTWHITE);
			
				    	
				    	String firstPlace = ("1st: "+top3.get(0)[0]+", "+top3.get(0)[1]+"s\n");
				    	Text firstPlacement = new Text(30,80,firstPlace);
					    firstPlacement.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
					    firstPlacement.setFill(Color.GHOSTWHITE);
					    
				    	String secondPlace = ("2nd: "+top3.get(1)[0]+", "+top3.get(1)[1]+"s\n");
				    	Text secondPlacement = new Text(30,100,secondPlace);
					    secondPlacement.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
					    secondPlacement.setFill(Color.GHOSTWHITE);
					    
				    	String thirdPlace = ("3rd: "+top3.get(2)[0]+", "+top3.get(2)[1]+"s\n");
				    	Text thirdPlacement = new Text(30,120,thirdPlace);
					    thirdPlacement.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
					    thirdPlacement.setFill(Color.GHOSTWHITE);
					    
						String guideMessage = "Press MAIN MENU \nto play again or \npress QUIT to leave";
				
						Text guideText = new Text(30,160,guideMessage);
						guideText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
						guideText.setFill(Color.GHOSTWHITE);

					    
					    kids.addAll(HIGHSCORES,firstPlacement,secondPlacement,thirdPlacement, guideText);
				    	
				    }
				    else {
					    String missionAccomplishedMessage = ("Here's \nyour stats\n\n"
				    +playerName+"'s"+" Stats\n\n"+"Time: "+(60-timeRemaining)+" seconds \n"
					    		+ "Lives Left: "+livesRemaining+"\nPress MAIN MENU \nto play again or \npress QUIT to leave");
					    Text missionAccomplishedText = new Text(30,60,missionAccomplishedMessage);
					    missionAccomplishedText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
					    missionAccomplishedText.setFill(Color.GHOSTWHITE);
					    textField.setDisable(true);
					    kids.addAll(missionAccomplishedText);
					    
				    }
				    
				    
				    
				    
				    
				}
				else {
					
				}
			}catch(Exception except2) {
				
			}
		});
		


		
	      //Instantiating the VBox class  
	      VBox vBox = new VBox(); 
	      HBox hBox = new HBox();
	      HBox hbox2 = new HBox();
	      
	      //Setting the space between the nodes of a VBox pane 
	      vBox.setSpacing(10);   
	      
	      //Setting the margin to the nodes 
	      vBox.setMargin(mission, new Insets(5, 5, 5, 5));  
	      vBox.setMargin(accomplished, new Insets(5, 5, 5, 5)); 
	      vBox.setMargin(subSceneScores, new Insets(10, 10, 10, 10));

	      
	      
	      hBox.setMargin(exitButton, new Insets(10, 10, 10, 10));
	      hBox.setMargin(mainButton, new Insets(10, 10, 10, 10));
	      hBox.setAlignment(Pos.BOTTOM_CENTER);
	      
	      hbox2.setMargin(accomplished, new Insets(10, 10, 10, 10));
	      hbox2.setMargin(textField, new Insets(10, 10, 10, 10));
	      hbox2.setAlignment(Pos.CENTER);
	      
	      //retrieving the observable list of the VBox 
	      ObservableList list = vBox.getChildren(); 
	      ObservableList listH = hBox.getChildren();
	      ObservableList listH2 = hbox2.getChildren();
	      
	      listH.addAll(exitButton, mainButton);
	      listH2.addAll(accomplished, textField);
	      //Adding all the nodes to the observable list 
	      list.addAll(mission,hbox2, subSceneScores, hBox);       
	      
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
