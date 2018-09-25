package ru.yarikbur.obj;

import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Ball{
	private static float[] coordinates = {500, 500};
	private static int weight = 50;
	private static float speed = 0;
	
	public Ball() {
		
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		Ball.speed = speed;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public float[] getCoordinates() {
		return coordinates;
	}
	
	public void setCoordinates(float[] coordinates) {
		Ball.coordinates = coordinates;
	}
	
	public void render() {
		glBegin(GL_TRIANGLE_FAN);
			glColor3f(1, 1, 1);
			glVertex2f(Ball.coordinates[0], Ball.coordinates[1]);
			for(float angle=0; angle<2*Math.PI+0.15f; angle+=0.2f) {
				double x = Ball.coordinates[0]+Math.sin(angle)*30;
				double y = Ball.coordinates[1]+Math.cos(angle)*30;
				glVertex2d(x, y);
			}
		glEnd();
	}
}
