package group3.demonGame;

import java.awt.Image;
import java.awt.Toolkit;

import group3.demonGame.Objects.Wall;

/**
 * creates a Maze using the Wall class
 * 
 * @author myw11
 *
 */
public class Maze {
	GameManager gm;
	int width;
	int height;
	Image wallim = Toolkit.getDefaultToolkit().getImage("src/image/wall.png");

	/**
	 * constructor for the Maze class
	 * 
	 * @param manager GameManager instance
	 */
	public Maze(GameManager manager) {
		this.gm = manager;
		width = gm.windowWidth;
		height = gm.windowHeight;

	}

	/**
	 * create 1 version of a maze
	 */
	public void createMaze1() {
		for (int i = 0; i < width; i += 50) {
			new Wall(i, 0, wallim, gm);
			new Wall(i, height - 50, wallim, gm);
		}
		for (int i = 50; i < height; i += 50) {
			new Wall(0, i, wallim, gm);
			new Wall(width - 50, i, wallim, gm);
		}
		for (int i = 50; i < 350; i += 50) {
			new Wall(100, i, wallim, gm);
		}
		for (int i = 50; i < 350; i += 50) {
			new Wall(850, i, wallim, gm);
		}
		for (int i = 100; i < 350; i += 50) {
			new Wall(750, i, wallim, gm);
		}
		for (int i = 100; i < 350; i += 50) {
			new Wall(650, i, wallim, gm);
		}
		for (int i = 100; i < 250; i += 50) {
			new Wall(550, i, wallim, gm);
		}
		for (int i = 100; i < 250; i += 50) {
			new Wall(200, i, wallim, gm);
		}
		for (int i = 200; i < 350; i += 50) {
			new Wall(350, i, wallim, gm);
		}
		for (int i = 150; i < 400; i += 50) {
			new Wall(i, 300, wallim, gm);
		}
		for (int i = 200; i < 550; i += 50) {
			new Wall(i, 100, wallim, gm);
		}
		for (int i = 400; i < 500; i += 50) {
			new Wall(i, 300, wallim, gm);
		}
		for (int i = 550; i < 650; i += 50) {
			new Wall(i, 300, wallim, gm);
		}
		new Wall(700, 100, wallim, gm);
		for (int i = 100; i < 900; i += 50) {
			new Wall(i, 450, wallim, gm);
		}
		for (int i = 550; i < 700; i += 50) {
			new Wall(100, i, wallim, gm);
		}
		for (int i = 450; i < 600; i += 50) {
			new Wall(250, i, wallim, gm);
		}
		for (int i = 550; i < 700; i += 50) {
			new Wall(850, i, wallim, gm);
		}
		for (int i = 500; i < 600; i += 50) {
			new Wall(550, i, wallim, gm);
		}
		for (int i = 550; i < 650; i += 50) {
			new Wall(650, i, wallim, gm);
		}
		for (int i = 550; i < 700; i += 50) {
			new Wall(450, i, wallim, gm);
		}
		for (int i = 500; i < 850; i += 50) {
			new Wall(i, 650, wallim, gm);
		}
		for (int i = 150; i < 400; i += 50) {
			new Wall(i, 650, wallim, gm);
		}
		for (int i = 750; i < 850; i += 50) {
			new Wall(i, 550, wallim, gm);
		}
		new Wall(350, 550, wallim, gm);
		new Wall(350, 600, wallim, gm);
	}

}
