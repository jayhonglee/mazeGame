package group3.demonGame;

import static org.junit.Assert.assertEquals;
import java.awt.Image;
import java.awt.Toolkit;

import org.junit.Test;

/**
 * Unit (and integration) test for RegularReward class.
 */
public class BonusRewardTest {
    /**
     * Test the changeScore() method (positive numbers only)
     */
    @Test
    public void checkRegularRewardPoints() {
        GameManager gm = new GameManager();
        Score score = new Score(gm);
        Image r1 = Toolkit.getDefaultToolkit().getImage("");
        RegularReward rw1 = new RegularReward(0, 0, r1, gm, score);

        assertEquals(100, rw1.getPoints());
    }
}
