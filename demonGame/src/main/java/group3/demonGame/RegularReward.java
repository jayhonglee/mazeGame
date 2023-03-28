package group3.demonGame;

import java.awt.Image;

/**
 * Create a gameobj regular reward with a defualt size(50w x 50h). When demon
 * get it, points add 100.
 * 
 * @author zeyoup
 * @param x  X coordinate of regular reward
 * @param y  Y coordinate of regular reward
 * @param ig image of regular reward
 * @param gm gamemanager
 *
 */
public class RegularReward extends GameObj {
    private int points = 100;
    private Score score;

    public RegularReward(int x, int y, Image ig, GameManager gm, Score score) {
        super(x, y, ig, gm);
        this.score = score;
    }

    public void getReward() {
        // this.gm.score += points;
        score.increaseScore(points);
    }
}
