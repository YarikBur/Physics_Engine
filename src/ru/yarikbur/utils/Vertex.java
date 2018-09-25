package ru.yarikbur.utils;

public class Vertex {
	
	public static int[] vertex2d(int a, int b) {
		int matrix[] = {a, b};
		return matrix;
	}
	
	public static int[] vertex3d(int a, int b, int c) {
		int matrix[] = {a, b, c};
		return matrix;
	}
	
	public static int[][] coordinates2d(int x, int y, int right, int top) {
		int matrix[][] = {{x, y}, {right, top}};
		return matrix;
	}
	
	public static int[][] coordinates3d(int x, int y, int z, int right, int top, int before) {
		int matrix[][] = {{x, y, z}, {right, top, before}};
		return matrix;
	}
}
