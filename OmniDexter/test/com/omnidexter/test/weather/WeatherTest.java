package com.omnidexter.test.weather;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.omnidex.weather.FieldWeather;
import com.omnidex.weather.Weather;

/**
 * @author jakers
 */
public class WeatherTest {

	private Weather weather;

	@Before
	public void setUp() {
		weather = new FieldWeather();
	}

	/**
	 * Test of decrementDuration method, of class Weather.
	 */
	@Test
	public void testDecrementDuration() {
		System.out.println("decrementDuration");
		weather.setFog(Weather.DUR_5);
		assertEquals(Weather.DUR_5, weather.getDuration());
		weather.decrementDuration();
		assertEquals(Weather.DUR_5 - 1, weather.getDuration());
	}

	/**
	 * Test of getDuration method, of class Weather.
	 */
	@Test
	public void testGetDuration() {
		System.out.println("getDuration");
		int expResult = Weather.DUR_8;
		weather.setRain(Weather.DUR_8);
		int result = weather.getDuration();
		assertEquals(expResult, result);
	}

	/**
	 * Test of isRain method, of class Weather.
	 */
	@Test
	public void testIsRain() {
		System.out.println("isRain");
		weather.setRain(Weather.DUR_5);
		assertEquals(true, weather.isRain());
		assertEquals(false, weather.isFog());
		assertEquals(false, weather.isHail());
		assertEquals(false, weather.isClear());
		assertEquals(false, weather.isSand());
		assertEquals(false, weather.isSun());
	}

	/**
	 * Test of isFog method, of class Weather.
	 */
	@Test
	public void testIsFog() {
		System.out.println("isFog");
		weather.setFog(Weather.DUR_5);
		assertEquals(false, weather.isRain());
		assertEquals(true, weather.isFog());
		assertEquals(false, weather.isHail());
		assertEquals(false, weather.isClear());
		assertEquals(false, weather.isSand());
		assertEquals(false, weather.isSun());
	}

	/**
	 * Test of isSun method, of class Weather.
	 */
	@Test
	public void testIsSun() {
		System.out.println("isSun");
		weather.setSun(Weather.DUR_5);
		assertEquals(false, weather.isRain());
		assertEquals(false, weather.isFog());
		assertEquals(false, weather.isHail());
		assertEquals(false, weather.isClear());
		assertEquals(false, weather.isSand());
		assertEquals(true, weather.isSun());
	}

	/**
	 * Test of isHail method, of class Weather.
	 */
	@Test
	public void testIsHail() {
		System.out.println("isHail");
		weather.setHail(Weather.DUR_5);
		assertEquals(false, weather.isRain());
		assertEquals(false, weather.isFog());
		assertEquals(true, weather.isHail());
		assertEquals(false, weather.isClear());
		assertEquals(false, weather.isSand());
		assertEquals(false, weather.isSun());
	}

	/**
	 * Test of isSand method, of class Weather.
	 */
	@Test
	public void testIsSand() {
		System.out.println("isSand");
		weather.setRain(Weather.DUR_8);
		weather.setSand(Weather.DUR_5);
		assertEquals(false, weather.isRain());
		assertEquals(false, weather.isFog());
		assertEquals(false, weather.isHail());
		assertEquals(false, weather.isClear());
		assertEquals(true, weather.isSand());
		assertEquals(false, weather.isSun());
	}

	/**
	 * Test of isClear method, of class Weather.
	 */
	@Test
	public void testIsClear() {
		System.out.println("isClear");
		weather.setClear();
		assertEquals(false, weather.isRain());
		assertEquals(false, weather.isFog());
		assertEquals(false, weather.isHail());
		assertEquals(true, weather.isClear());
		assertEquals(false, weather.isSand());
		assertEquals(false, weather.isSun());
		assertEquals(Weather.PERMANENT, weather.getDuration());
	}

	/**
	 * Test of setRain method, of class Weather.
	 */
	@Test
	public void testSetRain() {
		System.out.println("setRain");
		weather.setSand(Weather.DUR_8);
		weather.setRain(Weather.DUR_5);
		assertEquals(true, weather.isRain());
		assertEquals(false, weather.isFog());
		assertEquals(false, weather.isHail());
		assertEquals(false, weather.isClear());
		assertEquals(false, weather.isSand());
		assertEquals(false, weather.isSun());
		assertEquals(Weather.DUR_5, weather.getDuration());
	}

	/**
	 * Test of setFog method, of class Weather.
	 */
	@Test
	public void testSetFog() {
		System.out.println("setFog");
		weather.setSun(Weather.PERMANENT);
		weather.setFog(Weather.DUR_5);
		assertEquals(false, weather.isRain());
		assertEquals(true, weather.isFog());
		assertEquals(false, weather.isHail());
		assertEquals(false, weather.isClear());
		assertEquals(false, weather.isSand());
		assertEquals(false, weather.isSun());
		assertEquals(Weather.DUR_5, weather.getDuration());
	}

	/**
	 * Test of setSun method, of class Weather.
	 */
	@Test
	public void testSetSun() {
		System.out.println("setSun");
		weather.setHail(Weather.DUR_5);
		weather.setSun(Weather.PERMANENT);
		assertEquals(false, weather.isRain());
		assertEquals(false, weather.isFog());
		assertEquals(false, weather.isHail());
		assertEquals(false, weather.isClear());
		assertEquals(false, weather.isSand());
		assertEquals(true, weather.isSun());
		assertEquals(Weather.PERMANENT, weather.getDuration());
	}

	/**
	 * Test of setHail method, of class Weather.
	 */
	@Test
	public void testSetHail() {
		System.out.println("setHail");
		weather.setSand(Weather.DUR_5);
		weather.setHail(Weather.DUR_8);
		assertEquals(false, weather.isRain());
		assertEquals(false, weather.isFog());
		assertEquals(true, weather.isHail());
		assertEquals(false, weather.isClear());
		assertEquals(false, weather.isSand());
		assertEquals(false, weather.isSun());
		assertEquals(Weather.DUR_8, weather.getDuration());
	}

	/**
	 * Test of setSand method, of class Weather.
	 */
	@Test
	public void testSetSand() {
		System.out.println("setSand");
		weather.setSun(Weather.PERMANENT);
		weather.setSand(Weather.PERMANENT);
		assertEquals(false, weather.isRain());
		assertEquals(false, weather.isFog());
		assertEquals(false, weather.isHail());
		assertEquals(false, weather.isClear());
		assertEquals(true, weather.isSand());
		assertEquals(false, weather.isSun());
		assertEquals(Weather.PERMANENT, weather.getDuration());
	}

	/**
	 * Test of setClear method, of class Weather.
	 */
	@Test
	public void testSetClear() {
		System.out.println("setClear");
		weather.setSand(Weather.DUR_8);
		weather.setRain(Weather.DUR_5);
		weather.setClear();
		assertEquals(false, weather.isRain());
		assertEquals(false, weather.isFog());
		assertEquals(false, weather.isHail());
		assertEquals(true, weather.isClear());
		assertEquals(false, weather.isSand());
		assertEquals(false, weather.isSun());
		assertEquals(Weather.PERMANENT, weather.getDuration());
	}

	@After
	public void tearDown() {
		weather = null;
	}
}
