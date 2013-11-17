package com.omnidex.damage;

import com.omnidex.ability.Ability;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.type.Type;
import com.omnidex.weather.Weather;

public class WeatherDamage {

	public static void applyDamagingWeather(Weather weather, ActivePokemon poke) {
		if (!poke.hasAbility(Ability.OVERCOAT)
				&& !poke.hasAbility(Ability.MAGIC_GUARD)) {
			applySandstormDamage(weather, poke);
			applyHailDamage(weather, poke);
			applySunDamage(weather,poke);
		}
	}

	private static void applySandstormDamage(Weather field, ActivePokemon poke) {
		if (field.isSand()) {
			if (!isImmuneToSandStorm(poke)) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_SIXTEENTH);
			}
		}
	}

	private static void applyHailDamage(Weather field, ActivePokemon poke) {
		if (field.isHail()) {
			if (!isImmuneToHail(poke)) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_SIXTEENTH);
			}
		}
	}

	private static void applySunDamage(Weather field, ActivePokemon poke) {
		if (field.isSun()) {
			if (isHurtBySunDueToAbility(poke)) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_EIGHTH);
			}
		}
	}

	private static boolean isHurtBySunDueToAbility(ActivePokemon poke) {
		return poke.hasAbility(Ability.SOLAR_POWER)
				|| poke.hasAbility(Ability.DRY_SKIN);
	}

	private static boolean isImmuneToSandStorm(ActivePokemon poke) {
		return isImmuneToSandStormDueToTyping(poke)
				|| isImmuneToSandStormDueToAbility(poke);
	}

	private static boolean isImmuneToSandStormDueToTyping(ActivePokemon poke) {
		return poke.isType(Type.GROUND) || poke.isType(Type.STEEL)
				|| poke.isType(Type.ROCK);
	}

	private static boolean isImmuneToSandStormDueToAbility(ActivePokemon poke) {
		return poke.hasAbility(Ability.SAND_VEIL)
				|| poke.hasAbility(Ability.SAND_FORCE)
				|| poke.hasAbility(Ability.SAND_RUSH);
	}

	private static boolean isImmuneToHail(ActivePokemon poke) {
		return poke.isType(Type.ICE) || isImmuneToHailDueToAbility(poke);
	}

	private static boolean isImmuneToHailDueToAbility(ActivePokemon poke) {
		return poke.hasAbility(Ability.SNOW_CLOAK)
				|| poke.hasAbility(Ability.ICE_BODY);
	}

	public static void applyHealingWeather(Weather weather, ActivePokemon poke) {
		if (weather.isRain()) {
			if (poke.hasAbility(Ability.RAIN_DISH)) {
				MathUtils.applyFractionalHealing(poke, MathUtils.ONE_SIXTEENTH);
			} else if (poke.hasAbility(Ability.DRY_SKIN)) {
				MathUtils.applyFractionalHealing(poke, MathUtils.ONE_EIGHTH);
			} else if (poke.hasAbility(Ability.HYDRATION)) {
				poke.cureStatus();
			}
		} else if (weather.isHail()) {
			if (poke.hasAbility(Ability.ICE_BODY)) {
				MathUtils.applyFractionalHealing(poke, MathUtils.ONE_SIXTEENTH);
			}
		}
	}
}
