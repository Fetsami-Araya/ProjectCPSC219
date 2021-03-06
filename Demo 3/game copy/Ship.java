package game;



import java.awt.Rectangle;

import javafx.scene.shape.Polygon;


public class Ship extends BaseVectorShape {
    //define the ship polygon
    private double[] shipx = { -12, -6, 0, 6, 12, 0 };
    private double[] shipy = {  12, 14, 14, 14, 12, -14 };

    //bounding rectangle
    public Rectangle getBounds() {
        Rectangle r;
        r = new Rectangle((int)getX() - 6, (int) getY() - 6, 12,12);
        return r;
    }

    Ship() {
    	
    	Polygon A=new Polygon();
    	A.getPoints().addAll(new Double[] {shipx[0],shipy[0],shipx[1],shipy[1],shipx[2],shipy[2],
    			shipx[3],shipy[3],shipx[4],shipy[4],shipx[5],shipy[5]});
        setShape(A);
        setAlive(true);
    }
}
