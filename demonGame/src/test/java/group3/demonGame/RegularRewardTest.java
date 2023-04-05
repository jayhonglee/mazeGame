package group3.demonGame;

import static org.junit.Assert.assertEquals;
import java.awt.Image;
import java.awt.Toolkit;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit/integration test for RegularReward class.
 */
public class RegularRewardTest {
	GameManager gm;
    Score score;
    Image r1;
    RegularReward rw1;
    int expectedPoints;

    
	@Before
	public void setUp() {
		gm = new GameManager();
		score = new Score(gm);
		r1 = Toolkit.getDefaultToolkit().getImage("");
		rw1 = new RegularReward(0, 0, r1, gm, score);
		expectedPoints = 100;
	}
	
    /**
     * Test if the regular reward point is displaying the correct value
     */
    @Test
    public void checkRegularRewardPoints() {
        assertEquals(expectedPoints, rw1.getPoints());
    }
    
    /**
     * Test to see if getting regular reward changes score value
     */
    @Test
    public void checkScoreInteraction() {
    	// getting 1 regular reward
        rw1.getReward();
        assertEquals(expectedPoints, score.getScore());
        // getting 2 regular rewards
        rw1.getReward();
        assertEquals(expectedPoints*2, score.getScore());

    }
}
