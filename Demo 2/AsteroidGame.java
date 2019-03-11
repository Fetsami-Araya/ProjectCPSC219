import java.awt.Insets;
import java.awt.event.KeyListener;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.transform.Rotate;

public class AsteroidGame extends Application implements Runnable, KeyListener{
	private int x, y;
	Thread thread;
	Image img;
	
	private long endTime, startTime, framePeriod;
	
	Ship ship = new Ship();
	Shot[] shots;
	int numShots;
	boolean shooting;
	
	Asteroid asteroid = new Asteroid();
	Asteroid[] asteroids;
	int numAsteroids;
	double astRadius, minAstVel, maxAstVel;
	
	int astNumHits, astNumSplit;
	
	int level;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Group root = new Group();
		ObservableList list = root.getChildren();
		list.add(asteroid.getAsteroid());
		list.add(ship.getShip());
				
		
		Scene scene = new Scene(root, 600, 600, Color.BLACK);
		
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:  ship.moveUp(); break;
                    case DOWN: ship.moveDown(); break;
                    case LEFT: ship.moveLeft(); break;
                    case RIGHT: ship.moveRight(); break;
                }
            }
        });
		
		primaryStage.setTitle("Asteroids");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void run() {
		asteroid.motion();
	}

	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
		// TODO Auto-generated method stub

	}
	

	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}