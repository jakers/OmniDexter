package com.omnidex.test.battlefield;
import org.junit.Test;

import com.omnidexter.battlefield.BattleField;
import com.omnidexter.battlefield.SingleBattleField;


import static org.junit.Assert.*;
public class Battlefieldtest {

	private BattleField bf;
	public Battlefieldtest() {
		bf = new SingleBattleField();
	}
	
	@Test
	public void printBattleField() {
		bf.printBattleField();
	}
	
	@Test
	public void set_Gravity() {
		assertFalse(bf.hasGravity());
		bf.setGravity(BattleField.DUR_5);
		assertTrue(bf.hasGravity());
		assertEquals(BattleField.DUR_5, bf.getGravityCount());
	}
	
	@Test
	public void decrement_Gravity() {
		assertFalse(bf.hasGravity());
		bf.setGravity(BattleField.DUR_5);
		assertTrue(bf.hasGravity());
		assertEquals(BattleField.DUR_5, bf.getGravityCount());
		bf.decrementGravity();
		assertTrue(bf.hasGravity());
		assertEquals(4, bf.getGravityCount());
	}
	
	@Test
	public void copy_constructor_test() {
		bf.setRain(5);
		BattleField newBf = new SingleBattleField(bf);
		assertTrue(bf.isRain());
		assertTrue(newBf.isRain());
		assertEquals(BattleField.DUR_5, bf.getDuration());
		assertEquals(BattleField.DUR_5, newBf.getDuration());
	}
	
}
