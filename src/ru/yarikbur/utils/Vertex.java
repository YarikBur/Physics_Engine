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
			if(i==0) vertex(top, 0, h);
			else if(i==1) vertex(right, w, h);
			else if(i==2) vertex(bottom, w-50, h-50);
			else vertex(left, 50, h-50);
		}
	}
	
	public static void vertex(int massive[], int one, int two) {
		massive[0] = one;
		massive[1] = two;
	}
}
