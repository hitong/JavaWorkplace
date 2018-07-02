package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Path {
	/**
	 * 规定四个方向的权值
	 */
	public final static int RIGHT = 4;
	public final static int BOTTOM = 3;
	public final static int LEFT = 2;
	public final static int TOP = 1;
	public static int ROW;
	public static int COL;

	public static int[][] reSet(int[][] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (table[i][j] != Integer.MIN_VALUE) {
					table[i][j] = 0;
				} else {
				}
			}
		}
		return table;
	}

	private static ArrayList<ArrayList<Location>> allPath;

	public static ArrayList<ArrayList<Location>> findAllPath(int[][] table) {
		allPath = new ArrayList<>();
		findAllPath(table, new Location(0, 0, 0), new Location(table.length - 1, table[0].length - 1, 0),
				new ArrayList<Location>());
		return allPath;
	}

	private static void findAllPath(int[][] table, Location start, Location end, ArrayList<Location> path) {
		path.add(new Location(start.x, start.y, 0));
		table[start.x][start.y] = -1;
		if (start.inTheLocation(end.x, end.y)) {
			ArrayList<Location> tmp = new ArrayList<Location>(path.size());
			for (int i = 0; i < path.size(); i++) {
				tmp.add(new Location(path.get(i).x, path.get(i).y, path.get(i).direction));
			}
			allPath.add(tmp);
			table[start.x][start.y] = 0;
			path.remove(path.size() - 1);
			return;
		}

		if (start.y + 1 < table[0].length && table[start.x][start.y + 1] == 0) {
			path.get(path.size() - 1).direction = RIGHT;
			start.y = start.y + 1;
			findAllPath(table, start, end, path);
			start.y = start.y - 1;
		}
		if (start.x + 1 < table.length && table[start.x + 1][start.y] == 0) {
			path.get(path.size() - 1).direction = BOTTOM;
			start.x = start.x + 1;
			findAllPath(table, start, end, path);
			start.x = start.x - 1;
		}
		if (start.y - 1 >= 0 && table[start.x][start.y - 1] == 0) {
			path.get(path.size() - 1).direction = LEFT;
			start.y = start.y - 1;
			findAllPath(table, start, end, path);
			start.y = start.y + 1;
		}
		if (start.x - 1 >= 0 && table[start.x - 1][start.y] == 0) {
			path.get(path.size() - 1).direction = TOP;
			start.x = start.x - 1;
			findAllPath(table, start, end, path);
			start.x = start.x + 1;
		}

		table[start.x][start.y] = 0;
		path.remove(path.size() - 1);
	}

	/**
	 * 
	 * @param table
	 * @return 值中存放Location对象包装了当前点的坐标以及下一步的方向
	 */
	public static LinkedList<Location> getPath(int[][] table) {
		ROW = table.length;
		COL = table[0].length;
		int t = getBestValue(table, 0, 0);
		LinkedList<Location> path = new LinkedList<>();
		path.push(new Location(0, 0, 0));
		table[0][0] = -1;
		while (!path.isEmpty()) {
			int x = path.peek().x;
			int y = path.peek().y;
			t = getBestValue(table, x, y);
			if (x == ROW - 1 && y == COL - 1) {
				return path;
			}
			path.peek().direction = t;

			switch (t) {
			case 0:
				return path;
			case TOP:
				if (table[x - 1][y] == 0) {
					path.push(new Location(x - 1, y, 0));
					table[x - 1][y] = -1;
					table[x][y] = -1;
				} else {
					path.pop();
					table[x][y] = Integer.MIN_VALUE / 2;
				}
				break;
			case LEFT:
				if (table[x][y - 1] == 0) {
					path.push(new Location(x, y - 1, 0));
					table[x][y - 1] = -1;
					table[x][y] = -1;
				} else {
					path.pop();
					table[x][y] = Integer.MIN_VALUE / 2;
				}
				break;
			case BOTTOM:
				if (table[x + 1][y] == 0) {
					path.push(new Location(x + 1, y, 0));
					table[x + 1][y] = -1;
					table[x][y] = -1;
				} else {
					path.pop();
					table[x][y] = Integer.MIN_VALUE / 2;
				}
				break;
			case RIGHT:
				if (table[x][y + 1] == 0) {
					path.push(new Location(x, y + 1, 0));
					table[x][y + 1] = -1;
					table[x][y] = -1;
				} else {
					path.pop();
					table[x][y] = Integer.MIN_VALUE / 2;
				}
				break;
			}
		}
		return path;
	}

	public static class Location {
		int x;
		int y;
		int direction;

		Location(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		public boolean inTheLocation(int x, int y) {
			return this.x == x && this.y == y;
		}

		public int getDirection() {
			return direction;
		}
	}

	/**
	 * 传入当前棋盘信息，返回最佳方向
	 * 
	 * @param table
	 * @param x
	 * @param y
	 * @return
	 */
	public static int getBestValue(int[][] table, int x, int y) {
		int bestValue = -500;
		int direction = 0;
		// System.out.println(x + " " + y);
		if (ROW > x && COL > (y + 1)) {
			if (table[x][y + 1] > bestValue) {
				bestValue = table[x][y + 1];
				direction = RIGHT;
			}
		}

		if (ROW > (x + 1) && COL > y) {
			if (table[x + 1][y] > bestValue) {
				bestValue = table[x + 1][y];
				direction = BOTTOM;
			}
		}

		if (ROW > x && 0 <= (y - 1)) {
			if (table[x][y - 1] > bestValue) {
				bestValue = table[x][y - 1];
				direction = LEFT;
			}
		}

		if (0 <= x - 1 && COL > y) {
			if (table[x - 1][y] > bestValue) {
				bestValue = table[x - 1][y];
				direction = TOP;
			}
		}
		return direction;
	}

	public static void main(String[] args) {
		int m = 10;
		int n = 13;
		int[][] table = new int[m][n];
		// { { 0, 0, 0, 0, Integer.MIN_VALUE }, { 0, 0, 0, 0, Integer.MIN_VALUE },
		// { 0, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, 0 }, { Integer.MIN_VALUE, 0, 0,
		// 0, 0 },
		// { 0, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, 0 } };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (Math.random() > 0.7) {
					table[i][j] = Integer.MIN_VALUE;
				}
			}
		}
		table[0][0] = 0;
		for (int[] x : table) {
			for (int y : x) {
				if (y == Integer.MIN_VALUE) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
		ArrayList<ArrayList<Location>> list = Path.findAllPath(table);
		// for(int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).x + " " + list.get(i).y + " " +
		// list.get(i).direction);
		// }

		System.out.println();
		for (int[] x : table) {
			for (int y : x) {
				if (y == Integer.MIN_VALUE) {
					System.out.print(1 + " ");
				} else if (y == -1) {
					System.out.print('9' + " ");
				} else if (y == Integer.MIN_VALUE / 2) {
					System.out.print("8" + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}

		System.out.println(list.size());

		// for (int i = 0; i < list.size(); i++) {
		// ArrayList<Location> l = list.get(i);
		// for (int j = 0; j < l.size(); j++) {
		// System.out.println(l.get(j).x + " " + l.get(j).y + " " + l.get(j).direction);
		// }
		// System.out.println();
		// }
	}
}
