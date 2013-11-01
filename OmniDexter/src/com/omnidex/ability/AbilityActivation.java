package com.omnidex.ability;

import com.omnidex.damage.MathUtils;
import com.omnidex.item.Item;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.pokemon.Species;
import com.omnidex.weather.Weather;

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
	
	public static void activateDrizzle(Pokemon poke, Weather weather) {
		if (poke.hasAbility(Ability.DRIZZLE)) {
			if (poke.hasItem(Item.DAMP_ROCK)) {
				weather.setRain(Weather.DUR_8);
			} else {
				weather.setRain(Weather.DUR_5);
			}
		}
	}
	
	
	public static void activateForecast(Pokemon poke, Weather weather) {
		if (poke.isSpecies(Species.CASTFORM) && poke.hasAbility(Ability.ADAPTABILITY)) {
			if (weather.isRain()) {
				poke.setSpecies(Species.CASTFORM_RAIN);
			} else if (weather.isSun()) {
				poke.setSpecies(Species.CASTFORM_SUNNY);
			} else if (weather.isHail()) {
				poke.setSpecies(Species.CASTFORM_HAIL);
			}
		}
	}

	public static void activateDrought(ActivePokemon poke, Weather weather) {
		if (poke.hasAbility(Ability.DROUGHT)) {
			if (poke.hasItem(Item.HEAT_ROCK)) {
				weather.setSun(Weather.DUR_8);
			} else {
				weather.setSun(Weather.DUR_5);
			}
		}
	}

	public static void activateSandStream(ActivePokemon poke,
			Weather weather) {
		if (poke.hasAbility(Ability.SAND_STREAM)) {
			if (poke.hasItem(Item.SMOOTH_ROCK)) {
				weather.setSand(Weather.DUR_8);
			} else {
				weather.setSand(Weather.DUR_5);
			}
		}
	}

	public static void activateSnowWarning(ActivePokemon poke,
			Weather weather) {
		if (poke.hasAbility(Ability.SNOW_WARNING)) {
			if (poke.hasItem(Item.ICY_ROCK)) {
				weather.setHail(Weather.DUR_8);
			} else {
				weather.setHail(Weather.DUR_5);
			}
		}
	}
	
}
