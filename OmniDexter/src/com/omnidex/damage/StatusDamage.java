package com.omnidex.damage;

import com.omnidex.ability.Ability;
import com.omnidex.pokemon.Pokemon;

/**
 * @author Akers
 */
public class StatusDamage {

	/**
     * This deals Burn, Poison, Toxic poison, or Nightmare damage.
     * Also this increments the toxCount on the DeepPokemon if they have Toxic
     * poison
     * @param poke a DeepPokemon that is the active DeepPokemon on the battle field.
     */
	public static void applyStatusDamage(Pokemon poke) {
		Ability ability = poke.getAbility();
		if (!ability.equals(Ability.MAGIC_GUARD)) {
			if (poke.isBurnt()) {
				if (ability.equals(Ability.HEATPROOF)) {
					PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_SIXTEENTH);
				} else {
					PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_EIGHTH);
				}
			} else if (poke.isRegPoison()
					&& !ability.healsWhenPoisoned()) {
				PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_EIGHTH);
			} else if (poke.isToxPoison()
					&& !ability.healsWhenPoisoned()) {
				PokemonMath.toxicDamage(poke);
			}
		} else if (poke.isAsleep() && poke.hasNightmare()) {
			PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_QUARTER);
		}
	}

	/**
     * This heals DeepPokemon with the ability Poison heal.
     * @param poke a DeepPokemon that is the active DeepPokemon on the battle field.
     */
	public static void applyStatusHealing(Pokemon poke) {
		if (!poke.hasFainted()) {
			if ((poke.isRegPoison() || poke.isToxPoison())
					&& poke.getAbility().healsWhenPoisoned()) {
				PokemonMath.applyFractionalHealing(poke, PokemonMath.ONE_EIGHTH);
			}
		}
	}

	 /**
     * This deals the Ghost version of the Curse secondary affect.
     * @param poke the Pokemon that this curse damage is to be applied to.
     */
	public static  void applyCurseDamage(Pokemon poke) {
		if (!poke.hasFainted() && poke.isCursed()) {
			PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_QUARTER);
		}
	}

	/**
     * The seeded Pokemon loses 1/8th of their max hp and the healer is healed
     * by 1/8th of the seeded Pokemon's max hp.
     * @param seeded a Pokemon that has been seeded.
     * @param healer a Pokemon that has seeded the seeded Pokemmon.
     */
	public static void applyLeechSeed(Pokemon seeded, Pokemon healer) {
		if (seeded.isSeeded() && !seeded.hasFainted() && !healer.hasFainted()) {
			PokemonMath.applyFractionalLeeching(seeded, healer, PokemonMath.ONE_EIGHTH);	
		}
	}

	/**
     * The sleeping Pokemon loses 1/8th of its max hp to the Pokemon with
     * Bad dreams.
     * @param dreamer a Pokemon that is asleep.
     * @param badDream a Pokemon with the ability BadDreams.
     */
	public static void applyBadDreams(Pokemon dreamer, Pokemon badDream) {
		if (!badDream.hasFainted() && dreamer.isAsleep()
				&& badDream.getAbility().equals(Ability.BAD_DREAMS)) {
			PokemonMath.applyFractionalDamage(dreamer, PokemonMath.ONE_EIGHTH);
		}
	}

	/**
     * The Pokemon with Ingrain roots is healed by 1/16th of its max hp.
     * @param poke 
     */
	public static void applyIngrainHealing(Pokemon poke) {
		if (!poke.hasFainted() && poke.hasRoots()) {
			PokemonMath.applyFractionalHealing(poke, PokemonMath.ONE_SIXTEENTH);
		}
	}

	 /**
     * The Pokemon with AquaRing is healed by 1/16th of its max hp.
     * @param poke a Pokemon with the Aqua Ring affect.
     */
	public static void applyAquaRingHealing(Pokemon poke) {
		if (!poke.hasFainted() && poke.hasRings()) {
			PokemonMath.applyFractionalHealing(poke, PokemonMath.ONE_SIXTEENTH);
		}
	}
}
