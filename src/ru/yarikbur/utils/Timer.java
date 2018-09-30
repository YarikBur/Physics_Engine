package ru.yarikbur.utils;

public class Timer implements Runnable {
	private static int miliLast = 0;
	private static int miliFuture = 0;
	private static int sec = 0;
	private static int min = 0;
	private static int hou = 0;
	private static Thread timer;
	private static boolean destroy = false;
	private static int milisDelay = 50;
	
	public Timer(){
		timer = new Thread(this, "Timer delay: " + milisDelay);
		timer.start();
	}
	
	public Timer(int milis){
		milisDelay = milis;
		timer = new Thread(this, "Timer delay: " + milisDelay);
		timer.start();
	}
	
	public static void timerStop() {
		destroy = true;
	}
	
	public static boolean switchTime() {
		if(miliFuture > miliLast)
			return true;
		else
			return false;
	}
	
	private static void update() {
		if(switchTime()) {
			miliLast = miliFuture;
			if(miliLast >= 1000) {
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
		while(!destroy) {
			try {
				miliFuture += milisDelay;
				update();
				Thread.sleep(milisDelay);
//				System.out.println("Miliseconds: " + miliLast + "Second: " + sec + " Minutes: " + min + " Hours: " + hou);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	public static int getMiliLast() {
		return miliLast;
	}

	public static void setMiliLast(int miliLast) {
		Timer.miliLast = miliLast;
	}

	public static int getmiliFuture() {
		return miliFuture;
	}

	public static void setMiliFuture(int miliFuture) {
		Timer.miliFuture = miliFuture;
	}
	
	public static int getSec() {
		return sec;
	}

	public static void setCes(int sec) {
		Timer.sec = sec;
	}
	
	public static int getMin() {
		return min;
	}

	public static void setMin(int min) {
		Timer.min = min;
	}

	public static int getHou() {
		return hou;
	}

	public static void setHou(int hou) {
		Timer.hou = hou;
	}
	
}
