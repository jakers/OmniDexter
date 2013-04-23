package com.omnidex.battlefield.team;

import java.util.*;


import com.omnidex.damage.EntryHazardDamage;
import com.omnidex.game.Game;
import com.omnidex.pokemon.DeepPokemon;
import com.omnidex.pokemon.Pokemon;
import com.omnidexter.ai.AiWriter;

public class DeepTeam extends FieldScreen implements Team {
	private int teamId;
	private int choice;
	private Pokemon activePokemon;
	private Deque<Pokemon> party;
	private boolean hasStealthRocks;
	private boolean hasSpikes;
	private boolean hasToxicSpikes;
	private boolean hasMist;
	private boolean hasLuckyChant;
	private boolean hasSafeguard;
	private boolean hasWish;
	private int wishCount;
	private int wishHealAmount;
	private int mistCount;
	private int luckyChantCount;
	private int safeguardCount;
	private int spikesCount;
	private int toxicSpikesCount;
	private int tailwindCount;
	private boolean hasTailwind;
	private boolean hasWaterSport;
	private boolean hasMudSport;

	private static final int MAX_NUM_SPIKE_LAYERS = 3;
	private static final int MAX_NUM_T_SPIKE_LAYERS = 2;

	private int teamSize = 0;

	public DeepTeam() {
		super();
		party = new ArrayDeque<Pokemon>();
		hasStealthRocks = false;
		hasSpikes = false;
		hasToxicSpikes = false;
		hasLuckyChant = false;
		hasSafeguard = false;
		hasMist = false;
		hasTailwind = false;
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
		party = new ArrayDeque<Pokemon>();
		activePokemon = new DeepPokemon(team.getActivePokemon());
		List<Pokemon> temp = team.getParty();
		for (int i = 0; i < temp.size(); i++) {
			party.add(temp.get(i));
		}
		hasStealthRocks = team.hasStealthRocks();
		hasSpikes = team.hasSpikes();
		hasToxicSpikes = team.hasToxicSpikes();
		spikesCount = team.getSpikesCount();
		toxicSpikesCount = team.getToxicSpikesCount();
		teamSize = team.teamSize();
		choice = team.getChoice();
		teamId = team.getTeamId();
	}

	@Override
	public void addTeamMate(Pokemon p) {
		if (activePokemon == null) {
			activePokemon = new DeepPokemon(p);
		} else {
			party.add(new DeepPokemon(p));
		}
		teamSize++;
	}

	@Override
	public int size() {
		if (activePokemon == null) {
			return 0;
		} else {
			return 1 + party.size();
		}
	}

	@Override
	public Pokemon getActivePokemon() {
		return activePokemon;
	}

	@Override
	public void switchActivePokemon(int position) {
		if (position < 0) {
			position = -position;
			position--;
		}
		
		for (int i = 0; i < position; i++) {
			party.add(party.pop());
		}

		// add poke back only if it still has
		// HP
		if (!activePokemon.hasFainted()) {
			party.add(activePokemon);
		}
		activePokemon = party.pop();
		
		AiWriter.writeSwitch(activePokemon, teamId);
		activePokemon.setSleep(activePokemon.getInitialSleepDuration());
		EntryHazardDamage.applyToxicSpikes(this);
		EntryHazardDamage.applySpikeDamage(this);
		EntryHazardDamage.applyStealthRocks(this);
	}

	@Override
	public List<Pokemon> getParty() {
		List<Pokemon> result = new ArrayList<Pokemon>();
		for (int i = 0; i < party.size(); i++) {
			result.add(new DeepPokemon(party.peek()));
			party.add(party.pop());
		}
		return result;
	}

	@Override
	public boolean hasStealthRocks() {
		return hasStealthRocks;
	}

	@Override
	public boolean hasSpikes() {
		return hasSpikes;
	}

	@Override
	public boolean hasToxicSpikes() {
		return hasToxicSpikes;
	}

	@Override
	public void addSpikes() {
		if (spikesCount < MAX_NUM_SPIKE_LAYERS) {
			hasSpikes = true;
			spikesCount++;
		}
	}

	@Override
	public void addToxicSpikes() {
		if (toxicSpikesCount < MAX_NUM_T_SPIKE_LAYERS) {
			hasToxicSpikes = true;
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
		hasSpikes = false;
		spikesCount = 0;
	}

	@Override
	public void removeToxicSpikes() {
		hasToxicSpikes = false;
		toxicSpikesCount = 0;
	}

	@Override
	public void addStealthRocks() {
		hasStealthRocks = true;
	}

	@Override
	public boolean hasMist() {
		return hasMist;
	}

	@Override
	public int getMistCount() {
		return mistCount;
	}

	@Override
	public boolean hasSafeguard() {
		return hasSafeguard;
	}

	@Override
	public int getSafeguardCount() {
		return safeguardCount;
	}

	@Override
	public boolean hasLuckyChant() {
		return hasLuckyChant;
	}

	@Override
	public int getLuckyChantCount() {
		return luckyChantCount;
	}

	@Override
	public void setMist(boolean state) {
		hasMist = state;
		if (!hasMist) {
			mistCount = 0;
		}
	}

	@Override
	public void addMist(int duration) {
		hasMist = true;
		mistCount = duration;
	}

	@Override
	public void decrementMist() {
		if (mistCount > 0) {
			mistCount--;
			if (mistCount == 0) {
				hasMist = false;
			}
		}
	}

	@Override
	public void setLuckyChant(boolean state) {
		hasLuckyChant = state;
		if (!hasLuckyChant) {
			luckyChantCount = 0;
		}
	}

	@Override
	public void addLuckyChant(int duration) {
		hasLuckyChant = true;
		luckyChantCount = duration;
	}

	@Override
	public void decrementLuckyChant() {
		if (luckyChantCount > 0) {
			luckyChantCount--;
			if (luckyChantCount == 0) {
				hasLuckyChant = false;
			}
		}
	}

	@Override
	public void setSafeguard(boolean state) {
		hasSafeguard = state;
		if (!hasSafeguard) {
			safeguardCount = 0;
		}
	}

	@Override
	public void addSafeguard(int duration) {
		hasSafeguard = true;
		safeguardCount = duration;
	}

	@Override
	public void decrementSafeguard() {
		if (safeguardCount > 0) {
			safeguardCount--;
			if (safeguardCount == 0) {
				hasSafeguard = false;
			}
		}
	}

	@Override
	public boolean hasWish() {
		return hasWish;
	}

	@Override
	public void addWish(int duration, int wishHealAmount) {
		hasWish = true;
		wishCount = duration;
		this.wishHealAmount = wishHealAmount;
	}

	@Override
	public void decrementWishCount() {
		if (wishCount > 0) {
			wishCount--;
			if (wishCount == 0) {
				hasWish = false;
				activePokemon.setCurrHp(activePokemon.getCurrHp()+wishHealAmount);
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
		hasTailwind = true;
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
			if (tailwindCount == 0) {
				// TODO find correct statement
				System.out.println("The tailwind pettered out!");
			}
		}
	}

	@Override
	public boolean hasTailWind() {
		return hasTailwind;
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

	
}
