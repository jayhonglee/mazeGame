package group3.demonGame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit (and integration) test for Score class.
 */
public class ScoreTest 
{
    /**
     * Test the changeScore() method (positive numbers only)
     */
    @Test
    public void increaseScore()
    {
    	GameManager gm = new GameManager();
    	Score testee = new Score(gm);

    	testee.changeScore(25);
    	testee.changeScore(75);
        assertEquals( 100, testee.getScore());
    }
    
    /**
     * Test the changeScore() method (negative numbers only)
     */
    @Test
    public void decreaseScore()
    {
    	GameManager gm = new GameManager();
    	Score testee = new Score(gm);
    	
    	testee.changeScore(-55);
    	testee.changeScore(-5);
    	testee.changeScore(-40);
        assertEquals( -100, testee.getScore());
    }
    
    /**
     * Test the changeScore() method (both + and - numbers)
     */
    @Test
    public void addSubtract()
    {
    	GameManager gm = new GameManager();
    	Score testee = new Score(gm);
    	
    	testee.changeScore(55);
    	testee.changeScore(-5);
    	testee.changeScore(-40);
        assertEquals( 10, testee.getScore());
    }
    
    /**
     * Test the Score class interaction with GameManager class (win or lose)
     */
    @Test
    public void interactionGameWin()
    {
    	GameManager gm = new GameManager();
    	Score testee = new Score(gm);
    	
    	//should lose in both cases
        testee.changeScore(9900); // high score should not end game
        assertFalse( gm.win );
    	testee.changeScore(-10000);
        assertFalse( gm.win );

    }
    
    /**
     * Test the Score class interaction with GameManager class (game over or not)
     */
    @Test
    public void interactionGameDone()
    {
    	GameManager gm = new GameManager();
    	Score testee = new Score(gm);
    	//as long as score > 0, game should continue
    	testee.changeScore(100);
        assertFalse( gm.gameDone );
        //game should end, since score <0
    	testee.changeScore(-200);
        assertTrue( gm.gameDone );
    }
    
}
