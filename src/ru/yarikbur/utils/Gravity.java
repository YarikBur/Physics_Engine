package ru.yarikbur.utils;

public class Gravity {
	private float forse = 0;
	private float forse2 = 0;
	
	public void bounce() {
		System.out.println("BOUNCE");
		forse2 = forse;
		forse = 0;
	}

	public float[] gravity(float[] obj, float weight) {
		float[] gr = obj;
		if(Math.abs(forse-forse2)<0.3f) {
			forse2=0;
			forse=0;
		}
		gr[1] -= (forse-forse2)*0.3f;
		forse+=9.8f*(weight/1000f);
		forse2*=0.98f;
		System.out.println(gr[1] + "  " + forse + "  " + forse2);
		
		return gr;
	}
}
