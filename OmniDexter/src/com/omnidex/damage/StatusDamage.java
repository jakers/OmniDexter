package com.omnidex.damage;

import com.omnidex.ability.Ability;
import com.omnidex.item.Item;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Pokemon;

public class StatusDamage {

	public static void applyBurnDamage(ActivePokemon poke) {
		if (noMagicGuard(poke) && poke.isBurnt()) {
			if (poke.hasAbility(Ability.HEATPROOF)) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_SIXTEENTH);
			} else {
				MathUtils.passiveDamage(poke, MathUtils.ONE_EIGHTH);
			}
		}
	}

	public static void applyPoisonDamage(ActivePokemon poke) {
		if (noMagicGuard(poke)) {
			if (poke.isRegPoison()) {
				MathUtils.passiveDamage(poke, MathUtils.ONE_EIGHTH);
			} else {
				MathUtils.toxicDamage(poke);
			}
		}
	}

	public static void applyNightmareDamage(ActivePokemon poke) {
		if (noMagicGuard(poke) && poke.isAsleep()) {
			MathUtils.passiveDamage(poke, MathUtils.ONE_QUARTER);
		}
	}

	private static boolean noMagicGuard(Pokemon poke) {
		return !poke.hasAbility(Ability.MAGIC_GUARD);
	}

	private static boolean hasEitherPoison(Pokemon poke) {
		return poke.isRegPoison() || poke.isToxPoison();
	}

	/**
	 * This heals DeepPokemon with the ability Poison heal.
	 * 
	 * @param poke
	 *            a DeepPokemon that is the active DeepPokemon on the battle
	 *            field.
	 */
	public static void applyStatusHealing(Pokemon poke) {
		if (!poke.hasFainted() && hasEitherPoison(poke) && poke.hasAbility(Ability.POISON_HEAL)) {
			MathUtils.applyFractionalHealing(poke, MathUtils.ONE_EIGHTH);
		}
	}

	public static void applyCurseDamage(ActivePokemon poke) {
		if (poke.isCursed()) {
			MathUtils.passiveDamage(poke, MathUtils.ONE_QUARTER);
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
			MathUtils.applyFractionalLeeching(seeded, healer,
					MathUtils.ONE_EIGHTH);
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
	

	/**
	 * The Pokemon with Ingrain roots is healed by 1/16th of its max hp.
	 * 
	 * @param poke
	 */
	public static void applyIngrainHealing(ActivePokemon poke) {
		if (!poke.hasFainted() && poke.isIngrained()) {
			MathUtils.applyFractionalHealing(poke, MathUtils.ONE_SIXTEENTH);
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
			MathUtils.applyFractionalHealing(poke, MathUtils.ONE_SIXTEENTH);
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
			MathUtils.passiveDamage(target, MathUtils.ONE_EIGHTH);
		} else {
			MathUtils.passiveDamage(target, MathUtils.ONE_SIXTEENTH);
		}

	}
}
