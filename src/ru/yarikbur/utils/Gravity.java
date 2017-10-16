package ru.yarikbur.utils;

public class Gravity {
	private static float forse = 0;
	
	public static void resetForse() {
		forse = 0;
	}
	
	public static int[] gravity(int[] obj, int weight) {
		int[] gr = obj;
		gr[1] -= forse;
		if(forse>=10)
			forse=10;
		else
			forse+=(weight/100);
		return gr;
	}
}
