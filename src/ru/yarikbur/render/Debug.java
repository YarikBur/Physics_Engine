package ru.yarikbur.render;

public class Debug {
	private static boolean debug = true;
	
	public static void render() {
		if(debug) {
			
			
			
		}
	}
	
	public static void setDebug(boolean debug) {
		Debug.debug = debug;
	}
	
	public static boolean getDebug() {
		return debug;
	}
	
	public static void println(String string) {
		if(debug)
			System.out.println(string);
	}
	
	public static void print(String string) {
		if(debug)
			System.out.print(string);
	}
}
