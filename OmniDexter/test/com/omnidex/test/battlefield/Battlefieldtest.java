package com.omnidex.test.battlefield;
import org.junit.Before;
import org.junit.Test;

import com.omnidexter.battlefield.BattleField;

import static org.junit.Assert.*;
public class Battlefieldtest {

	private BattleField bf;
	public Battlefieldtest() {
		bf = new BattleField();
	}
	
	@Before
	public void setUp() {
		bf = new BattleField();
	}
	
	@Test
	public void battleFieldsAreClearWhenInitialized() {
		assertFalse(bf.hasGravity());
		assertFalse(bf.hasMagicRoom());
		assertFalse(bf.hasTrickRoom());
		assertFalse(bf.hasWonderRoom());
		assertTrue(bf.isClear());
	}
	
	@Test
	public void set_Gravity() {
		bf.setGravity(BattleField.DURATION_FIVE);
		assertTrue(bf.hasGravity());
		assertEquals(BattleField.DURATION_FIVE, bf.getGravityCount());
	}
	
	@Test
	public void decrement_Gravity() {
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
		assertTrue(newBf.isRain());
		assertEquals(BattleField.DURATION_FIVE, bf.getDuration());
		assertEquals(BattleField.DURATION_FIVE, newBf.getDuration());
		newBf.setTrickRoom(BattleField.DURATION_FIVE);
		assertTrue(newBf.hasTrickRoom());
		assertFalse(bf.hasTrickRoom());
	}
	
	@Test
	public void clearingBattleField() {
		bf.setMagicRoom(BattleField.DURATION_EIGHT);
		bf.clearBattleField();
	}
	
}
