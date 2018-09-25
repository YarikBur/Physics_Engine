package ru.yarikbur.obj;

public interface Obj {
	int getId();
	void setId(int id);
	
	void render();
	
	boolean getAttraction();
	void setAttraction(boolean attraction);
	
	int[][] getCoordinates();
	void setCoordinates(int[][] coordinates);
	
	int getWeight();
	void setWeight(int weight);
	
	int[] getForce();
	void setForce(int[] force);
}
