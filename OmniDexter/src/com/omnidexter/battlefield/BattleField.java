package com.omnidexter.battlefield;

import com.omnidex.weather.Weather;

public class BattleField extends Weather {

	private int gravityCount;
	private int trickRoomCount;
	private int wonderRoomCount;
	private int magicRoomCount;

	public BattleField() {
		super();
		gravityCount = 0;
		trickRoomCount = 0;
		wonderRoomCount = 0;
		magicRoomCount = 0;
	}

	public BattleField(BattleField field) {
		super(field);
		this.gravityCount = field.getGravityCount();
		this.trickRoomCount = field.getTrickRoomCount();
		this.wonderRoomCount = field.getWonderRoomCount();
		this.magicRoomCount = field.getMagicRoomCount();
	}

	public boolean hasGravity() {
		return gravityCount > 0;
	}

	public boolean hasWonderRoom() {
		return wonderRoomCount > 0;
	}

	public boolean hasTrickRoom() {
		return trickRoomCount > 0;
	}

	public boolean hasMagicRoom() {
		return magicRoomCount > 0;
	}

	public int getWonderRoomCount() {
		return wonderRoomCount;
	}

	public int getTrickRoomCount() {
		return trickRoomCount;
	}

	public int getMagicRoomCount() {
		return magicRoomCount;
	}

	public int getGravityCount() {
		return gravityCount;
	}

	public Weather getWeather() {
		return this;
	}
	
	public void printBattleField() {
		System.out.print("Weather: " + getWeatherText());
		if (!isClear()) {
			if (super.getDuration() == Weather.DURATION_PERMANENT) {
				System.out.print(" : Perma");
			} else {
				System.out.print(" for " + super.getDuration()
						+ " more turn(s)");
			}
		}
		System.out.println();
		System.out.println("Gravity: " + gravityCount);
		System.out.println("Trick Room: " + trickRoomCount);
		System.out.println("Magic Room: " + magicRoomCount);
		System.out.println("Wonder Room: " + wonderRoomCount);
	}

	public void setGravity(int duration) {
		gravityCount = duration;
	}

	public void setWonderRoom(int duration) {
		wonderRoomCount = duration;
	}

	public void setTrickRoom(int duration) {
		trickRoomCount = duration;
	}

	public void setMagicRoom(int duration) {
		magicRoomCount = duration;
	}
	
	public void decrementGravity() {
		if (gravityCount > 0) {
			gravityCount--;
		}
	}

	public void decrementTrickRoom() {
		if (trickRoomCount > 0) {
			trickRoomCount--;
		}
	}

	public void decrementWonderRoom() {
		if (wonderRoomCount > 0) {
			wonderRoomCount--;
		}
	}

	public void decrementMagicRoom() {
		if (magicRoomCount > 0) {
			magicRoomCount--;
		}
	}
}
