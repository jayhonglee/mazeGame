package group3.demonGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class Time {
	double playTime;
	int minutes = 0;
	GameManager gm;
	Font fontStyle = new Font("Arial", Font.PLAIN, 40);
	
	public Time(GameManager manager) {
		this.gm = manager;
	}

	/**
	 * display time on game screen (UI)
	 * 
	 */
	public void draw(Graphics2D g) {
		
		// used to write words on display screen
		g.setFont(fontStyle);
		g.setColor(Color.white);
					
		if(gm.gameDone) {
			// display final score at game's end
			String timeMSG = "TIME: " + minutes + ":" + gm.seconds;
			g.drawString(timeMSG, 500, 200);
			
		} else {
			
			if(gm.seconds >= 60) {
				minutes = (int)(gm.seconds/60);
				gm.seconds = (gm.seconds)%60;
			}
			g.drawString(minutes + ":" + gm.seconds, 50, 50); // y indicates baseline of text!!
			//System.out.println(minutes + ":" + gm.seconds);
		}	
		
	}
	

}
