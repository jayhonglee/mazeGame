package group3.demonGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class pathfinder {
	GameManager gm;
	public int bitmap[][]; 
	
	public pathfinder(GameManager manager) {
		this.gm = manager;
		bitmap = new int[gm.widh / 50][gm.widw / 50];

		for (int i = 0; i < gm.widh / 50; i++) {
			for (int j = 0; j < gm.widw / 50; j++) {
				bitmap[i][j] = 1;
			}
		}
	}

	public void set(int x, int y, int loc, int hd) {
		bitmap[y][x] = hd;

	}

	public boolean canPath(int x, int y) {
		if (!(0 <= x && x < gm.widw / 50 && 0 <= y && y < gm.widh / 50)) {
			return false;
		}
		if (bitmap[y][x] % 10 == 2) {
			return false;
		}
		return true;

	}

	class queueEle {
		public int x;
		public int y;
		public int c;
		public int e;
		public boolean hl;
		public int cost = 0;

		public queueEle() {
			this.x = 0;
			this.y = 0;
			this.c = 0;
			this.e = 0;
			hl = false;
		}

		public queueEle(int x, int y, int c, int e) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.e = e;
			hl = false;
		}
	}

	static Comparator<queueEle> eleCmp = new Comparator<queueEle>() {
		@Override
		public int compare(queueEle o1, queueEle o2) {
			return (o1.c + o1.e) - (o2.c + o2.e);
		}
	};

	public boolean inRange(int x, int y) {
		if (0 <= x && x < gm.widw / 50 && 0 <= y && y < gm.widh / 50)
			return true;
		return false;
	}

	public ArrayList<queueEle> getPath(int x, int y) {
		ArrayList<queueEle> path = new ArrayList<>();
		queueEle[][] tempMap = new queueEle[gm.widh / 50][gm.widw / 50];
		for (int i = 0; i < gm.widh / 50; i++) {
			for (int j = 0; j < gm.widw / 50; j++) {
				tempMap[i][j] = new queueEle();
				if (bitmap[i][j] % 10 == 2) {
					tempMap[i][j].cost = 50;
				}
			}
		}
		PriorityQueue<queueEle> q = new PriorityQueue<>(eleCmp);
		int dx = gm.dm.x / 50;
		int dy = gm.dm.y / 50;
		int sx = x / 50;
		int sy = y / 50;
		q.add(new queueEle(sx, sy, 0, Math.abs(sx - dx) + Math.abs(sy - dy)));
		while (!q.isEmpty()) {
			queueEle temp = q.poll();
			if (temp.x == dx && temp.y == dy) {

				int total = temp.c;
				tempMap[temp.y][temp.x] = temp;
				tempMap[temp.y][temp.x].hl = true;
				for (int i = 0; i < total; i++) {
					path.add(temp);
					if (inRange(temp.x + 1, temp.y) && tempMap[temp.y][temp.x + 1].c == total - i - 1) {
						temp = tempMap[temp.y][temp.x + 1];
					} else if (inRange(temp.x - 1, temp.y) && tempMap[temp.y][temp.x - 1].c == total - i - 1) {
						temp = tempMap[temp.y][temp.x - 1];
					} else if (inRange(temp.x, temp.y + 1) && tempMap[temp.y + 1][temp.x].c == total - i - 1) {
						temp = tempMap[temp.y + 1][temp.x];
					} else if (inRange(temp.x, temp.y - 1) && tempMap[temp.x][temp.y - 1].c == total - i - 1) {
						temp = tempMap[temp.x][temp.y - 1];
					}
				}

//				for (int i = 0; i < path.size(); i++) {
//					System.out.println(path.get(i).x + "\t" + path.get(i).y);
//				}
				/*
				 * for(int i=0;i<main.widh/50;i++) {
				 * for(int j=0;j<main.widw510;j++) {
				 * //System.out.print(tempMap[i][j].c+tempMap[i][j].e);
				 * System.out.print(tempMap[i][j].c);
				 * System.out.print("\t");
				 * }
				 * System.out.println(" ");
				 * }
				 */
				break;
			}
			if (!(0 <= temp.x && temp.x < gm.widw / 50 && 0 <= temp.y && temp.y < gm.widh / 50)
					|| tempMap[temp.y][temp.x].hl) {
				continue;
			}
			tempMap[temp.y][temp.x] = temp;
			tempMap[temp.y][temp.x].hl = true;

			if (inRange(temp.x + 1, temp.y) && !tempMap[temp.y][temp.x + 1].hl)
				q.add(new queueEle(temp.x + 1, temp.y, temp.c + 1 + tempMap[temp.y][temp.x + 1].cost,
						Math.abs(temp.x + 1 - dx) + Math.abs(sy - temp.y)));
			if (inRange(temp.x - 1, temp.y) && !tempMap[temp.y][temp.x - 1].hl)
				q.add(new queueEle(temp.x - 1, temp.y, temp.c + 1 + tempMap[temp.y][temp.x - 1].cost,
						Math.abs(temp.x - 1 - dx) + Math.abs(sy - temp.y)));
			if (inRange(temp.x, temp.y + 1) && !tempMap[temp.y + 1][temp.x].hl)
				q.add(new queueEle(temp.x, temp.y + 1, temp.c + 1 + tempMap[temp.y + 1][temp.x].cost,
						Math.abs(temp.x - dx) + Math.abs(sy - temp.y + 1)));
			if (inRange(temp.x, temp.y - 1) && !tempMap[temp.y - 1][temp.x].hl)
				q.add(new queueEle(temp.x, temp.y - 1, temp.c + 1 + tempMap[temp.y - 1][temp.x].cost,
						Math.abs(temp.x - dx) + Math.abs(sy - temp.y - 1)));
		}
		return path;
	}
}
