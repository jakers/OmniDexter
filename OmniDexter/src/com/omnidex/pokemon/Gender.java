package com.omnidex.pokemon;

public enum Gender {
	 MALE("Male"), FEMALE("Female"), NEUTRAL("Genderless");
	
	private String name;
	
	Gender(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
