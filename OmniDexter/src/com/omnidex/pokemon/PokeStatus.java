package com.omnidex.pokemon;

import com.omnidex.damage.MathUtils;

/**
 * This class implements Status Pokemon can have
 * throughout the course of a Pokemon battle
 */
public class PokeStatus implements Status {
	private boolean isFrozen;
	private boolean hasFainted;
	private boolean isPara;
	private boolean isBurnt;
	private boolean isRegPoison;
	private boolean isToxPoison;
	private boolean isAsleep;
	private boolean isOk;

	private int toxCount;
	private int initSleepCount;
	private int currSleepCount;

	public PokeStatus() {
		cureAll();
	}

	public PokeStatus(Status status) {
		isFrozen = status.isFrozen();
		hasFainted = status.hasFainted();
		isPara = status.isParalyzed();
		isBurnt = status.isBurnt();
		isRegPoison = status.isRegPoison();
		isToxPoison = status.isToxPoison();
		isAsleep = status.isAsleep();
		isOk = status.isOk();
		toxCount = status.getToxCount();
		initSleepCount = status.getInitialSleepDuration();
		currSleepCount = status.getSleepDuration();
	}

	@Override
	public int getSleepDuration() {
		return currSleepCount;
	}

	@Override
	public void decrementSleep() {
		if (isAsleep) {
			currSleepCount--;
			if (currSleepCount <= 0) {
				currSleepCount = 0;
				initSleepCount = 0;
				isAsleep = false;
				isOk = true;
			}
		}
	}

	@Override
	public int getInitialSleepDuration() {
		return initSleepCount;
	}

	@Override
	public double getAtkMod() {
		double result = 1.0;
		if (isBurnt) {
			result = BURN_ATK_MOD;
		}
		return result;
	}

	@Override
	public double getSpeMod() {
		double result = 1.0;
		if (isPara) {
			result = PARA_SPE_MOD;
		}
		return result;
	}

	@Override
	public void cureStatus() {
		cureAll();
	}

	@Override
	public boolean isBurnt() {
		return isBurnt;
	}

	@Override
	public boolean isAsleep() {
		return isAsleep;
	}

	@Override
	public boolean isParalyzed() {
		return isPara;
	}

	@Override
	public boolean isRegPoison() {
		return isRegPoison;
	}

	@Override
	public boolean isToxPoison() {
		return isToxPoison;
	}

	@Override
	public boolean isFrozen() {
		return isFrozen;
	}

	@Override
	public boolean hasFainted() {
		return hasFainted;
	}

	public void setRestSleep() {
		cureAll();
		isOk = false;
		isAsleep = true;
		initSleepCount = 2;
		currSleepCount = 2;
	}
		
	@Override
	public void setSleep(int duration) {
		if (isOk) { 
			isOk = false;
			isAsleep = true;
			initSleepCount = duration;
			currSleepCount = duration;
		}
	}

	@Override
	public boolean doesThaw() {
		return MathUtils.eventOccursWithProb(Status.CHANCE_TO_THAW);
	}

	@Override
	public void setToxPoison() {
		cureAll();
		isOk = false;
		isToxPoison = true;
		toxCount = 1;
	}

	@Override
	public int getToxCount() {
		return toxCount;
	}

	@Override
	public void setRegPoison() {
		cureAll();
		isOk = false;
		isRegPoison = true;
	}

	@Override
	public void setBurnt() {
		cureAll();
		isOk = false;
		isBurnt = true;
	}

	@Override
	public void setFrozen() {
		cureAll();
		isOk = false;
		isFrozen = true;
	}

	@Override
	public void setParalysis() {
		cureAll();
		isOk = false;
		isPara = true;
	}

	@Override
	public boolean isOk() {
		return isOk;
	}

	@Override
	public boolean doesFullyParalyze() {
		return MathUtils.eventOccursWithProb(CHANCE_TO_FULL_PARA);
	}

	private void cureAll() {
		isOk = true;
		isFrozen = false;
		isPara = false;
		isBurnt = false;
		isRegPoison = false;
		isToxPoison = false;
		isAsleep = false;
		hasFainted = false;

		toxCount = 0;
		initSleepCount = 0;
		currSleepCount = 0;
	}

	@Override
	public void incrementToxCount() {
		if (isToxPoison) {
			if (toxCount < MAX_TOXIC_COUNT) {
				toxCount++;
			} else {
				toxCount = 1;
			}
		}
	}

	@Override
	public void setFainted() {
		cureAll();
		isOk = false;
		hasFainted = true;
	}
}
