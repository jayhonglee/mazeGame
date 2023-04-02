package group3.demonGame;

import static org.junit.Assert.assertEquals;
import java.awt.Image;
import java.awt.Toolkit;

import org.junit.Test;

/**
 * Unit test for RegularReward class.
 */
public class RegularRewardTest {
    /**
     * Test the regular reward point displaying the correct value
     */
    @Test
    public void checkRegularRewardPoints() {
        int expectedPoints = 100;

        GameManager gm = new GameManager();
        Score score = new Score(gm);
        Image r1 = Toolkit.getDefaultToolkit().getImage("");
        RegularReward rw1 = new RegularReward(0, 0, r1, gm, score);

        assertEquals(expectedPoints, rw1.getPoints());
    }
}
