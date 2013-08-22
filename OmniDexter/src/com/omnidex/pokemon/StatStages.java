package com.omnidex.pokemon;

public class StatStages extends Stage {

	private static final double STAGE_NEGATIVE_SIX = 2 / (double) 8;
	private static final double STAGE_NEGATIVE_FIVE = 2 / (double) 7;
	private static final double STAGE_NEGATIVE_FOUR = 2 / (double) 6;
	private static final double STAGE_NEGATIVE_THREE = 2 / (double) 5;
	private static final double STAGE_NEGATIVE_TWO = 2 / (double) 4;
	private static final double STAGE_NEGATIVE_ONE = 2 / (double) 3;
	private static final double STAGE_ZERO = 1.0;
	private static final double STAGE_ONE = 1.5;
	private static final double STAGE_TWO = 2.0;
	private static final double STAGE_THREE = 2.5;
	private static final double STAGE_FOUR = 3.0;
	private static final double STAGE_FIVE = 3.5;
	private static final double STAGE_SIX = 4.0;

	public StatStages() {
		super(-6, 6, 0);
	}

	@Override
	public double getStageModifier() {
		double stageModifier = STAGE_ZERO;

		switch (stage) {
		case -6:
			stageModifier = STAGE_NEGATIVE_SIX;
			break;
		case -5:
			stageModifier = STAGE_NEGATIVE_FIVE;
			break;
		case -4:
			stageModifier = STAGE_NEGATIVE_FOUR;
			break;
		case -3:
			stageModifier = STAGE_NEGATIVE_THREE;
			break;
		case -2:
			stageModifier = STAGE_NEGATIVE_TWO;
			break;
		case -1:
			stageModifier = STAGE_NEGATIVE_ONE;
			break;
		case 0:
			stageModifier = STAGE_ZERO;
			break;
		case 1:
			stageModifier = STAGE_ONE;
			break;
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
			break;
		case 6:
			stageModifier = STAGE_SIX;
			break;
		default:
			stageModifier = STAGE_ZERO;
		}
		return stageModifier;
	}

}
