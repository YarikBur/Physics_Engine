package ru.yarikbur.obj;

import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Ball extends Properties{
	public Ball(float[] coordinates, float[] size, float weight, boolean attraction, float bounce, float color) {
		this.setSize(size);
		this.setCoordinates(coordinates);
		this.setWeight(weight);
		this.setAttraction(attraction);
		this.setColor(color);
	}
	
	public void render() {
		glBegin(GL_TRIANGLE_FAN);
			glColor3f((this.getColor()/255), (this.getColor()/255), (this.getColor()/255));
			glVertex2f(this.getCoordinates()[0], this.getCoordinates()[1]);
			for(float angle=0; angle<2*Math.PI+0.1f; angle+=0.2f) {
				double x = this.getCoordinates()[0]+Math.sin(angle)*this.getSize()[0];
				double y = this.getCoordinates()[1]+Math.cos(angle)*this.getSize()[1];
				glVertex2d(x, y);
			}
		glEnd();
	}
}
