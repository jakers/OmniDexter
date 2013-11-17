package com.omnidex.test.pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.InactivePokemon;
import com.omnidex.pokemon.Species;

public class DeepPokemonTest {

	
	@Test
	public void pokemon_do_faint_at_zero_hp() {
		InactivePokemon poke = new InactivePokemon(Species.SLOWPOKE);
		assertFalse(poke.hasFainted());
		assertTrue(poke.isOk());
		poke.setCurrHp(0);
		assertTrue(poke.hasFainted());
		assertFalse(poke.isOk());
	}
	
	@Test
	public void pokemon_do_faint_at_less_than_zero_hp() {
		InactivePokemon poke = new InactivePokemon(Species.SLOWPOKE);
		assertFalse(poke.hasFainted());
		assertTrue(poke.isOk());
		poke.setCurrHp(-10);
		assertTrue(poke.hasFainted());
		assertFalse(poke.isOk());
	}
	
	@Test
	public void pokemon_doesnot_alias() {
		ActivePokemon poke = new ActivePokemon(Species.CHARIZARD);
		poke.setHpEv(252);
		ActivePokemon poke2 = new ActivePokemon(poke);
		assertEquals(360, poke.getCurrHp());
		assertEquals(360, poke2.getCurrHp());
		poke2.damage(5);
		assertEquals(360, poke.getCurrHp());
		assertEquals(355, poke2.getCurrHp());
	}
}
