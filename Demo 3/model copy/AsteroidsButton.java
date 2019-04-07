package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import game.Asteroids;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.input.MouseEvent;


public class AsteroidsButton extends Button {
	
	private AnchorPane mainPane;
	private final String FONT_PATH = "src/model/resources/kenvector_future.ttf";
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/grey_button04.png');";
	private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/grey_button03.png');";
	
	
	public AsteroidsButton(String text) {
		setText(text);
		setButtonFont();
		setPrefWidth(190);
		setPrefHeight(49);
		setStyle(BUTTON_FREE_STYLE); 
		initializeButtonListeners();
		
	}
	
	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 25));}
			
			catch (FileNotFoundException e) {
				setFont(Font.font("Verdana", 25));
			}
			
		}
	
	
	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4);
	}
	
	private void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY() - 4);
	}
	
	private void initializeButtonListeners() {
		
		setOnMouseClicked(new EventHandler<MouseEvent> () {
			@Override
			public void handle (MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}
			}
			
			
			
		});
		 	
	
	
		setOnMouseReleased(new EventHandler<MouseEvent> () {
			@Override
			public void handle (MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
				}
			}
			
			
			
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent> () {
			@Override
			public void handle (MouseEvent event) {
				setEffect(new DropShadow());
				
				
				
				}
		});
		
		setOnMouseExited(new EventHandler<MouseEvent> () {
			@Override
			public void handle (MouseEvent event) {
				setEffect(null);

			
			
			}
		});
	
	
	
		

}
	
}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
