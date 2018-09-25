package ru.yarikbur.render;

import ru.yarikbur.obj.Ball;
import ru.yarikbur.obj.Square;

public class Render {
	static Ball ball = new Ball();
	static int floor[][] = {{100,0}, {600, 50}};
	static Square square = new Square(floor, 5f);
	
	public static void render() {
		ball.render();
		square.render();
	}
}
