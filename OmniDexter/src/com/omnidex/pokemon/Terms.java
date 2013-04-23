package com.omnidex.pokemon;

public enum Terms {
	 MALE("Male"), FEMALE("Female"), NEUTRAL("Genderless");
	
	private String name;
	
	Terms(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
