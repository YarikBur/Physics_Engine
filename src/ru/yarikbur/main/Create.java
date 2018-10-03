package ru.yarikbur.main;

import ru.yarikbur.obj.Ball;
import ru.yarikbur.obj.Quadrilateral;
import ru.yarikbur.obj.Triangle;
import ru.yarikbur.obj.World;
import ru.yarikbur.utils.Vertex;

public class Create {
	static Ball ball;
	static Triangle triangle;
	static Quadrilateral quadrilateral;
	
	public static void create() {
		init();
		addObj();
	}
	
	private static void init() {
		triangle = new Triangle(Vertex.vertex2d(200f, 200f), Vertex.vertex2d(30f, 30f), 100, true, 3, 200);
		ball = new Ball(Vertex.vertex2d(400f, 400f), Vertex.vertex2d(5f, 5f), 5, true, 3, 255);
		quadrilateral = new Quadrilateral(Vertex.vertex2d(100f, 0f), Vertex.vertex2d(600f, 10f), 100, false, 1, 50f);
	}
	
	private static void addObj() {
		World.addObj(ball);
		World.addObj(triangle);
		World.addObj(quadrilateral);
	}
}
