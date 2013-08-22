package com.omnidex.pokemon;

public class CriticalHitStages extends Stage {

	private static final double STAGE_ONE = 0.0625;
	private static final double STAGE_TWO = 0.125;
	private static final double STAGE_THREE = 0.25;
	private static final double STAGE_FOUR = 0.333;
	private static final double STAGE_FIVE = 0.5;

	public CriticalHitStages() {
		super(1, 5, 1);
	}

	@Override
	public double getStageModifier() {
		double stageModifier = STAGE_ONE;

		switch (stage) {
		case 2:
			stageModifier = STAGE_TWO;
			break;
		case 3:
			stageModifier = STAGE_THREE;
			break;
		case 4:
			stageModifier = STAGE_FOUR;
			break;
		case 5:
			stageModifier = STAGE_FIVE;
		default:
			stageModifier = STAGE_ONE;
		}
		return stageModifier;
	}

}
