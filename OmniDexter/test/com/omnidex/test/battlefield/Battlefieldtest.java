package com.omnidex.test.battlefield;
import org.junit.Test;

import com.omnidexter.battlefield.BattleField;

import static org.junit.Assert.*;
public class Battlefieldtest {

	private BattleField bf;
	public Battlefieldtest() {
		bf = new BattleField();
	}
	
	@Test
	public void printBattleField() {
		bf.printBattleField();
	}
	
	@Test
	public void set_Gravity() {
		assertFalse(bf.hasGravity());
		bf.setGravity(BattleField.DURATION_FIVE);
		assertTrue(bf.hasGravity());
		assertEquals(BattleField.DURATION_FIVE, bf.getGravityCount());
	}
	
	@Test
	public void decrement_Gravity() {
		assertFalse(bf.hasGravity());
		bf.setGravity(BattleField.DURATION_FIVE);
		assertTrue(bf.hasGravity());
		assertEquals(BattleField.DURATION_FIVE, bf.getGravityCount());
		bf.decrementGravity();
		assertTrue(bf.hasGravity());
		assertEquals(4, bf.getGravityCount());
	}
	
	@Test
	public void copy_constructor_test() {
		bf.setRain(5);
		BattleField newBf = new BattleField(bf);
		assertTrue(bf.isRain());
		assertTrue(newBf.isRain());
		assertEquals(BattleField.DURATION_FIVE, bf.getDuration());
		assertEquals(BattleField.DURATION_FIVE, newBf.getDuration());
	}
	
}
