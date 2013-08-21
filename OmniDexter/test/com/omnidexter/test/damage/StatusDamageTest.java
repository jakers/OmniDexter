package com.omnidexter.test.damage;

import org.junit.Test;
import com.omnidex.ability.Ability;
import com.omnidex.damage.StatusDamage;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Species;

import static org.junit.Assert.*;

public class StatusDamageTest {

	/**
	 * Test of applyStatusDamage method, of class StatusDamage.
	 */
	@Test
	public void testApplyStatusDamage_RegPoison() {
		System.out.println("applyStatusDamage reg poison");
		ActivePokemon poke = new ActivePokemon(Species.QUAGSIRE);
		poke.setHpEv(252);
		poke.setRegPoison();
		StatusDamage.applyStatusDamage(poke);
		assertEquals(345, poke.getCurrHp());
	}

	/**
	 * Test of applyStatusDamage method, of class StatusDamage.
	 */
	@Test
	public void testApplyStatusDamage_ToxPoison() {
		System.out.println("applyStatusDamage toxic Poison for 2 turns");
		ActivePokemon poke = new ActivePokemon(Species.QUAGSIRE);
		poke.setHpEv(252);
		poke.setToxPoison();
		assertEquals(394, poke.getCurrHp());
		StatusDamage.applyStatusDamage(poke);
		assertEquals(370, poke.getCurrHp());
		StatusDamage.applyStatusDamage(poke);
		assertEquals(321, poke.getCurrHp());
	}

	/**
	 * Test of applyStatusDamage method, of class StatusDamage.
	 */
	@Test
	public void testApplyStatusDamage_ToxPoison_Poison_Heal() {
		System.out.println("applyStatusDamage toxic Poison turn 2");
		ActivePokemon poke = new ActivePokemon(Species.BRELOOM);
		poke.setAbility(Ability.POISON_HEAL);
		poke.setHpEv(252);
		poke.setToxPoison();
		StatusDamage.applyStatusDamage(poke);
		assertEquals(324, poke.getCurrHp());
	}

	/**
	 * Test of applyStatusDamage method, of class StatusDamage.
	 */
	@Test
	public void testApplyStatusDamage_RegPoison_Poison_Heal() {
		System.out.println("applyStatusDamage toxic Poison turn 2");
		ActivePokemon poke = new ActivePokemon(Species.BRELOOM);
		poke.setAbility(Ability.POISON_HEAL);
		poke.setHpEv(252);
		poke.setRegPoison();
		StatusDamage.applyStatusDamage(poke);
		assertEquals(324, poke.getCurrHp());
	}

	/**
	 * Test of applyStatusDamage method, of class StatusDamage.
	 */
	@Test
	public void testApplyStatusDamage_Burn_Poison_Heal() {
		System.out.println("applyStatusDamage burn w/ poison heal");
		ActivePokemon poke = new ActivePokemon(Species.BRELOOM);
		poke.setAbility(Ability.POISON_HEAL);
		poke.setHpEv(252);
		poke.setBurnt();
		StatusDamage.applyStatusDamage(poke);
		assertEquals(284, poke.getCurrHp());
	}

	/**
	 * Test of applyStatusDamage method, of class StatusDamage.
	 */
	@Test
	public void testApplyStatusDamage_Burn() {
		System.out.println("applyStatusDamage burn");
		ActivePokemon poke = new ActivePokemon(Species.BRELOOM);
		poke.setAbility(Ability.EFFECT_SPORE);
		poke.setHpEv(252);
		poke.setBurnt();
		StatusDamage.applyStatusDamage(poke);
		assertEquals(284, poke.getCurrHp());
	}

	/**
	 * Test of applyStatusDamage method, of class StatusDamage.
	 */
	@Test
	public void testApplyStatusDamage_Burn_Heatproof() {
		System.out.println("applyStatusDamage burn heatproof");
		ActivePokemon poke = new ActivePokemon(Species.BRONZONG);
		poke.setAbility(Ability.HEATPROOF);
		poke.setHpEv(252);
		poke.setBurnt();
		StatusDamage.applyStatusDamage(poke);
		assertEquals(317, poke.getCurrHp());
	}

	/**
	 * Test of applyStatusDamage method, of class StatusDamage.
	 */
	@Test
	public void testApplyStatusDamage_Burn_MagicGuard() {
		System.out.println("applyStatusDamage magicguard");
		ActivePokemon poke = new ActivePokemon(Species.BRONZONG);
		poke.setAbility(Ability.MAGIC_GUARD);
		poke.setHpEv(252);
		poke.setBurnt();
		StatusDamage.applyStatusDamage(poke);
		assertEquals(338, poke.getCurrHp());
	}

	/**
	 * Test of applyStatusHealing method, of class StatusDamage.
	 */
	@Test
	public void testApplyStatusHealing_reg_poison() {
		System.out.println("applyStatusHealing Rain Dry Skin");
		ActivePokemon poke = new ActivePokemon(Species.BRELOOM);
		poke.setHpEv(252);
		poke.setAbility(Ability.POISON_HEAL);
		poke.setCurrHp(100);
		poke.setRegPoison();
		StatusDamage.applyStatusHealing(poke);
		assertEquals("should be 140", 140, poke.getCurrHp());
	}

	/**
	 * Test of applyStatusHealing method, of class StatusDamage.
	 */
	@Test
	public void testApplyStatusHealing_tox_poison() {
		System.out.println("applyStatusHealing Rain Dry Skin");
		ActivePokemon poke = new ActivePokemon(Species.BRELOOM);
		poke.setHpEv(252);
		poke.setAbility(Ability.POISON_HEAL);
		poke.setCurrHp(100);
		poke.setToxPoison();
		StatusDamage.applyStatusHealing(poke);
		assertEquals("should be 140", 140, poke.getCurrHp());
	}

	@Test
	public void testApplyLeechSeed() {
		System.out.println("applying leech seed");
		ActivePokemon healer = new ActivePokemon(Species.ABOMASNOW);
		healer.setHpEv(252);
		healer.setCurrHp(342);

		ActivePokemon seeded = new ActivePokemon(Species.ABSOL);
		seeded.setHpEv(252);
		seeded.activateSeeds();

		assertEquals(healer.getCurrHp(), 342);
		assertEquals(seeded.getCurrHp(), 334);
		assertEquals(seeded.getMaxHp(), 334);
		StatusDamage.applyLeechSeed(seeded, healer);
		assertEquals(seeded.getCurrHp(), 293);
		assertEquals(healer.getCurrHp(), 383);
	}
}
