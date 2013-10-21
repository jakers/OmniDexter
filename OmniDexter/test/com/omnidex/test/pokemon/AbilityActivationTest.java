package com.omnidex.test.pokemon;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.omnidex.ability.Ability;
import com.omnidex.ability.AbilityActivation;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Species;

public class AbilityActivationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void activateSpeedBoostTest() {
		ActivePokemon poke = new ActivePokemon(Species.NINJASK);
		poke.setAbility(Ability.SPEED_BOOST);
		
		for (int i = 0; i < 5; i++) {
			AbilityActivation.activateSpeedBoost(poke);
			assertEquals(i+1, poke.getSpeedStage());
		}
	}

}
