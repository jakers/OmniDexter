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

	public static void applySpikeDamage(Team team) {
		int spikeCount = team.getSpikesCount();
		Pokemon poke = team.getActivePokemon();

		if (isAffectedBySpikes(team)) {
			if (spikeCount == 1) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_EIGHTH);
			} else if (spikeCount == 2) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_SIXTH);
			} else if (spikeCount == 3) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_QUARTER);
			}
		}
	}

	private static boolean isAffectedBySpikes(Team team) {
		Pokemon poke = team.getActivePokemon();
		return team.hasSpikes() && poke.isGrounded()
				&& !poke.hasAbility(Ability.MAGIC_GUARD);
	}

	public static void applyToxicSpikes(Team team) {
		Pokemon poke = team.getActivePokemon();
		if (poke.isType(Type.POISON) && poke.isGrounded()) {
			team.removeToxicSpikes();
		} else if (isAffectedByToxicSpikes(team)) {
			if (team.getToxicSpikesCount() == 1) {
				poke.setRegPoison();
			} else if (team.getToxicSpikesCount() == 2){
				poke.setToxPoison();
			}
		}
	}

	private static boolean isAffectedByToxicSpikes(Team team) {
		Pokemon poke = team.getActivePokemon();
		return poke.isGrounded() && team.hasToxicSpikes() && !poke.isType(Type.STEEL) && poke.isOk()
				&& !poke.hasAbility(Ability.MAGIC_GUARD);
	}

	public static void applyStealthRocks(Team team) {
		if (team.hasStealthRocks()) {
			Pokemon poke = team.getActivePokemon();
			TypeChart tc = new TypeChart();
			double mod = tc.getWeaknessResistance(Type.ROCK,
					poke.getFirstType(), poke.getSecondType());
			if (mod == FOUR_TIMES_WEAK) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_HALF);
			} else if (mod == TWO_TIMES_WEAK) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_QUARTER);
			} else if (mod == NEUTRAL) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_EIGHTH);
			} else if (mod == TWO_TIMES_RESIST) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_SIXTEENTH);
			} else {
				MathUtils.passiveDamage(poke, MathUtils.ONE_THIRTY_SECOND);
			}
		}
	}
}
