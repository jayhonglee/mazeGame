package group3.demonGame;

import java.awt.*;



public class Trap extends gameObj {
	private int points  = -50;

	 public Trap(int x, int y, Image ig, GameManager gm) {
	        super(x, y, ig, gm);
	 }

    public void trapCatch(){
        this.gm.score += points;
      if(this.gm.score<0){
      	this.gm.win = false;
      	gm.gameDone = true;
      }
    }
}

