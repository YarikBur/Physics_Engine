package ru.yarikbur.utils;

public class Random {
	public static int randomInt(int min, int max) {
		java.util.Random r = new java.util.Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
