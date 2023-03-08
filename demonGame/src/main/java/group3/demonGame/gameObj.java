package game;

import java.awt.Graphics;
import java.awt.Image;

public class gameObj {
	public gameObj(int x, int y, Image ig) {
		this.x=x;
		this.y=y;
		w=100;
		h=100;
		img=ig;
		main.objList.add(this);
	}
	public gameObj(int x,int y, int w,int h, Image ig) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		img=ig;
		main.objList.add(this);
	}
	public void update() {}
	public void draw(Graphics g) {
		g.drawImage(img, x, y, w, h, null);
	}
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected Image img;
	
	
}