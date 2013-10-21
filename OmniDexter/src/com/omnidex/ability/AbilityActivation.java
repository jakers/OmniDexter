package com.omnidex.ability;

import java.util.Random;

import com.omnidex.damage.MathUtils;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Pokemon;

public class AbilityActivation {

	public static void activateSpeedBoost(ActivePokemon poke) {
		if (poke.hasAbility(Ability.SPEED_BOOST)) {
			poke.boostSpeedStage(1);
		}
	}
	
	public static void activateShedSkin(ActivePokemon poke) {
		if (poke.hasAbility(Ability.SHED_SKIN) && !poke.hasFainted()) {
			if (MathUtils.eventOccursWithProb(MathUtils.ONE_THIRD)) {
				poke.cureStatus();
			}
		}
	}

	public static void applyBadDreams(Pokemon dreamer, Pokemon badDream) {
		if (!badDream.hasFainted() && dreamer.isAsleep()
				&& badDream.hasAbility(Ability.BAD_DREAMS)) {
			MathUtils.passiveDamage(dreamer, MathUtils.ONE_EIGHTH);
		}
	}
	
	
	
	public static void activateDownload(ActivePokemon switchIn, ActivePokemon opponent) {
		int def = opponent.getCurrDef();
		int spDef = opponent.getCurrSpDef();
		
		if (def < spDef) {
			switchIn.boostAttackStage(1);
		} else {
			switchIn.boostSpAtkStage(1);
		}
	}
	
	public static void activateDownload(ActivePokemon switchIn, ActivePokemon opponentA, ActivePokemon opponentB) {
		int def = opponentA.getCurrDef() + opponentB.getCurrDef();
		int spDef = opponentA.getCurrSpDef() + opponentB.getCurrSpDef();

		if (def < spDef) {
			switchIn.boostAttackStage(1);
		} else {
			switchIn.boostSpAtkStage(1);
		}
	}
	
}
