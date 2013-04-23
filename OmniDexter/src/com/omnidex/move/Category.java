package com.omnidex.move;

public enum Category {
	 PHYSICAL("physical"),SPECIAL("special"),STATUS("status");
	 private String name;
	 
	 Category(String name) {
		 this.name = name;
	 }
	 
	 public String toString() {
		 return name;
	 }
}
