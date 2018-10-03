package ru.yarikbur.obj;

public class Properties implements Obj{
	
	private int id;
	private float weight;
	private float bounce;
	private float color;
	private float[] coordinates = new float[2];
	private float[] size = new float[2];
	private float[] speed = new float[2];
	private boolean attractoin;
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void render() {
		
	}

	@Override
	public boolean getAttraction() {
		return attractoin;
	}

	@Override
	public void setAttraction(boolean attraction) {
		this.attractoin = attraction;
	}

	@Override
	public float[] getCoordinates() {
		return coordinates;
	}

	@Override
	public void setCoordinates(float[] coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public float[] getSize() {
		return size;
	}

	@Override
	public void setSize(float[] size) {
		this.size = size;
	}

	@Override
	public float getWeight() {
		return weight;
	}

	@Override
	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public float[] getSpeed() {
		float[] speedV0 = {speed[0]/100f, speed[1]/100f};
		return speedV0;
	}

	@Override
	public void setSpeed(float[] speed) {
		this.speed = speed;
	}

	@Override
	public float getBounce() {
		return bounce;
	}

	@Override
	public void setBounce(float bounce) {
		this.bounce = bounce;
	}
	
	@Override
	public float getColor() {
		return color;
	}
	
	@Override
	public void setColor(float color) {
		this.color = color;
	}
}
