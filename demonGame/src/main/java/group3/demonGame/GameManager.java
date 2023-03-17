package group3.demonGame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * GameManager manages all the game elements and brings them together
 * to run the game. 
 * 
 * @author myw11
 *
 */
public class GameManager extends JPanel implements Runnable {
	/**
	 * needed because JPanel is a serializable class. 
	 * number would differentiate it from other JPanel, etc. types.
	 */
	private static final long serialVersionUID = -4593365196307425464L;
	
	/**
	 * screen settings
	 */
	// size of gameplay area (game map)
	public int widw = 1000; // width
	public int widh = 800; // height
	// Ui addition
	//int uih = 100;
	
	// collision
	public pathfinder pf = new pathfinder(this);
	
	/**
	 * game characters and map objects
	 */
	public ArrayList<gameObj> objList = new ArrayList<>();
	//public gameObj bg;
		// map items
	public wall wall;
//	Image d1im = Toolkit.getDefaultToolkit().getImage("src/image/door.png");
//	public door door1 = new door(50, 50, d1im, this);	
	Image d2im = Toolkit.getDefaultToolkit().getImage("src/image/door.png");
	public door door2 = new door(900,50,d2im, this);
		// main character
	Image dmim = Toolkit.getDefaultToolkit().getImage("src/image/demon.png");/* demon */
	public demon dm = new demon(50, 50, dmim, this);
		// moving enemies
	Image em1im = Toolkit.getDefaultToolkit().getImage("src/image/enemies.png");/* enemy1 */
	public enemies em1 = new enemies(700, 700, em1im, this);
	Image em2im = Toolkit.getDefaultToolkit().getImage("src/image/enemies.png");/* enemy2 */
	public enemies em2 = new enemies(700, 450, em2im, this);
		// regular reward
	Image r1 = Toolkit.getDefaultToolkit().getImage("src/image/reward1.png");
	RegularReward rw1 = new RegularReward(350, 350, r1, this);
	RegularReward rw11 = new RegularReward(150, 150, r1, this);
	RegularReward rw111 = new RegularReward(150, 550, r1, this);
		// bonus reward
	Image r2 = Toolkit.getDefaultToolkit().getImage("src/image/reward2.png");
	Random random=new Random();
	int randIndex=random.nextInt(8)%8;
		// trap
	Image tr = Toolkit.getDefaultToolkit().getImage("src/image/trap.png");
	Trap trap1 = new Trap(450, 350, tr, this);
	Trap trap2 = new Trap(700, 700, tr, this);
	Trap trap3 = new Trap(150, 200, tr, this);
		

	/**
	 * UI: time and score
	 */
	Time clock = new Time(this);
	public int seconds = 0;
	private long timer = 0;
	Score points = new Score(this);
	int score = 0;
	// font used to display time and score
	Font fontStyle = new Font("Serif", Font.PLAIN, 24);
	
	
	/**
	 * variables used in to run the game / in the game loop
	 */
	boolean gameDone = false;
	boolean win = false;
	Thread game;
	
	//fps
	private int FPS = 10;
	private double updateWait = 1000000000/FPS;
	private double accumulator = 0;
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
	 * updates the game elements (position of characters) 
	 */
	public void update() {
		//update position of characters
		for (int i = 0; i < objList.size(); i++) {
			objList.get(i).update();
		}
	}/* refresh to keep game operate */
	
	/**
	 * updates game visuals; called with repaint()
	 * 
	 * @param g 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < objList.size(); i++) {
			objList.get(i).draw(g2);
		}
		clock.draw(g2);
		points.draw(g2);
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
		
		// load rewards
		if(randIndex==1  ){
			new BonusReward(550,350, r2, this);
		}
		else if(randIndex==2) {
			new BonusReward(800,500 , r2,this);
		}
		else if(randIndex==3) {
			new BonusReward(550,400 , r2, this);
		}
		else if(randIndex==4) {
			new BonusReward(100,500 , r2, this);
		}
		else if(randIndex==5) {
			new BonusReward(700,150 , r2, this);
		}
		else if(randIndex==6) {
			new BonusReward(600,50 , r2, this);
		}
		else if(randIndex==7) {
			new BonusReward(550,50 , r2, this);
		}
		else if(randIndex==8) {
			new BonusReward(450,900 , r2, this);
		}
		else {
			new BonusReward(700,250 , r2, this);
		}

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
