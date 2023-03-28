package group3.demonGame;

import java.awt.Image;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

import group3.demonGame.Pathfinder.queueEle;

/**
 * https://www.bing.com/images/search?view=detailV2&ccid=jtoGsakR&id=
 * A11F28D8DA8BC9F101B9D6FA586E6189DB1ADEB3&thid=OIP.jtoGsakRDme07JpRgcK8ewAAAA&mediaurl=
 * https%3A%2F%2Fforums.rpgmakerweb.com%2Fdata%2Favatars%2Fl%2F33%2F33844.jpg%3F1485919896&exph=
 * 192&expw=192&q=2d+hero&simid=608051345322239944&form=IRPRST&ck=A6B78B6B4DCC74EE3B4FB92696A40824&selectedindex
 * =4&ajaxhist=0&ajaxserp=0&vt=0&sim=11&iss=VSI&cdnurl=https%3A%2F%2Fth.bing.com%
 * 2Fth%2Fid%2FR.8eda06b1a9110e67b4ec9a5181c2bc7b%3Frik%3Ds94a24lhblj61g%26pid%3DImgRaw%26r%3D0&pivotparams=
 * nsightsToken%3Dccid_f2HdSPK1*cp_6072C87D5C2F6E0D876C7EBA71493478*mid_784BC1A715BC01A44A971C2828C1AE8E2BA5ECDB
 * simid_607993809944126315*thid_OIP.f2HdSPK1Z-IhRhGmCyERHQHaGQ&ajaxhist=0&ajaxserp=0
 * <p>
 * create a gameObj enemies that can move,they would follow the demon from a
 * path. The enemies size is default by gm.squareSize W X gm.squareSize H.
 *
 * @author zeyoup
 * @param x  X coordinate of enemies
 * @param y  Y coordinate of enemies
 * @param ig Image of enemies
 * @param h  height of enemies image
 * @param w  width of enemies image
 * @param gm gamemanager
 */

public class Enemies extends GameObj {
	int waitRound = 0;
	int test = 0;
	ArrayList<queueEle> path = null;
	LocalDate nextAct;

	public Enemies(int x, int y, Image ig, GameManager gm) {
		super(x, y, ig, gm);
		nextAct = LocalDate.now().plus(Duration.ofSeconds((long) 0.5));
	}

	public Enemies(int x, int y, int w, int h, Image ig, GameManager gm) {
		super(x, y, w, h, ig, gm);
	}

	public void update() {
		waitRound++;

		if (waitRound == 8) {
			waitRound = 0;
		} else {
			return;
		}
		path = gm.pf.getPath(x, y);
		queueEle ele = path.remove(path.size() - 1);
		x = ele.x * gm.squareSize;
		y = ele.y * gm.squareSize;
		// System.out.println(path.size());
		return;

	}// move follow the path

	public void getpath() {
		path = gm.pf.getPath(x, y);
	}// get a path between demon and enemies

}
