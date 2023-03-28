package group3.demonGame.Objects;

import java.awt.Image;

import group3.demonGame.GameManager;
import group3.demonGame.GameObj;

/**
 * Create a gameobj wall by a default image size gm.squareSizeW X
 * gm.squareSizeH. Set a number 2 in the cell contain a wall
 * 
 * @author zeyoup
 * @param x  X coordiante of wall
 * @param y  Y coordainte of wall
 * @param ig a wall iamge
 * @param w  width of wall image
 * @param h  height of wall image
 * @param gm gamemanager
 */

public class Wall extends GameObj {

	public Wall(int x, int y, Image ig, GameManager gm) {
		super(x, y, ig, gm);
		// TODO Auto-generated constructor stub
		gm.pf.set(x / gm.squareSize, y / gm.squareSize, gm.objList.size() - 1, 2);
	}

	public Wall(int x, int y, int w, int h, Image ig, GameManager gm) {
		super(x, y, w, h, ig, gm);
		// TODO Auto-generated constructor stub
		gm.pf.set(x, y, gm.objList.size() - 1, 2);
	}

}
