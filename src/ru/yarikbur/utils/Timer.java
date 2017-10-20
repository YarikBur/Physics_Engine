package ru.yarikbur.utils;

public class Timer {
	private static long startTime;
	private static long timeLast=0;
//	private static long time=0;
	
	public static void setTime() {
		startTime = System.currentTimeMillis();
	}
	
	public static long getTimeLast() {
		return timeLast;
	}
	
	public static long getStartTime() {
		return startTime;
	}
	
	public static boolean second() {
		if(timeLast!=(System.currentTimeMillis() - startTime)/1000) {
			timeLast++;
			return true;
		} else
			return false;
	}
}
