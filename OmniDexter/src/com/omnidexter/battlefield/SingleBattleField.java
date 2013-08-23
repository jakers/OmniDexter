package com.omnidexter.battlefield;

import com.omnidex.weather.FieldWeather;
import com.omnidex.weather.Weather;

public class SingleBattleField extends FieldWeather implements BattleField {

	private int gravityCount;
	private int trickRoomCount;
	private int wonderRoomCount;
	private int magicRoomCount;

	public SingleBattleField() {
		super();
		gravityCount = 0;
		trickRoomCount = 0;
		wonderRoomCount = 0;
		magicRoomCount = 0;
	}

	public SingleBattleField(BattleField field) {
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

	public void printBattleField() {
		System.out.print("Weather: " + getWeatherCondition());
		if (!getWeatherCondition().equals("Clear")) {
			if (super.getDuration() == Weather.PERMANENT) {
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

	@Override
	public void setGravity(int duration) {
		gravityCount = duration;
	}

	@Override
	public void setWonderRoom(int duration) {
		wonderRoomCount = duration;
	}

	@Override
	public void setTrickRoom(int duration) {
		trickRoomCount = duration;
	}

	@Override
	public void setMagicRoom(int duration) {
		magicRoomCount = duration;
	}
	
	@Override
	public void decrementGravity() {
		if (gravityCount > 0) {
			gravityCount--;
		}
	}

	@Override
	public void decrementTrickRoom() {
		if (trickRoomCount > 0) {
			trickRoomCount--;
		}
	}

	@Override
	public void decrementWonderRoom() {
		if (wonderRoomCount > 0) {
			wonderRoomCount--;
		}
	}

	@Override
	public void decrementMagicRoom() {
		if (magicRoomCount > 0) {
			magicRoomCount--;
		}
	}
}
