package ru.yarikbur.obj;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Square {
//	[] - X, Y; [] - Left, Top
	private int[][] coordinates;
	private float color;
	
	public Square(int[][] coordinates, float color) {
		this.setCoordinates(coordinates);
		this.color = color;
	}
	
	public void render() {
		blockRender();
	}
	
	private void blockRender() {
		glBegin(GL_QUADS);
			glColor3f((color/255), (color/255), (color/255));
			glVertex2f(0, 0);
			glVertex2f(5, 5);
			glVertex2f(15, 15);
			glVertex2f(45, 45);
		glEnd();
	}

	public int[][] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(int[][] coordinates) {
		this.coordinates = coordinates;
	}
}
