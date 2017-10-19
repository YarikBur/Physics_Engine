package ru.yarikbur.utils;

import ru.yarikbur.obj.Obj;

public class Gravity {
	private float forse = 0;
	private float forse2 = 0;
	private boolean bounce = false;
	
	public void bounce() {
		System.out.println("BOUNCE");
		forse2 = forse;
		forse = 0;
	}

	public float[] gravity(Obj obj) {
		float[] gr = obj.getCoordinates();
		if(Math.abs(forse-forse2)<0.3f) {
			forse2=0;
			forse=0;
		}
		gr[1] -= (forse-forse2)*0.3f;
		forse+=9.8f*(obj.getWeight()/1000f);
		forse2*=0.98f;
//		System.out.println(gr[1] + "  " + forse + "  " + forse2);
		testGravity(obj);
		
		return gr;
	}
	
	public float[] testGravity(Obj obj) {
		float mgh = obj.getWeight()*9.8f*(obj.getCoordinates()[1]/100);
		float mv22 = (obj.getWeight()*(float)Math.pow(obj.getSpeed(), 2))/2;
		float v = (float) Math.sqrt(2*9.8f*(obj.getCoordinates()[1]/100));
		float h2 = ((float) Math.pow(obj.getSpeed(), 2)-(float) Math.pow(v, 2))/(-2*9.8f);
		System.out.println(mgh + "  " + mv22 + "  " + v + "  " + h2);
		
		if(!bounce) {
			
		} else {
			
		}
		
		return null;
	}
}
