package group3.demonGame;

import static org.junit.Assert.assertEquals;
import java.awt.Image;
import java.awt.Toolkit;

import org.junit.Test;

/**
 * Unit test for BonusReward class.
 */
public class BonusRewardTest {
    /**
     * Test the bonus reward point displaying the correct value
     */
    @Test
    public void checkRegularRewardPoints() {
        int expectedPoints = 200;

        GameManager gm = new GameManager();
        Score score = new Score(gm);
        Image r1 = Toolkit.getDefaultToolkit().getImage("");
        BonusReward bonuseReward = new BonusReward(0, 0, r1, gm, score);

        assertEquals(expectedPoints, bonuseReward.getPoints());
    }
}
