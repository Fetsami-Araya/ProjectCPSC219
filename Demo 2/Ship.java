import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class Ship {
	Rectangle rectangle;
	
	public Ship() {
		Rectangle rect = new Rectangle(300,300,50,100); // creates the ship 
		rect.setFill(Color.ANTIQUEWHITE); // gives the shape ship the color
		this.rectangle = rect;
	}
	
	public Rectangle getShip() {
		return rectangle;
	}
	
	public void setShip(Rectangle rect) {
		this.rectangle = rect;
	}
	
	/**
	 * sets up the direction and the roation
	 */
	public void moveUp() {
		rectangle.setY(rectangle.getY()-20);
	}

	public void moveDown() {
		rectangle.setY(rectangle.getY()+20);
	}

	public void moveRight() {
	      Rotate rotate = new Rotate(); // creating a new roation
	      
	      //Setting the angle for the rotation 
	      rotate.setAngle(-20); 
	      
	      //Setting pivot points for the rotation 
	      rotate.setPivotX(this.rectangle.getX()); 
	      rotate.setPivotY(this.rectangle.getY());
	      

	      this.rectangle.getTransforms().addAll(rotate);
	}
	
	public void moveLeft() {
	      Rotate rotate = new Rotate(); 
	      
	      //Setting the angle for the rotation 
	      rotate.setAngle(20); 
	      
	      //Setting pivot points for the rotation 
	      rotate.setPivotX(this.rectangle.getX()); 
	      rotate.setPivotY(this.rectangle.getY());
	      
	      this.rectangle.getTransforms().addAll(rotate);

	}

}
