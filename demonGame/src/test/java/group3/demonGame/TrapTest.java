package group3.demonGame;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.Toolkit;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit/integration tests for Trap class
 *
 */
public class TrapTest {
	GameManager gm;
    Score score;
    Image pic;
    Trap trap;
    int expectedPenalty;

    
	@Before
	public void setUp() {
		gm = new GameManager();
		score = new Score(gm);
		pic = Toolkit.getDefaultToolkit().getImage("");
		trap = new Trap(0, 0, pic, gm, score);
		expectedPenalty = -110;
	}
	
    /**
     * Test if the trap points has the correct value
     */
    @Test
    public void checkRewardPoints() {
        assertEquals(expectedPenalty, trap.getPoints());
    }
    
    /**
     * Test to see if getting trap changes score value
     * and if that, in turn, changes the GameManager variables 
     * (like in interactionGameDone() of ScoreTest)
     */
    @Test
    public void checkScoreInteraction() {
      	trap.trapCatch();
        assertEquals(expectedPenalty, score.getScore()); //change score
        assertTrue( gm.gameDone ); // game over
        assertFalse( gm.win ); // game lost
        
    }
}
