package group3.demonGame;

import java.awt.Graphics2D;
import java.awt.Image;

/**
 * Manage gameobject for the game. This method determine the coordinate and size for the game attributes. Then draw the attributes in the screen.
 * 
 * @author zeyoup
 * @param x X coordinate of gameobj
 * @param y Y coordinate of gameobj
 * @param ig image of gameobj
 * @param w width of gameobj image
 * @param h height of gameobj image
 * @param gm gamemanager
 */
public class GameObj {
    
	public GameObj(int x, int y, Image ig, GameManager gm) {
		this.gm = gm;
		this.x = x;
		this.y = y;
		w = 50;
		h = 50;
		img = ig;
		gm.objList.add(this);
	}

	public GameObj(int x, int y, int w, int h, Image ig, GameManager gm) {
		this.gm = gm;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		img = ig;
		gm.objList.add(this);
	}

	public void update() {
	}

	public void draw(Graphics2D g) {
		g.drawImage(img, x, y, w, h, null);
	}
        
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected Image img;
	GameManager gm;

}