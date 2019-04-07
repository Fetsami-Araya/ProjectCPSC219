package game;


import java.awt.Rectangle;

import javafx.scene.shape.Polygon;


/*********************************************************
 * Bullet class derives from BaseVectorShape
 **********************************************************/
public class Bullet extends BaseVectorShape {

    //bounding rectangle
    public Rectangle getBounds() {
        Rectangle r;
        r = new Rectangle((int)getX(), (int) getY(), 1, 1);
        return r;
    }

    Bullet() {
        //create the bullet shape
    	Polygon A=new Polygon();
    	A.getPoints().addAll(new Double[] {0.0,0.0,0.0,2.0,2.0,2.0,2.0,0.0});
        setShape(A);
        setAlive(false);
    }
}
