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

	public Score(GameManager manager) {
		this.gm = manager;
	}

//	// get score
//	public int getScore() {
//		return this.score;
//	}
//
//	// add to score
//	public void increaseScore(int value) {
//		this.score += value;
//	}
//
//	// subtract from score
//	public void decreaseScore(int value) {
//		this.score -= value;
//	}
	
	public void draw(Graphics2D g) {
		
		// used to write words on display screen
		g.setFont(gm.fontStyle);
		g.setColor(Color.white);
					
		if(gm.gameDone) {
			// display final score at game's end
			String scoreMSG = "SCORE: " + gm.score;
			g.drawString(scoreMSG, 500,300);
			
		} else {
			
			g.drawString("Score:" + gm.score, 200, 50); // y indicates baseline of text!!
			//System.out.println(minutes + ":" + gm.seconds);
		}	
	}


}
