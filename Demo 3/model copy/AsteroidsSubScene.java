package model;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;

import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class AsteroidsSubScene extends SubScene {
	
	private final static String FONT_PATH = "src/model/resources/kenvector_future.ttf";
	private final static String BACKGROUND_IMAGE = "model/resources/Panel.png";
	
	
	private boolean isHidden;
	
	
	
	
	public AsteroidsSubScene() {
		super(new AnchorPane(),450, 250);
		prefWidth(350);
		prefHeight(250);
		
		BackgroundImage image = new BackgroundImage (new Image(BACKGROUND_IMAGE, 300, 265, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		
		
		AnchorPane root2 = (AnchorPane) this.getRoot();
		
		root2.setBackground(new Background(image));
		
		isHidden = true;
		
		setLayoutX(975);
		setLayoutY(215);
	}		
	
	public void moveSubScene() {
		TranslateTransition transition =  new TranslateTransition ();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		
		transition.setToX(-676);
		
		if(isHidden) {
			transition.setToX(-676);
			isHidden = false;
		}
		else {
			transition.setToX(0);
			isHidden = true;
		}
		
		
		transition.play();
	}
	
	public AnchorPane getPane() {
		return(AnchorPane) this.getRoot();
	}
	
}













































