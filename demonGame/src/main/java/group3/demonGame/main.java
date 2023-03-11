package group3.demonGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {
	public static int widw = 1000;
	public static int widh = 800;

	public static void initail(JFrame f) {
		f.setSize(widw, widh); // frame size
		f.setLocationRelativeTo(null); // windows in the middle
		f.setDefaultCloseOperation(3); // close event
		f.setResizable(false); // adjust the size
		jf.add(jp);
		f.setVisible(true); // see it

		f.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				dm.move(e.getKeyCode());
			}

			public void keyReleased(KeyEvent e) {
				dm.release(e.getKeyCode());
			}
		}); /* control movement with "W A S D" */
	}/* set initial game frame */

	public static void update() {
		while (true) {
			for (int i = 0; i < objList.size(); i++) {
				objList.get(i).update();
			}
			jp.repaint();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}/* refresh to keep game operate */

	public static ArrayList<gameObj> objList = new ArrayList<>();
	public static JFrame jf = new JFrame();
	public static JPanel jp = new JPanel() {
		public void paint(Graphics g) {
			super.paint(g);
			for (int i = 0; i < objList.size(); i++) {
				objList.get(i).draw(g);
			}
		}
	};/* draw the game object */

	public static gameObj bg;
	public static demon dm;
	public static enemies em1;
	public static enemies em2;
	public static wall wall;
	public static door door1;
	public static door door2;
	public static pathfinder pf;

	public static void main(String arg[]) {
		initail(jf);
		pf = new pathfinder();

		// Image
		// bgim=Toolkit.getDefaultToolkit().getImage("src/image/bg.png");/*background*/
		// bg=new gameObj( 0, 0, widw, widh, bgim);
		Image d1im = Toolkit.getDefaultToolkit().getImage("demonGame/src/image/door.png");
		door door1 = new door(50, 50, d1im);
		Image dmim = Toolkit.getDefaultToolkit().getImage("demonGame/src/image/demon.png");/* demon */
		dm = new demon(50, 50, dmim);
		Image em1im = Toolkit.getDefaultToolkit().getImage("demonGame/src/image/enemies.png");/* enemy1 */
		enemies em1 = new enemies(700, 700, em1im);
		Image em2im = Toolkit.getDefaultToolkit().getImage("demonGame/src/image/enemies.png");/* enemy1 */
		enemies em2 = new enemies(550, 450, em2im);
		// Image wallim = Toolkit.getDefaultToolkit().getImage("src/image/wall.png");
		Image wallim = Toolkit.getDefaultToolkit().getImage("demonGame/src/image/wall.png");
		for (int i = 0; i < widw; i += 50) {
			new wall(i, 0, wallim);
			new wall(i, widh - 50, wallim);
		}
		for (int i = 50; i < widh; i += 50) {
			new wall(0, i, wallim);
			new wall(widw - 50, i, wallim);
		}
		for (int i = 50; i < 350; i += 50) {
			new wall(100, i, wallim);
		}
		for (int i = 50; i < 350; i += 50) {
			new wall(850, i, wallim);
		}
		for (int i = 100; i < 350; i += 50) {
			new wall(750, i, wallim);
		}
		for (int i = 100; i < 350; i += 50) {
			new wall(650, i, wallim);
		}
		for (int i = 100; i < 250; i += 50) {
			new wall(550, i, wallim);
		}
		for (int i = 100; i < 250; i += 50) {
			new wall(200, i, wallim);
		}
		for (int i = 200; i < 350; i += 50) {
			new wall(350, i, wallim);
		}
		for (int i = 150; i < 400; i += 50) {
			new wall(i, 300, wallim);
		}
		for (int i = 200; i < 550; i += 50) {
			new wall(i, 100, wallim);
		}
		for (int i = 400; i < 500; i += 50) {
			new wall(i, 300, wallim);
		}
		for (int i = 550; i < 650; i += 50) {
			new wall(i, 300, wallim);
		}
		new wall(700, 100, wallim);
		for (int i = 100; i < 900; i += 50) {
			new wall(i, 450, wallim);
		}
		for (int i = 550; i < 700; i += 50) {
			new wall(100, i, wallim);
		}
		for (int i = 450; i < 600; i += 50) {
			new wall(250, i, wallim);
		}
		for (int i = 550; i < 700; i += 50) {
			new wall(850, i, wallim);
		}
		for (int i = 500; i < 600; i += 50) {
			new wall(550, i, wallim);
		}
		for (int i = 550; i < 650; i += 50) {
			new wall(650, i, wallim);
		}
		for (int i = 550; i < 700; i += 50) {
			new wall(450, i, wallim);
		}
		for (int i = 500; i < 850; i += 50) {
			new wall(i, 650, wallim);
		}
		for (int i = 150; i < 400; i += 50) {
			new wall(i, 650, wallim);
		}
		for (int i = 750; i < 850; i += 50) {
			new wall(i, 550, wallim);
		}
		new wall(350, 550, wallim);
		new wall(350, 600, wallim);
		Image d2im = Toolkit.getDefaultToolkit().getImage("demonGame/src/image/door.png");
		door door2 = new door(900, 50, d2im);
		em1.getpath();
		em2.getpath();
		update();

	}

}
