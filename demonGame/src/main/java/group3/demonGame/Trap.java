package group3.demonGame;

import java.awt.*;



public class Trap extends gameObj {
        private Score score;
	private int points  = -50;

	 public Trap(int x, int y, Image ig, GameManager gm, Score score) {
	        super(x, y, ig, gm);
                this.score = score;
	 }

    public void trapCatch(){
//        this.gm.score += points;
          score.increaseScore(points);
//      if(this.gm.score<0){
//      	this.gm.win = false;
//      	gm.gameDone = true;
//      }
        if(score.getScore()<0) {
            this.gm.win = false;
            gm.gameDone = true;
        }
    }
}

