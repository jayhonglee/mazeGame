package group3.demonGame;

import java.awt.Color;
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

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
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
	 * Needed because JPanel is a serializable class.
	 * The number differentiates it from other JPanel, etc. types.
	 */
	private static final long serialVersionUID = -4593365196307425464L;

	/**
	 * screen settings
	 */
	// size of gameplay area (game map)
	public int windowWidth = 1000; // width
	public int windowHeight = 800; // height
	public int squareSize = 50; // tile size

	/**
	 * time and score
	 */
	Time clock = new Time(this);
	public int seconds = 0;
	private long timer = 0;
	Score score = new Score(this);
	// font used to display time and score during the game
	Font fontStyle = new Font("Serif", Font.PLAIN, 24);

	/**
	 * game characters and map objects
	 */
	// enemy movement system
	public Pathfinder pf = new Pathfinder(this);
	// array to hold all game objects
	public ArrayList<GameObj> objList = new ArrayList<>();
	//maze
	public Maze maze1 = new Maze(this);
	// map items (wall and door)
	public Wall wall;
	Image d2im = Toolkit.getDefaultToolkit().getImage("src/image/door.png");
	public Door door2 = new Door(900, 50, d2im, this);
	// main characters
	Image dmim = Toolkit.getDefaultToolkit().getImage("src/image/demon.png");/* demon */
	public Demon dm = new Demon(50, 50, dmim, this);
	// moving enemies
	Image em1im = Toolkit.getDefaultToolkit().getImage("src/image/enemies.png");/* enemy1 */
	public Enemies em1 = new Enemies(700, 700, em1im, this);
	Image em2im = Toolkit.getDefaultToolkit().getImage("src/image/enemies.png");/* enemy2 */
	public Enemies em2 = new Enemies(700, 450, em2im, this);
	// regular reward
	Image r1 = Toolkit.getDefaultToolkit().getImage("src/image/reward1.png");
	RegularReward rw1 = new RegularReward(350, 350, r1, this, score);
	RegularReward rw11 = new RegularReward(150, 150, r1, this, score);
	RegularReward rw111 = new RegularReward(150, 550, r1, this, score);
	// bonus reward
	Image r2 = Toolkit.getDefaultToolkit().getImage("src/image/reward2.png");
	Random random = new Random();
	int randIndex = random.nextInt(8) % 8;
	// trap
	Image tr = Toolkit.getDefaultToolkit().getImage("src/image/trap.png");
	Trap trap1 = new Trap(450, 350, tr, this, score);
	Trap trap2 = new Trap(700, 700, tr, this, score);
	Trap trap3 = new Trap(150, 200, tr, this, score);

	/**
	 * variables used to run the game / in the game loop
	 */
	boolean gameDone = false;
	boolean win = false;
	Thread game;
	// FPS
	private int FPS = 10;
	private double updateWait = 1000000000 / FPS; // in nanoseconds
	private double accumulator = 0;
	// int frameCount = 0; // used only to double check FPS

	/**
	 * Class constructor
	 */
	public GameManager() {
		// set screen size
		this.setPreferredSize(new Dimension(windowWidth, windowHeight));
		// handle user keyboard input -> control movement with "W A S D"
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				dm.move(e.getKeyCode());
			}

			public void keyReleased(KeyEvent e) {
				dm.release(e.getKeyCode());
			}
		});
		this.setFocusable(true); // focus on user input
	}

	/**
	 * Updates the game elements (position of characters)
	 * to keep the game working
	 */
	public void update() {
		// update position of characters
		for (int i = 0; i < objList.size(); i++) {
			objList.get(i).update();
		}
	}

	/**
	 * Updates/draws the game visuals; called with repaint().
	 * Needed to draw on the JPanel (game screen).
	 * 
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; // 2D has more control/options
		for (int i = 0; i < objList.size(); i++) {
			objList.get(i).draw(g2);
		}
		g2.setColor(Color.red);
		g2.setFont(fontStyle);
		clock.draw(g2);
		score.draw(g2);
		g2.dispose();
	}

	/**
	 * Start the game's thread
	 */
	public void startGame() {
		game = new Thread(this);
		game.start(); // automatically calls run() below
	}

	/**
	 * Runs the game
	 */
	@Override
	public void run() {
		// center the gameFrame
		JFrame gameFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		gameFrame.setLocationRelativeTo(null);
		
		// load maze
		maze1.createMaze1();
		
		// load bonus reward (appears in new place every game)
		if (randIndex == 1) {
			new BonusReward(550, 350, r2, this, score);
		} else if (randIndex == 2) {
			new BonusReward(800, 500, r2, this, score);
		} else if (randIndex == 3) {
			new BonusReward(550, 400, r2, this, score);
		} else if (randIndex == 4) {
			new BonusReward(100, 500, r2, this, score);
		} else if (randIndex == 5) {
			new BonusReward(700, 150, r2, this, score);
		} else if (randIndex == 6) {
			new BonusReward(600, 50, r2, this, score);
		} else if (randIndex == 7) {
			new BonusReward(550, 50, r2, this, score);
		} else if (randIndex == 8) {
			new BonusReward(450, 900, r2, this, score);
		} else {
			new BonusReward(700, 250, r2, this, score);
		}

		// run game
		long currentTime;
		long prevTime = System.nanoTime();

		while (game != null) {
			currentTime = System.nanoTime();
			accumulator += (currentTime - prevTime) / updateWait;
			timer += (currentTime - prevTime);
			prevTime = currentTime;

			// control how often game updates the game elements and visuals
			if (accumulator >= 1) {
				update();
				repaint();

				accumulator = 0;
				// frameCount++;
				if (timer >= 1000000000) {
					// System.out.println("FPS: " + frameCount);
					// frameCount = 0;
					timer = 0;
					seconds += 1;
				}
			}
			if (gameDone) {
				// end thread
				game = null;
				// close the gameFrame
				gameFrame.dispose();
				// open End Frame
				EndFrame endframe = new EndFrame();
				endframe.setVisible(true);
				// display final score
				endframe.scoreValue.setText(String.valueOf(score.getScore()));
				int min = clock.getMinutes(this.seconds); // must get minutes before seconds!!
				int sec = clock.getSeconds();
				endframe.timeValue.setText(String.valueOf(min) + ":" + String.valueOf(sec));
				if (win) {
					endframe.result.setText("YOU WIN");
				} else {
					endframe.result.setText("GAME OVER");
				}

			}
		}

	}

}
