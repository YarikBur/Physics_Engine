package ru.yarikbur.main;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

import ru.yarikbur.math.Calculation;
import ru.yarikbur.render.Render;

public class Loop{
	public static void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glClearColor(0.8f, 0.2f, 0.2f, 1f);
		
		//pre render
		Calculation.preRender();
		
		//render
		Render.render();
		
		//post render
		Calculation.postRender();
	}
}
