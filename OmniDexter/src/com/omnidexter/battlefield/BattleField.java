package com.omnidexter.battlefield;

import com.omnidex.weather.Weather;

/**
 * @author jakers
 */
public interface BattleField extends Weather {
	void setGravity(int duration);

	void setWonderRoom(int duration);

	void setTrickRoom(int duration);

	void setMagicRoom(int duration);

	/**
	 * @return a boolean representing if Gravity is in affect.
	 */
	boolean hasGravity();

	/**
	 * @return a boolean representing if Wonder Room is in affect.
	 */
	boolean hasWonderRoom();

	/**
	 * @return a boolean representing if Trick Room is in affect.
	 */
	boolean hasTrickRoom();

	/**
	 * @return a boolean representing if Magic Room is in affect.
	 */
	boolean hasMagicRoom();

	/**
	 * 
	 * @return an int representing how many turns of Wonder Room are left.
	 */
	int getWonderRoomCount();

	/**
	 * @return an int representing how many turns of Trick Room are left.
	 */
	int getTrickRoomCount();

	/**
	 * @return an int representing how many turns of Magic Room are left
	 */
	int getMagicRoomCount();

	/**
	 * @return an int representing how many turns of Gravity are left
	 */
	int getGravityCount();

	void printBattleField();
	
	void decrementGravity();
	void decrementTrickRoom();
	void decrementWonderRoom();
	void decrementMagicRoom();
}
