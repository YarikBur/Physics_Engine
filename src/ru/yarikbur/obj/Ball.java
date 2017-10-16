package ru.yarikbur.obj;

import static org.lwjgl.opengl.GL11.*;

import ru.yarikbur.utils.Gravity;

public class Ball {
	private static int[] coordinates = {500, 500};
	private static int weight = 50;
	private static Gravity gravity;
	
	public Ball() {
		gravity = new Gravity();
	}
	
	public static int getWeight() {
		return weight;
	}
	
	public static int[] getCoordinates() {
		return coordinates;
	}
	
	public static void setCoordinates(int[] coordinates) {
		Ball.coordinates = coordinates;
	}

	public static void update() {
		if(Ball.coordinates[1]-Math.sin(90)*30 <= 50)
			gravity.bounce();
		Ball.coordinates = gravity.gravity(Ball.coordinates, Ball.weight);
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
