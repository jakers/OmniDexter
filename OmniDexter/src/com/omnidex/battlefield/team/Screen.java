package com.omnidex.battlefield.team;

/**
 * This interface promises the behaviors of Light Screen and Reflect. Light
 * Screen reduces Special move damage and Reflect reduces physical move damage.
 * 
 * @author jakers
 */
public interface Screen {
	/**
	 * Sets up a Reflect with a fixed duration.
	 * 
	 * @param duration
	 *            an int representing how long the Reflect will remain in
	 *            affect.
	 */
	void setReflect(int duration);

	/**
	 * Sets up a Light Screen with a fixed duration.
	 * 
	 * @param duration
	 *            an int representing how long the Light Screen will remain in
	 *            affect.
	 */
	void setLightScreen(int duration);

	/**
	 * Removes the Reflect from the field. Call this in cases like Brick Break.
	 * The Reflect count is set to 0.
	 */
	void removeRelfect();

	/**
	 * Removes the Light Screen from the field. Call this in cases like Brick
	 * Break. The Light Screen count is set to 0.
	 */
	void removeLightScreen();

	/**
	 * Removes both the Reflect and Light Screen from the field. Call this in a
	 * case like Brick Break. Both Reflect and Light Screen counts are set to 0.
	 */
	void removeBoth();

	/**
	 * @return a boolean representing whether or not a Reflect is on the field.
	 */
	boolean hasRelfect();

	/**
	 * @return a boolean representing whether or not a Light Screen is on the
	 *         field.
	 */
	boolean hasLightScreen();

	/**
	 * decrements the light screen if the there is one Removes the lightscreen
	 * if the count becoems 0
	 */
	void decrementLightScreen();

	/**
	 * decrements the reflect if there is one. Removes the reflect if the count
	 * becomes 0
	 */
	void decrementRelfect();

	// TODO javadocs
	int getLightScreenCount();
	
	int getReflectCount();
	
}
