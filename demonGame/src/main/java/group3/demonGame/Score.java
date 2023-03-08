package group3.demonGame;

/**
 * 
 * The game score.
 * 
 * @author myw11
 *
 */
public class Score {
	private int score;
	
	// set score
	public void setScore(int value) {
		this.score = value;
	}
	// get score
	public int getScore() {
		return this.score;
	}
	// add to score
	public void increaseScore(int value) {
		this.score += value;
	}
	// subtract from score
	public void decreaseScore(int value) {
		this.score -= value;
	}
	
}
