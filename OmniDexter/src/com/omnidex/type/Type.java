package com.omnidex.type;

import com.omnidex.pokemon.Pokemon;

public enum Type {
	NO_TYPE(0, "(none)", new double[]{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0}),
	BUG(1,"Bug",new double[]{1.0,1.0,2.0,1.0,1.0,0.5,0.5,0.5,0.5,2.0,1.0,1.0,1.0,0.5,2.0,1.0,0.5,1.0,0.5}),
	DARK(2, "Dark",new double[]{1.0,1.0,0.5,1.0,1.0,0.5,1.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,0.5}),
	DRAGON(3, "Dragon",new double[]{1.0,1.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.5,1.0,0.0}),
	ELECTRIC(4, "Electric",new double[]{1.0,1.0,1.0,0.5,0.5,1.0,1.0,2.0,1.0,0.5,0.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0}),
	FIGHTING(5, "Fighting",new double[]{1.0,0.5,2.0,1.0,1.0,1.0,1.0,0.5,0.0,1.0,1.0,2.0,2.0,0.5,0.5,2.0,2.0,1.0,0.5}),
	FIRE(6, "Fire",new double[]{1.0,2.0,1.0,0.5,1.0,1.0,0.5,1.0,1.0,2.0,1.0,2.0,1.0,1.0,1.0,0.5,2.0,0.5,1.0}), 
	FLYING(7, "Flying",new double[]{1.0,2.0,1.0,1.0,0.5,2.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0,0.5,0.5,1.0,1.0}),
	GHOST(8, "Ghost",new double[]{1.0,1.0,0.5,1.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,0.0,1.0,2.0,1.0,0.5,1.0,1.0}),
	GRASS(9, "Grass",new double[]{1.0,0.5,1.0,0.5,1.0,1.0,0.5,0.5,1.0,0.5,2.0,1.0,1.0,0.5,1.0,2.0,0.5,2.0,1.0}), 
	GROUND(10, "Ground",new double[]{1.0,0.5,1.0,1.0,2.0,1.0,2.0,0.0,1.0,0.5,1.0,1.0,1.0,2.0,1.0,2.0,2.0,1.0,1.0}),
	ICE(11, "Ice",new double[]{1.0,1.0,1.0,2.0,1.0,1.0,0.5,2.0,1.0,2.0,2.0,0.5,1.0,1.0,1.0,1.0,0.5,0.5,1.0}),
	NORMAL(12, "Normal",new double[]{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,0.5,0.5,1.0,1.0}),
	POISON(13, "Poison",new double[]{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.5,2.0,0.5,1.0,1.0,0.5,1.0,1.0,0.0,1.0,2.0}), 
	PSYCHIC(14, "Psychic",new double[]{1.0,1.0,0.0,1.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,0.5,1.0,0.5,1.0,1.0}),
	ROCK(15, "Rock",new double[]{1.0,2.0,1.0,1.0,1.0,0.5,2.0,2.0,1.0,1.0,0.5,2.0,1.0,1.0,1.0,1.0,0.5,1.0,1.0}),
	STEEL(16, "Steel",new double[]{1.0,1.0,1.0,1.0,0.5,1.0,0.5,1.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,2.0,0.5,0.5,2.0}),
	WATER(17, "Water",new double[]{1.0,1.0,1.0,0.5,1.0,1.0,2.0,1.0,1.0,0.5,2.0,1.0,1.0,1.0,1.0,2.0,1.0,0.5,1.0}),
	FAIRY(18, "Fairy",new double[]{1.0,1.0,2.0,2.0,1.0,2.0,0.5,1.0,1.0,1.0,1.0,1.0,1.0,0.5,1.0,1.0,0.5,1.0,1.0});
	
	private int index;
	private String name;
	private double [] typeChart;
	
	Type(int index, String name, double[] typeChart) {
		this.index = index;
		this.name = name;
		this.typeChart = typeChart;
	}
	
	public int getIndex() {
		return index;
	}
	public String toString() {
		return name;
	}
	
	public boolean isSuperEffective(Pokemon poke) {
		return getEffectiveness(poke) > 1.0;
	}
	
	public boolean isNotVeryEffective(Pokemon poke) {
		return getEffectiveness(poke) < 1.0;
	}
	
	public double getEffectiveness(Pokemon poke) {
		return typeChart[poke.getFirstType().getIndex()] * typeChart[poke.getSecondType().getIndex()];
	}
	
	public double getEffectiveness(Type defending) {
		return typeChart[defending.getIndex()];
	}
	
}
