package com.omnidex.ability;

import com.omnidex.pokemon.ActivePokemon;

public class AbilityActivation {

	public static void activateSpeedBoost(ActivePokemon poke) {
		if (poke.hasAbility(Ability.SPEED_BOOST)) {
			poke.boostSpeedStage(1);
		}
	}
	
	public static void activateShedSkin(ActivePokemon poke) {
		if (poke.hasAbility(Ability.SHED_SKIN) && !poke.hasFainted()) {
			poke.cureStatus();
		}
	}
	
	
	
}
