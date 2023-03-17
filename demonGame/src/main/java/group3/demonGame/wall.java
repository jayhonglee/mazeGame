package group3.demonGame;

import java.awt.Image;

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
