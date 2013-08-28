package com.omnidex.pokemon;

import com.omnidex.type.Type;

public interface Stats {
	// constants for elements of arrays
	static final int CURR_HP = 1;
	static final int MAX_HP = 0;
	static final int ATK = 1;
	static final int DEF = 2;
	static final int SPATK = 3;
	static final int SPDEF = 4;
	static final int SPE = 5;
	static final int ACCURARY = 0;
	static final int EVASION = 1;

	/**
	 * Assigns the Pokemon the specified Nature
	 * 
	 * @param nature
	 *            a Nature enum for the Pokemon to have next
	 */
	void setNature(Nature nature);

	/**
	 * @return a Nature enum representing the Pokemon's nature.
	 */
	Nature getNature();

	/**
	 * @return an int[] of all the base stats for the pokemon in the following
	 *         order. hp, atk, def, spAtk, spDef, spe
	 */
	int[] getBaseStats();

	/**
	 * @param baseStats
	 *            an int array of a Pokemon's base states in the order: hp, atk,
	 *            def, spAtk, spDef, spe
	 */
	void setBaseStats(int[] baseStats);

	/**
	 * Sets a Pokemon's evs to the specified values in evs[].
	 * 
	 * @param evs
	 *            an int[] of all the evs a Pokemon has earned. The order of the
	 *            evs are: hp, atk, def, spAtk, spDef, spe
	 */
	void setEvs(int[] evs);

	/**
	 * @return an int[] of the Pokemons current ivs. The order of the ivs are:
	 *         hp, atk, def, spAtk, spDef, spe
	 */
	int[] getIvs();

	/**
	 * Sets the Pokemon's ivs to those specified in ivs[].
	 * 
	 * @param ivs
	 *            an int[] of ivs for the Pokemon. The order of the ivs is: hp,
	 *            atk, def, spAtk, spDef, spe
	 */
	void setIvs(int[] ivs);

	/**
	 * @return an int representing the pokemon's unmodified attack stat.
	 */
	int getAtk();

	/**
	 * @return an int representing the pokemon's unmodified defense stat.
	 */
	int getDef();

	/**
	 * @return an int representing the pokemon's unmodified special attack stat.
	 */
	int getSpAtk();

	/**
	 * @return an int representing the pokemon's unmodified special defense
	 *         stat.
	 */
	int getSpDef();

	/**
	 * @return an int representing the pokemon's unmodified speed stat.
	 */
	int getSpe();

	// TODO javadocs
	void setHpBase(int hpBase);

	void setAtkBase(int atkBase);

	void setDefBase(int defBase);

	void setSpAtkBase(int spAtkBase);

	void setSpDefBase(int spDefBase);

	void setSpeBase(int speBase);

	// TODO javadocs
	int getHpBase();

	int getAtkBase();

	int getDefBase();

	int getSpAtkBase();

	int getSpDefBase();

	int getSpeBase();

	// TOOD javadocs
	void setLevel(int level);

	int getLevel();

	int getHpIv();

	int getAtkIv();

	int getDefIv();

	int getSpAtkIv();

	int getSpDefIv();

	int getSpeIv();

	int[] getEvs();

	int getHpEv();

	int getAtkEv();

	int getDefEv();

	int getSpAtkEv();

	int getSpDefEv();

	int getSpeEv();

	void setHpIv(int hpIv);

	void setAtkIv(int atkIv);

	void setDefIv(int defIv);

	void setSpAtkIv(int spAtkIv);

	void setSpDefIv(int spDefIv);

	void setSpeIv(int speIv);

	void setHpEv(int hpEv);

	void setAtkEv(int atkEv);

	void setDefEv(int defEv);

	void setSpAtkEv(int spAtkEv);

	void setSpDefEv(int spDefEv);

	void setSpeEv(int speEv);

	/**
	 * @return an int representing the current hit points.
	 */
	int getCurrHp();

	/**
	 * @return a Type representing the type of the hidden power's type.
	 */
	Type getHiddenPowerType();

	/**
	 * @return an int representing the maximum hit points available when at full
	 *         health.
	 */
	int getMaxHp();

	/**
	 * Sets the current Hit Points.
	 * 
	 * @param an
	 *            int representing the new value of the current Hit Points
	 */
	void setCurrHp(int currHp);

	// TODO javadocs

	/**
	 * Sets all the stats at the same time.
	 * 
	 * @param stats
	 *            an array of ints representing the stats in the following order
	 *            int[0] = hp int[3] = spAtk int[1] = atk int[4] = spDef int[2]
	 *            = def int[5] = spe
	 */
	void setStats(int[] stats);

	/**
	 * Sets atk,def,spatk,spdef,spe,accuracy, evasion and stages for the
	 * respective stats equals to those values from the newStats.
	 * 
	 * @param newStat
	 *            a Stats object that that the current stats will be set to
	 */
	void setStats(Stats newStat);

	/**
	 * Sets all the stats at once.
	 * 
	 * @param hp
	 *            an int representing the new maximum hit point stat Ensures:
	 *            that the current hit points equals the maximum hit points
	 * @param atk
	 *            an int representing the new attack stat
	 * @param def
	 *            an int representing the new defense stat
	 * @param spAtk
	 *            an int representing the new special attack stat
	 * @param spDef
	 *            an int representing the new special defense stat
	 * @param spe
	 *            an int representing the new speed stat
	 */
	void setStats(int hp, int atk, int def, int spAtk, int spDef, int spe);

	String getStatAt(int position);
}
