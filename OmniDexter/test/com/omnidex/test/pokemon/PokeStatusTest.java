package com.omnidex.test.pokemon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.omnidex.pokemon.PokeStatus;
import com.omnidex.pokemon.Status;

public class PokeStatusTest {
	private Status status;

	@Before
	public void before() {
		status = new PokeStatus();
	}

	@Test
	public void testPokeStatus() {
		status.isOk();
	}

	@Test
	public void testPokeStatusStatus() {
		status.setBurnt();
		Status tmpStatus = new PokeStatus(status);
		assertTrue(tmpStatus.isBurnt());
		status.cureStatus();
		assertTrue(tmpStatus.isBurnt());
	}

	@Test
	public void testGetSleepDuration() {
		assertEquals(0, status.getSleepDuration());
		status.setSleep(5);
		assertEquals(5, status.getSleepDuration());
	}

	@Test
	public void testDecrementSleep() {
		status.setSleep(2);
		assertTrue(status.isAsleep());
		status.decrementSleep();
		
		assertEquals(2, status.getInitialSleepDuration());
		assertEquals(1, status.getSleepDuration());
		status.decrementSleep();
		assertEquals(0, status.getInitialSleepDuration());
		assertEquals(0, status.getSleepDuration());
		assertTrue(status.isOk());
		assertFalse(status.isAsleep());
	}

	@Test
	public void testGetInitialSleepDuration() {
		status.setSleep(5);
		assertTrue(status.isAsleep());
		assertEquals(5, status.getInitialSleepDuration());
		assertEquals(5, status.getSleepDuration());
		status.decrementSleep();
		assertEquals(5, status.getInitialSleepDuration());
		assertEquals(4, status.getSleepDuration());
	}

	@Test
	public void testGetAtkMod() {
		assertEquals(1.0,status.getAtkMod(), 0.0);
		status.setBurnt();
		assertEquals(Status.BURN_ATK_MOD,status.getAtkMod(), 0.0);
	}

	@Test
	public void testGetSpeMod() {
		assertEquals(1.0,status.getSpeMod(), 0.0);
		status.setParalysis();
		assertEquals(Status.PARA_SPE_MOD, status.getSpeMod(), 0.0);
	}

	@Test
	public void testCureStatus_ok_status() {
		status.cureStatus();
		assertFalse(status.isAsleep());
		assertEquals(0, status.getSleepDuration());
		assertFalse(status.isBurnt());
		assertFalse(status.isFrozen());
		assertFalse(status.isParalyzed());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testCureStatus_asleep_status() {
		status.setSleep(5);
		assertTrue(status.isAsleep());
		status.cureStatus();
		assertTrue(status.isOk());
	}

	@Test
	public void testCureStatus_burnt_status() {
		status.setBurnt();
		assertTrue(status.isBurnt());
		status.cureStatus();
		assertTrue(status.isOk());
	}

	@Test
	public void testCureStatus_frozen_status() {
		status.setFrozen();
		assertTrue(status.isFrozen());
		status.cureStatus();
		assertTrue(status.isOk());
	}

	@Test
	public void testCureStatus_para_status() {
		status.setParalysis();
		assertTrue(status.isParalyzed());
		status.cureStatus();
		assertTrue(status.isOk());
	}

	@Test
	public void testCureStatus_reg_poison_status() {
		status.setRegPoison();
		assertTrue(status.isRegPoison());
		status.cureStatus();
		assertTrue(status.isOk());
	}

	@Test
	public void testCureStatus_tox_poison_status() {
		status.setToxPoison();
		assertTrue(status.isToxPoison());
		status.cureStatus();
		assertTrue(status.isOk());
	}

	@Test
	public void testIsBurnt() {
		assertFalse(status.isBurnt());
		status.setBurnt();
		assertTrue(status.isBurnt());
		assertFalse(status.isOk());
		assertFalse(status.isFrozen());
		assertFalse(status.isParalyzed());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testIsAsleep() {
		assertFalse(status.isAsleep());
		status.setSleep(5);
		assertTrue(status.isAsleep());
		assertTrue(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isOk());
		assertFalse(status.isFrozen());
		assertFalse(status.isParalyzed());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testIsParalyzed() {
		assertFalse(status.isParalyzed());
		status.setParalysis();
		assertTrue(status.isParalyzed());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isOk());
		assertFalse(status.isFrozen());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testIsRegPoison() {
		assertFalse(status.isRegPoison());
		status.setRegPoison();
		assertFalse(status.isParalyzed());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isOk());
		assertFalse(status.isFrozen());
		assertTrue(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testIsToxPoison() {
		assertFalse(status.isToxPoison());
		status.setToxPoison();
		assertFalse(status.isParalyzed());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isOk());
		assertFalse(status.isFrozen());
		assertFalse(status.isRegPoison());
		assertTrue(status.isToxPoison());
	}

	@Test
	public void testIsFrozen() {
		assertFalse(status.isFrozen());
		status.setFrozen();
		assertFalse(status.isParalyzed());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isOk());
		assertTrue(status.isFrozen());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testHasFainted() {
		assertFalse(status.hasFainted());
		status.setFainted();
		assertTrue(status.hasFainted());
		assertFalse(status.isParalyzed());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isOk());
		assertFalse(status.isFrozen());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testSetSleep() {
		status.setSleep(5);
		assertFalse(status.isOk());
		assertTrue(status.isAsleep());
		assertEquals(5, status.getInitialSleepDuration());
		assertEquals(5, status.getSleepDuration());
	}

	@Ignore
	@Test
	public void testDoesThaw() {
		// TODO need to figure out how to test probabilistic methods
		fail("Not yet implemented");
	}

	@Test
	public void testSetToxPoison() {
		status.setToxPoison();
		assertFalse(status.isOk());
		assertTrue(status.isToxPoison());
	}

	@Test
	public void testGetToxCount() {
		status.setToxPoison();
		assertFalse(status.isOk());
		assertTrue(status.isToxPoison());	
	}

	@Test
	public void testSetRegPoison() {
		status.setRegPoison();
		assertFalse(status.isOk());
		assertTrue(status.isRegPoison());
	}

	@Test
	public void testSetBurnt() {
		status.setBurnt();
		assertTrue(status.isBurnt());
		assertFalse(status.isOk());
	}

	@Test
	public void testSetFrozen() {
		status.setFrozen();
		assertTrue(status.isFrozen());
		assertFalse(status.isOk());
	}

	@Test
	public void testSetParalysis() {
		status.setParalysis();
		assertTrue(status.isParalyzed());
		assertFalse(status.isOk());
	}

	@Test
	public void testIsOk() {
		assertTrue(status.isOk());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isFrozen());
		assertFalse(status.isParalyzed());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Ignore
	@Test
	public void testDoesFullyParalyze() {
//		TODO need to figure out how to test probabilistic methods
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementToxCount() {
		status.incrementToxCount();
		assertEquals(0, status.getToxCount());
		status.setToxPoison();
		assertTrue(status.isToxPoison());
		
		for (int i = 1; i < 17;i++) {
			assertEquals(i, status.getToxCount());
			status.incrementToxCount();
		}
		
		assertEquals(1, status.getToxCount());
	}

	@Test
	public void testSetFainted_with_ok_status() {
		status.setFainted();
		assertTrue(status.hasFainted());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isFrozen());
		assertFalse(status.isOk());
		assertFalse(status.isParalyzed());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testSetFainted_with_isAsleep_status() {
		status.setSleep(5);
		assertTrue(status.isAsleep());
		status.setFainted();
		assertTrue(status.hasFainted());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isFrozen());
		assertFalse(status.isOk());
		assertFalse(status.isParalyzed());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testSetFainted_with_burnt_status() {
		status.setBurnt();
		assertTrue(status.isBurnt());
		status.setFainted();
		assertTrue(status.hasFainted());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isFrozen());
		assertFalse(status.isOk());
		assertFalse(status.isParalyzed());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testSetFainted_with_frozen_status() {
		status.setFrozen();
		assertTrue(status.isFrozen());
		status.setFainted();
		assertTrue(status.hasFainted());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isFrozen());
		assertFalse(status.isOk());
		assertFalse(status.isParalyzed());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testSetFainted_with_para_status() {
		status.setParalysis();
		assertTrue(status.isParalyzed());
		status.setFainted();
		assertTrue(status.hasFainted());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isFrozen());
		assertFalse(status.isOk());
		assertFalse(status.isParalyzed());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testSetFainted_with_reg_poison_status() {
		status.setRegPoison();
		assertTrue(status.isRegPoison());
		status.setFainted();
		assertTrue(status.hasFainted());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isFrozen());
		assertFalse(status.isOk());
		assertFalse(status.isParalyzed());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}

	@Test
	public void testSetFainted_with_tox_poison_status() {
		status.setToxPoison();
		assertTrue(status.isToxPoison());
		status.setFainted();
		assertTrue(status.hasFainted());
		assertFalse(status.isAsleep());
		assertFalse(status.isBurnt());
		assertFalse(status.isFrozen());
		assertFalse(status.isOk());
		assertFalse(status.isParalyzed());
		assertFalse(status.isRegPoison());
		assertFalse(status.isToxPoison());
	}
}
