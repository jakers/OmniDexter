package com.omnidex.test.pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

import com.omnidex.pokemon.DeepPokemon;
import com.omnidex.pokemon.Species;

public class DeepPokemonTest {

	
	@Test
	public void pokemon_do_faint_at_zero_hp() {
		DeepPokemon poke = new DeepPokemon(Species.SLOWPOKE);
		assertFalse(poke.hasFainted());
		assertTrue(poke.isOk());
		poke.setCurrHp(0);
		assertTrue(poke.hasFainted());
		assertFalse(poke.isOk());
	}
	
	@Test
	public void pokemon_do_faint_at_less_than_zero_hp() {
		DeepPokemon poke = new DeepPokemon(Species.SLOWPOKE);
		assertFalse(poke.hasFainted());
		assertTrue(poke.isOk());
		poke.setCurrHp(-10);
		assertTrue(poke.hasFainted());
		assertFalse(poke.isOk());
	}
	
	
}
