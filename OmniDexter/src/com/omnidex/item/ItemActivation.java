package com.omnidex.item;

import com.omnidex.ability.Ability;
import com.omnidex.damage.MathUtils;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.type.Type;

/**
 * This class handles situations where pokemon Items affect activate
 * 
 * @author jakers
 */
public class ItemActivation {

	public static void applyHealingItems(Pokemon poke) {
		if (!poke.hasFainted()) {
			if (!poke.hasAbility(Ability.KLUTZ)) {
				if (poke.hasItem(Item.LEFTOVERS)) {
					MathUtils.applyFractionalHealing(poke,
							MathUtils.ONE_SIXTEENTH);
				} else if (poke.hasItem(Item.BLACK_SLUDGE)) {
					if (poke.isType(Type.POISON)) {
						MathUtils.applyFractionalHealing(poke,
								MathUtils.ONE_SIXTEENTH);
					} else {
						MathUtils.passiveDamage(poke,
								MathUtils.ONE_SIXTEENTH);
					}
				}
			}
		}
	}

	public static void burnOrbActivation(Pokemon poke) {
		if (poke.isOk() && poke.hasItem(Item.FLAME_ORB)
				&& !poke.hasAbility(Ability.KLUTZ)
				&& !poke.hasAbility(Ability.WATER_VEIL)
				&& !poke.isType(Type.FIRE)) {
			poke.setBurnt();
		}
	}

	public static void toxicOrbActivation(Pokemon poke) {
		if (poke.isOk() && poke.hasItem(Item.TOXIC_ORB)
				&& !poke.hasAbility(Ability.KLUTZ) && !poke.isType(Type.POISON)
				&& !poke.isType(Type.STEEL)) {
			poke.setToxPoison();
		}
	}

	public static void activateStickBarb(ActivePokemon poke) {
		if (poke.hasItem(Item.STICKY_BARB) && !poke.hasFainted()) {
			MathUtils.passiveDamage(poke, MathUtils.ONE_EIGHTH);
		}
	}

}
