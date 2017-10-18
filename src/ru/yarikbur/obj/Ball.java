package ru.yarikbur.obj;

import static org.lwjgl.opengl.GL11.*;

import ru.yarikbur.utils.Gravity;

public class Ball implements Obj {
	private static float[] coordinates = {500, 500};
	private static int weight = 50;
	private static Gravity gravity;
	
	public Ball() {
		gravity = new Gravity();
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

	public void update() {
		if(Ball.coordinates[1]-Math.sin(90)*30 <= 50)
			gravity.bounce();
		Ball.coordinates = gravity.gravity(this);
	}
	
	public static void render() {
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
