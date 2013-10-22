package com.omnidex.battlefield.team;

import java.util.ArrayList;
import java.util.List;

import com.omnidex.damage.EntryHazardDamage;
import com.omnidex.game.Game;
import com.omnidex.move.Move;
import com.omnidex.move.MoveWithPP;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.InactivePokemon;
import com.omnidex.pokemon.Pokemon;
import com.omnidexter.ai.AiWriter;

public class DeepTeam extends FieldScreen implements Team {
	private int teamId;
	private int choice;
	private ActivePokemon activePokemon;
	private List<InactivePokemon> party;
	private boolean hasStealthRocks;

	private int wishCount;
	private int wishHealAmount;
	private int mistCount;
	private int luckyChantCount;
	private int safeguardCount;
	private int spikesCount;
	private int toxicSpikesCount;
	private int tailwindCount;
	private boolean hasWaterSport;
	private boolean hasMudSport;

	private static final int MAX_NUM_SPIKE_LAYERS = 3;
	private static final int MAX_NUM_T_SPIKE_LAYERS = 2;

	private int teamSize = 0;

	public DeepTeam() {
		super();
		party = new ArrayList<InactivePokemon>();
		hasStealthRocks = false;
		tailwindCount = 0;
		luckyChantCount = 0;
		safeguardCount = 0;
		mistCount = 0;
		spikesCount = 0;
		toxicSpikesCount = 0;
		teamId = Game.OPPONENT;
		choice = 0;
	}

	public DeepTeam(Team team) {
		super(team);
		party = new ArrayList<InactivePokemon>();
		activePokemon = team.getActivePokemon();
		List<InactivePokemon> temp = team.getParty();
		for (int i = 0; i < temp.size(); i++) {
			party.add(temp.get(i));
		}
		hasStealthRocks = team.hasStealthRocks();
		spikesCount = team.getSpikesCount();
		toxicSpikesCount = team.getToxicSpikesCount();
		teamSize = team.teamSize();
		choice = team.getChoice();
		teamId = team.getTeamId();
	}

	@Override
	public void addTeamMate(Pokemon poke) {
		assignSwitchingOptions(poke);
		
		if (activePokemon == null) {
			activePokemon = new ActivePokemon(poke);
		} 
		
		if (party.size() < 6) {
			
			party.add(new InactivePokemon(poke));
			if (party.size() == 1) {
				party.get(0).setAsActivePokemon();
			} else {
				party.get(party.size()-1).setAsInactivePokemon();
			}
			teamSize++;
		}
	}

	@Override
	public int size() {
		return party.size();
	}

	@Override
	public ActivePokemon getActivePokemon() {
		return activePokemon;
	}

	@Override
	public void switchActivePokemon(MoveWithPP switchOption) {

		Move switchTo = switchOption.getMove();
		
		activePokemon.setSleep(activePokemon.getInitialSleepDuration());

		switch (switchTo) {
		case SWITCH_1:
			activePokemon = new ActivePokemon(party.get(0));
			break;
		case SWITCH_2:
			activePokemon = new ActivePokemon(party.get(1));
			break;
		case SWITCH_3:
			activePokemon = new ActivePokemon(party.get(2));
			break;
		case SWITCH_4:
			activePokemon = new ActivePokemon(party.get(3));
			break;
		case SWITCH_5:
			activePokemon = new ActivePokemon(party.get(4));
			break;
		case SWITCH_6:
			activePokemon = new ActivePokemon(party.get(5));
			break;
		default:
			break;
		}
		AiWriter.writeSwitch(activePokemon, teamId);
		EntryHazardDamage.applyToxicSpikes(this);
		EntryHazardDamage.applySpikeDamage(this);
		EntryHazardDamage.applyStealthRocks(this);
	}

	@Override
	public List<InactivePokemon> getParty() {
		return party;
	}

	@Override
	public boolean hasStealthRocks() {
		return hasStealthRocks;
	}

	@Override
	public boolean hasSpikes() {
		return spikesCount > 0;
	}

	@Override
	public boolean hasToxicSpikes() {
		return toxicSpikesCount > 0;
	}

	@Override
	public void addSpikes() {
		if (spikesCount < MAX_NUM_SPIKE_LAYERS) {
			spikesCount++;
		}
	}

	@Override
	public void addToxicSpikes() {
		if (toxicSpikesCount < MAX_NUM_T_SPIKE_LAYERS) {
			toxicSpikesCount++;
		}
	}

	@Override
	public int getSpikesCount() {
		return spikesCount;
	}

	@Override
	public int getToxicSpikesCount() {
		return toxicSpikesCount;
	}

	@Override
	public void removeStealthRocks() {
		hasStealthRocks = false;
	}

	@Override
	public void removeSpikes() {
		spikesCount = 0;
	}

	@Override
	public void removeToxicSpikes() {
		toxicSpikesCount = 0;
	}

	@Override
	public void addStealthRocks() {
		hasStealthRocks = true;
	}

	@Override
	public boolean hasMist() {
		return mistCount > 0;
	}

	@Override
	public int getMistCount() {
		return mistCount;
	}

	@Override
	public boolean hasSafeguard() {
		return safeguardCount > 0;
	}

	@Override
	public int getSafeguardCount() {
		return safeguardCount;
	}

	@Override
	public boolean hasLuckyChant() {
		return luckyChantCount > 0;
	}

	@Override
	public int getLuckyChantCount() {
		return luckyChantCount;
	}

	@Override
	public void addMist(int duration) {
		mistCount = duration;
	}

	@Override
	public void decrementMist() {
		if (mistCount > 0) {
			mistCount--;
		}
	}

	@Override
	public void addLuckyChant(int duration) {
		luckyChantCount = duration;
	}

	@Override
	public void decrementLuckyChant() {
		if (luckyChantCount > 0) {
			luckyChantCount--;
		}
	}

	@Override
	public void addSafeguard(int duration) {
		safeguardCount = duration;
	}

	@Override
	public void decrementSafeguard() {
		if (safeguardCount > 0) {
			safeguardCount--;
		}
	}

	@Override
	public boolean hasWish() {
		return wishCount > 0;
	}

	@Override
	public void addWish(int duration, int wishHealAmount) {
		wishCount = duration;
		this.wishHealAmount = wishHealAmount;
	}

	@Override
	public void decrementWishCount() {
		if (wishCount > 0) {
			wishCount--;
			if (wishCount == 0) {
				activePokemon.heal(wishHealAmount);
				wishHealAmount = 0;
			}
		}
	}

	@Override
	public int teamSize() {
		return teamSize;
	}

	@Override
	public void addTailWind() {
		tailwindCount = 3;
	}

	@Override
	public int getTailWindCount() {
		return tailwindCount;
	}

	@Override
	public void decrementTailWind() {
		if (tailwindCount > 0) {
			tailwindCount--;
		}
	}

	@Override
	public boolean hasTailWind() {
		return tailwindCount > 0;
	}

	@Override
	public void setChoice(int choice) {
		this.choice = choice;
	}

	@Override
	public int getChoice() {
		return choice;
	}

	@Override
	public int getTeamId() {
		return teamId;
	}

	@Override
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	@Override
	public boolean hasMudSport() {
		return hasMudSport;
	}

	@Override
	public void setMudSport(boolean state) {
		hasMudSport = state;
	}

	@Override
	public boolean hasWaterSport() {
		return hasWaterSport;
	}

	@Override
	public void setWaterSport(boolean state) {
		hasWaterSport = state;
	}

	@Override
	public boolean canSwitch(MoveWithPP switchOption, Team opponent) {

		if (opponent.getActivePokemon().getAbility()
				.preventsSwitching(activePokemon)) {
			return false;
		}

		Move switchTo = switchOption.getMove();
		Pokemon pokeToSwitchIn = null;
		switch (switchTo) {
		case SWITCH_1:
			pokeToSwitchIn = party.get(0);
			break;
		case SWITCH_2:
			pokeToSwitchIn = party.get(1);
			break;
		case SWITCH_3:
			pokeToSwitchIn = party.get(2);
			break;
		case SWITCH_4:
			pokeToSwitchIn = party.get(3);
			break;
		case SWITCH_5:
			pokeToSwitchIn = party.get(4);
			break;
		case SWITCH_6:
			pokeToSwitchIn = party.get(5);
			break;
		default:
			break;
		}
		if (!pokeToSwitchIn.hasFainted()) {
			return true;
		} else {
			return false;
		}
	}
	
	private void assignSwitchingOptions(Pokemon poke) {
		switch(party.size()) {
		case 0:
			poke.setMove(Move.SWITCH_2, Pokemon.SWITCH_ONE);
			poke.setMove(Move.SWITCH_3, Pokemon.SWITCH_TWO);
			poke.setMove(Move.SWITCH_4, Pokemon.SWITCH_THREE);
			poke.setMove(Move.SWITCH_5, Pokemon.SWITCH_FOUR);
			poke.setMove(Move.SWITCH_6, Pokemon.SWITCH_FIVE);
			break;
		case 2:
			poke.setMove(Move.SWITCH_1, Pokemon.SWITCH_ONE);
			poke.setMove(Move.SWITCH_3, Pokemon.SWITCH_TWO);
			poke.setMove(Move.SWITCH_4, Pokemon.SWITCH_THREE);
			poke.setMove(Move.SWITCH_5, Pokemon.SWITCH_FOUR);
			poke.setMove(Move.SWITCH_6, Pokemon.SWITCH_FIVE);
			break;
		case 3:
			poke.setMove(Move.SWITCH_1, Pokemon.SWITCH_ONE);
			poke.setMove(Move.SWITCH_2, Pokemon.SWITCH_TWO);
			poke.setMove(Move.SWITCH_4, Pokemon.SWITCH_THREE);
			poke.setMove(Move.SWITCH_5, Pokemon.SWITCH_FOUR);
			poke.setMove(Move.SWITCH_6, Pokemon.SWITCH_FIVE);
			break;
		case 4:
			poke.setMove(Move.SWITCH_1, Pokemon.SWITCH_ONE);
			poke.setMove(Move.SWITCH_2, Pokemon.SWITCH_TWO);
			poke.setMove(Move.SWITCH_3, Pokemon.SWITCH_THREE);
			poke.setMove(Move.SWITCH_5, Pokemon.SWITCH_FOUR);
			poke.setMove(Move.SWITCH_6, Pokemon.SWITCH_FIVE);
			break;
		case 5:
			poke.setMove(Move.SWITCH_1, Pokemon.SWITCH_ONE);
			poke.setMove(Move.SWITCH_2, Pokemon.SWITCH_TWO);
			poke.setMove(Move.SWITCH_3, Pokemon.SWITCH_THREE);
			poke.setMove(Move.SWITCH_4, Pokemon.SWITCH_FOUR);
			poke.setMove(Move.SWITCH_6, Pokemon.SWITCH_FIVE);
			break;
			default:
		}
	}
	
}
