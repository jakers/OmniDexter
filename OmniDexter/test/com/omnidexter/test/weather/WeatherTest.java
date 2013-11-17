package com.omnidexter.test.weather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.omnidex.weather.Weather;

public class WeatherTest {

	private Weather weather;

	@Before
	public void setUp() {
		weather = new Weather();
	}

	@After
	public void tearDown() {
		weather = null;
	}

	@Test
	public void weatherIsClearOnCreation() {
		checkAllWeatherIsCleared();
	}

	@Test
	public void settingWeatherToRain() {
		weather.setRain(Weather.DURATION_FIVE);
		assertTrue(weather.isRain());
		checkWeatherIsNotClearAndHasDuration(Weather.DURATION_FIVE);
	}

	@Test
	public void settingWeatherToSun() {
		weather.setSun(Weather.DURATION_FIVE);
		assertTrue(weather.isSun());
		checkWeatherIsNotClearAndHasDuration(Weather.DURATION_FIVE);
	}

	@Test
	public void onlyOneWeatherAtATime() {
		weather.setRain(Weather.DURATION_FIVE);
		weather.setSun(Weather.DURATION_EIGHT);
		assertFalse(weather.isRain());
		assertTrue(weather.isSun());
		checkWeatherIsNotClearAndHasDuration(Weather.DURATION_EIGHT);
	}

	@Test
	public void settingWeatherToSandStorm() {
		assertFalse(weather.isSand());
		weather.setSand(Weather.DURATION_EIGHT);
		assertTrue(weather.isSand());
		checkWeatherIsNotClearAndHasDuration(Weather.DURATION_EIGHT);
	}

	@Test
	public void settingWeatherToHail() {
		assertFalse(weather.isHail());
		weather.setHail(Weather.DURATION_FIVE);
		assertTrue(weather.isHail());
		checkWeatherIsNotClearAndHasDuration(Weather.DURATION_FIVE);
	}

	@Test
	public void settingWeatherToFog() {
		assertFalse(weather.isFog());
		weather.setFog(Weather.DURATION_FIVE);
		assertTrue(weather.isFog());
		checkWeatherIsNotClearAndHasDuration(Weather.DURATION_FIVE);
	}

	@Test
	public void clearingSandByDecrementing() {
		weather.setSand(1);
		checkClearingOneTurnWeather();
	}

	@Test
	public void clearingSunByDecrementing() {
		weather.setSun(1);
		checkClearingOneTurnWeather();
	}

	@Test
	public void clearingRainByDecrementing() {
		weather.setRain(1);
		checkClearingOneTurnWeather();
	}

	@Test
	public void clearingFogByDecrementing() {
		weather.setFog(1);
		checkClearingOneTurnWeather();
	}

	@Test
	public void clearingHailByDecrementing() {
		weather.setHail(1);
		checkClearingOneTurnWeather();
	}

	@Test
	public void decrementingPermanentWeather() {
		weather.setRain(Weather.DURATION_PERMANENT);
		checkWeatherIsNotClearAndHasDuration(Weather.DURATION_PERMANENT);
		weather.decrement();
		assertTrue(weather.isRain());
		checkWeatherIsNotClearAndHasDuration(Weather.DURATION_PERMANENT);
	}

	@Test
	public void clearingWeatherExplicitly() {
		weather.setFog(Weather.DURATION_PERMANENT);
		weather.clearWeather();
		checkAllWeatherIsCleared();
	}

	@Test
	public void copyingAWeatherObject() {
		weather.setSand(Weather.DURATION_PERMANENT);
		Weather tempWeather = new Weather(weather);

		assertTrue(tempWeather.isSand());
		assertEquals(Weather.DURATION_PERMANENT, tempWeather.getDuration());
		tempWeather.setRain(Weather.DURATION_FIVE);

		checkOriginalRemainsUnchanged();

		assertTrue(tempWeather.isRain());
		assertEquals(Weather.DURATION_FIVE, tempWeather.getDuration());

		tempWeather.clearWeather();

		checkOriginalRemainsUnchanged();
	}

	@Test
	public void getWeatherText() {
		assertEquals(Weather.CLEAR, weather.getWeatherText());
		weather.setFog(Weather.DURATION_PERMANENT);
		assertEquals(Weather.FOG, weather.getWeatherText());
		weather.setHail(Weather.DURATION_PERMANENT);
		assertEquals(Weather.HAIL, weather.getWeatherText());
		weather.setRain(Weather.DURATION_PERMANENT);
		assertEquals(Weather.RAIN, weather.getWeatherText());
		weather.setSand(Weather.DURATION_PERMANENT);
		assertEquals(Weather.SAND, weather.getWeatherText());
		weather.setSun(Weather.DURATION_PERMANENT);
		assertEquals(Weather.SUN, weather.getWeatherText());
	}

	private void checkOriginalRemainsUnchanged() {
		assertTrue(weather.isSand());
		assertEquals(Weather.DURATION_PERMANENT, weather.getDuration());
	}

	private void checkAllWeatherIsCleared() {
		assertTrue(weather.isClear());
		assertFalse(weather.isSand());
		assertFalse(weather.isSun());
		assertFalse(weather.isRain());
		assertFalse(weather.isHail());
		assertFalse(weather.isFog());
		assertEquals(0, weather.getDuration());
	}

	private void checkWeatherIsNotClearAndHasDuration(int duration) {
		assertFalse(weather.isClear());
		assertEquals(duration, weather.getDuration());
	}

	private void checkClearingOneTurnWeather() {
		checkWeatherIsNotClearAndHasDuration(1);
		weather.decrement();
		checkAllWeatherIsCleared();
	}
}
