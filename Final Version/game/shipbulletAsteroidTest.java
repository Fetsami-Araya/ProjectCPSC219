//importing the junit tests
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
//create test class shipbulletAsteroid
class shipbulletAsteroidTest {

	@Test
	//create test for ship
	void testship() {
		//creating ship
		Ship A=new Ship();
		//set x y to 1.0
		A.setX(1.0);
		A.setY(1.0);
		Rectangle r=A.getBounds(); 
		Rectangle r1=new Rectangle(-5,-5,12,12);
		TestCase.assertEquals(r, r1);
	}

	@Test
	//create test for bullets
	void testbullet() {
		//create bullet
		Bullet A=new Bullet();
		//set x y to 1.0
		A.setX(1.0);
		A.setY(1.0);
		Rectangle r=A.getBounds(); 
		Rectangle r1=new Rectangle(1,1,1,1);
		TestCase.assertEquals(r, r1);
	}
	
	@Test
	void testAsteroid() {
		//create asteroids
		Asteroid A=new Asteroid();
		//set x y to 1.0
		A.setX(1.0);
		A.setY(1.0);
		Rectangle r=A.getBounds(); 
		Rectangle r1=new Rectangle(-19,-19,40,40);
		TestCase.assertEquals(r, r1);
		TestCase.assertEquals(A.getRotationVelocity(),0.0);
		//additional test for set rotation velocity
		A.setRotationVelocity(1.0);
		TestCase.assertEquals(A.getRotationVelocity(),1.0);
	}
}
