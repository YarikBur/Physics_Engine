package ru.yarikbur.utils;

public class Timer implements Runnable{
	private static int miliLast = 0;
	private static int miliFuture = 0;
	private static int sec = 0;
	private static int min = 0;
	private static int hou = 0;
	private static Thread timer;
	private static boolean destroy = false;
	
	public Timer(){
		timer = new Thread(this, "Timer");
		timer.start();
	}
	
	public static void timerStop() {
		destroy = true;
	}
	
	private static boolean switchTime() {
		if(miliFuture > miliLast)
			return true;
		else
			return false;
	}
	
	private static void update() {
		if(switchTime()) {
			miliLast = miliFuture;
			if(miliLast == 1000) {
				miliLast = 0;
				miliFuture = 0;
				sec += 1;
				if(sec == 60) {
					sec = 0;
					min += 1;
					if(min == 60) {
						min = 0;
						hou += 1;
					}
				}
			}
		}
	}
	
	@Override
	public void run() {
		System.out.println("Test");
		while(!destroy) {
			try {
				miliFuture += 50;
				update();
				Thread.sleep(50);
				System.out.println("Miliseconds: " + miliLast + "Second: " + sec + " Minutes: " + min + " Hours: " + hou);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	public static int getMiliLast() {
		return miliLast;
	}

	public static void setSecLast(int miliLast) {
		Timer.miliLast = miliLast;
	}

	public static int getSecFuture() {
		return miliFuture;
	}

	public static void setSecFuture(int miliFuture) {
		Timer.miliFuture = miliFuture;
	}
	
	public static int getSecLast() {
		return sec;
	}

	public static void setCesLast(int sec) {
		Timer.sec = sec;
	}
	
	public static int getMinLast() {
		return min;
	}

	public static void setMinLast(int min) {
		Timer.min = min;
	}

	public static int getHouLast() {
		return hou;
	}

	public static void setHouLast(int hou) {
		Timer.hou = hou;
	}
	
}
