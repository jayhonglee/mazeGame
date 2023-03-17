package group3.demonGame;

import java.awt.Graphics2D;
import java.awt.Image;

public class gameObj {
	public gameObj(int x, int y, Image ig, GameManager gm) {
		this.gm = gm;
		this.x = x;
		this.y = y;
		w = 50;
		h = 50;
		img = ig;
		gm.objList.add(this);
	}

	public gameObj(int x, int y, int w, int h, Image ig, GameManager gm) {
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