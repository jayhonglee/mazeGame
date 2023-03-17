package group3.demonGame;

import java.awt.Image;

/**
 * Create a gameobj wall by a default image size 50W X 50H. Set a number 2 in the cell contain a wall  
 * 
 * @author zeyoup
 * @param x X coordiante of wall
 * @param y Y coordainte of wall
 * @param ig a wall iamge
 * @param w width of wall image
 * @param h height of wall image
 * @param gm gamemanager
 */

public class wall extends gameObj {

	public wall(int x, int y, Image ig, GameManager gm) {
		super(x, y, ig, gm);
		// TODO Auto-generated constructor stub
		gm.pf.set(x / 50, y / 50, gm.objList.size() - 1, 2);
	}

	public wall(int x, int y, int w, int h, Image ig, GameManager gm) {
		super(x, y, w, h, ig, gm);
		// TODO Auto-generated constructor stub
		gm.pf.set(x, y, gm.objList.size() - 1, 2);
	}

}
