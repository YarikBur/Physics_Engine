package ru.yarikbur.obj;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import ru.yarikbur.utils.Vertex;

public class Wall {
	private int[][] coordinates;
	private float color;
	
	public Wall(int[][] coordinates, float color) {
		this.coordinates = coordinates;
		this.color = color;
	}
	
	public void render() {
		blockRender(Vertex.vertex(coordinates[0][0], coordinates[0][1]),
				Vertex.vertex(coordinates[1][0], coordinates[1][1]),
				Vertex.vertex(coordinates[2][0], coordinates[2][1]),
				Vertex.vertex(coordinates[3][0], coordinates[3][1]));
	}
	
	private void blockRender(int top[], int right[], int bottom[], int left[]) {
		glBegin(GL_QUADS);
		glColor3f((color/255), (color/255), (color/255));
		glVertex2f(top[0], top[1]);
		glVertex2f(right[0], right[1]);
		glVertex2f(bottom[0], bottom[1]);
		glVertex2f(left[0], left[1]);
		glEnd();
	}
}
