package group3.demonGame;

import java.awt.Image;

public class wall extends gameObj {

	public wall( GameManager gm,int x, int y, Image ig) {
		super(gm,x, y, ig);
		// TODO Auto-generated constructor stub
		gm.pf.set(x / 50, y / 50, gm.objList.size() - 1, 2);
	}

	public wall(GameManager gm,int x, int y, int w, int h, Image ig) {
		super(gm,x, y, w, h, ig);
		// TODO Auto-generated constructor stub
		gm.pf.set(x, y, gm.objList.size() - 1, 2);
	}

}
