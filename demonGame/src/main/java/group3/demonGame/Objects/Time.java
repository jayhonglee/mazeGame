package group3.demonGame;

import java.awt.Graphics2D;

/**
 * used to display time onto game screen
 * @author myw11
 *
 */
public class Time {
	private int seconds;
	private int minutes;
	GameManager gm;
	
	public Time(GameManager manager) {
		this.gm = manager;
	}
	/**
	 * Calculates the amount of minutes passed in-game
	 * based on the total amount of seconds passed. 
	 * @param sec
	 * @return the number of minutes passed in game
	 */
	public int getMinutes(int sec) {
		this.seconds = sec;
		if(sec >= 60) {
			this.minutes = (int)(sec/60);
			this.seconds = sec%60;
		}
		return minutes;
	}
	
	/**
	 * If called after getMinutes(), returns the 
	 * (number of seconds) - 60*(number of minutes).
	 * @return the amount of seconds (less 60 if applicable)
	 */
	public int getSeconds() {
		return this.seconds;
	}

	/**
	 * display time on game screen (UI)
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g) {
					
		if(!(gm.gameDone)) {
			getMinutes(gm.seconds);
			g.drawString("Time:" + minutes + ":" + seconds, 50, 50); // y indicates baseline of text!!
			//System.out.println(minutes + ":" + gm.seconds);
		}	
		
	}
	

}
