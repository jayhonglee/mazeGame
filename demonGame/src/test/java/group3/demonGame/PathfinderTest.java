package group3.demonGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PathfinderTest {
	private GameManager mockManager;

    private Pathfinder pathfinderUnderTest;
    

	@Before
	public void setUp() {
		 mockManager = new GameManager();
	     pathfinderUnderTest = new Pathfinder(mockManager);
	}



	@Test
	public void testCanPath() {
		boolean a=pathfinderUnderTest.canPath(1,1);
		boolean b=pathfinderUnderTest.canPath(1000,1000);
		assertTrue(a);
		assertFalse(b);
		
	}

	@Test
	public void testInRange() {
		boolean a=pathfinderUnderTest.inRange(1,1);
		boolean b=pathfinderUnderTest.inRange(1000,1000);
		assertTrue(a);
		assertFalse(b);
	}

	@Test
	public void testGetPath() {
		final ArrayList<Pathfinder.queueEle> result=pathfinderUnderTest.getPath(1,1);
		Assert.assertNotNull(result);
	}

}
