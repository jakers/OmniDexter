package com.omnidexter.test.damage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.omnidex.damage.MathUtils;

public class MathUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void decrementingGreaterThanOne() {
		int i = 5;
		i = MathUtils.decrement(i);
		assertEquals(4, i);
	}
	
	@Test
	public void decrementingOne() {
		int i = 1;
		i = MathUtils.decrement(i);
		assertEquals(0, i);
	}

	@Test
	public void decrementingNonPermanentNegative() {
		int i = -40;
		i = MathUtils.decrement(i);
		assertEquals(0, i);
	}
	
}
