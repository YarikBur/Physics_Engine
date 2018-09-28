package ru.yarikbur.obj;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Quadrilateral implements Obj{
//	[] - X, Y; [] - Right, Top
	private int[][] coordinates;
	private int[] force = new int[2];
	private int weight;
	private int bounce;
	private int id;
	private boolean attraction;
	private float color;
	
	
	public Quadrilateral(int[][] coordinates, int weight, boolean attraction, float bounce, float color) {
		this.setCoordinates(coordinates);
		this.setWeight(weight);
		this.setAttraction(attraction);
		this.color = color;
	}
	
	public void render() {
		glBegin(GL_QUADS);
			glColor3f((color/255), (color/255), (color/255));
			glVertex2f(coordinates[0][0], coordinates[0][1]);
			glVertex2f(coordinates[0][0], coordinates[0][1]+coordinates[1][1]);
			glVertex2f(coordinates[0][0]+coordinates[1][0], coordinates[0][1]+coordinates[1][1]);
			glVertex2f(coordinates[0][0]+coordinates[1][0], coordinates[0][1]);
		glEnd();
	}
	
	@Override
	public int[][] getCoordinates() {
		return coordinates;
	}
	
	@Override
	public void setCoordinates(int[][] coordinates) {
		this.coordinates = coordinates;
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
		return attraction;
	}

	@Override
	public void setAttraction(boolean attraction) {
		this.attraction = attraction;
	}
	
	@Override
	public int getWeight() {
		return weight;
	}
	
	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public int[] getForce() {
		return this.force;
	}

	@Override
	public void setForce(int[] force) {
		this.force = force;
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
