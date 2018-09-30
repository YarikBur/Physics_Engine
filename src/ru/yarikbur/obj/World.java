package ru.yarikbur.obj;

import java.util.ArrayList;

import ru.yarikbur.utils.Random;

public class World {
	private static ArrayList<Obj> Objs = new ArrayList<Obj>();
	
	public static ArrayList<Obj> getObj(){
		return Objs;
	}
	
	public static void addObj(Obj object) {
		Thread add = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int rnd = Random.randomInt(0, (Integer.MAX_VALUE/20));
				boolean sus = false;
				while(!sus) {
					for(Obj obj : Objs) {
						if(obj.getId() != rnd)
							sus = true;
						else
							sus = false;
					}
					if(!sus)
						rnd = Random.randomInt(0, Integer.MAX_VALUE/20);
				}
				object.setId(rnd);
			}
			
		});
		add.start();
		Objs.add(object);
	}
	
	public static void render() {
		for(Obj obj : Objs) {
			obj.render();
		}
	}
}
