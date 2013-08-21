package com.omnidex.pokemon;

public class Stage implements Stageable {

	private int stage;
	private int max;
	private int min;

	public Stage(int minStage, int maxStage, int startingStage) {
		stage = startingStage;
		max = maxStage;
		min = minStage;
	}

	@Override
	public int getStage() {
		return stage;
	}

	@Override
	public void boostStage(int boost) {
		stage += boost;

		if (stage > max) {
			boostToMaxStage();
		}
	}

	@Override
	public void decreaseStage(int decrease) {
		stage -= decrease;

		if (stage < min) {
			decreaseToMinStage();
		}
	}

	@Override
	public void boostToMaxStage() {
		stage = max;
	}

	@Override
	public void decreaseToMinStage() {
		stage = min;
	}

}
