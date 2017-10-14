package ru.yarikbur.render;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import ru.yarikbur.main.Room;
import ru.yarikbur.utils.Vertex;

public class Wall {
	private static int room[][];
	
	public Wall(){
		Room.mainRoom();
		room = Room.getRoom();
	}
	
	public static void renderWall(int w, int h) {
		for(int i=0; i<4; i++) {
			if(i==0) {
				glColor3f(room[1][4]/10, room[1][4]/10, room[1][4]/10);
				if(room[1][1]==0) {
					Vertex.vertex2(null, w, h);
					blockRender(Vertex.getTop(), Vertex.getRight(), Vertex.getBottom(), Vertex.getLeft());
				}
			}
		}
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
