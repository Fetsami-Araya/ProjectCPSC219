import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Asteroid {
	private Circle circle;
	
	public Asteroid() {
		Circle circ = new Circle(20,20,20, Color.SADDLEBROWN);
		this.circle = circ;
	}
	
	
	public Circle getAsteroid() {
		return this.circle;
	}
	
	public void motion() {
        PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(javafx.util.Duration.millis(500));
        pathTransition.setPath(createPath());
        pathTransition.setNode(this.circle);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(2);
        pathTransition.setAutoReverse(true);
        pathTransition.setOnFinished(e -> {

            pathTransition.setPath(createPath());
            pathTransition.play();

        });
        pathTransition.play();
	}

	private Shape createPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
