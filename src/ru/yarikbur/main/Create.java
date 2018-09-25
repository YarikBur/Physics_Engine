package ru.yarikbur.main;

import ru.yarikbur.obj.Ball;
import ru.yarikbur.obj.Quadrilateral;
import ru.yarikbur.obj.World;

public class Create {
	static Ball ball;
	static Quadrilateral quadrilateral;
	
	public static void create() {
		init();
		addObj();
	}
	
	private static void init() {
		int[][] ballC= {{400, 400}, {30, 30}};
		ball = new Ball(ballC, 5, true, 255);
		
		int floor[][] = {{100,0}, {200, 10}};
		quadrilateral = new Quadrilateral(floor, 100, false, 50f);
	}
	
	private static void addObj() {
		World.addObj(ball);
		World.addObj(quadrilateral);
	}
}
