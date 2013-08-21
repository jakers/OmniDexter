package com.omnidex.test.pokemon;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.omnidex.pokemon.Stage;
import com.omnidex.pokemon.Stageable;

public class StageTest {
	
	private Stageable ch;
	
	@Before
	public void setup() {
		ch = new Stage(1,5,1);
	}
	
	@Test
	public void canCreateCriticalHit() {
		assertEquals(1, ch.getStage());
	}
	
	@Test
	public void TestMaxCriticalHitStage() {
		ch.boostToMaxStage();
		assertEquals(5, ch.getStage());
	}
	
	@Test
	public void TestMinCriticalHitStage() {
		ch.boostStage(3);
		assertEquals(4, ch.getStage());
		ch.decreaseToMinStage();
		assertEquals(1, ch.getStage());
	}
	
	@Test
	public void TestBoostCriticalHitStage() {
		ch.boostStage(2);
		assertEquals(3, ch.getStage());
	}
	
	@Test
	public void TestBoostCriticalHitStageWhileAtMax() {
		ch.boostToMaxStage();
		ch.boostStage(3);
		assertEquals(5, ch.getStage());
	}
	
	@Test
	public void TestDecreaseCriticalHitStage() {
		ch.boostToMaxStage();
		ch.decreaseStage(2);
		assertEquals(3, ch.getStage());
	}

	@Test
	public void TestDecreaseCriticalHitStageWhileAtMin() {
		ch.decreaseStage(5);
		assertEquals(1, ch.getStage());
	}
	
}
