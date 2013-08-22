package com.omnidex.pokemon;

public interface Stageable {
	int getStage();
	void boostStage(int boost);
	void decreaseStage(int decrease);
	void boostToMaxStage();
	void decreaseToMinStage();
	void resetToInitialStage();
	double getStageModifier();
}
