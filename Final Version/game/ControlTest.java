//importing the junit test
import org.junit.Test;

import junit.framework.TestCase;
//create tests for control functions
public class ControlTest {

	/**
	 * simulate LEFT and RIGHT
	 */
	@Test
	//create test for increase face angle by stimulate left and right
	public void testIncFaceAngle() {
		Ship ship = new Ship();
		ship.incFaceAngle(10);
		TestCase.assertEquals(10.0,ship.getFaceAngle());
		
		ship.incFaceAngle(-10);
		TestCase.assertEquals(0.0,ship.getFaceAngle());
	}

	/**
	 * simulate UP and DOWN
	 */
	@Test
	//create test for set move angle by stimulate up and down
	public void testSetMoveAngle() {
		Ship ship = new Ship();
		ship.setMoveAngle(ship.getFaceAngle()-90);
		TestCase.assertEquals(-90.0,ship.getMoveAngle());
		
		ship.setMoveAngle(ship.getFaceAngle()+90);
		TestCase.assertEquals(90.0,ship.getMoveAngle());
	}

}
