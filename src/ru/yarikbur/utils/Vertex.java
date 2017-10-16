package ru.yarikbur.utils;

public class Vertex {
	private static int top[] = new int[2], right[] = new int[2], bottom[] = new int[2], left[] = new int[2];
	
	public static int[] getTop() {
		return top;
	}
	
	public static int[] getRight() {
		return right;
	}
	
	public static int[] getBottom() {
		return bottom;
	}
	
	public static int[] getLeft() {
		return left;
	}
	
	public static void vertex2(int massive[][], int w, int h) {
		for(int i=0; i<4; i++) {
			if(i==0) vertex(left, 0, 0);
			else if(i==1) vertex(top, 50, 50);
			else if(i==2) vertex(right, w-50, 50);
			else vertex(bottom, w, 0);
		}
	}
	
	public static int[][] vertex(int[] a, int[] b, int[] c, int[] d){
		int[][] v = {a, b, c, d};
		return v;
	}
	
	public static int[] vertex(int one, int two) {
		int[] v = {one, two};
		return v;
	}
	
	public static void vertex(int massive[], int one, int two) {
		massive[0] = one;
		massive[1] = two;
	}
}
