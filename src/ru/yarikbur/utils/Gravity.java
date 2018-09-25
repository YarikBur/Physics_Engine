package ru.yarikbur.utils;

import ru.yarikbur.obj.Obj;
import ru.yarikbur.obj.World;

public class Gravity {
	static float[] force = new float[2];
	
	public static void attraction() {
		for(Obj obj : World.getObj()) {
			if(obj.getAttraction()) {
				gravity(obj);
			}
		}
	}
	
	private static void gravity(Obj obj) {
		int coordinates[][] = obj.getCoordinates().clone();
		
		for(Obj objs : World.getObj()) {
			if(objs.getId()!=obj.getId() && !objs.getAttraction()) {
				if((coordinates[0][1]-coordinates[1][1])-(objs.getCoordinates()[0][1]+objs.getCoordinates()[1][1]) <= 0) {
					int minus = (coordinates[0][1]-coordinates[1][1])-(objs.getCoordinates()[0][1]+objs.getCoordinates()[1][1]);
					force[0] = minus;
				} else
					force[0] += (obj.getWeight()/98f)*9.8f;
				
				int forceI[] = {Math.round(force[0]), Math.round(force[1])};
				obj.setForce(forceI);
				int y = (int) (coordinates[0][1]-force[0]);
				obj.setCoordinates(Vertex.coordinates2d(coordinates[0][0], y, coordinates[1][0], coordinates[1][1]));
			}
		}
	}
}
