package game;


import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
//testing sethits
public class CountdownoverTest {
	Countdownover test = new Countdownover();
	@Test
	void testsethits() {
		test.sethits(5);
	TestCase.assertEquals(test.gethits(), 5);
	
}
	@Test
	//testing get hits
	void testgethits() {
		test.sethits(50);
		TestCase.assertEquals(test.gethits(), 50);
		
	}

}
