package ru.yarikbur.utils;

public class Gravity {
	private float forse = 0;
	private float forse2 = 0;
	
	public void bounce() {
		forse2 = forse;
		forse = 0;
	}

	public int[] gravity(int[] obj, int weight) {
		int[] gr = obj;
		gr[1] -= (forse-forse2);
		if((forse+(9.8f*(weight/1000)))<10)
			forse+=9.8f*(weight/1000);
		else
			forse=10;
		System.out.println(gr[1] + "  " + forse + "  " + (float)(50/1000));
		
		return gr;
	}
}
