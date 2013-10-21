package com.omnidex.pokemon;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.omnidex.ability.Ability;
import com.omnidex.item.Item;
import com.omnidex.move.Move;
import com.omnidex.move.MoveWithPP;
import com.omnidex.pokemon.Species;
import com.omnidex.type.Type;

/**
 * A DeepPokemon object that holds all the stats of a DeepPokemon species.
 * 
 * @convention an Undeclared DeepPokemon is initially set as MissingNo. This
 *             class utilizes function from the PokemonDatabase class and is
 *             connected with OmniDex.mdb file.
 * @author jakers
 */
public class InactivePokemon implements Pokemon, Status, Stats {

	private static final int NUM_OF_STATS = 6;
	private static final int HP = 0;
	private static final int SP_ATK = 3;
	private static final int SP_DEF = 4;

	protected Stats stats;
	protected Species forme;
	protected String nickName;
	protected int gen;
	protected Nature nature;
	protected String gender;
	protected boolean isShiny;
	protected Status status;
	protected Ability ability;
	protected Item item;
	protected double weight;
	
	protected MoveWithPP move1;
	protected MoveWithPP move2;
	protected MoveWithPP move3;
	protected MoveWithPP move4;
	protected MoveWithPP switch1;
	protected MoveWithPP switch2;
	protected MoveWithPP switch3;
	protected MoveWithPP switch4;
	protected MoveWithPP switch5;

	protected int friendship;
	private boolean isActivePokemon;
	private boolean isGrounded = false;
	
	public InactivePokemon() {
		forme = Species.MISSINGNO;
		nickName = forme.toString();
		item = Item.NO_ITEM;
		ability = Ability.NO_ABILITY;
		nature = Nature.HARDY;

		int[] iv = { MAX_IV_VALUE, MAX_IV_VALUE, MAX_IV_VALUE, MAX_IV_VALUE,
				MAX_IV_VALUE, MAX_IV_VALUE };
		int[] ev = { 0, 0, 0, 0, 0, 0, 0 };

		stats = new PokeStats(nature, forme.getAllBases(), iv, ev);

		status = new PokeStatus();
		MoveWithPP m = new MoveWithPP(Move.NONE);

		move1 = m;
		move2 = m;
		move3 = m;
		move4 = m;

		isShiny = false;
	}

	public InactivePokemon(ResultSet rs) {
		try {
			rs.next();
			forme = Species.findSpeciesByName(rs.getString("form"));
			item = Item.findItemByName(rs.getString("item"));
			ability = Ability.findAbilityByName(rs.getString("ability"));
			nature = Nature.findNatureByName((rs.getString("nature")));

			int[] iv = { MAX_IV_VALUE, MAX_IV_VALUE, MAX_IV_VALUE,
					MAX_IV_VALUE, MAX_IV_VALUE, MAX_IV_VALUE };
			int[] evs = new int[6];
			evs[0] = rs.getInt("hp_iv");

			evs[1] = rs.getInt("atk_iv");
			evs[2] = rs.getInt("def_iv");
			evs[3] = rs.getInt("spatk_iv");
			evs[4] = rs.getInt("spdef_iv");
			evs[5] = rs.getInt("spe_iv");

			stats = new PokeStats(nature, forme.getAllBases(), iv, evs);

			status = new PokeStatus();
			move1 = new MoveWithPP(Move.findMoveByName(rs.getString("move_1")));
			move2 = new MoveWithPP(Move.findMoveByName(rs.getString("move_2")));
			move3 = new MoveWithPP(Move.findMoveByName(rs.getString("move_3")));
			move4 = new MoveWithPP(Move.findMoveByName(rs.getString("move_4")));

		} catch (SQLException e) {
			System.out.println("Failed to load in a pokemon by usage stats");
			e.printStackTrace();
		}

		isShiny = false;
	}

	@Override
	public void setAbility(Ability ability) {
		this.ability = ability;
	}

	@Override
	public Ability getAbility() {
		return ability;
	}

	@Override
	public void setFrozen() {
		status.setFrozen();
	}

	@Override
	public void setFainted() {
		status.setFainted();
	}

	@Override
	public void setBurnt() {
		status.setBurnt();
	}

	@Override
	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public Item getItem() {
		return this.item;
	}

	public InactivePokemon(Species pokemon) {

		int[] iv = { 31, 31, 31, 31, 31, 31 };
		int[] ev = { 0, 0, 0, 0, 0, 0 };

		ability = Ability.NO_ABILITY;
		nature = Nature.HARDY;

		forme = pokemon;
		nickName = forme.toString();

		item = Item.NO_ITEM;

		stats = new PokeStats(MAX_LEVEL, nature, forme.getAllBases(), iv, ev);
		status = new PokeStatus();
		isShiny = false;
	}

	public InactivePokemon(Species forme, int level, Nature nature, int[] ivs,
			int[] evs, MoveWithPP[] moveSet) {
		move1 = moveSet[MOVE_ONE];
		move2 = moveSet[MOVE_TWO];
		move3 = moveSet[MOVE_THREE];
		move4 = moveSet[MOVE_FOUR];

		this.forme = forme;
		stats = new PokeStats(level, nature, this.forme.getAllBases(), ivs, evs);
		status = new PokeStatus();
		this.nature = nature;
		ability = Ability.NO_ABILITY;
		isShiny = false;
	}

	@Override
	public void setMove(Move move, int slot) {
		if (slot == MOVE_ONE) {
			move1 = new MoveWithPP(move);
		} else if (slot == MOVE_TWO) {
			move2 = new MoveWithPP(move);
		} else if (slot == MOVE_THREE) {
			move3 = new MoveWithPP(move);
		} else if (slot == MOVE_FOUR) {
			move4 = new MoveWithPP(move);
		} else if (slot == SWITCH_ONE) {
			switch1 = new MoveWithPP(move);
		} else if (slot == SWITCH_TWO) {
			switch2 = new MoveWithPP(move);
		} else if (slot == SWITCH_THREE) {
			switch3 = new MoveWithPP(move);
		} else if (slot == SWITCH_FOUR) {
			switch4 = new MoveWithPP(move);
		} else if (slot == SWITCH_FIVE) {
			switch5 = new MoveWithPP(move);
		}
	}

	@Override
	public int[] getEvs() {
		return stats.getEvs();
	}

	@Override
	public int[] getIvs() {
		return stats.getIvs();
	}

	@Override
	public int[] getBaseStats() {
		return stats.getBaseStats();
	}

	public InactivePokemon(Pokemon p) {
		stats = new PokeStats(p.getStats());
		forme = p.getSpecies();
		nickName = p.getNickName();
		ability = p.getAbility();
		stats.setEvs(p.getEvs());
		stats.setIvs(p.getIvs());
		status = p.getStatus();
		stats.setBaseStats(p.getBaseStats());

		gender = p.getGender();
		stats.setLevel(p.getLevel());
		nature = stats.getNature();

		item = p.getItem();

		move1 = p.getMove(MOVE_ONE);
		move2 = p.getMove(MOVE_TWO);
		move3 = p.getMove(MOVE_THREE);
		move4 = p.getMove(MOVE_FOUR);
		
		switch1 = p.getMove(SWITCH_ONE);
		switch2 = p.getMove(SWITCH_TWO);
		switch3 = p.getMove(SWITCH_THREE);
		switch4 = p.getMove(SWITCH_FOUR);
		switch5 = p.getMove(SWITCH_FIVE);
		
		isShiny = p.isShiny();
	}

	@Override
	public void setNature(Nature nature) {
		stats.setNature(nature);
	}

	public void setIvs(int hpIv, int atkIv, int defIv, int spAtkIv,
			int spDefIv, int spdIv) {
		stats.setHpIv(hpIv);
		stats.setAtkIv(atkIv);
		stats.setDefIv(defIv);
		stats.setSpAtkIv(spAtkIv);
		stats.setSpDefIv(spDefIv);
		stats.setSpeIv(spdIv);
	}

	public int getGen() {
		return gen;
	}

	public MoveWithPP getMove1() {
		return move1;
	}

	public MoveWithPP getMove2() {
		return move2;
	}

	public MoveWithPP getMove3() {
		return move3;
	}

	public MoveWithPP getMove4() {
		return move4;
	}

	@Override
	public MoveWithPP getMove(int slot) {
		MoveWithPP result = null;
		if (slot == MOVE_ONE) {
			result = move1;
		} else if (slot == MOVE_TWO) {
			result = move2;
		} else if (slot == MOVE_THREE) {
			result = move3;
		} else if (slot == MOVE_FOUR) {
			result = move4;
		} else if (slot == SWITCH_ONE) {
			result = switch1;
		} else if (slot == SWITCH_TWO) {
			result = switch2;
		} else if (slot == SWITCH_THREE) {
			result = switch3;
		} else if (slot == SWITCH_FOUR) {
			result = switch4;
		} else if (slot == SWITCH_FIVE) {
			result = switch5;
		}
		return result;
	}

	@Override
	public void setIvs(int newIvs[]) {
		stats.setHpIv(newIvs[HP]);
		stats.setAtkIv(newIvs[ATK]);
		stats.setDefIv(newIvs[DEF]);
		stats.setSpAtkIv(newIvs[SP_ATK]);
		stats.setSpDefIv(newIvs[SP_DEF]);
		stats.setSpeIv(newIvs[SPE]);
	}

	public void setEvs(int hpEv, int atkEv, int defEv, int spAtkEv,
			int spDefEv, int spdEv) {
		stats.setHpEv(hpEv);
		stats.setAtkEv(atkEv);
		stats.setDefEv(defEv);
		stats.setSpAtkEv(spAtkEv);
		stats.setSpDefEv(spDefEv);
		stats.setSpeEv(spdEv);
	}

	@Override
	public void setEvs(int newEvs[]) {
		stats.setEvs(newEvs);
	}

	@Override
	public void setHpEv(int hpEv) {
		stats.setHpEv(hpEv);
	}

	@Override
	public void setAtkEv(int atkEv) {
		stats.setAtkEv(atkEv);
	}

	@Override
	public void setDefEv(int defEv) {
		stats.setDefEv(defEv);
	}

	@Override
	public void setSpDefEv(int spDefEv) {
		stats.setSpDefEv(spDefEv);
	}

	@Override
	public void setSpeEv(int speEv) {
		stats.setSpeEv(speEv);
	}

	@Override
	public void setHpIv(int hpIv) {
		stats.setHpIv(hpIv);
	}

	@Override
	public void setLevel(int level) {
		stats.setLevel(level);
	}

	@Override
	public int getLevel() {
		return stats.getLevel();
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setSpecies(Species forme) {
		this.forme = forme;
		int[] baseStats = { forme.getHpBase(), forme.getAtkBase(),
				forme.getDefBase(), forme.getspAtkBase(), forme.getspDefBase(),
				forme.getspeBase() };
		stats.setBaseStats(baseStats);
	}

	@Override
	public boolean hasFainted() {
		return status.hasFainted();
	}

	@Override
	public void setNickName(String newNickName) {
		nickName = newNickName;
	}

	@Override
	public String getNickName() {
		return nickName;
	}

	@Override
	public int getHpIv() {
		return stats.getHpIv();
	}

	@Override
	public int getAtkIv() {
		return stats.getAtkIv();
	}

	@Override
	public int getDefIv() {
		return stats.getDefIv();
	}

	@Override
	public int getSpAtkIv() {
		return stats.getSpAtkIv();
	}

	@Override
	public int getSpDefIv() {
		return stats.getSpDefIv();
	}

	@Override
	public int getSpeIv() {
		return stats.getSpeIv();
	}

	@Override
	public int getHpEv() {
		return stats.getHpEv();
	}

	@Override
	public int getAtkEv() {
		return stats.getAtkEv();
	}

	@Override
	public int getDefEv() {
		return stats.getDefEv();
	}

	@Override
	public int getSpAtkEv() {
		return stats.getSpAtkEv();
	}

	@Override
	public int getSpDefEv() {
		return stats.getSpDefEv();
	}

	@Override
	public int getSpeEv() {
		return stats.getSpeEv();
	}

	public int getHPBase() {
		return stats.getHpBase();
	}

	@Override
	public int getAtkBase() {
		return stats.getAtkBase();
	}

	@Override
	public int getDefBase() {
		return stats.getDefBase();
	}

	@Override
	public int getSpAtkBase() {
		return stats.getSpAtkBase();
	}

	@Override
	public int getSpDefBase() {
		return stats.getSpDefBase();
	}

	@Override
	public int getSpeBase() {
		return stats.getSpeBase();
	}

	@Override
	public int getMaxHp() {
		return stats.getMaxHp();
	}

	@Override
	public void setShiny(boolean isShiny) {
		if (isShiny == true) {
			this.isShiny = true;
		} else {
			this.isShiny = false;
		}
	}

	public boolean getShiny() {
		return isShiny;
	}

	public int[] getCalcStats() {
		int[] result = new int[NUM_OF_STATS];
		result[HP] = stats.getCurrHp();
		result[ATK] = stats.getAtk();
		result[DEF] = stats.getDef();
		result[SP_ATK] = stats.getSpAtk();
		result[SP_DEF] = stats.getSpDef();
		result[SPE] = stats.getSpe();
		return result;
	}

	@Override
	public int getCurrHp() {
		return stats.getCurrHp();
	}

	@Override
	public Stats getStats() {
		return stats;
	}

	@Override
	public void setCurrHp(int newHp) {
		if (newHp <= 0) {
			stats.setCurrHp(0);
			status.setFainted();
		} else {
			stats.setCurrHp(newHp);
		}
	}

	@Override
	public void incrementToxCount() {
		status.incrementToxCount();
	}

	@Override
	public int getSleepDuration() {
		return status.getSleepDuration();
	}

	@Override
	public void decrementSleep() {
		status.decrementSleep();
	}

	@Override
	public int getInitialSleepDuration() {
		return status.getInitialSleepDuration();
	}

	@Override
	public double getAtkMod() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public double getSpeMod() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void cureStatus() {
		status.cureStatus();
	}

	@Override
	public boolean isBurnt() {
		return status.isBurnt();
	}

	@Override
	public boolean isAsleep() {
		return status.isAsleep();
	}

	@Override
	public boolean isParalyzed() {
		return status.isParalyzed();
	}

	@Override
	public boolean isOk() {
		return status.isOk();
	}

	@Override
	public boolean isRegPoison() {
		return status.isRegPoison();
	}

	@Override
	public boolean isToxPoison() {
		return status.isToxPoison();
	}

	@Override
	public boolean isFrozen() {
		return status.isFrozen();
	}

	@Override
	public void setSleep(int duration) {
		status.setSleep(duration);
	}

	@Override
	public boolean doesThaw() {
		return status.doesThaw();
	}

	@Override
	public void setToxPoison() {
		status.setToxPoison();
	}

	@Override
	public int getToxCount() {
		return status.getToxCount();
	}

	@Override
	public void setRegPoison() {
		status.setRegPoison();
	}

	@Override
	public void setParalysis() {
		status.setParalysis();
	}

	@Override
	public boolean doesFullyParalyze() {
		return status.doesFullyParalyze();
	}

	@Override
	public void setBaseStats(int[] baseStats) {
		stats.setBaseStats(baseStats);
	}

	@Override
	public void setHpBase(int hpBase) {
		stats.setHpBase(hpBase);
	}

	@Override
	public void setAtkBase(int atkBase) {
		stats.setAtkBase(atkBase);
	}

	@Override
	public void setDefBase(int defBase) {
		stats.setDefBase(defBase);
	}

	@Override
	public void setSpAtkBase(int spAtkBase) {
		stats.setSpAtkBase(spAtkBase);
	}

	@Override
	public void setSpDefBase(int spDefBase) {
		stats.setSpDefBase(spDefBase);
	}

	@Override
	public void setSpeBase(int speBase) {
		stats.setSpeBase(speBase);
	}

	@Override
	public int getHpBase() {
		return stats.getHpBase();
	}

	@Override
	public void setAtkIv(int atkIv) {
		stats.setAtkIv(atkIv);
	}

	@Override
	public void setDefIv(int defIv) {
		stats.setDefIv(defIv);
	}

	@Override
	public void setSpAtkIv(int spAtkIv) {
		stats.setSpAtkIv(spAtkIv);
	}

	@Override
	public void setSpDefIv(int spDefIv) {
		stats.setSpDefIv(spDefIv);
	}

	@Override
	public void setSpeIv(int speIv) {
		stats.setSpeIv(speIv);
	}

	@Override
	public Type getHiddenPowerType() {
		return stats.getHiddenPowerType();
	}

	@Override
	public void setStats(int[] stats) {
		this.stats.setStats(stats);
	}

	@Override
	public void setStats(Stats newStat) {
		stats.setStats(newStat);
	}

	@Override
	public void setStats(int hp, int atk, int def, int spAtk, int spDef, int spe) {
		stats.setStats(hp, atk, def, spAtk, spDef, spe);
	}

	@Override
	public Nature getNature() {
		return nature;
	}

	@Override
	public void setSpAtkEv(int spAtkEv) {
		stats.setSpAtkEv(spAtkEv);
	}

	@Override
	public int getAtk() {
		return stats.getAtk();
	}

	@Override
	public int getDef() {
		return stats.getDef();
	}

	@Override
	public int getSpAtk() {
		return stats.getSpAtk();
	}

	@Override
	public int getSpDef() {
		return stats.getSpDef();
	}

	@Override
	public int getSpe() {
		return stats.getSpe();
	}

	@Override
	public boolean isShiny() {
		return isShiny;
	}

	@Override
	public Species getSpecies() {
		return forme;
	}

	@Override
	public Type getFirstType() {
		return forme.getFirstType();
	}

	@Override
	public Type getSecondType() {
		return forme.getSecondType();
	}

	@Override
	public Status getStatus() {
		return status;
	}

	@Override
	public boolean isType(Type type) {
		return type.equals(getFirstType()) || type.equals(getSecondType());
	}

	@Override
	public String toString() {

		String s = forme + " @ " + item + "\n" + ability + "\n"
				+ stats.getHpEv() + "\n" + stats.getAtkEv() + "/"
				+ stats.getDefEv() + "/" + stats.getSpAtkEv() + "/"
				+ stats.getSpDefEv() + "/" + stats.getSpeEv() + "\n"
				+ stats.getNature() + "\n-" + move1 + "\n-" + move2 + "\n-"
				+ move3 + "\n-" + move4;
		return s;
	}

	@Override
	public String getStatAt(int position) {
		return stats.getStatAt(position);
	}

	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public void setFriendship(int friendship) {
		this.friendship = friendship;
	}

	@Override
	public int getFriendship() {
		return friendship;
	}

	@Override
	public boolean hasAbility(Ability ability) {
		return this.ability.equals(ability);
	}

	@Override
	public boolean isGender(Gender gender) {
		return this.gender.equals(gender);
	}

	@Override
	public boolean hasItem(Item item) {
		return this.item.equals(item);
	}

	@Override
	public boolean isSpecies(Species species) {
		return this.forme.equals(species);
	}
	
	public boolean isActivePokemon() {
		return isActivePokemon;
	}
	
	public void setAsActivePokemon() {
		isActivePokemon = true;
	}
	
	public void setAsInactivePokemon() {
		isActivePokemon = false;
	}
	
	public void damage(int damage) {
		if (stats.getCurrHp() > 0) {
			stats.setCurrHp(stats.getCurrHp() - damage);
		}
	}

	public void heal(int healing) {
		if (stats.getCurrHp() > 0) {
			stats.setCurrHp(stats.getCurrHp() + healing);
		}
		
	}

	@Override
	public boolean isGrounded() {
		return !isType(Type.FLYING) && !hasAbility(Ability.LEVITATE) || isGrounded;
	}
	
}