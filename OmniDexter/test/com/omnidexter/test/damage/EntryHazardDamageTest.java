package com.omnidexter.test.damage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.omnidex.ability.Ability;
import com.omnidex.battlefield.team.DeepTeam;
import com.omnidex.battlefield.team.Team;
import com.omnidex.damage.EntryHazardDamage;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Species;
public class EntryHazardDamageTest {
	
	private ActivePokemon accelgor;
	public EntryHazardDamageTest(){
		accelgor = new ActivePokemon(Species.ACCELGOR);
		accelgor.setHpEv(252);
	}
	
	@Test
	public void one_layer_of_spikes() {
		Team team = new DeepTeam();
		team.addTeamMate(accelgor);
		team.addSpikes();
		EntryHazardDamage.applySpikeDamage(team);
		assertEquals(319, team.getActivePokemon().getCurrHp());
	}

	@Test
	public void two_layers_of_spikes(){
		Team team = new DeepTeam();
		team.addTeamMate(accelgor);
		team.addSpikes();
		team.addSpikes();
		EntryHazardDamage.applySpikeDamage(team);
		assertEquals(304, team.getActivePokemon().getCurrHp());
	}
	
	@Test
	public void three_layers_of_spikes(){
		Team team = new DeepTeam();
		team.addTeamMate(accelgor);
		team.addSpikes();
		team.addSpikes();
		team.addSpikes();
		EntryHazardDamage.applySpikeDamage(team);
		assertEquals(273, team.getActivePokemon().getCurrHp());
	}
	
	@Test
	public void one_layer_of_toxic_spikes(){
		Team team = new DeepTeam();
		team.addTeamMate(accelgor);
		team.addToxicSpikes();
		EntryHazardDamage.applyToxicSpikes(team);
		assertTrue(team.getActivePokemon().isRegPoison());
		assertFalse(team.getActivePokemon().isToxPoison());
	}
	
	@Test
	public void two_layers_of_toxic_spikes() {
		Team team = new DeepTeam();
		team.addTeamMate(accelgor);
		team.addToxicSpikes();
		team.addToxicSpikes();
		EntryHazardDamage.applyToxicSpikes(team);
		assertTrue(team.getActivePokemon().isToxPoison());
		assertFalse(team.getActivePokemon().isRegPoison());
	}
	
	@Test
	public void toxic_layers_with_poisonType() {
		ActivePokemon arbok = new ActivePokemon(Species.ARBOK);
		Team team = new DeepTeam();
		team.addTeamMate(arbok);
		team.addToxicSpikes();
		team.addToxicSpikes();
		assertTrue(team.hasToxicSpikes());
		EntryHazardDamage.applyToxicSpikes(team);
		assertFalse(team.hasToxicSpikes());
		assertEquals(0, team.getToxicSpikesCount());
	}
	
	@Test
	public void toxic_layers_with_lev_poisonType() {
		ActivePokemon gengar = new ActivePokemon(Species.GENGAR);
		gengar.setAbility(Ability.LEVITATE);
		Team team = new DeepTeam();
		team.addTeamMate(gengar);
		team.addToxicSpikes();
		team.addToxicSpikes();
		assertTrue(team.hasToxicSpikes());
		EntryHazardDamage.applyToxicSpikes(team);
		assertTrue(team.hasToxicSpikes());
		assertEquals(2, team.getToxicSpikesCount());
	}
	
	@Test
	public void toxic_layers_with_flying_poisonType() {
		ActivePokemon crobat = new ActivePokemon(Species.CROBAT);
		crobat.setAbility(Ability.INNER_FOCUS);
		Team team = new DeepTeam();
		team.addTeamMate(crobat);
		team.addToxicSpikes();
		team.addToxicSpikes();
		assertTrue(team.hasToxicSpikes());
		EntryHazardDamage.applyToxicSpikes(team);
		assertTrue(team.hasToxicSpikes());
		assertEquals(2, team.getToxicSpikesCount());
	}
	
	@Test
	public void toxic_layers_with_flyingType() {
		ActivePokemon pidgeot = new ActivePokemon(Species.PIDGEOT);
		pidgeot.setAbility(Ability.KEEN_EYE);
		Team team = new DeepTeam();
		team.addTeamMate(pidgeot);
		team.addToxicSpikes();
		team.addToxicSpikes();
		assertTrue(team.hasToxicSpikes());
		EntryHazardDamage.applyToxicSpikes(team);
		assertTrue(team.hasToxicSpikes());
		assertEquals(2, team.getToxicSpikesCount());
	}
	
	@Test
	public void four_times_weak_to_stealthRocks() {
		ActivePokemon charizard = new ActivePokemon(Species.CHARIZARD);
		charizard.setHpEv(252);
		Team team = new DeepTeam();
		team.addTeamMate(charizard);
		team.addStealthRocks();
		EntryHazardDamage.applyStealthRocks(team);
		assertEquals(180,team.getActivePokemon().getCurrHp());
	}
	
	@Test
	public void two_times_weak_to_stealthRocks() {
		Team team = new DeepTeam();
		team.addTeamMate(accelgor);
		team.addStealthRocks();
		EntryHazardDamage.applyStealthRocks(team);
		assertEquals(273, team.getActivePokemon().getCurrHp());
	}
	
	@Test
	public void neutral_to_stealthRocks() {
		ActivePokemon arbok = new ActivePokemon(Species.ARBOK);
		arbok.setHpEv(252);
		Team team = new DeepTeam();
		team.addTeamMate(arbok);
		team.addStealthRocks();
		EntryHazardDamage.applyStealthRocks(team);
		assertEquals(284, team.getActivePokemon().getCurrHp());
	}
	
	
}