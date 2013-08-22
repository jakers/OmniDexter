package com.omnidex.pokemon;

import com.omnidex.damage.PokemonMath;
import com.omnidex.type.Type;

/**
 * @author jakers
 */
public class PokeStats implements Stats {

	private static final int NUMBER_OF_STATS = 6;
	private int maxHp;
	private int currHp;
	private int atk;
	private int def;
	private int spAtk;
	private int spDef;
	private int spe;
	private int hpIv;
	private int atkIv;
	private int defIv;
	private int spAtkIv;
	private int spDefIv;
	private int speIv;
	private int hpEv;
	private int atkEv;
	private int defEv;
	private int spAtkEv;
	private int spDefEv;
	private int speEv;
	private Nature nature;
	private int[] baseStats;
	private int level;

	private int hiddenPowerBasePower;
	private Type hiddenPowerType;

	public PokeStats(Nature nature, int[] baseStats, int[] ivs, int[] evs) {
		this.nature = nature;
		this.baseStats = baseStats;
		this.level = 100;

		hpIv = ivs[MAX_HP];
		atkIv = ivs[ATK];
		defIv = ivs[DEF];
		spAtkIv = ivs[SPATK];
		spDefIv = ivs[SPDEF];
		speIv = ivs[SPE];

		hpEv = evs[MAX_HP];
		atkEv = evs[ATK];
		defEv = evs[DEF];
		spAtkEv = evs[SPATK];
		spDefEv = evs[SPDEF];
		speEv = evs[SPE];

		int[] stats = PokemonMath.calcPokemon(level, nature, baseStats, ivs,
				evs);
		reCalcStats();
		maxHp = stats[MAX_HP];
		currHp = maxHp;

		atk = stats[ATK];
		def = stats[DEF];
		spAtk = stats[SPATK];
		spDef = stats[SPDEF];
		spe = stats[SPE];

	}

	public PokeStats(int level, Nature nature, int[] baseStats, int[] ivs,
			int[] evs) {
		this.nature = nature;
		this.baseStats = baseStats;
		this.level = level;

		hpIv = ivs[MAX_HP];
		atkIv = ivs[ATK];
		defIv = ivs[DEF];
		spAtkIv = ivs[SPATK];
		spDefIv = ivs[SPDEF];
		speIv = ivs[SPE];

		hpEv = evs[MAX_HP];
		atkEv = evs[ATK];
		defEv = evs[DEF];
		spAtkEv = evs[SPATK];
		spDefEv = evs[SPDEF];
		speEv = evs[SPE];

		int[] stats = PokemonMath.calcPokemon(level, nature, baseStats, ivs,
				evs);
		reCalcStats();
		maxHp = stats[MAX_HP];
		currHp = maxHp;

		atk = stats[ATK];
		def = stats[DEF];
		spAtk = stats[SPATK];
		spDef = stats[SPDEF];
		spe = stats[SPE];
	}

	public PokeStats(Stats s) {
		this.nature = s.getNature();
		this.baseStats = s.getBaseStats();
		this.level = s.getLevel();

		hpIv = s.getHpIv();
		atkIv = s.getAtkIv();
		defIv = s.getDefIv();
		spAtkIv = s.getSpAtkIv();
		spDefIv = s.getSpDefIv();
		speIv = s.getSpeIv();

		hpEv = s.getHpEv();
		atkEv = s.getAtkEv();
		defEv = s.getDefEv();
		spAtkEv = s.getSpAtkEv();
		spDefEv = s.getSpDefEv();
		speEv = s.getSpeEv();

		reCalcStats();

		this.currHp = s.getCurrHp();
	}

	@Override
	public int getMaxHp() {
		return maxHp;
	}

	@Override
	public int getCurrHp() {
		return currHp;
	}

	@Override
	public void setCurrHp(int currHp) {
		if (currHp < 0) {
			this.currHp = 0;
		} else if (currHp > maxHp) {
			this.currHp = this.maxHp;
		} else {
			this.currHp = currHp;
		}
	}

	@Override
	public void setStats(int hp, int atk, int def, int spAtk, int spDef, int spe) {
		maxHp = hp;
		currHp = hp;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.spe = spe;
	}

	@Override
	public void setStats(int[] stats) {
		maxHp = stats[MAX_HP];
		currHp = maxHp;
		atk = stats[ATK];
		def = stats[DEF];
		spAtk = stats[SPATK];
		spDef = stats[SPDEF];
		spe = stats[SPE];
	}

	@Override
	public void setStats(Stats newStat) {
		this.hpIv = newStat.getHpIv();
		this.atkIv = newStat.getAtkIv();
		this.defIv = newStat.getDefIv();
		this.spAtkIv = newStat.getSpAtkIv();
		this.spDefIv = newStat.getSpDefIv();
		this.speIv = newStat.getSpeIv();
		this.hpEv = newStat.getHpEv();
		this.atkEv = newStat.getAtkEv();
		this.defEv = newStat.getDefEv();
		this.spAtkEv = newStat.getSpAtkEv();
		this.spDefEv = newStat.getSpDefEv();
		this.speEv = newStat.getSpeEv();
		reCalcStats();
	}

	@Override
	public int[] getIvs() {
		int[] result = new int[NUMBER_OF_STATS];
		result[MAX_HP] = hpIv;
		result[ATK] = atkIv;
		result[DEF] = defIv;
		result[SPATK] = spAtkIv;
		result[SPDEF] = spDefIv;
		result[SPE] = speIv;
		reCalcStats();
		return result;
	}

	@Override
	public int getHpIv() {
		return hpIv;
	}

	@Override
	public int getAtkIv() {
		return atkIv;
	}

	@Override
	public int getDefIv() {
		return defIv;
	}

	@Override
	public int getSpAtkIv() {
		return spAtkIv;
	}

	@Override
	public int getSpDefIv() {
		return spDefIv;
	}

	@Override
	public int getSpeIv() {
		return speIv;
	}

	@Override
	public int[] getEvs() {
		int[] result = new int[NUMBER_OF_STATS];
		result[MAX_HP] = hpEv;
		result[ATK] = atkEv;
		result[DEF] = defEv;
		result[SPATK] = spAtkEv;
		result[SPDEF] = spDefEv;
		result[SPE] = speEv;
		return result;
	}

	@Override
	public int getHpEv() {
		return hpEv;
	}

	@Override
	public int getAtkEv() {
		return atkEv;
	}

	@Override
	public int getDefEv() {
		return defEv;
	}

	@Override
	public int getSpAtkEv() {
		return spAtkEv;
	}

	@Override
	public int getSpDefEv() {
		return spDefEv;
	}

	@Override
	public int getSpeEv() {
		return speEv;
	}

	@Override
	public void setHpIv(int hpIv) {
		this.hpIv = hpIv;
		reCalcStats();
	}

	@Override
	public void setAtkIv(int atkIv) {
		this.atkIv = atkIv;
		reCalcStats();
	}

	@Override
	public void setDefIv(int defIv) {
		this.defIv = defIv;
		reCalcStats();
	}

	@Override
	public void setSpAtkIv(int spAtkIv) {
		this.spAtkIv = spAtkIv;
		reCalcStats();
	}

	@Override
	public void setSpDefIv(int spDefIv) {
		this.spDefIv = spDefIv;
		reCalcStats();
	}

	@Override
	public void setSpeIv(int speIv) {
		this.speIv = speIv;
		reCalcStats();
	}

	@Override
	public void setHpEv(int hpEv) {
		this.hpEv = hpEv;
		reCalcStats();
	}

	@Override
	public void setAtkEv(int atkEv) {
		this.atkEv = atkEv;
		reCalcStats();
	}

	@Override
	public void setDefEv(int defEv) {
		this.defEv = defEv;
		reCalcStats();
	}

	@Override
	public void setSpAtkEv(int spAtkEv) {
		this.spAtkEv = spAtkEv;
		reCalcStats();
	}

	@Override
	public void setSpDefEv(int spDefEv) {
		this.spDefEv = spDefEv;
		reCalcStats();
	}

	@Override
	public void setSpeEv(int speEv) {
		this.speEv = speEv;
		reCalcStats();
	}

	@Override
	public int getHiddenPowerBasePower() {
		return hiddenPowerBasePower;
	}

	@Override
	public Type getHiddenPowerType() {
		return hiddenPowerType;
	}

	private void reCalcStats() {
		int ivs[] = { hpIv, atkIv, defIv, spAtkIv, spDefIv, speIv };
		int evs[] = { hpEv, atkEv, defEv, spAtkEv, spDefEv, speEv };

		int[] stats = PokemonMath.calcPokemon(level, nature, baseStats, ivs,
				evs);

		hiddenPowerBasePower = PokemonMath.calcHiddenPowerBasePower(hpIv,
				atkIv, defIv, spAtkIv, spDefIv, speIv);
		hiddenPowerType = PokemonMath.calcHiddenPower(hpIv, atkIv, defIv,
				spAtkIv, spDefIv, speIv);

		// HACK for keeping hp saved
		if (currHp == maxHp) {
			maxHp = stats[MAX_HP];
			currHp = maxHp;
		} else {
			maxHp = stats[MAX_HP];
		}
		atk = stats[ATK];
		def = stats[DEF];
		spAtk = stats[SPATK];
		spDef = stats[SPDEF];
		spe = stats[SPE];
	}

	@Override
	public void setHpBase(int hpBase) {
		baseStats[MAX_HP] = hpBase;
		reCalcStats();
	}

	@Override
	public void setAtkBase(int atkBase) {
		baseStats[ATK] = atkBase;
		reCalcStats();
	}

	@Override
	public void setDefBase(int defBase) {
		baseStats[DEF] = defBase;
		reCalcStats();
	}

	@Override
	public void setSpAtkBase(int spAtkBase) {
		baseStats[SPATK] = spAtkBase;
		reCalcStats();
	}

	@Override
	public void setSpDefBase(int spDefBase) {
		baseStats[SPDEF] = spDefBase;
		reCalcStats();
	}

	@Override
	public void setSpeBase(int speBase) {
		baseStats[SPE] = speBase;
		reCalcStats();
	}

	@Override
	public int getHpBase() {
		return baseStats[MAX_HP];
	}

	@Override
	public int getAtkBase() {
		return baseStats[ATK];
	}

	@Override
	public int getDefBase() {
		return baseStats[DEF];
	}

	@Override
	public int getSpAtkBase() {
		return baseStats[SPATK];
	}

	@Override
	public int getSpDefBase() {
		return baseStats[SPDEF];
	}

	@Override
	public int getSpeBase() {
		return baseStats[SPE];
	}

	@Override
	public void setNature(Nature nature) {
		this.nature = nature;
		reCalcStats();
	}

	@Override
	public Nature getNature() {
		return nature;
	}

	@Override
	public void setEvs(int[] evs) {
		hpEv = evs[MAX_HP];
		atkEv = evs[ATK];
		defEv = evs[DEF];
		spAtkEv = evs[SPATK];
		spDefEv = evs[SPDEF];
		speEv = evs[SPE];
		reCalcStats();
	}

	@Override
	public int[] getBaseStats() {
		return baseStats;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
		reCalcStats();
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public void setIvs(int[] ivs) {
		hpIv = ivs[MAX_HP];
		atkIv = ivs[ATK];
		defIv = ivs[DEF];
		spAtkIv = ivs[SPATK];
		spDefIv = ivs[SPDEF];
		speIv = ivs[SPE];
		reCalcStats();
	}

	@Override
	public int getAtk() {
		return atk;
	}

	@Override
	public int getDef() {
		return def;
	}

	@Override
	public int getSpAtk() {
		return spAtk;
	}

	@Override
	public int getSpDef() {
		return spDef;
	}

	@Override
	public int getSpe() {
		return spe;
	}

	@Override
	public void setBaseStats(int[] baseStats) {
		this.baseStats[CURR_HP] = baseStats[CURR_HP];
		this.baseStats[ATK] = baseStats[ATK];
		this.baseStats[DEF] = baseStats[DEF];
		this.baseStats[SPATK] = baseStats[SPATK];
		this.baseStats[SPDEF] = baseStats[SPDEF];
		this.baseStats[SPE] = baseStats[SPE];
	}

	@Override
	public String getStatAt(int position) {
		String stat = "Spe";
		if (position == 0) {
			stat = "HP";
		} else if (position == 1) {
			stat = "Atk";
		} else if (position == 2) {
			stat = "Def";
		} else if (position == 3) {
			stat = "SAtk";
		} else if (position == 4) {
			stat = "Atk";
		}
		return stat;
	}
}
