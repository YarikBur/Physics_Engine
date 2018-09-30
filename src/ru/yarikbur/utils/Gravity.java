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
		if(contact(obj))
			bounce(obj);
		else
			fall(obj);
		System.out.println("Obj ID[" + obj.getId() +"]: Speed[" + obj.getSpeed()[0] + ", " + obj.getSpeed()[1] + "]");
	}
	
	private static boolean contact(Obj obj) {
		for(Obj objs : World.getObj()) {
			if(objs.getId()!=obj.getId() && !objs.getAttraction()) {
				if((obj.getCoordinates()[0][1]-obj.getCoordinates()[1][1])-(objs.getCoordinates()[0][1]+objs.getCoordinates()[1][1]) <= 0 
						&& obj.getCoordinates()[0][0] <= objs.getCoordinates()[0][0]+objs.getCoordinates()[1][0]
						&& obj.getCoordinates()[0][0] >= objs.getCoordinates()[0][0]) {
					return true;
				} else
					return false;
			}
		}
		return false;
	}
	
	private static void fall(Obj obj) {
		
	}
	
	private static void bounce(Obj obj) {
		int speedV0 = obj.getSpeed()[1];
		int time = (Timer.getMiliLast()/1000);
		float h = speedV0 * time - (9.8f*(time*time))/2;
		System.out.println(h);
	}
}
