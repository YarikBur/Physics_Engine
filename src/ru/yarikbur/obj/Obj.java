package ru.yarikbur.obj;

public interface Obj {
	int getWeight();

	float[] getCoordinates();
	float getSpeed();
	
	void setCoordinates(float[] coordinates);
	void setSpeed(float speed);
}
