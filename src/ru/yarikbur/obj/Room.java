package ru.yarikbur.obj;

import ru.yarikbur.render.Walls;
import ru.yarikbur.utils.Vertex;

public class Room {
	private static int room[][] = new int[3][3];
	private static int room1[][] = new int [9][9];
	
	public static int[][] getRoom() {
		return room1;
	}
	/*
	 * MATERIALS
	 * 0 - section between materials
	 * 1 - air
	 * 2 - iron
	 * 3 - brick
	 */
	
	public static void mainRoom() {
		init();
		fillRoom(3, 3, 4, 2);
		printRoom();
		checkRoom();
		printRoom();
		createWalls();
	}
	private static void init() {
		for(int y=0; y<3; y++)
			for(int x=0; x<3; x++)
				room[y][x] = 0;
		
		for(int y=0; y<9; y++)
			for(int x=0; x<9; x++)
				room1[y][x]=1;
	}
	private static void printRoom() {
//		for(int y=0; y<3; y++) {
//			for(int x=0; x<3; x++)
//				System.out.print(room[y][x]);
//			System.out.print('\n');
//		}
		for(int y=1; y<10; y++) {
			for(int x=1; x<10; x++) {
				System.out.print(room1[y-1][x-1]+" ");
				if(x%3==0) System.out.print("  ");
			}
			System.out.print('\n');
			if(y%3==0) System.out.print('\n');
		}
	}
	
	static int[][][] i = new int[4][4][4];
	
	private static void createWalls() {
		for(int y=0; y<room1.length; y++) {
			for(int x=0; x<room1[0].length; x++) {
				if(y==1) {
					if(x==1) {
						i[0][0] = Vertex.vertex(0, 600);
						i[0][1] = Vertex.vertex(50, 550);
						
						i[3][3] = Vertex.vertex(0, 600);
						i[3][2] = Vertex.vertex(50, 550);
					} else if(x==7) {
						i[0][2] = Vertex.vertex(750, 550);
						i[0][3] = Vertex.vertex(800, 600);
						
						i[1][0] = Vertex.vertex(800, 600);
						i[1][1] = Vertex.vertex(750, 550);
					}
				} else if(y==7) {
					if(x==1) {
						i[3][0] = Vertex.vertex(0, 0);
						i[3][1] = Vertex.vertex(50, 50);
						
						i[2][0] = Vertex.vertex(0, 0);
						i[2][1] = Vertex.vertex(50, 50);
					} else if(x==7) {
						i[1][2] = Vertex.vertex(750, 50);
						i[1][3] = Vertex.vertex(800, 0);
						
						i[2][2] = Vertex.vertex(750, 50);
						i[2][3] = Vertex.vertex(800, 0);
					}
				}
			}
		}
		
		for(int n=0; n<i.length; n++) {
			int color = n;
			switch (n) {
				case (0):
					color = room1[1][4];
					break;
				case (1):
					color = room1[4][7];
					break;
				case (2):
					color = room1[4][1];
					break;
				case (3):
					color = room1[7][4];
					break;
			}
			Walls.addWall(new Wall(Vertex.vertex(i[n][0], i[n][1], i[n][2], i[n][3]), color*20));
		}
	}
	
	private static void checkRoom() {
		System.out.println("\nIF\n");
//		if(room[0][1] != 0 && room[1][0] != 0 && room[0][1] == room[1][0])
//			room[0][0] = room[0][1];
//		if(room[0][1] != 0 && room[1][2] != 0 && room[0][1] == room[1][2])
//			room[0][2] = room[0][1];
//		if(room[1][0] != 0 && room[2][1] != 0 && room[1][0] == room[2][1])
//			room[2][0] = room[1][0];
//		if(room[1][2] != 0 && room[2][1] != 0 && room[1][2] == room[2][1])
//			room[2][2] = room[1][2];
		
		if(room1[1][4] != 0 && room1[4][1] !=0)
			if(room1[1][4] == room1[4][1])
				for(int y=0; y<3; y++)
					for(int x=0; x<3; x++) {
						room1[y][x] = room1[1][4];
					}
			else {
				for(int d=0; d<3; d++) {
					room1[d][d] = 0;
					if(d!=0)
						for(int i=1; i<3; i++) {
							if(d-i>=0) {
								room1[d][d-i] = room1[4][1];
								room1[d-i][d] = room1[1][4];
							}
						}
//						if(d==1) {
//							room1[d][d-1] = 3;
//							room1[d-1][d] = 4;
//						}
//						else if(d==2) {
//							room1[d][d-1] = 3;
//							room1[d][d-2] = 3;
//							room1[d-1][d] = 4;
//							room1[d-2][d] = 4;
//						}
				}
			}
		if(room1[1][4] != 0 && room1[4][7] !=0) {
			if(room1[1][4] == room1[4][7])
				for(int y=0; y<3; y++)
					for(int x=0; x<3; x++)
						room1[y][x+6] = room1[4][7];
			else {
				for(int d=0; d<3; d++) {
					room1[d][8-d] = 0;
					if(d!=0)
						for(int i=0; i<3; i++) {
							if(d-i>=0) {
								if(8-d+1+i<9) room1[d][8-d+i+1] = room1[4][7];
								if(d-i-1>=0) room1[d-i-1][8-d] = room1[1][4];
							}
						}
				}
			}
		}
		if(room1[4][7] != 0 && room1[7][4] !=0) {
			if(room1[4][7] == room1[7][4])
				for(int y=0; y<3; y++)
					for(int x=0; x<3; x++)
						room1[y+6][x+6] = room1[4][7];
			else {
				for(int d=0; d<3; d++) {
					room1[8-d][d] = 0;
					if(d!=3)
						for(int i=0; i<3; i++) {
							if(8-d-i-1>=6) room1[8-d-i-1][d] = room1[4][1];
							if(d+i+1<3) room1[8-d][d+i+1] = room1[7][4];
						}
				}
			}
		}
		if(room1[4][1] != 0 && room1[7][4] !=0) {
			if(room1[4][1] == room1[7][4])
				for(int y=0; y<3; y++)
					for(int x=0; x<3; x++)
						room1[y+6][x] = room1[4][1];
			else {
				for(int d=0; d<3; d++) {
					room1[8-d][8-d] = 0;
					for(int i=0; i<3; i++) {
						if(8-d-i-1>=6) {
							room1[8-d-i-1][8-d] = room1[4][7];
							room1[8-d][8-d-i-1] = room1[7][4];
						}
					}
				}
			}
		}
 	}
	private static void fillRoom(int top, int right, int bottom, int left) {
//		room[0][1] = 2;
//		room[0][1] = 1;
//		room[1][0] = 1;
//		room[1][2] = 1;
//		room[2][1] = 1;
		
		for(int y=0; y<9; y++) {
			if(top!=0)
				if(y<3)
					for(int x=0; x<3; x++)
						room1[y][x+3] = top;
			if(right!=0)
				if(y>=3 && y<6)
					for(int x=0; x<3; x++)
						room1[y][x+6] = right;
			if(bottom!=0)
				if(y>=6)
					for(int x=0; x<3; x++)
						room1[y][x+3] = bottom;
			if(left!=0)
				if(y>=3 && y<6)
					for(int x=0; x<3; x++)
						room1[y][x] = left;
		}
	}
}
