package group3.demonGame;

import java.awt.Image;

public class RegularReward extends gameObj{
	private int points = 100;
	
    public RegularReward(int x, int y, Image ig, GameManager gm) {
        super(x, y, ig, gm);
    }

    public void getReward(){
        this.gm.score += points;
    }
}
