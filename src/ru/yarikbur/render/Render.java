package ru.yarikbur.render;

public class Render {
	public Render() {
		new Wall();
		new Ball();
	}
	
	public void update() {
		Ball.update();
	}
	
	public void render(int width, int height) {
		Wall.renderWall(width, height);
		Ball.render();
	}
}
