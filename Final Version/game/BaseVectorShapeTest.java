//import junit test
import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;

//import javafx polygon
import javafx.scene.shape.Polygon;


//create tests for basevectorshape
public class BaseVectorShapeTest {
	BaseVectorShape Test=new BaseVectorShape();
	@Test
	//create test for getShape
	public void testGetShape() {
		//test for null shape
		TestCase.assertEquals(Test.getShape(), null);
		Polygon A=new Polygon();
		//test with given shape
		A.getPoints().addAll(new Double[] {0.0,0.0,0.0,2.0,2.0,2.0,2.0,0.0});
        Test.setShape(A);
        TestCase.assertEquals(Test.getShape(), A);
	}

	@Test
	//create test for IsAlive
	public void testIsAlive() {
		//test without set isAlieve to true
		TestCase.assertEquals(Test.isAlive(), false);
		//test after setting the isAlive to true
		Test.setAlive(true);
		TestCase.assertEquals(Test.isAlive(), true);
	}

	@Test
	//create test for Getx
	public void testGetX() {
		//test without set x coord
		TestCase.assertEquals(Test.getX(), 0.0);
		//test after set x to 1.0
		Test.setX(1.0);
		TestCase.assertEquals(Test.getX(), 1.0);
	}

	@Test
	//create test for GetY
	public void testGetY() {
		//test without set y coord
		TestCase.assertEquals(Test.getY(), 0.0);
		//test after setting y to 1.0
		Test.setY(1.0);
		TestCase.assertEquals(Test.getY(), 1.0);
	}

	@Test
	//create test for getvelx
	public void testGetVelX() {
		//test without setting xvel
		TestCase.assertEquals(Test.getVelX(), 0.0);
		//test after setting the value to 1.0
		Test.setVelX(1.0);
		TestCase.assertEquals(Test.getVelX(), 1.0);
	}

	@Test
	//create test for getvely
	public void testGetVelY() {
		//test without setting yvel
		TestCase.assertEquals(Test.getVelY(), 0.0);
		//test after setting the value to 1.0
		Test.setVelY(1.0);
		TestCase.assertEquals(Test.getVelY(), 1.0);
	}

	@Test
	//create test for getMoveAngle
	public void testGetMoveAngle() {
		//test with the default value 0.0
		TestCase.assertEquals(Test.getMoveAngle(), 0.0);
		//test after setting the value to 1.0
		Test.setMoveAngle(1.0);
		TestCase.assertEquals(Test.getMoveAngle(), 1.0);
	}

	@Test
	//create test for getFaceAngle
	public void testGetFaceAngle() {
		//test with the default value 0.0
		TestCase.assertEquals(Test.getFaceAngle(), 0.0);
		//test after setting the value to 1.0
		Test.setFaceAngle(1.0);
		TestCase.assertEquals(Test.getFaceAngle(), 1.0);
	}

	@Test
	//create test for setshape
	public void testSetShape() {
		//setting the shape to null
		Test.setShape(null);
		TestCase.assertEquals(Test.getShape(), null);
	}

	@Test
	//create test for setalive
	public void testSetAlive() {
		//setting the isAlive to true
		Test.setAlive(true);
		TestCase.assertEquals(Test.isAlive(), true);
	}

	@Test
	//create test for setx
	public void testSetX() {
		//setting the x to 1.0
		Test.setX(1.0);
		TestCase.assertEquals(Test.getX(), 1.0);
	}

	@Test
	//create test for incx
	public void testIncX() {
		//setting the x to 1.0
		Test.setX(1.0);
		//increase x by 1.0
		Test.incX(1.0);
		TestCase.assertEquals(Test.getX(), 2.0);
	}

	@Test
	//create test for sety
	public void testSetY() {
		//set y to 1.0
		Test.setY(1.0);
		TestCase.assertEquals(Test.getY(), 1.0);
	}

	@Test
	//create test for incy
	public void testIncY() {
		//sety to 1.0
		Test.setY(1.0);
		//increase y by 1.0
		Test.incY(1.0);
		TestCase.assertEquals(Test.getY(), 2.0);
	}

	@Test
	//create test for set vel x
	public void testSetVelX() {
		//set the vel x to 1.0
		Test.setVelX(1.0);
		TestCase.assertEquals(Test.getVelX(), 1.0);
	}

	@Test
	//create test for inc vel x
	public void testIncVelX() {
		//set vel x to 1.0
		Test.setVelX(1.0);
		//increase the value by 1.0
		Test.incVelX(1.0);
		TestCase.assertEquals(Test.getVelX(), 2.0);
	}

	@Test
	//test for decrease vel x
	public void testDecVelX() {
		//set vel x to 1.0
		Test.setVelX(1.0);
		//decrease by 1.0
		Test.decVelX(1.0);
		TestCase.assertEquals(Test.getVelX(), 0.0);
	}

	@Test
	//create test for set vel y
	public void testSetVelY() {
		//set vel y to 1.0
		Test.setVelY(1.0);
		TestCase.assertEquals(Test.getVelY(), 1.0);
	}

	@Test
	//create test for increase vel y
	public void testIncVelY() {
		//set vel y to 1.0
		Test.setVelY(1.0);
		//increase vel y by 1.0
		Test.incVelY(1.0);
		TestCase.assertEquals(Test.getVelY(), 2.0);
	}

	@Test
	//create test for decrease vel y
	public void testDecVelY() {
		//set vel y to 1.0
		Test.setVelY(1.0);
		//decerase value by 1.0
		Test.decVelY(1.0);
		TestCase.assertEquals(Test.getVelY(), 0.0);
	}

	@Test
	//create test for set face angle
	public void testSetFaceAngle() {
		//set face angle to 1.0
		Test.setFaceAngle(1.0);
		TestCase.assertEquals(Test.getFaceAngle(), 1.0);
	}

	@Test
	//create test for increase face angle
	public void testIncFaceAngle() {
		//set face angle to 1.0
		Test.setFaceAngle(1.0);
		//increase face angle by 1.0
		Test.incFaceAngle(1.0);
		TestCase.assertEquals(Test.getFaceAngle(), 2.0);
	}

	@Test
	//create test for set move angle
	public void testSetMoveAngle() {
		//set the value to 1.0
		Test.setMoveAngle(1.0);
		TestCase.assertEquals(Test.getMoveAngle(), 1.0);
	}

	@Test
	//create test for increase move angle
	public void testIncMoveAngle() {
		//set the value to 1.0
		Test.setMoveAngle(1.0);
		//increase the value by 1.0
		Test.incMoveAngle(1.0);
		TestCase.assertEquals(Test.getMoveAngle(), 2.0);
	}

}
