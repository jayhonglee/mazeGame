package group3.demonGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;


public class GameManager extends JPanel implements Runnable {
	/**
	 * needed because JPanel is a serializable class
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * screen settings
	 */
	public int widw = 1000; // width
	public int widh = 800; // height
	
	// collision
	public pathfinder pf = new pathfinder(this);
	
	/**
	 * game characters and map objects
	 */
	public ArrayList<gameObj> objList = new ArrayList<>();
	public gameObj bg;
		// map items
	public wall wall;
	Image d1im = Toolkit.getDefaultToolkit().getImage("src/image/door.png");
	public door door1 = new door(50, 50, d1im, this);	
	public door door2;
		// main character
	Image dmim = Toolkit.getDefaultToolkit().getImage("src/image/demon.png");/* demon */
	public demon dm = new demon(50, 50, dmim, this);
		// moving enemies
	Image em1im = Toolkit.getDefaultToolkit().getImage("src/image/enemies.png");/* enemy1 */
	public enemies em1 = new enemies(700, 700, em1im, this);
	Image em2im = Toolkit.getDefaultToolkit().getImage("src/image/enemies.png");/* enemy2 */
	public enemies em2 = new enemies(550, 450, em2im, this);
		

	/**
	 * UI: time and score
	 */
	Time clock = new Time(this);
	public int seconds = 0;
	long timer = 0;
//	Score points = new Score(this);
	
	/**
	 * game loop
	 */
	boolean gameDone = false;
	Thread game;
	
	//fps
	int FPS = 10;
	double updateWait = 1000000000/FPS;
	double accumulator = 0;
	int frameCount =0;

	

	// constructor
	public GameManager() {
		// set screen size
		this.setPreferredSize(new Dimension(widw, widh));
		// handle user keyboard input
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				dm.move(e.getKeyCode());
			}

			public void keyReleased(KeyEvent e) {
				dm.release(e.getKeyCode());
			}
		}); /* control movement with "W A S D" */
		this.setFocusable(true); // focus on user input
	}
	
	
	/**
	 * update game 
	 */
	public void update() {
		//update position of characters
		for (int i = 0; i < objList.size(); i++) {
			objList.get(i).update();
		}
	}/* refresh to keep game operate */
	
	/**
	 * update game visuals; called with repaint()
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < objList.size(); i++) {
			objList.get(i).draw(g2);
		}
		clock.draw(g2);
		g2.dispose();
	} /* draw the game object */
	
	/**
	 * start the game's thread
	 */
	public void startGame() {
		game = new Thread(this);
		game.start(); // automatically calls run() below
	}
	
	@Override
	public void run() {				
		// load map
		Image wallim = Toolkit.getDefaultToolkit().getImage("src/image/wall.png");
		for (int i = 0; i < widw; i += 50) {
			new wall(i, 0, wallim, this);
			new wall(i, widh - 50, wallim, this);
		}
		for (int i = 50; i < widh; i += 50) {
			new wall(0, i, wallim, this);
			new wall(widw - 50, i, wallim, this);
		}
		for (int i = 50; i < 350; i += 50) {
			new wall(100, i, wallim, this);
		}
		for (int i = 50; i < 350; i += 50) {
			new wall(850, i, wallim, this);
		}
		for (int i = 100; i < 350; i += 50) {
			new wall(750, i, wallim, this);
		}
		for (int i = 100; i < 350; i += 50) {
			new wall(650, i, wallim, this);
		}
		for (int i = 100; i < 250; i += 50) {
			new wall(550, i, wallim, this);
		}
		for (int i = 100; i < 250; i += 50) {
			new wall(200, i, wallim, this);
		}
		for (int i = 200; i < 350; i += 50) {
			new wall(350, i, wallim, this);
		}
		for (int i = 150; i < 400; i += 50) {
			new wall(i, 300, wallim, this);
		}
		for (int i = 200; i < 550; i += 50) {
			new wall(i, 100, wallim, this);
		}
		for (int i = 400; i < 500; i += 50) {
			new wall(i, 300, wallim, this);
		}
		for (int i = 550; i < 650; i += 50) {
			new wall(i, 300, wallim, this);
		}
		new wall(700, 100, wallim, this);
		for (int i = 100; i < 900; i += 50) {
			new wall(i, 450, wallim, this);
		}
		for (int i = 550; i < 700; i += 50) {
			new wall(100, i, wallim, this);
		}
		for (int i = 450; i < 600; i += 50) {
			new wall(250, i, wallim, this);
		}
		for (int i = 550; i < 700; i += 50) {
			new wall(850, i, wallim, this);
		}
		for (int i = 500; i < 600; i += 50) {
			new wall(550, i, wallim, this);
		}
		for (int i = 550; i < 650; i += 50) {
			new wall(650, i, wallim, this);
		}
		for (int i = 550; i < 700; i += 50) {
			new wall(450, i, wallim, this);
		}
		for (int i = 500; i < 850; i += 50) {
			new wall(i, 650, wallim, this);
		}
		for (int i = 150; i < 400; i += 50) {
			new wall(i, 650, wallim, this);
		}
		for (int i = 750; i < 850; i += 50) {
			new wall(i, 550, wallim, this);
		}
		new wall(350, 550, wallim, this);
		new wall(350, 600, wallim, this);
		em1.getpath();
		em2.getpath();

		// run game
		long currentTime;
		long prevTime = System.nanoTime();
		while (game != null) {
			currentTime = System.nanoTime();
			accumulator +=(currentTime - prevTime)/updateWait;
			timer +=(currentTime - prevTime);
			prevTime = currentTime;					

			
			if(accumulator >= 1) { // control how often game updates
				//update game elements and visuals
				update();
				repaint();
	
				accumulator=0;
				//frameCount++;
				if(timer >= 1000000000) {
					//System.out.println("FPS: " + frameCount);
					//frameCount = 0;
					timer=0;
					seconds+=1;
				}
			}
			if(gameDone) {
				game = null;
			}
		}
		
	} 


}
