package ru.yarikbur.utils;

import ru.yarikbur.obj.Obj;
import ru.yarikbur.obj.World;
import ru.yarikbur.render.Debug;

public class Gravity {
	
	static final float g = 9.81523f;
	static float t = 0;
	
	public static void attraction() {
		for(Obj obj : World.getObj()) {
			if(obj.getAttraction()) {
				gravity(obj);
			}
		}
	}
	
	private static void gravity(Obj obj) {
		time();
		allFall(obj);
		if(contact(obj))
			bounce(obj);
		else
			fall(obj);
		Debug.println("Obj ID[" + obj.getId() +"]: Speed[" + obj.getSpeed()[0] + ", " + obj.getSpeed()[1] + "]" + 
			" Coordinates: [" + obj.getCoordinates()[0] + ", " + obj.getCoordinates()[1] + "] Bounced: " + obj.getBounced());
	}
	
	private static void time() {
		t = (Timer.getMiliLast()/1000f) + Timer.getSec() + (Timer.getMin()*60f) + (Timer.getHou()*60f*60f);
	}
	
	private static boolean contact(Obj obj) {
		for(Obj objs : World.getObj()) {
			if(objs.getId()!=obj.getId() && !objs.getAttraction()) {
				if((obj.getCoordinates()[1]-obj.getSize()[1])-(objs.getCoordinates()[1]+objs.getSize()[1]) <= 0) {
					float minus = (objs.getCoordinates()[1]+objs.getSize()[1])-(obj.getCoordinates()[1]-obj.getSize()[1]);
					obj.setCoordinates(Vertex.vertex2d(obj.getCoordinates()[0], obj.getCoordinates()[1]+minus));
					return true;
				} else
					return false;
			}
		}
		return false;
	}
	
	private static void allFall(Obj obj) {
		for(Obj objs : World.getObj()) {
			if(objs.getId() != obj.getId()) {
				obj.setCoordinates(Vertex.vertex2d(obj.getCoordinates()[0]-obj.getSpeed()[0], obj.getCoordinates()[1]+obj.getSpeed()[1]));
			}
		}
	}
	
	private static void fall(Obj obj) {
		float speedV0 = obj.getSpeed()[1];
		float speed = speedV0 + ((-g*obj.getWeight())/10)*(t*t);
		obj.setSpeed(Vertex.vertex2d(obj.getSpeed()[0], speed));
	}
	
	private static void bounce(Obj obj) {
		if(!obj.getBounced()) {
			float speedV0 = -(obj.getSpeed()[1]);
			float tMax = speedV0/g;
			float hMax = ((speedV0*speedV0)/(2*g))*100*obj.getBounce();
			float speed = speedV0 - g*t;
			
			obj.setMaxCoordiantes(Vertex.vertex2d(obj.getCoordinates()[0], hMax));
			
			Debug.println("Max time: " + tMax + " hMax: " + hMax + " speed: " + -(speed));
			
			obj.setSpeed(Vertex.vertex2d(obj.getSpeed()[0], -(speed)));
			obj.setBounced(true);
		} else {
			if(obj.getCoordinates()[1] == obj.getMaxCoordiantes()[1])
				obj.setBounced(false);
		}
	}
}
