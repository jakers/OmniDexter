package com.omnidex.damage;

import com.omnidex.ability.Ability;
import com.omnidex.item.Item;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Pokemon;

/**
 * @author Akers
 */
public class StatusDamage {

	/**
	 * This deals Burn, Poison, Toxic poison, or Nightmare damage. Also this
	 * increments the toxCount on the DeepPokemon if they have Toxic poison
	 * 
	 * @param poke
	 *            a DeepPokemon that is the active DeepPokemon on the battle
	 *            field.
	 */
	public static void applyStatusDamage(ActivePokemon poke) {
		if (!poke.hasAbility(Ability.MAGIC_GUARD)) {
			if (poke.isBurnt()) {
				if (poke.hasAbility(Ability.HEATPROOF)) {
					PokemonMath.applyFractionalDamage(poke,
							PokemonMath.ONE_SIXTEENTH);
				} else {
					PokemonMath.applyFractionalDamage(poke,
							PokemonMath.ONE_EIGHTH);
				}
			} else if (poke.isRegPoison()
					&& !poke.getAbility().healsWhenPoisoned()) {
				PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_EIGHTH);
			} else if (poke.isToxPoison()
					&& !poke.getAbility().healsWhenPoisoned()) {
				PokemonMath.toxicDamage(poke);
			}
		} else if (poke.isAsleep() && poke.hasNightmare()) {
			PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_QUARTER);
		}
	}

	/**
	 * This heals DeepPokemon with the ability Poison heal.
	 * 
	 * @param poke
	 *            a DeepPokemon that is the active DeepPokemon on the battle
	 *            field.
	 */
	public static void applyStatusHealing(Pokemon poke) {
		if (!poke.hasFainted()) {
			if ((poke.isRegPoison() || poke.isToxPoison())
					&& poke.getAbility().healsWhenPoisoned()) {
				PokemonMath
						.applyFractionalHealing(poke, PokemonMath.ONE_EIGHTH);
			}
		}
	}

	/**
	 * This deals the Ghost version of the Curse secondary affect.
	 * 
	 * @param poke
	 *            the Pokemon that this curse damage is to be applied to.
	 */
	public static void applyCurseDamage(ActivePokemon poke) {
		if (!poke.hasFainted() && poke.isCursed()) {
			PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_QUARTER);
		}
	}

	/**
	 * The seeded Pokemon loses 1/8th of their max hp and the healer is healed
	 * by 1/8th of the seeded Pokemon's max hp.
	 * 
	 * @param seeded
	 *            a Pokemon that has been seeded.
	 * @param healer
	 *            a Pokemon that has seeded the seeded Pokemmon.
	 */
	public static void applyLeechSeed(ActivePokemon seeded, ActivePokemon healer) {
		if (seeded.isSeeded() && !seeded.hasFainted() && !healer.hasFainted()) {
			PokemonMath.applyFractionalLeeching(seeded, healer,
					PokemonMath.ONE_EIGHTH);
		}
	}

	/**
	 * The sleeping Pokemon loses 1/8th of its max hp to the Pokemon with Bad
	 * dreams.
	 * 
	 * @param dreamer
	 *            a Pokemon that is asleep.
	 * @param badDream
	 *            a Pokemon with the ability BadDreams.
	 */
	public static void applyBadDreams(Pokemon dreamer, Pokemon badDream) {
		if (!badDream.hasFainted() && dreamer.isAsleep()
				&& badDream.hasAbility(Ability.BAD_DREAMS)) {
			PokemonMath.applyFractionalDamage(dreamer, PokemonMath.ONE_EIGHTH);
		}
	}

	/**
	 * The Pokemon with Ingrain roots is healed by 1/16th of its max hp.
	 * 
	 * @param poke
	 */
	public static void applyIngrainHealing(ActivePokemon poke) {
		if (!poke.hasFainted() && poke.isIngrained()) {
			PokemonMath.applyFractionalHealing(poke, PokemonMath.ONE_SIXTEENTH);
		}
	}

	/**
	 * The Pokemon with AquaRing is healed by 1/16th of its max hp.
	 * 
	 * @param poke
	 *            a Pokemon with the Aqua Ring affect.
	 */
	public static void applyAquaRingHealing(ActivePokemon poke) {
		if (!poke.hasFainted() && poke.hasAquaRing()) {
			PokemonMath.applyFractionalHealing(poke, PokemonMath.ONE_SIXTEENTH);
		}
	}

	public static void applyPartialTrappingDamage(ActivePokemon target,
			ActivePokemon trapper) {
		if (!target.hasFainted() && target.hasFireSpin()) {
			applyPartialTrappingDamageWithItemMod(target, trapper);
			target.decrementFireSpin();
		}

		if (!target.hasFainted() && target.isClamped()) {
			applyPartialTrappingDamageWithItemMod(target, trapper);
			target.decrementClamp();
		}

		if (!target.hasFainted() && target.isWrapped()) {
			applyPartialTrappingDamageWithItemMod(target, trapper);
			target.decrementWrap();
		}

		if (!target.hasFainted() && target.hasSandTomb()) {
			applyPartialTrappingDamageWithItemMod(target, trapper);
			target.decrementSandTomb();
		}

		if (!target.hasFainted() && target.hasWhirlpool()) {
			applyPartialTrappingDamageWithItemMod(target, trapper);
			target.decrementWhirlpool();
		}
		
		if (!target.hasFainted() && target.hasMagmaStorm()) {
			applyPartialTrappingDamageWithItemMod(target, trapper);
			target.decrementMagmaStorm();
		}
		
		if (!target.hasFainted() && target.isBound()) {
			applyPartialTrappingDamageWithItemMod(target, trapper);
			target.decrementBind();
		}
	}

	private static void applyPartialTrappingDamageWithItemMod(
			ActivePokemon target, ActivePokemon trapper) {
		if (trapper.getItem().equals(Item.BINDING_BAND)) {
			PokemonMath.applyFractionalDamage(target, PokemonMath.ONE_EIGHTH);
		} else {
			PokemonMath
					.applyFractionalDamage(target, PokemonMath.ONE_SIXTEENTH);
		}

	}
}
