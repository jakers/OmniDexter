package com.omnidex.item;

import com.omnidex.ability.Ability;
import com.omnidex.damage.PokemonMath;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.type.Type;

/**
 * This class handles situations where pokemon Items affect activate
 * 
 * @author jakers
 */
public class ItemActivation {

	public static void applyHealingItems(Pokemon poke) {
		if (!poke.getAbility().equals(Ability.KLUTZ)) {
			if (poke.getItem().equals(Item.LEFTOVERS)) {
				PokemonMath.applyFractionalHealing(poke,
						PokemonMath.ONE_SIXTEENTH);
			} else if (poke.getItem().equals(Item.BLACK_SLUDGE)) {
				if (poke.isType(Type.POISON)) {
					PokemonMath.applyFractionalHealing(poke, PokemonMath.ONE_SIXTEENTH);
				} else {
					PokemonMath.applyFractionalDamage(poke, PokemonMath.ONE_SIXTEENTH);
				}
			}
		}
	}

	public static void burnOrbActivation(Pokemon poke) {
		if (poke.isOk() && poke.getItem().equals(Item.FLAME_ORB)
				&& !poke.getAbility().equals(Ability.KLUTZ)
				&& !poke.getAbility().equals(Ability.WATER_VEIL)
				&& !poke.isType(Type.FIRE)) {
			poke.setBurnt();
		}
	}

	public static void toxicOrbActivation(Pokemon poke) {
		if (poke.isOk() && poke.getItem().equals(Item.TOXIC_ORB)
				&& !poke.getAbility().equals(Ability.KLUTZ)
				&& !poke.isType(Type.POISON)
				&& !poke.isType(Type.STEEL)) {
			poke.setToxPoison();
		}
	}
}
