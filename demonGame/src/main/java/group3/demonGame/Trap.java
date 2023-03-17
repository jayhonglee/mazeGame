package group3.demonGame;

import java.awt.*;



public class Trap extends gameObj {
	private int points  = -100;

	 public Trap(GameManager gm,int x, int y, Image ig) {
	        super(gm,x, y, ig);
	 }

    public void trapCatch(){
        this.gm.score += points;
      if(this.gm.score<0){
      	this.gm.win = false;
      	gm.gameDone = true;
      }
    }
}

