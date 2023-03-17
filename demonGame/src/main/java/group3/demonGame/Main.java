package group3.demonGame;

import javax.swing.JFrame;

public class Main {

	public static void main(String arg[]) {
		
		// new window pop-up for game
		JFrame gWindow = new JFrame();
		// window default appears in the middle of screen
		gWindow.setLocationRelativeTo(null); 
    	// close event
		gWindow.setDefaultCloseOperation(3); 
    	// cannot adjust the size
		gWindow.setResizable(false);
		// set caption of window
    	gWindow.setTitle("276 Group 3");
    	
    	// load game
    	GameManager game = new GameManager();
       	gWindow.add(game); 
       	gWindow.pack(); // fits Jframe (game window) to 
       					// game/map size (specified in GameManager)
    	
    	// let people see window (after loading game so they don't notice much wait)
    	gWindow.setVisible(true);
    	
    	// start game
    	game.startGame();
	}

}
