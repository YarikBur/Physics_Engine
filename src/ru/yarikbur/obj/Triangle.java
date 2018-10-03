package ru.yarikbur.obj;

import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Triangle extends Properties{
	public Triangle(float[] coordinates, float[] size, float weight, boolean attraction, float bounce, float color) {
		this.setCoordinates(coordinates);
		this.setSize(size);
		this.setWeight(weight);
		this.setAttraction(attraction);
		this.setBounce(bounce);
		
	}
	
	public void render() {
		glBegin(GL_TRIANGLE_FAN);
			glColor3f((this.getColor()/255), (this.getColor()/255), (this.getColor()/255));
			glVertex2f(this.getCoordinates()[0], this.getCoordinates()[1]);
			glVertex2f(this.getCoordinates()[0]+(this.getSize()[0]/2), this.getCoordinates()[1]-this.getSize()[1]);
			glVertex2f(this.getCoordinates()[0]+this.getSize()[0], this.getCoordinates()[1]);
		glEnd();
	}
}
