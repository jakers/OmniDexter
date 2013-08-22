package com.omnidex.battlefield.team;

import java.util.List;

import com.omnidex.move.MoveWithPP;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Pokemon;

/**
 * An interface that promises the behaviors of a team
 * 
 * @author jakers
 */
public interface Team extends Screen {
	/**
	 * @return an int representing the number of Pokemon in the team
	 */
	int teamSize();

	/**
	 * @return true if the team has stealth rocks on their side of the field
	 */
	boolean hasStealthRocks();

	/**
	 * @return true if the team has spikes on their side of the field
	 */
	boolean hasSpikes();

	/**
	 * @return true if the team has toxic spikes on their side of the field
	 */
	boolean hasToxicSpikes();

	/**
	 * @return true if the team has mist on their side of the field
	 */
	boolean hasMist();

	/**
	 * @return the number of turns Mist has remaining
	 */
	int getMistCount();

	/**
	 * @return true if the team has safeguard
	 */
	boolean hasSafeguard();

	/**
	 * @return the number of turns safeguard has left
	 */
	int getSafeguardCount();

	/**
	 * @return true if the team has lucky chant
	 */
	boolean hasLuckyChant();

	/**
	 * 
	 * @return the number of turns left for lucky chant
	 */
	int getLuckyChantCount();

	// TODO Comment interface methods
	void setMist(boolean state);

	void addMist(int duration);

	void decrementMist();

	void setLuckyChant(boolean state);

	void addLuckyChant(int duration);

	void decrementLuckyChant();

	void setSafeguard(boolean state);

	void addSafeguard(int duration);

	void decrementSafeguard();

	boolean hasWish();

	void addWish(int duration, int wishHealAmount);

	void decrementWishCount();

	void removeStealthRocks();

	void removeSpikes();

	void removeToxicSpikes();

	void addSpikes();

	void addToxicSpikes();

	void addStealthRocks();

	int getSpikesCount();

	int getToxicSpikesCount();

	void addTeamMate(Pokemon p);

	void addTailWind();

	int getTailWindCount();

	void decrementTailWind();

	boolean hasTailWind();

	/**
	 * @return the total size of the party
	 */
	int size();

	/**
	 * @return the pokemon that is currently active
	 */
	ActivePokemon getActivePokemon();

	/**
	 * Switches the Pokemon at the position with the current active Pokemon
	 * 
	 * @param position
	 *            the position of the Pokemon
	 */
	void switchActivePokemon(MoveWithPP switchOption);
	
	boolean canSwitch(MoveWithPP switchOption, Team opponent);
	

	/**
	 * @return a list of the Pokemon that are in the party
	 */
	List<Pokemon> getParty();
	
	void setChoice(int choice);
	
	int getChoice();
	
	boolean hasMudSport();
	void setMudSport(boolean state);
	boolean hasWaterSport();
	void setWaterSport(boolean state);
	
	int getTeamId();
	void setTeamId(int teamId);
}
