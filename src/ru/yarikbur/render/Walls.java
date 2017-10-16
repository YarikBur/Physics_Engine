package ru.yarikbur.render;

import java.util.ArrayList;
import java.util.List;

import ru.yarikbur.obj.Wall;

public class Walls {
	private static List<Wall> walls = new ArrayList<Wall>();
	
	public static void addWall(Wall w) {
		walls.add(w);
	}
	
	public static List<Wall> getWalls() {
		return walls;
	}
	
	public static void renderWall(int w, int h) {
		for(Wall wall : walls) {
			wall.render();
		}
	}
}
