package group3.demonGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameManagerTest {
	private GameManager gm;

  	@Before
	public void setUp() {
		this.gm = new GameManager();
	}

	/**
  	 * see if when game is over, game thread stops running
  	 */
	@Test
	public void testThreadEnd() {
		gm.gameDone = true;
		assertTrue(gm.game == null);

	}
	

}
