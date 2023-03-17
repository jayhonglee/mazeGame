package group3.demonGame;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * used to display time onto game screen
 * @author myw11
 *
 */
public class Time {
	double playTime;
	int minutes = 0;
	GameManager gm;
		
	public Time(GameManager manager) {
		this.gm = manager;
	}

	/**
	 * display time on game screen (UI)
	 * 
	 */
	public void draw(Graphics2D g) {
		
		// used to write words on display screen
		g.setColor(Color.red);
		g.setFont(gm.fontStyle);
		
					
		if(gm.gameDone) {
			// display final score at game's end
			String timeMSG = "TIME: " + minutes + ":" + gm.seconds;
			g.drawString(timeMSG, 500, 200);
			
		} else {
			
			if(gm.seconds >= 60) {
				minutes = (int)(gm.seconds/60);
				gm.seconds = (gm.seconds)%60;
			}
			g.drawString("Time:" + minutes + ":" + gm.seconds, 50, 50); // y indicates baseline of text!!
			//System.out.println(minutes + ":" + gm.seconds);
		}	
		
	}
	

}
