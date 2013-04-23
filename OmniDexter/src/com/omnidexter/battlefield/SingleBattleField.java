package com.omnidexter.battlefield;

import com.omnidex.weather.FieldWeather;
import com.omnidex.weather.Weather;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleBattleField extends FieldWeather implements BattleField {

	private boolean hasGravity;
	private boolean hasTrickRoom;
	private boolean hasWonderRoom;
	private boolean hasMagicRoom;
	private AtomicInteger gravityCount;
	private AtomicInteger trickRoomCount;
	private AtomicInteger wonderRoomCount;
	private AtomicInteger magicRoomCount;

	public SingleBattleField() {
		super();
		hasGravity = false;
		hasTrickRoom = false;
		hasWonderRoom = false;
		hasMagicRoom = false;
		
		gravityCount = new AtomicInteger(0);
		trickRoomCount = new AtomicInteger(0);
		wonderRoomCount = new AtomicInteger(0);
		magicRoomCount = new AtomicInteger(0);
	}

	public SingleBattleField(BattleField field) {
		super(field);
		this.hasGravity = field.hasGravity();
		this.hasTrickRoom = field.hasTrickRoom();
		this.hasWonderRoom = field.hasWonderRoom();
		this.hasMagicRoom = field.hasMagicRoom();
		this.gravityCount = new AtomicInteger(field.getGravityCount());
		this.trickRoomCount = new AtomicInteger(field.getTrickRoomCount());
		this.wonderRoomCount = new AtomicInteger(field.getWonderRoomCount());
		this.magicRoomCount = new AtomicInteger(field.getMagicRoomCount());
	}

	public boolean hasGravity() {
		return hasGravity;
	}

	public boolean hasWonderRoom() {
		return hasWonderRoom;
	}

	public boolean hasTrickRoom() {
		return hasTrickRoom;
	}

	public boolean hasMagicRoom() {
		return hasMagicRoom;
	}

	public int getWonderRoomCount() {
		return wonderRoomCount.get();
	}

	public int getTrickRoomCount() {
		return trickRoomCount.get();
	}

	public int getMagicRoomCount() {
		return magicRoomCount.get();
	}

	public int getGravityCount() {
		return gravityCount.get();
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
		hasGravity = true;
		gravityCount.set(duration);
	}

	@Override
	public void setWonderRoom(int duration) {
		hasWonderRoom = true;
		wonderRoomCount.set(duration);
	}

	@Override
	public void setTrickRoom(int duration) {
		hasTrickRoom = true;
		trickRoomCount.set(duration);
	}

	@Override
	public void setMagicRoom(int duration) {
		hasMagicRoom = true;
		magicRoomCount.set(duration);
	}
	
	private boolean resetAfterDecrement(boolean flag, AtomicInteger count) {
		if (count.get() > 0) {
			count.set(count.get()-1);
			if (count.get() == 0) {
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public void decrementGravity() {
		hasGravity = resetAfterDecrement(hasGravity, gravityCount);
	}

	@Override
	public void decrementTrickRoom() {
		hasTrickRoom = resetAfterDecrement(hasTrickRoom, trickRoomCount);
	}

	@Override
	public void decrementWonderRoom() {
		hasWonderRoom = resetAfterDecrement(hasWonderRoom, wonderRoomCount);
	}

	@Override
	public void decrementMagicRoom() {
		hasMagicRoom = resetAfterDecrement(hasMagicRoom, magicRoomCount);
	}
}
