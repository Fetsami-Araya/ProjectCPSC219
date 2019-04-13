package game;
import java.awt.Rectangle;

import javafx.scene.shape.Polygon;



public class Asteroid extends BaseVectorShape {
    //define the asteroid polygon shape
    private int[] astx = {-20,-13, 0,20,22, 20, 12,  2,-10,-22,-16};
    private int[] asty = { 20, 23,17,20,16,-20,-22,-14,-17,-20, -5};

    //rotation speed
    protected double rotVel;
    public double getRotationVelocity() { return rotVel; }
    public void setRotationVelocity(double v) { rotVel = v; }

    //bounding rectangle
    public Rectangle getBounds() {
        Rectangle r;
        r = new Rectangle((int)getX() - 20, (int) getY() - 20, 40, 40);
        return r;
    }

    //default constructor
    Asteroid() {
        Polygon A=new Polygon();
        Double[] T=new Double[astx.length*2];
        for(int i=0;i<astx.length;i++)
        {
        	T[2*i]=(double)astx[i];
        	T[2*i+1]=(double)asty[i];
        }
        A.getPoints().addAll(T);
        setShape(A);
    	setAlive(true);
        setRotationVelocity(0.0);
    }

}
