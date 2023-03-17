package group3.demonGame;

import java.awt.Image;

public class RegularReward extends gameObj{
	private int points = 100;
        private Score score;
	
    public RegularReward(int x, int y, Image ig, GameManager gm, Score score) {
        super(x, y, ig, gm);
        this.score = score;
    }

    public void getReward(){
//        this.gm.score += points;
          score.increaseScore(points);
    }
}
