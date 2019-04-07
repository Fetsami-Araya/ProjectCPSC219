package game;


import java.util.*;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;  
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;  
import java.util.concurrent.TimeUnit;

/*****************************************************
 * Primary class for the game
 *****************************************************/
public class Asteroids extends Application  {
    //the main thread becomes the game loop
   
    Scene pane = new Scene(new Group(), 640, 480);
    
    private Timeline timeline;
	private KeyFrame keyFrame;
	private int duration = 20;
	
	
	

    //create the asteroid array
    int ASTEROIDS = 20;
    Asteroid[] ast = new Asteroid[ASTEROIDS];

    //create the bullet array
    int BULLETS = 10;
    Bullet[] bullet = new Bullet[BULLETS];
    int currentBullet = 0;

    //the player's ship
    Ship ship = new Ship();


    //create a random number generator
    Random rand = new Random();

    //sound effects objects
    //SoundClip shoot;
    //SoundClip explode;

    
    public void Init() {

        //set up the ship
        ship.setX(320);
        ship.setY(240);

        //set up the bullets
        for (int n = 0; n<BULLETS; n++) {
            bullet[n] = new Bullet();
        }

        //set up the asteroids
        for (int n = 0; n<ASTEROIDS; n++) {
            ast[n] = new Asteroid();
            ast[n].setRotationVelocity(rand.nextInt(3)+1);
            ast[n].setX((double)rand.nextInt(600)+20);
            ast[n].setY((double)rand.nextInt(440)+20);
            ast[n].setMoveAngle(rand.nextInt(360));
            double ang = ast[n].getMoveAngle() - 90;
            ast[n].setVelX(calcAngleMoveX(ang));
            ast[n].setVelY(calcAngleMoveY(ang));
        }

        
    }

    
	
	
 
    public void update() {

    	ObservableList<Node> content = ((Group)pane.getRoot()).getChildren(); 
    	content.clear();
    	
     	
    	String timerText = "Time Elapsed:  "+String.valueOf(timeline.getCurrentTime());
    	
    	
      
        Text text1 = new Text(5,10,timerText);
    	text1.setFill(Color.WHITE);
      	content.add(text1);
        


    	
        //draw the game graphics
        drawShip();
        drawBullets();
        drawAsteroids();
                
    }

   
    public void drawShip() {
        //draw the ship
 

    	Polygon A=ship.getShape();
    	A.setFill(Color.ORANGE);
    	A.setTranslateX(ship.getX());
    	A.setTranslateY(ship.getY());
    	A.setRotate(ship.getFaceAngle());
    	((Group)pane.getRoot()).getChildren().add(A);

    }

   
    public void drawBullets() {
        for (int n = 0; n < BULLETS; n++) {
            if (bullet[n].isAlive()) {
            	Polygon A=bullet[n].getShape();
            	A.setFill(Color.MAGENTA);
            	A.setTranslateX(bullet[n].getX());
            	A.setTranslateY(bullet[n].getY());
            	((Group)pane.getRoot()).getChildren().add(A);

            }
        }
    }

   
    public void drawAsteroids() {
    	
        for (int n = 0; n < ASTEROIDS; n++) {
            if (ast[n].isAlive()) {
            	Polygon A=ast[n].getShape();
            	A.setFill(Color.DARKGREY);
            	A.setTranslateX(ast[n].getX());
            	A.setTranslateY(ast[n].getY());
            	A.setRotate(ast[n].getMoveAngle());
            	((Group)pane.getRoot()).getChildren().add(A);


 
            }
        }
    	
    }

  
    /*****************************************************
     * move and animate the objects in the game
     *****************************************************/
    private void gameUpdate() {
        updateShip();
        updateBullets();
        updateAsteroids();
        checkCollisions();
    }

    /*****************************************************
     * Update the ship position based on velocity
     *****************************************************/
    public void updateShip() {
        //update ship's X position, wrap around left/right
        ship.incX(ship.getVelX());
        if (ship.getX() < -10)
            ship.setX(pane.getWidth() + 10);
        else if (ship.getX() > pane.getWidth() + 10)
            ship.setX(-10);
        //update ship's Y position, wrap around top/bottom
        ship.incY(ship.getVelY());
        if (ship.getY() < -10)
            ship.setY(pane.getHeight() + 10);
        else if (ship.getY() > pane.getHeight() + 10)
            ship.setY(-10);
    }

    /*****************************************************
     * Update the bullets based on velocity
     *****************************************************/
    public void updateBullets() {
        //move the bullets
        for (int n = 0; n < BULLETS; n++) {
            if (bullet[n].isAlive()) {
                //update bullet's x position
                bullet[n].incX(bullet[n].getVelX());
                //bullet disappears at left/right edge
                if (bullet[n].getX() < 0 ||
                    bullet[n].getX() > pane.getWidth())
                {
                    bullet[n].setAlive(false);
                }
                //update bullet's y position
                bullet[n].incY(bullet[n].getVelY());
                //bullet disappears at top/bottom edge
                if (bullet[n].getY() < 0 ||
                    bullet[n].getY() > pane.getHeight())
                {
                    bullet[n].setAlive(false);
                }
            }
        }
    }

    /*****************************************************
     * Update the asteroids based on velocity
     *****************************************************/
    public void updateAsteroids() {
        //move and rotate the asteroids
        for (int n = 0; n < ASTEROIDS; n++) {
            if (ast[n].isAlive()) {
                //update the asteroid's X value
                ast[n].incX(ast[n].getVelX());
                if (ast[n].getX() < -20)
                    ast[n].setX(pane.getWidth() + 20);
                else if (ast[n].getX() > pane.getWidth() + 20)
                    ast[n].setX(-20);

                //update the asteroid's Y value
                ast[n].incY(ast[n].getVelY());
                if (ast[n].getY() < -20)
                    ast[n].setY(pane.getHeight() + 20);
                else if (ast[n].getY() > pane.getHeight() + 20)
                    ast[n].setY(-20);

                //update the asteroid's rotation
                ast[n].incMoveAngle(ast[n].getRotationVelocity());
                if (ast[n].getMoveAngle() < 0)
                    ast[n].setMoveAngle(360 - ast[n].getRotationVelocity());
                else if (ast[n].getMoveAngle() > 360)
                    ast[n].setMoveAngle(ast[n].getRotationVelocity());
            }
        }
    }

    /*****************************************************
     * Test asteroids for collisions with ship or bullets
     *****************************************************/
    public void checkCollisions() {
        //check for ship and bullet collisions with asteroids
        for (int m = 0; m<ASTEROIDS; m++) {
            if (ast[m].isAlive()) {
                //check for bullet collisions
                for (int n = 0; n < BULLETS; n++) {
                    if (bullet[n].isAlive()) {
                        //perform the collision test
                        if (ast[m].getBounds().contains(
                                bullet[n].getX(), bullet[n].getY()))
                        {
                            bullet[n].setAlive(false);
                            ast[m].setAlive(false);
                            //explode.play();
                            continue;
                        }
                    }
                }

                //check for ship collision
                if (ast[m].getBounds().intersects(ship.getBounds())) {
                    ast[m].setAlive(false);
                    //explode.play();
                    ship.setX(320);
                    ship.setY(240);
                    ship.setFaceAngle(0);
                    ship.setVelX(0);
                    ship.setVelY(0);
                    continue;
                }
            }
        }

    }



    /*****************************************************
     * calculate X movement value based on direction angle
     *****************************************************/
    public double calcAngleMoveX(double angle) {
        return (double) (Math.cos(angle * Math.PI / 180));
      }

    /*****************************************************
     * calculate Y movement value based on direction angle
     *****************************************************/
    public double calcAngleMoveY(double angle) {
        return (double) (Math.sin(angle * Math.PI / 180));
    }

    public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		pane.setFill(Color.BLACK);
		Init();
		
        
        pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
        	 
			@Override
			public void handle(KeyEvent k) {
		        KeyCode keyCode = k.getCode();
		        
		        switch (keyCode) {

		        case LEFT:
		            //left arrow rotates ship left 5 degrees
		            ship.incFaceAngle(-10);
		            if (ship.getFaceAngle() < 0) ship.setFaceAngle(360-10);
		            break;

		        case RIGHT:
		            //right arrow rotates ship right 5 degrees
		            ship.incFaceAngle(10);
		            if (ship.getFaceAngle() > 360) ship.setFaceAngle(10);
		            break;

		        case UP:
		            //up arrow adds thrust to ship (1/10 normal speed)
		            ship.setMoveAngle(ship.getFaceAngle()-90);
		            ship.incVelX(calcAngleMoveX(ship.getMoveAngle()) * 0.09);
		            ship.incVelY(calcAngleMoveY(ship.getMoveAngle()) * 0.09);
		            break;
		            
		        case DOWN:
		            //up arrow adds thrust to ship (1/10 normal speed)
		            ship.setMoveAngle(ship.getFaceAngle() + 90);
		            ship.incVelX(calcAngleMoveX(ship.getMoveAngle()) * 0.1);
		            ship.incVelY(calcAngleMoveY(ship.getMoveAngle()) * 0.1);
		            break;
		            
		        //Ctrl, Enter, or Space can be used to fire weapon
		        case CONTROL:
		        case ENTER:
		        case SPACE:
		            //fire a bullet
		            currentBullet++;
		            if (currentBullet > BULLETS - 1) currentBullet = 0;
		            bullet[currentBullet].setAlive(true);
		            //point bullet in same direction ship is facing
		            bullet[currentBullet].setX(ship.getX());
		            bullet[currentBullet].setY(ship.getY());
		            bullet[currentBullet].setMoveAngle(ship.getFaceAngle() - 90);
		            //fire bullet at angle of the ship
		            double angle = bullet[currentBullet].getMoveAngle();
		            double svx = ship.getVelX();
		            double svy = ship.getVelY();
		            bullet[currentBullet].setVelX(svx + calcAngleMoveX(angle) * 2);
		            bullet[currentBullet].setVelY(svy + calcAngleMoveY(angle) * 2);
		            //play shoot sound
		            //shoot.play();
		            break;

				default:
					break;
		        }
				
			}
		});        
        
        timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
 
		keyFrame = new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				gameUpdate();
				update();
			}
		});
		timeline.getKeyFrames().add(keyFrame);
        
		timeline.play();
		arg0.setTitle("Asteroids Game");
        arg0.setScene(pane);
        arg0.show();
        
	}


}
