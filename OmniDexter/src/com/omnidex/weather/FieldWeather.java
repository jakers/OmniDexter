package com.omnidex.weather;


/**
 * Creation Date: 3/10/2012
 * @author Akers
 */
public class FieldWeather implements Weather {

    private boolean isRain;
    private boolean isClear;
    private boolean isFog;
    private boolean isSand;
    private boolean isHail;
    private boolean isSun;
    private int duration;
    
    static final int DUR_0 = 0;
	static final int DUR_5 = 5;
	static final int DUR_8 = 8;
	static final int DUR_INF = -1;

	// SUN and RAIN modifiers
	static final double RAIN_FIRE_NEG_MOD = 0.5;
	static final double RAIN_WATER_BOOST_MOD = 2.0;
	static final double SUN_FIE_BOOST_MOD = 2.0;
	static final double SUN_WATER_NEG_MOD = 0.5;

    public FieldWeather() {
        clearWeather();
    }

    public FieldWeather(Weather weather) {
        isRain = weather.isRain();
        isClear = weather.isClear();
        isFog = weather.isFog();
        isSand = weather.isSand();
        isHail = weather.isHail();
        isSun = weather.isSun();
        duration = weather.getDuration();
    }

    /**
	 * Decreases the duration of the current weather by 1. If the duration of
	 * the weather becomes zero then the weather is set to NO_WEATHER.
	 */
    public int getDuration() {
        return duration;
    }

    /**
	 * Returns the number of turns the weather will be in play.
	 * 
	 * @return an int representing the number of turns that the current weather
	 *         will be in effect. A return value of -1 indicates infinite
	 *         weather condition.
	 */
    public void decrementDuration() {
        if (duration > 0) {
            duration--;
            if (duration == 0) {
                clearWeather();
            }
        }
    }

    /**
	 * @return a boolean representing whether or not the current weather
	 *         condition is no weather.
	 */
    public boolean isClear() {
        return isClear;
    }

    /**
	 * @return a boolean representing whether or not the current weather
	 *         condition is Fog.
	 */
    public boolean isFog() {
        return isFog;
    }

    /**
	 * @return a boolean representing whether or not the current weather
	 *         condition is Hail.
	 */
    public boolean isHail() {
        return isHail;
    }

    /**
	 * @return a boolean representing whether or not the current weather
	 *         condition is Rain.
	 */
    public boolean isRain() {
        return isRain;
    }

    /**
	 * @return a boolean representing whether or not the current weather
	 *         condition is Sand.
	 */
    public boolean isSand() {
        return isSand;
    }

    /**
	 * @return a boolean representing whether or not the current weather
	 *         condition is Sun.
	 */
    @Override
    public boolean isSun() {
        return isSun;
    }

    /**
	 * Sets the current weather condition to No Weather and sets the duration.
	 */
    public void setClear() {
        clearWeather();
    }

    /**
	 * Sets the current weather condition to Fog and sets the duration of the
	 * weather effect.
	 * 
	 * @param duration
	 *            an int representing how long the Fog will last.
	 */
    public void setFog(int duration) {
        clearWeather();
        isClear = false;
        isFog = true;
        this.duration = duration;
    }

    /**
	 * Sets the current weather condition to Hail and sets the duration of the
	 * weather effect.
	 * 
	 * @param duration
	 *            an int representing how long the Hail will last.
	 */
    @Override
    public void setHail(int duration) {
        clearWeather();
        isClear = false;
        isHail = true;
        this.duration = duration;
    }

    /**
	 * Sets the current weather condition to Rain and sets the duration of the
	 * weather effect.
	 * 
	 * @param duration
	 *            an int representing how long the Rain will last.
	 */
    public void setRain(int duration) {
        clearWeather();
        isClear = false;
        isRain = true;
        this.duration = duration;
    }

    /**
	 * Sets the current weather condition to Sand and sets the duration of the
	 * weather effect.
	 * 
	 * @param duration
	 *            an int representing how long the Sand will last.
	 */
    public void setSand(int duration) {
        clearWeather();
        isClear = false;
        isSand = true;
        this.duration = duration;
    }

    
    /**
	 * Sets the current weather condition to Sun and sets the duration of the
	 * weather effect.
	 * 
	 * @param duration
	 *            an int representing how long the Sun will last.
	 */
    public void setSun(int duration) {
        clearWeather();
        isClear = false;
        isSun = true;
        this.duration = duration;
    }

    private void clearWeather() {
        isClear = true;
        isRain = false;
        isSun = false;
        isSand = false;
        isFog = false;
        isHail = false;

        duration = DUR_INF;
    }

	public String getWeatherCondition() {
		String condition = "Foggy";
		if (isClear) {
			condition = "Clear";
		}
		else if (isRain) {
			condition = "Raining";
		} else if (isSun) {
			condition = "Sunny";
		} else if (isSand) {
			condition = "Sandstorm";
		} else if (isHail) {
			condition = "Hailing";
		} 
		return condition;
	}
}
