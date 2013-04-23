package com.omnidex.pokemon;

/**
 * An interface that promises the behavior of the status ailments that exist in
 * the Pokemon game.
 * 
 * Creation Date: 3/9/2012
 * 
 * @author Akers
 */
public interface Status {
	static final double CHANCE_TO_THAW = 0.20;
	static final double CHANCE_TO_FULL_PARA = 0.25;
	static final double PARA_SPE_MOD = 0.25;
	static final double BURN_ATK_MOD = 0.5;
	static final double QUICK_FEET_SPE_MOD = 1.5;
	static final double GUTS_ATK_MOD = 1.5;
	static final double MARVEL_SCALE_DEF_MOD = 1.5;
	static final int MAX_TOXIC_COUNT = 16;

	/**
	 * Increases the toxic count by one. Maxs out at 16. If the current Status
	 * isn't toxic Poison nothing happens.
	 */
	void incrementToxCount();

	/**
	 * @return an int representing the duration of the sleep status.
	 */
	int getSleepDuration();

	/**
	 * Decreases the duration of a status by 1. If the value is zero cure the
	 * status.
	 */
	void decrementSleep();

	/**
	 * @return an int representing the initial duration of the status. This is
	 *         used for calculating sleep.
	 */
	int getInitialSleepDuration();

	/**
	 * @return a double representing the current status's mod on atk. 1.0 for
	 *         all status except Burn. Burn 0.5
	 */
	double getAtkMod();

	/**
	 * @return a double representing the current status's mod on spe. 1.0 for
	 *         all status except Paralysis.
	 */
	double getSpeMod();

	/**
	 * Resets the current status to NO_STATUS. Resets all counters.
	 */
	void cureStatus();

	/**
	 * @return a boolean representing whether or not the Pokemon is burnt.
	 */
	boolean isBurnt();

	/**
	 * @return a boolean representing whether or not the Pokemon is asleep.
	 */
	boolean isAsleep();

	/**
	 * @return a boolean representing whether or not the Pokemon is paralyzed.
	 */
	boolean isParalyzed();

	/**
	 * @return a boolean representing whether or not the Pokemon has no
	 *         condition.
	 */
	boolean isOk();

	/**
	 * @return a boolean representing whether or not the Pokemon is regular
	 *         poisoned.
	 */
	boolean isRegPoison();

	/**
	 * @return a boolean representing whether or not the Pokemon is toxic
	 *         poisoned.
	 */
	boolean isToxPoison();

	/**
	 * @return a boolean representing whether or not the Pokemon is frozen.
	 */
	boolean isFrozen();

	/**
	 * @return a boolean representing whether or not the Pokemon has fainted.
	 */
	boolean hasFainted();

	/**
	 * Sets the status to sleep.
	 * 
	 * @param duration
	 *            an int representing the number of turns the Pokemon will
	 *            sleep.
	 */
	void setSleep(int duration);

	/**
	 * @return a boolean whether or not the Pokemon is cured of freeze.
	 */
	boolean doesThaw();

	/**
	 * Sets the status to toxic poison.
	 */
	void setToxPoison();

	/**
	 * @return an int representing how many turns the toxic status has been in
	 *         effect.
	 */
	int getToxCount();

	/**
	 * Sets the status to regular poison.
	 */
	void setRegPoison();

	/**
	 * Sets the status to burn.
	 */
	void setBurnt();

	/**
	 * Sets the status to fainted.
	 */
	void setFainted();

	/**
	 * Sets the status to frozen.
	 */
	void setFrozen();

	/**
	 * Sets the status to paralyzed.
	 */
	void setParalysis();

	/**
	 * @return a boolean representing whether or not the Pokemon is fully
	 *         paralyzed.
	 */
	boolean doesFullyParalyze();
}
