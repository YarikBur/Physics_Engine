package ru.yarikbur.utils;

public class Gravity {
	private float forse = 0;
	private float forse2 = 0;
	
	public void bounce() {
		forse2 = forse;
		forse = 0;
	}

	public int[] gravity(int[] obj, float weight) {
		int[] gr = obj;
		gr[1] -= (forse-forse2);
		forse+=9.8f*(weight/1000f);
		if(forse-forse2==0) {
			forse2=0;
			forse=0;
		}
		System.out.println(gr[1] + "  " + forse + "  " + forse2);
		
		return gr;
	}
}
