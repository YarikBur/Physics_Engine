package ru.yarikbur.main;

import ru.yarikbur.utils.Timer;

public class Main {
	private static Window window;
	
	public static void main(String[] args) {
		Timer.setTime();
		window = new Window(800, 600, "Physics of objects", 0, 0);
		window.run();
	}
}
