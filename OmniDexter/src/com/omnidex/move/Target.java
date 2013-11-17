package com.omnidex.move;

public enum Target {
	ALL_ADJACENT("all adjacent"), ALL_ADJACENT_FOES("all adjacent foes"), ALL("all"), ALL_FOES("all foes"),
	ALL_ALLIES("all allies"), ANY_ADJACENT("any adjacent"), ANY("any"), ANY_ADJACENT_FOE("any adjacent foe"),
	SELF("self"), USER_AND_ALLIES("user and allies"),ADJACENT_ALLY("adjacent ally");
	
	private String name;
	Target(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
