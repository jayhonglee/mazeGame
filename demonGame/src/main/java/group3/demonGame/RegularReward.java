package group3.demonGame;

import java.awt.Image;

public class RegularReward extends gameObj{
	private int points = 100;
	
    public RegularReward(GameManager gm,int x, int y, Image ig) {
        super(gm,x, y, ig);
    }

    public void getReward(){
        this.gm.score += points;
    }
}
