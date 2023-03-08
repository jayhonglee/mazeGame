package group3.demonGame;

public class Game_State implements Runnable {
	private boolean isPaused, gameWin;
	
	Thread runningGame;
	
	// start the game
	public void startGame() {
		runningGame = new Thread(this);
		runningGame.start();
	}
	
	// run thread
	@Override
	public void run() {
		
		while (runningGame != null) {
			if (!isPaused) {
				// update game element information
				
				// update game screen/display
			}
			
			
		}
	}

}
