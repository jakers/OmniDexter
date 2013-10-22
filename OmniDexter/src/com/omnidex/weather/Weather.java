package com.omnidex.weather;

/**
 * Weather is a field condition that exists on the field. These are the methods
 * that weather can have.
 * 
 * @author jakers
 */
public interface Weather {
	// constants for the duration of weather
	static final int DUR_0 = 0;
	static final int DUR_5 = 5;
	static final int DUR_8 = 8;
	static final int PERMANENT = -1;

	// SUN and RAIN modifiers
	static final double RAIN_SUN_NEG_MOD = 0.5;
	static final double RAIN_SUN_BOOST_MOD = 2.0;

	// TODO javadocs getWeatherCondition
	String getWeatherCondition();

	/**
	 * Decreases the duration of the current weather by 1. If the duration of
	 * the weather becomes zero then the weather is set to NO_WEATHER.
	 */
	void decrementDuration();

	/**
	 * Returns the number of turns the weather will be in play.
	 * 
	 * @return an int representing the number of turns that the current weather
	 *         will be in effect. A return value of -1 indicates infinite
	 *         weather condition.
	 */
	int getDuration();

	/**
	 * @return a boolean representing whether or not the current weather
	 *         condition is no weather.
	 */
	boolean isClear();

	/**
	 * @return a boolean representing whether or not the current weather
	 *         condition is Fog.
	 */
	boolean isFog();

	/**
	 * @return a boolean representing whether or not the current weather
	 *         condition is Hail.
	 */
	boolean isHail();

	/**
	 * @return a boolean representing whether or not the current weather
	 *         condition is Rain.
	 */
	boolean isRain();

	/**
	 * @return a boolean representing whether or not the current weather
	 *         condition is Sand.
	 */
	boolean isSand();

	/**
	 * @return a boolean representing whether or not the current weather
	 *         condition is Sun.
	 */
	boolean isSun();

	/**
	 * Sets the current weather condition to No Weather and sets the duration.
	 */
	void setClear();

	/**
	 * Sets the current weather condition to Fog and sets the duration of the
	 * weather effect.
	 * 
	 * @param duration
	 *            an int representing how long the Fog will last.
	 */
	void setFog(int duration);

	/**
	 * Sets the current weather condition to Hail and sets the duration of the
	 * weather effect.
	 * 
	 * @param duration
	 *            an int representing how long the Hail will last.
	 */
	void setHail(int duration);

	/**
	 * Sets the current weather condition to Rain and sets the duration of the
	 * weather effect.
	 * 
	 * @param duration
	 *            an int representing how long the Rain will last.
	 */
	void setRain(int duration);

	/**
	 * Sets the current weather condition to Sand and sets the duration of the
	 * weather effect.
	 * 
	 * @param duration
	 *            an int representing how long the Sand will last.
	 */
	void setSand(int duration);

	/**
	 * Sets the current weather condition to Sun and sets the duration of the
	 * weather effect.
	 * 
	 * @param duration
	 *            an int representing how long the Sun will last.
	 */
	void setSun(int duration);
}
