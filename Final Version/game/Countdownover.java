package game;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Countdownover extends Application{

	private int hits;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void sethits(int h)
	{
	    	hits=h;
	}
	public int gethits() {
		return hits;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		ObservableList list = root.getChildren();
		
		
		Button exitButton = new Button("Quit");
		exitButton.setLayoutX(250);
		exitButton.setLayoutY(300);
		exitButton.setMinSize(10, 50);
		exitButton.setFont(Font.font("Verdana", 20));
		exitButton.setAlignment(Pos.CENTER);
		
		
		
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                stage.close();
            } 
        };
        exitButton.setOnAction(event);
		
		
		
		Text highScores = new Text(190,125,"HIGH SCORES");
		highScores.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		highScores.setFill(Color.GHOSTWHITE);
		
		Text highScore1 = new Text(190,175,"FIRST PLACE:  ");
		highScore1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		highScore1.setFill(Color.GOLD);
		
		
		Text highScore2 = new Text(190,200,"SECOND PLACE:  ");
		highScore2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		highScore2.setFill(Color.SILVER);
		
		Text highScore3 = new Text(190,225,"THIRD PLACE:  ");
		highScore3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		highScore3.setFill(Color.BROWN);
		

        
		Text gameOver = new Text(210,25,"TIME UP");
		gameOver.setScaleX(1.5);
		gameOver.setScaleY(1.5);
		gameOver.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		gameOver.setFill(Color.RED);
		
		Text Hits = new Text(190,250,"ASTEROID HIT "+hits);
		Hits.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		Hits.setFill(Color.RED);
		
		
		list.add(Hits);
		list.add(gameOver);
		list.add(highScores);
		list.add(highScore1);
		list.add(highScore2);
		list.add(highScore3);
		list.add(exitButton);
		
		Scene scene = new Scene(root, 640, 480);
		scene.setFill(Color.BLACK);
		
		stage.setTitle("TIME UP");
		stage.setScene(scene);
		
		stage.show();
		
	}
	
	

}
