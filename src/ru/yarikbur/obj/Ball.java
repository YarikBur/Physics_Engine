package ru.yarikbur.obj;

import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Ball implements Obj{
//	[] - X, Y; [] - Right, Top
	private int[][] coordinates;
//	[] - X, Y;
	private int[] speed = new int[2];
	private int weight;
	private int bounce;
	private int id;
	private boolean attraction;
	private float color;
	
	
	public Ball(int[][] coordinates, int weight, boolean attraction, float bounce, float color) {
		this.setCoordinates(coordinates);
		this.setWeight(weight);
		this.setAttraction(attraction);
		this.color = color;
	}
	
	public void render() {
		glBegin(GL_TRIANGLE_FAN);
			glColor3f((color/255), (color/255), (color/255));
			glVertex2f(coordinates[0][0], coordinates[0][1]);
			for(float angle=0; angle<2*Math.PI+0.15f; angle+=0.2f) {
				double x = coordinates[0][0]+Math.sin(angle)*coordinates[1][0];
				double y = coordinates[0][1]+Math.cos(angle)*coordinates[1][1];
				glVertex2d(x, y);
			}
		glEnd();
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean getAttraction() {
		return this.attraction;
	}

	@Override
	public void setAttraction(boolean attraction) {
		this.attraction = attraction;
	}

	@Override
	public int[][] getCoordinates() {
		return this.coordinates;
	}
	
	@Override
	public void setCoordinates(int[][] coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public int getWeight() {
		return this.weight;
	}
	
	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int[] getSpeed() {
		return this.speed;
	}

	@Override
	public void setSpeed(int[] speed) {
		this.speed = speed;
	}
	
	@Override
	public int getBounce() {
		return bounce;
	}

	@Override
	public void setBounce(int bounce) {
		this.bounce = bounce;
	}
}
