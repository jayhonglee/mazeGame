package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {
	public static int widw=1000;
	public static int widh=700;
	
	public static void initail(JFrame f) {
		f.setSize(widw,widh); //frame size
		f.setLocationRelativeTo(null); //windows in the middle
		f.setDefaultCloseOperation(3); //close event
		f.setResizable(false); //adjust the size
		jf.add(jp);
		f.setVisible(true); //see it
		
		f.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				 dm.move(e.getKeyCode());
			}
			public void keyReleased(KeyEvent e) {
				 dm.release(e.getKeyCode());
			}
		}); /*control movement with "W A S D"*/
	}/*set initial game frame */
	
	
	public static void update() {
		while(true) {
			for(int i=0;i<objList.size();i++) {
				objList.get(i).update();
			}
			jp.repaint();
			try {Thread.sleep(50);}
			catch(Exception e) {e.printStackTrace();}
		}
	}/*refresh to keep game operate*/
	
	public static ArrayList<gameObj> objList=new ArrayList<>();
	public static JFrame jf=new JFrame();
	public static JPanel jp=new JPanel() {
		public void paint(Graphics g) {
			super.paint(g);
			for(int i=0;i<objList.size();i++) {
				objList.get(i).draw(g);
			}
		}
	};/*draw the game object*/
	
	
	public static gameObj bg;
	public static demon dm;
	public static enemies em1;
	public static enemies em2;
	
	public static void main(String arg[]) {
		initail(jf);
	    Image bgim=Toolkit.getDefaultToolkit().getImage("src/image/bg.png");/*background*/
		bg=new gameObj( 0, 0, widw, widh, bgim);
		Image dmim=Toolkit.getDefaultToolkit().getImage("src/image/demon.png");/*demon*/
		dm=new demon( 10, 10, 50, 50, dmim);
		Image em1im=Toolkit.getDefaultToolkit().getImage("src/image/enemies.png");/*enemy1*/
		em1=new enemies( 200, 500, 70, 70, em1im);
		Image em2im=Toolkit.getDefaultToolkit().getImage("src/image/enemies.png");/*enemy1*/
		em2=new enemies( 500, 300, 70, 70, em1im);
		
		update();
		
	}

}