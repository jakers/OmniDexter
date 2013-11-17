package com.omnidex.weather;

public class Weather {

	public static final int DURATION_FIVE = 5;
	public static final int DURATION_EIGHT = 8;
	public static final int DURATION_PERMANENT = -1;
	public static final String CLEAR = "Clear";
	public static final String FOG = "Fog";
	public static final String HAIL = "Hail";
	public static final String RAIN = "Rain";
	public static final String SAND = "Sand Storm";
	public static final String SUN = "Sun";
	public static final double WEATHER_DAMAGE_DEBUFF_MOD = 0;
	public static final double WEATHER_DAMAGE_BUFF_MOD = 0;
	
	private int duration;
	private boolean isRain;
	private boolean isSun;
	private boolean isSand;
	private boolean isHail;
	private boolean isFog;
	
	public Weather() {
		clearWeather();
	}
	
	public Weather(Weather weather) {
		duration = weather.getDuration();
		isSand = weather.isSand();
		isRain = weather.isRain();
		isSun = weather.isSun();
		isFog = weather.isFog();
		isHail = weather.isHail();
	}

	public boolean isClear() {
		return duration == 0;
	}

//	// SUN and RAIN modifiers
//	static final double RAIN_SUN_NEG_MOD = 0.5;
//	static final double RAIN_SUN_BOOST_MOD = 2.0;

	public void setRain(int duration) {
		clearWeather();
		isRain = true;
		this.duration = duration; 
	}

	public boolean isRain() {
		return isRain;
	}

	public int getDuration() {
		return duration;
	}

	public void setSun(int duration) {
		clearWeather();
		isSun = true;
		this.duration = duration;
	}

	public boolean isSun() {
		return isSun;
	}

	public void clearWeather() {
		duration = 0;
		isRain = false;
		isSun = false;
		isSand = false;
		isHail = false;
		isFog = false;
	}

	public void setSand(int duration) {
		clearWeather();
		isSand = true;
		this.duration = duration;
	}

	public boolean isSand() {
		return isSand;
	}

	public boolean isHail() {
		return isHail;
	}

	public void setHail(int duration) {
		clearWeather();
		isHail = true;
		this.duration = duration;
	}

	public boolean isFog() {
		return isFog;
	}

	public void setFog(int duration) {
		clearWeather();
		isFog = true;
		this.duration = duration;
	}

	public void decrement() {
		if (duration > 0) {
			duration--;
			if (duration == 0) {
				clearWeather();
			}
		}
	}

	public String getWeatherText() {
		
		String weatherText = null;
		
		if (isClear()) {
			weatherText = Weather.CLEAR;
		} else if (isSand()) {
			weatherText = Weather.SAND;
		} else if (isRain()) {
			weatherText = Weather.RAIN;
		} else if (isSun()) {
			weatherText = Weather.SUN;
		} else if (isHail()) {
			weatherText = Weather.HAIL;
		} else if (isFog()) {
			weatherText = Weather.FOG;
		} 
		
		return weatherText;
	}
}
