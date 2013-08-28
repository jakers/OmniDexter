package com.omnidex.damage;

import com.omnidex.ability.Ability;
import com.omnidex.battlefield.team.Team;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.type.Type;
import com.omnidex.type.TypeChart;

public class EntryHazardDamage {

	private static double FOUR_TIMES_WEAK = 4.0;
	private static double TWO_TIMES_WEAK = 2.0;
	private static double NEUTRAL = 1.0;
	private static double TWO_TIMES_RESIST = 0.5;

	/**
	 * This method applies appropriate
	 * 
	 * @param team
	 *            the team making its spikes check
	 */
	public static void applySpikeDamage(Team team) {
		int spikeCount = team.getSpikesCount();
		Pokemon poke = team.getActivePokemon();
		
		if (team.hasSpikes() && !poke.hasAbility(Ability.LEVITATE)
				&& !poke.isType(Type.FLYING)
				&& !poke.hasAbility(Ability.MAGIC_GUARD)) {
			if (spikeCount == 1) {
				PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_EIGHTH);
			} else if (spikeCount == 2) {
				PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_SIXTH);
			} else if (spikeCount == 3) {
				PokemonMath
						.applyFractionalDamage(poke, PokemonMath.ONE_QUARTER);
			}
		}
	}

	public static void applyToxicSpikes(Team team) {
		Pokemon poke = team.getActivePokemon();
		if (poke.isType(Type.POISON) && !poke.hasAbility(Ability.LEVITATE) 
			&& !poke.isType(Type.FLYING)) {
			team.removeToxicSpikes();
		} else if (team.hasToxicSpikes() && !poke.isType(Type.STEEL)
				&& !poke.isType(Type.FLYING) && poke.isOk()) {
			if (team.getToxicSpikesCount() == 1) {
				poke.setRegPoison();
			} else {
				poke.setToxPoison();
			}
		}
	}

	public static void applyStealthRocks(Team team) {
		if (team.hasStealthRocks()) {
			Pokemon poke = team.getActivePokemon();
			TypeChart tc = new TypeChart();
			double mod = tc.getWeaknessResistance(Type.ROCK,
					poke.getFirstType(), poke.getSecondType());
			if (mod == FOUR_TIMES_WEAK) {
				PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_HALF);
			} else if (mod == TWO_TIMES_WEAK) {
				PokemonMath
						.applyFractionalDamage(poke, PokemonMath.ONE_QUARTER);
			} else if (mod == NEUTRAL) {
				PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_EIGHTH);
			} else if (mod == TWO_TIMES_RESIST) {
				PokemonMath.applyFractionalDamage(poke,
						PokemonMath.ONE_SIXTEENTH);
			} else {
				PokemonMath.applyFractionalDamage(poke,
						PokemonMath.ONE_THIRTY_SECOND);
			}
		}
	}
}
