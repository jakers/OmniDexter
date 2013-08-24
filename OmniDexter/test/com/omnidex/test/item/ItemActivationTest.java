package com.omnidex.test.item;

import org.junit.Test;


import com.omnidex.ability.Ability;
import com.omnidex.item.Item;
import com.omnidex.item.ItemActivation;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.InactivePokemon;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.pokemon.Species;
import static org.junit.Assert.*;

public class ItemActivationTest {

	@Test
	public void applyHealingItems_leftovers() {
		Pokemon poke = new InactivePokemon(Species.MEW);
		poke.setHpEv(252);
		poke.setItem(Item.LEFTOVERS);
		poke.setCurrHp(200);
		assertEquals(200, poke.getCurrHp());
		ItemActivation.applyHealingItems(poke);
		assertEquals(225, poke.getCurrHp());
	}
	
	@Test
	public void applyHealingItemsLeftoversWithFaintedPoke() {
		ActivePokemon poke = new ActivePokemon(Species.MEW);
		poke.setHpEv(252);
		poke.setItem(Item.LEFTOVERS);
		poke.setCurrHp(0);
		assertTrue(poke.hasFainted());
		ItemActivation.applyHealingItems(poke);
		assertTrue(poke.hasFainted());
		assertEquals(0, poke.getCurrHp());
	}
	
	
	@Test
	public void applyHealingItems_blackSludge_PoisonType() {
		Pokemon poke = new InactivePokemon(Species.ARBOK);
		poke.setHpEv(252);
		poke.setItem(Item.BLACK_SLUDGE);
		poke.setCurrHp(200);
		assertEquals(200, poke.getCurrHp());
		ItemActivation.applyHealingItems(poke);
		assertEquals(220, poke.getCurrHp());
	}
	
	@Test
	public void applyHealingItems_blackSludge_not_PoisonType() {
		Pokemon poke = new InactivePokemon(Species.AERODACTYL);
		poke.setHpEv(252);
		poke.setItem(Item.BLACK_SLUDGE);
		poke.setCurrHp(200);
		assertEquals(200, poke.getCurrHp());
		ItemActivation.applyHealingItems(poke);
		assertEquals(178, poke.getCurrHp());
	}
	
	@Test
	public void applyHealingItems_No_heal() {
		Pokemon poke = new InactivePokemon(Species.AERODACTYL);
		poke.setHpEv(252);
		poke.setItem(Item.CHOICE_BAND);
		poke.setCurrHp(200);
		assertEquals(200, poke.getCurrHp());
		ItemActivation.applyHealingItems(poke);
		assertEquals(200, poke.getCurrHp());
	}
	
	@Test
	public void burnOrbActivation_normalConditions() {
		Pokemon poke = new InactivePokemon(Species.ARBOK);
		poke.setHpEv(252);
		poke.setItem(Item.FLAME_ORB);
		assertTrue(poke.isOk());
		ItemActivation.burnOrbActivation(poke);
		assertTrue(poke.isBurnt());
	}
	
	@Test
	public void burnOrbActivation_on_fireType() {
		Pokemon poke = new InactivePokemon(Species.ARCANINE);
		poke.setHpEv(252);
		poke.setItem(Item.FLAME_ORB);
		assertTrue(poke.isOk());
		ItemActivation.burnOrbActivation(poke);
		assertTrue(poke.isOk());
	}
	
	@Test
	public void burnOrbActivation_on_waterviel() {
		Pokemon poke = new InactivePokemon(Species.BUIZEL);
		poke.setHpEv(252);
		poke.setItem(Item.FLAME_ORB);
		poke.setAbility(Ability.WATER_VEIL);
		assertTrue(poke.isOk());
		ItemActivation.burnOrbActivation(poke);
		assertTrue(poke.isOk());
	}
	
	@Test
	public void burnOrbActivation_on_klutz() {
		Pokemon poke = new InactivePokemon(Species.LOPUNNY);
		poke.setHpEv(252);
		poke.setItem(Item.FLAME_ORB);
		poke.setAbility(Ability.KLUTZ);
		assertTrue(poke.isOk());
		ItemActivation.burnOrbActivation(poke);
		assertTrue(poke.isOk());
	}
	
	@Test
	public void toxicOrbActivation_normalConditions() {
		Pokemon poke = new InactivePokemon(Species.AMBIPOM);
		poke.setItem(Item.TOXIC_ORB);
		assertTrue(poke.isOk());
		ItemActivation.toxicOrbActivation(poke);
		assertTrue(poke.isToxPoison());
	}
	
	@Test
	public void toxicOrbActivation_on_burntPoke() {
		Pokemon poke = new InactivePokemon(Species.AMBIPOM);
		poke.setItem(Item.TOXIC_ORB);
		poke.setBurnt();
		assertTrue(poke.isBurnt());
		ItemActivation.toxicOrbActivation(poke);
		assertTrue(poke.isBurnt());
	}
	
	@Test
	public void toxicOrbActivation_on_SteelType() {
		Pokemon poke = new InactivePokemon(Species.STEELIX);
		poke.setItem(Item.TOXIC_ORB);
		assertTrue(poke.isOk());
		ItemActivation.toxicOrbActivation(poke);
		assertTrue(poke.isOk());
	}
	
	@Test
	public void toxicOrbActivation_on_PoisonType() {
		Pokemon poke = new InactivePokemon(Species.ARBOK);
		poke.setHpEv(252);
		poke.setItem(Item.TOXIC_ORB);
		assertTrue(poke.isOk());
		ItemActivation.toxicOrbActivation(poke);
		assertTrue(poke.isOk());
	}
	
	@Test
	public void toxicOrbActivation_on_klutz() {
		Pokemon poke = new InactivePokemon(Species.LOPUNNY);
		poke.setItem(Item.TOXIC_ORB);
		poke.setAbility(Ability.KLUTZ);
		assertTrue(poke.isOk());
		ItemActivation.toxicOrbActivation(poke);
		assertTrue(poke.isOk());
	}
	
}
