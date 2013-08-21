package com.omnidex.damage;

import com.omnidex.ability.Ability;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.type.Type;
import com.omnidex.weather.Weather;

public class WeatherDamage {
	
	/**
     * Applies the damage if any from the Current Weather
     * @param field the weather on the field
     * @param poke the DeepPokemon whose turn it is to be affected by weather
     * damage.
     * 
     * If Sand:
     *    1/16 Max Hp if Current DeepPokemon isn't Rock/Ground/Steel Type or
     *    current DeepPokemon's ability is Sand Veil, Sand Rush, Sand Force,
     *    overcoat or magic guard
     * 
     * If Hail:
     *    1/16 Max Hp if Current DeepPokemon isn't Ice Type or current ability isn't
     *    ice Body, snow Cloak, overcoat or magic guard
     * 
     * If Sun & ability == Solar Power or Dry Skin
     *    1/8 Max Hp for Solar Power and Dry Skin
     *
     */
	public static void applyDamagingWeather(Weather field, ActivePokemon poke) {

		Ability ability = poke.getAbility();

		if (!poke.hasAbility(Ability.OVERCOAT)
				&& !poke.hasAbility(Ability.MAGIC_GUARD)) {
			if (field.isSand()) {
				if (!(poke.isType(Type.GROUND) || poke.isType(Type.STEEL)
						|| poke.isType(Type.ROCK) || poke.isDiving()
						|| poke.isDigging() || ability.equals(Ability.SAND_VEIL)
						|| poke.getAbility().equals(Ability.SAND_FORCE) || ability
							.equals(Ability.SAND_RUSH))) {
					PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_SIXTEENTH);
				}
			} else if (field.isHail()) {
				if (!(poke.isType(Type.ICE)
						|| ability.equals(Ability.SNOW_CLOAK) || ability
							.equals(Ability.ICE_BODY))
						|| poke.isDigging()
						|| poke.isDiving()) {
					PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_SIXTEENTH);
				}
			} else if (field.isSun()) {
				if (poke.hasAbility(Ability.SOLAR_POWER)
						|| poke.hasAbility(Ability.DRY_SKIN)) {
					PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_EIGHTH);
				}
			}
		}
	}
	
	/**
     * Applies healing if any from the Current Weather
     * @param weather the weather on the field
     * @param poke the DeepPokemon whose turn it is to be affected by weather
     * healing
     * 
     * If Rain:
     *    Rain Dish, Hydration, Dry Skin 1/16 of Max Hp
     * If Hail:
     *    Ice Body 1/16 of Max Hp
     */
	public static void applyHealingWeather(Weather weather, ActivePokemon poke) {
		if (weather.isRain()) {
			if (poke.hasAbility(Ability.RAIN_DISH)) {
				PokemonMath.applyFractionalHealing(poke, PokemonMath.ONE_SIXTEENTH);
			} else if (poke.hasAbility(Ability.DRY_SKIN)) {
				PokemonMath.applyFractionalHealing(poke, PokemonMath.ONE_EIGHTH);
			} else if (poke.hasAbility(Ability.HYDRATION)) {
				poke.cureStatus();
			}
		} else if (weather.isHail()) {
			if (poke.hasAbility(Ability.ICE_BODY)) {
				PokemonMath.applyFractionalHealing(poke, PokemonMath.ONE_SIXTEENTH);
			}
		}
	}
}
