package ru.yarikbur.render;

public class Render {
	public Render() {
		new Walls();
		new Ball();
	}
	
	public void update() {
		Ball.update();
	}
	
	public void render(int width, int height) {
		Walls.renderWall(width, height);
		Ball.render();
	}
}
