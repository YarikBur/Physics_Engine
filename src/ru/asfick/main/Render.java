package ru.asfick.main;

import static org.lwjgl.opengl.GL11.*;

public class Render {
	private static int room[][];
	private static int b = 50;
	
	public Render() {
		Room.mainRoom();
		room = Room.getRoom();
	}
	
	private static int top[] = new int[2], right[] = new int[2], bottom[] = new int[2], left[] = new int[2];
	
	public static void renderWall(int w, int h) {
		for(int i=0; i<4; i++) {
			if(i==0) {
				glColor3f(room[1][4]/10, room[1][4]/10, room[1][4]/10);
				if(room[1][1]==0) {
					vertex2(null, w, h);
					blockRender(top, right, bottom, left);
				}
			}
		}
	}
	
	private static void vertex2(int massive[][], int w, int h) {
		for(int i=0; i<4; i++) {
			if(i==0) vertex(top, 0, h);
			else if(i==1) vertex(right, w, h);
			else if(i==2) vertex(bottom, w-b, h-b);
			else vertex(left, b, h-b);
		}
	}
	
	private static void vertex(int massive[], int one, int two) {
		massive[0] = one;
		massive[1] = two;
	}
	
	private static void blockRender(int top[], int right[], int bottom[], int left[]) {
		glBegin(GL_QUADS);
		glVertex2f(top[0], top[1]);
		glVertex2f(right[0], right[1]);
		glVertex2f(bottom[0], bottom[1]);
		glVertex2f(left[0], left[1]);
		glEnd();
	}
}
