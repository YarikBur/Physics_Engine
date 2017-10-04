package ru.asfick.main;

public class Main {
	static Window window;
	
	public static void main(String[] args) {
		window = new Window(800, 640, "Physics of objects", 0, 0);
		window.run();
	}
}
