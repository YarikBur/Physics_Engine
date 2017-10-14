package ru.yarikbur.main;

public class Main {
	private static Window window;
	
	public static void main(String[] args) {
		window = new Window(800, 640, "Physics of objects", 0, 0);
		window.run();
	}
}
