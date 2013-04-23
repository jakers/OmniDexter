package com.omnidex.type;

/**
 * The Pokemon Types
 * @author jakers
 */

public enum Type {
	NO_TYPE(0, "(none)"), BUG(1,"Bug"), DARK(2, "Dark"), DRAGON(3, "Dragon"),
	ELECTRIC(4, "Electric"), FIGHTING(5, "Fighting"), FIRE(6, "Fire"), 
	FLYING(7, "Flying"), GHOST(8, "Ghost"), GRASS(9, "Grass"), 
	GROUND(10, "Ground"), ICE(11, "Ice"), NORMAL(12, "Normal"), POISON(13, "Poison"), 
	PSYCHIC(14, "Psychic"), ROCK(15, "Rock"), STEEL(16, "Steel"), WATER(17, "Water");
	
	private int index;
	private String name;
	
	Type(int index, String name) {
		this.index = index;
		this.name = name;
	}
	
	public int getIndex() {
		return index;
	}
	public String toString() {
		return name;
	}
}
