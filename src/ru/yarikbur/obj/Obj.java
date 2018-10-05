package ru.yarikbur.obj;

public interface Obj {
	int getId();
	void setId(int id);
	
	void render();
	
	boolean getAttraction();
	void setAttraction(boolean attraction);
	
	boolean getBounced();
	void setBounced(boolean bounced);
	
	float[] getCoordinates();
	void setCoordinates(float[] coordinates);
	
	float[] getMaxCoordiantes();
	void setMaxCoordiantes(float[] maxCoordiantes);
	
	float[] getSize();
	void setSize(float[] size);
	
	float getWeight();
	void setWeight(float weight);
	
	float[] getSpeed();
	void setSpeed(float[] speed);
	
	float getBounce();
	void setBounce(float bounce);
	
	float getColor();
	void setColor(float color);
}
