package group3.demonGame;


import java.awt.Graphics2D;
import java.awt.Image;

public  class gameObj {
	

	public gameObj(GameManager gm,int x, int y,final Image ig) {
		this.x=x;
		this.y=y;
		w=50;
		h=50;
		img=ig;
		this.gm=gm;
		this.gm.objList.add(this);
	}
	public gameObj(GameManager gm,int x,int y, int w,int h, Image ig) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		img=ig;
		this.gm=gm;
		this.gm.objList.add(this);
	}
	public void update() {}
	public void draw(Graphics2D g) {
		g.drawImage(img, x, y, w, h, null);
	}
	
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected Image img;
	protected GameManager gm;
	
	
	
}