package game;

import java.awt.Image;


public class wall extends gameObj{
	public wall(int x, int y, Image ig) {
		super(x, y,ig);
		// TODO Auto-generated constructor stub
		main.pf.set(x/50, y/50, main.objList.size()-1, 2);
	}
	public wall(int x, int y, int w, int h, Image ig) {
		super(x, y, w, h, ig);
		// TODO Auto-generated constructor stub
		main.pf.set(x, y, main.objList.size()-1, 2);
	}
	

}
