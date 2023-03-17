package group3.demonGame;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * Used to keep track of player's score
 * and display it onto game screen.
 * 
 * @author myw11
 *
 */
public class Score {
	GameManager gm;
        private int score;

	public Score(GameManager manager) {
		this.gm = manager;
                this.score = 0;
	}

	 // get score
        public int getScore() {
            return score;
        }
	
	 // add to score
	 public void increaseScore(int value) {
            score += value;
	 }
	
	 // subtract from score
	 public void decreaseScore(int value) {
            score -= value;
	 }

	public void draw(Graphics2D g) {

		// used to write words on display screen
		g.setFont(gm.fontStyle);
		g.setColor(Color.red);

		if (gm.gameDone) {
			// display final score at game's end
			String scoreMSG = "SCORE: " + this.score;
			g.drawString(scoreMSG, 500, 300);

		} else {

			g.drawString("Score:" + this.score, 200, 50); // y indicates baseline of text!!
			// System.out.println(minutes + ":" + gm.seconds);
		}
	}

}
