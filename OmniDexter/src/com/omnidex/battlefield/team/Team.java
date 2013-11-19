package com.omnidex.battlefield.team;

import java.util.List;

import com.omnidex.move.MoveWithPP;
import com.omnidex.pokemon.ActivePokemon;

public interface Team extends Screen {

	int teamSize();

	boolean hasStealthRocks();

	boolean hasSpikes();

	boolean hasToxicSpikes();

	boolean hasMist();

	int getMistCount();

	boolean hasSafeguard();

	int getSafeguardCount();

	boolean hasLuckyChant();

	int getLuckyChantCount();


	void addMist(int duration);

	void decrementMist();

	void addLuckyChant(int duration);

	void decrementLuckyChant();

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

	void addTeamMate(ActivePokemon p);

	void addTailWind();

	int getTailWindCount();

	void decrementTailWind();

	boolean hasTailWind();
	int size();

	ActivePokemon getActivePokemon();

	void switchActivePokemon(MoveWithPP switchOption);
	
	boolean canSwitch(MoveWithPP switchOption, Team opponent);
	
	List<ActivePokemon> getParty();
	
	void setChoice(MoveWithPP choice);
	
	MoveWithPP getChoice();
	
	boolean hasMudSport();
	void setMudSport(boolean state);
	boolean hasWaterSport();
	void setWaterSport(boolean state);
	
	int getTeamId();
	void setTeamId(int teamId);
	boolean[] getValidSwitch();
	List<MoveWithPP> getAllChoices();
}
