package com.omnidex.pokemon;

public class Stage implements Stageable {

	protected int stage;
	private int maxStage;
	private int minStage;
	private int initialStage;

	public Stage(int minStage, int maxStage, int initialStage) {
		stage = initialStage;
		this.initialStage = initialStage;
		this.maxStage = maxStage;
		this.minStage = minStage;
	}

	@Override
	public int getStage() {
		return stage;
	}

	@Override
	public void boostStage(int boost) {
		stage += boost;

		if (stage > maxStage) {
			boostToMaxStage();
		}
	}

	@Override
	public void decreaseStage(int decrease) {
		stage -= decrease;

		if (stage < minStage) {
			decreaseToMinStage();
		}
	}

	@Override
	public void boostToMaxStage() {
		stage = maxStage;
	}

	@Override
	public void decreaseToMinStage() {
		stage = minStage;
	}

	@Override
	public void resetToInitialStage() {
		stage = initialStage;
	}
	
	@Override
	public double getStageModifier() {
		return 1.0;
	}

}
