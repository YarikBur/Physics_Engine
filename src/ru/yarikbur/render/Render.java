package ru.yarikbur.render;

import ru.yarikbur.obj.Ball;

public class Render {
	Ball ball;
	
	public Render() {
		new Walls();
		ball = new Ball();
	}
	
	public void update() {
		ball.update();
	}
	
	public void render(int width, int height) {
		Walls.renderWall(width, height);
		Ball.render();
	}
}
