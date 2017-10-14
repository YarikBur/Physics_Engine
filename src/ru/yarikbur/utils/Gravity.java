package ru.yarikbur.utils;

public class Gravity {
	private static float forse = 0;
	
	public static void resetForse() {
		forse = 0;
	}
	
	public static int[] gravity(int[] obj) {
		int[] gr = obj;
		gr[1] -= forse;
		if(forse>=10)
			forse=10;
		else
			forse+=0.25f;
		return gr;
	}
}
