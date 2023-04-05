package group3.demonGame;

import static org.junit.Assert.assertEquals;
import java.awt.Image;
import java.awt.Toolkit;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit/integration tests for BonusReward class.
 */
public class BonusRewardTest {
	GameManager gm;
    Score score;
    Image r1;
    BonusReward bonusReward;
    int expectedPoints;

    
	@Before
	public void setUp() {
		gm = new GameManager();
		score = new Score(gm);
		r1 = Toolkit.getDefaultToolkit().getImage("");
		bonusReward = new BonusReward(0, 0, r1, gm, score);
		expectedPoints = 200;
	}
	
    /**
     * Test if the bonus reward point is displaying the correct value
     */
    @Test
    public void checkRewardPoints() {
        assertEquals(expectedPoints, bonusReward.getPoints());
    }
    
    /**
     * Test to see if getting bonus reward changes score value
     */
    @Test
    public void checkScoreInteraction() {
    	// getting 1 bonus reward
        bonusReward.getReward();
        assertEquals(expectedPoints, score.getScore());
        // getting 2 bonus rewards
        bonusReward.getReward();
        assertEquals(expectedPoints*2, score.getScore());

        
    }
}
