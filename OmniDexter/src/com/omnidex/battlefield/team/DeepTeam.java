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
	private MoveWithPP choice;
	private ActivePokemon activePokemon;
	private List<ActivePokemon> party;
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
		party = new ArrayList<ActivePokemon>();
		hasStealthRocks = false;
		tailwindCount = 0;
		luckyChantCount = 0;
		safeguardCount = 0;
		mistCount = 0;
		spikesCount = 0;
		toxicSpikesCount = 0;
		teamId = Game.OPPONENT;
		choice = new MoveWithPP(Move.NONE);
	}

	public DeepTeam(Team team) {
		super(team);
		party = new ArrayList<ActivePokemon>();
				
		for (int i = 0; i < team.size(); i++) {
			party.add(new ActivePokemon(team.getParty().get(i)));
			if (party.get(i).isActivePokemon()) {
				activePokemon = party.get(i);
			}
		}
		
		hasStealthRocks = team.hasStealthRocks();
		spikesCount = team.getSpikesCount();
		toxicSpikesCount = team.getToxicSpikesCount();
		teamSize = team.teamSize();
		choice = team.getChoice();
		teamId = team.getTeamId();
	}

	@Override
	public void addTeamMate(ActivePokemon poke) {

		if (activePokemon == null) {
			activePokemon = poke;
		}

		if (party.size() < 6) {

			party.add(poke);
			if (party.size() == 1) {
				party.get(0).setAsActivePokemon();
			} else {
				party.get(party.size() - 1).setAsInactivePokemon();
			}
			teamSize++;
		}
	}

	public boolean isValidSwitch(Move switchOption) {
		switch (switchOption) {
		case SWITCH_1:
			return isPokemonHealthyAndNotActive(0);
		case SWITCH_2:
			return isPokemonHealthyAndNotActive(1);
		case SWITCH_3:
			return isPokemonHealthyAndNotActive(2);
		case SWITCH_4:
			return isPokemonHealthyAndNotActive(3);
		case SWITCH_5:
			return isPokemonHealthyAndNotActive(4);
		case SWITCH_6:
			return isPokemonHealthyAndNotActive(5);
		default:
			return false;
		}
	}

	private boolean isPokemonHealthyAndNotActive(int index) {
		return index < party.size() && !party.get(index).hasFainted()
				&& !party.get(index).isActivePokemon();
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

		if (switchOption != null) {
			Move switchTo = switchOption.getMove();

			activePokemon.setSleep(activePokemon.getInitialSleepDuration());

			if (isValidSwitch(switchTo)) {
				activePokemon.setAsInactivePokemon();
				switch (switchTo) {
				case SWITCH_1:
					activePokemon = party.get(0);
					break;
				case SWITCH_2:
					activePokemon = party.get(1);
					break;
				case SWITCH_3:
					activePokemon = party.get(2);
					break;
				case SWITCH_4:
					activePokemon = party.get(3);
					break;
				case SWITCH_5:
					activePokemon = party.get(4);
					break;
				case SWITCH_6:
					activePokemon = party.get(5);
					break;
				default:
					break;
				}
				activePokemon.setAsActivePokemon();
				AiWriter.writeSwitch(activePokemon, teamId);
				EntryHazardDamage.applyToxicSpikes(this);
				EntryHazardDamage.applySpikeDamage(this);
				EntryHazardDamage.applyStealthRocks(this);
			}
		}
	}

	@Override
	public List<ActivePokemon> getParty() {
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
	public void setChoice(MoveWithPP choice) {
		this.choice = choice;
	}

	@Override
	public MoveWithPP getChoice() {
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

	@Override
	public boolean[] getValidSwitch() {
		// TODO Auto-generated method stub
		boolean validSwitches[] = new boolean[party.size()];
		int i = 0;
		for (InactivePokemon p : party) {
			if (!p.hasFainted() && !p.isActivePokemon()) {
				validSwitches[i] = true;
			} else {
				validSwitches[i] = false;
			}
		}
		return validSwitches;
	}

	@Override
	public List<MoveWithPP> getAllChoices() {
		List<MoveWithPP> choices = new ArrayList<MoveWithPP>();
		for (int i = 0; i < 4; i++) {
			addMoveIfUseable(choices, i);
		}
		
		if (isValidSwitch(Move.SWITCH_1)) {
			choices.add(new MoveWithPP(Move.SWITCH_1));
		}
		if (isValidSwitch(Move.SWITCH_2)) {
			choices.add(new MoveWithPP(Move.SWITCH_2));
		}
		if (isValidSwitch(Move.SWITCH_3)) {
			choices.add(new MoveWithPP(Move.SWITCH_3));
		}
		if (isValidSwitch(Move.SWITCH_4)) {
			choices.add(new MoveWithPP(Move.SWITCH_4));
		}
		if (isValidSwitch(Move.SWITCH_5)) {
			choices.add(new MoveWithPP(Move.SWITCH_5));
		}
		if (isValidSwitch(Move.SWITCH_6)) {
			choices.add(new MoveWithPP(Move.SWITCH_6));
		}

		return choices;
	}

	private void addMoveIfUseable(List<MoveWithPP> choices, int index) {
		if (activePokemon.getMove(index) != null
				&& activePokemon.getMove(index).getCurrPP() > 0) {
			choices.add(activePokemon.getMove(index));
		} 
	}
}
