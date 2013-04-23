package com.omnidex.type;

/**
 * The type chart for Pokemon
 * @author jakers
 */
public class TypeChart {
	
	private double[][] typeChart;
	
	public TypeChart() {
		typeChart = new double[18][18];
		
		/* NO_TYPE attacking */
		typeChart[0][0] = 1.0; // NO_TYPE
		typeChart[0][1] = 1.0; // BUG		
		typeChart[0][2] = 1.0; // DARK
		typeChart[0][3]= 1.0;  // DRAGON
		typeChart[0][4] = 1.0; // ELECTRIC
		typeChart[0][5] = 1.0; // FIGHTING
		typeChart[0][6] = 1.0; // FIRE
		typeChart[0][7] = 1.0; // FLYING
		typeChart[0][8] = 1.0; // GHOST
		typeChart[0][9] = 1.0; // GRASS
		typeChart[0][10] = 1.0; // GROUND
		typeChart[0][11] = 1.0; // ICE 
		typeChart[0][12] = 1.0; // NORMAL
		typeChart[0][13] = 1.0; // POISON
		typeChart[0][14] = 1.0; // PSYCHIC
		typeChart[0][15] = 1.0; // ROCK	
		typeChart[0][16] = 1.0; // STEEL
		typeChart[0][17] = 1.0;// WATER
				
		/* BUG attacking */
		typeChart[1][0] = 1.0; // NO_TYPE
		typeChart[1][1] = 1.0; // BUG		
		typeChart[1][2] = 2.0; // DARK
		typeChart[1][3]= 1.0;  // DRAGON
		typeChart[1][4] = 1.0; // ELECTRIC
		typeChart[1][5] = 0.5; // FIGHTING
		typeChart[1][6] = 0.5; // FIRE
		typeChart[1][7] = 0.5; // FLYING
		typeChart[1][8] = 0.5; // GHOST
		typeChart[1][9] = 2.0; // GRASS
		typeChart[1][10] = 1.0; // GROUND
		typeChart[1][11] = 1.0; // ICE 
		typeChart[1][12] = 1.0; // NORMAL
		typeChart[1][13] = 0.5; // POISON
		typeChart[1][14] = 2.0; // PSYCHIC
		typeChart[1][15] = 1.0; // ROCK	
		typeChart[1][16] = 0.5; // STEEL
		typeChart[1][17] = 1.0;// WATER
		
		/* DARK attacking */
		typeChart[2][0] = 1.0; // NO_TYPE
		typeChart[2][1] = 1.0; // BUG		
		typeChart[2][2] = 0.5; // DARK
		typeChart[2][3] = 1.0; // DRAGON
		typeChart[2][4] = 1.0; // ELECTRIC
		typeChart[2][5] = 0.5; // FIGHTING
		typeChart[2][6] = 1.0; // FIRE
		typeChart[2][7] = 1.0; // FLYING
		typeChart[2][8] = 2.0; // GHOST
		typeChart[2][9] = 1.0; // GRASS
		typeChart[2][10] = 1.0; // GROUND
		typeChart[2][11] = 1.0; // ICE 
		typeChart[2][12] = 1.0; // NORMAL
		typeChart[2][13] = 1.0; // POISON
		typeChart[2][14] = 2.0; // PSYCHIC
		typeChart[2][15] = 1.0; // ROCK	
		typeChart[2][16] = 0.5; // STEEL
		typeChart[2][17] = 1.0; // WATER
				
		/* DRAGON attacking */
		typeChart[3][0] = 1.0; // NO_TYPE
		typeChart[3][1] = 1.0; // BUG		
		typeChart[3][2] = 1.0; // DARK
		typeChart[3][3] = 2.0;  // DRAGON
		typeChart[3][4] = 1.0; // ELECTRIC
		typeChart[3][5] = 1.0; // FIGHTING
		typeChart[3][6] = 1.0; // FIRE
		typeChart[3][7] = 1.0; // FLYING
		typeChart[3][8] = 1.0; // GHOST
		typeChart[3][9] = 1.0; // GRASS
		typeChart[3][10] = 1.0; // GROUND
		typeChart[3][11] = 1.0; // ICE 
		typeChart[3][12] = 1.0; // NORMAL
		typeChart[3][13] = 1.0; // POISON
		typeChart[3][14] = 1.0; // PSYCHIC
		typeChart[3][15] = 1.0; // ROCK	
		typeChart[3][16] = 0.5; // STEEL
		typeChart[3][17] = 1.0;// WATER
				
		/* ELECTRIC attacking */
		typeChart[4][0] = 1.0; // NO_TYPE
		typeChart[4][1] = 1.0; // BUG		
		typeChart[4][2] = 1.0; // DARK
		typeChart[4][3] = 0.5;  // DRAGON
		typeChart[4][4] = 0.5; // ELECTRIC
		typeChart[4][5] = 1.0; // FIGHTING
		typeChart[4][6] = 1.0; // FIRE
		typeChart[4][7] = 2.0; // FLYING
		typeChart[4][8] = 1.0; // GHOST
		typeChart[4][9] = 0.5; // GRASS
		typeChart[4][10] = 0.0; // GROUND
		typeChart[4][11] = 1.0; // ICE 
		typeChart[4][12] = 1.0; // NORMAL
		typeChart[4][13] = 1.0; // POISON
		typeChart[4][14] = 1.0; // PSYCHIC
		typeChart[4][15] = 1.0; // ROCK	
		typeChart[4][16] = 1.0; // STEEL
		typeChart[4][17] = 2.0;// WATER
				
		/* FIGHTING attacking */
		typeChart[5][0] = 1.0; // NO_TYPE
		typeChart[5][1] = 0.5; // BUG		
		typeChart[5][2] = 2.0; // DARK
		typeChart[5][3] = 1.0;  // DRAGON
		typeChart[5][4] = 1.0; // ELECTRIC
		typeChart[5][5] = 1.0; // FIGHTING
		typeChart[5][6] = 1.0; // FIRE
		typeChart[5][7] = 0.5; // FLYING
		typeChart[5][8] = 0.0; // GHOST
		typeChart[5][9] = 1.0; // GRASS
		typeChart[5][10] = 1.0; // GROUND
		typeChart[5][11] = 2.0; // ICE 
		typeChart[5][12] = 2.0; // NORMAL
		typeChart[5][13] = 0.5; // POISON
		typeChart[5][14] = 0.5; // PSYCHIC
		typeChart[5][15] = 2.0; // ROCK	
		typeChart[5][16] = 2.0; // STEEL
		typeChart[5][17] = 1.0;// WATER
		
		/* FIRE attacking */
		typeChart[6][0] = 1.0; // NO_TYPE
		typeChart[6][1] = 2.0; // BUG		
		typeChart[6][2] = 1.0; // DARK
		typeChart[6][3] = 0.5;  // DRAGON
		typeChart[6][4] = 1.0; // ELECTRIC
		typeChart[6][5] = 1.0; // FIGHTING
		typeChart[6][6] = 0.5; // FIRE
		typeChart[6][7] = 1.0; // FLYING
		typeChart[6][8] = 1.0; // GHOST
		typeChart[6][9] = 2.0; // GRASS
		typeChart[6][10] = 1.0; // GROUND
		typeChart[6][11] = 2.0; // ICE 
		typeChart[6][12] = 1.0; // NORMAL
		typeChart[6][13] = 1.0; // POISON
		typeChart[6][14] = 1.0; // PSYCHIC
		typeChart[6][15] = 0.5; // ROCK	
		typeChart[6][16] = 2.0; // STEEL
		typeChart[6][17] = 0.5;// WATER
		
		/* FLYING attacking */
		typeChart[7][0] = 1.0; // NO_TYPE
		typeChart[7][1] = 2.0; // BUG		
		typeChart[7][2] = 1.0; // DARK
		typeChart[7][3]= 1.0;  // DRAGON
		typeChart[7][4] = 0.5; // ELECTRIC
		typeChart[7][5] = 2.0; // FIGHTING
		typeChart[7][6] = 1.0; // FIRE
		typeChart[7][7] = 1.0; // FLYING
		typeChart[7][8] = 1.0; // GHOST
		typeChart[7][9] = 2.0; // GRASS
		typeChart[7][10] = 1.0; // GROUND
		typeChart[7][11] = 1.0; // ICE 
		typeChart[7][12] = 1.0; // NORMAL
		typeChart[7][13] = 1.0; // POISON
		typeChart[7][14] = 1.0; // PSYCHIC
		typeChart[7][15] = 0.5; // ROCK	
		typeChart[7][16] = 0.5; // STEEL
		typeChart[7][17] = 1.0;// WATER
				
		/* GHOST attacking */
		typeChart[8][0] = 1.0; // NO_TYPE
		typeChart[8][1] = 1.0; // BUG		
		typeChart[8][2] = 0.5; // DARK
		typeChart[8][3]= 1.0;  // DRAGON
		typeChart[8][4] = 1.0; // ELECTRIC
		typeChart[8][5] = 1.0; // FIGHTING
		typeChart[8][6] = 1.0; // FIRE
		typeChart[8][7] = 1.0; // FLYING
		typeChart[8][8] = 2.0; // GHOST
		typeChart[8][9] = 1.0; // GRASS
		typeChart[8][10] = 1.0; // GROUND
		typeChart[8][11] = 1.0; // ICE 
		typeChart[8][12] = 0.0; // NORMAL
		typeChart[8][13] = 1.0; // POISON
		typeChart[8][14] = 2.0; // PSYCHIC
		typeChart[8][15] = 1.0; // ROCK	
		typeChart[8][16] = 0.5; // STEEL
		typeChart[8][17] = 1.0;// WATER
			
		/* GRASS attacking */
		typeChart[9][0] = 1.0; // NO_TYPE
		typeChart[9][1] = 0.5; // BUG		
		typeChart[9][2] = 1.0; // DARK
		typeChart[9][3]= 0.5;  // DRAGON
		typeChart[9][4] = 1.0; // ELECTRIC
		typeChart[9][5] = 1.0; // FIGHTING
		typeChart[9][6] = 0.5; // FIRE
		typeChart[9][7] = 0.5; // FLYING
		typeChart[9][8] = 1.0; // GHOST
		typeChart[9][9] = 0.5; // GRASS
		typeChart[9][10] = 2.0; // GROUND
		typeChart[9][11] = 1.0; // ICE 
		typeChart[9][12] = 1.0; // NORMAL
		typeChart[9][13] = 0.5; // POISON
		typeChart[9][14] = 1.0; // PSYCHIC
		typeChart[9][15] = 2.0; // ROCK	
		typeChart[9][16] = 0.5; // STEEL
		typeChart[9][17] = 2.0;// WATER
		
		/* GROUND attacking */
		typeChart[10][0] = 1.0; // NO_TYPE
		typeChart[10][1] = 0.5; // BUG		
		typeChart[10][2] = 1.0; // DARK
		typeChart[10][3]= 1.0;  // DRAGON
		typeChart[10][4] = 2.0; // ELECTRIC
		typeChart[10][5] = 1.0; // FIGHTING
		typeChart[10][6] = 2.0; // FIRE
		typeChart[10][7] = 0.0; // FLYING
		typeChart[10][8] = 1.0; // GHOST
		typeChart[10][9] = 0.5; // GRASS
		typeChart[10][10] = 1.0; // GROUND
		typeChart[10][11] = 1.0; // ICE 
		typeChart[10][12] = 1.0; // NORMAL
		typeChart[10][13] = 2.0; // POISON
		typeChart[10][14] = 1.0; // PSYCHIC
		typeChart[10][15] = 2.0; // ROCK	
		typeChart[10][16] = 2.0; // STEEL
		typeChart[10][17] = 1.0;// WATER
				
		/* ICE attacking */
		typeChart[11][0] = 1.0; // NO_TYPE
		typeChart[11][1] = 1.0; // BUG		
		typeChart[11][2] = 1.0; // DARK
		typeChart[11][3]= 2.0;  // DRAGON
		typeChart[11][4] = 1.0; // ELECTRIC
		typeChart[11][5] = 1.0; // FIGHTING
		typeChart[11][6] = 0.5; // FIRE
		typeChart[11][7] = 2.0; // FLYING
		typeChart[11][8] = 1.0; // GHOST
		typeChart[11][9] = 2.0; // GRASS
		typeChart[11][10] = 2.0; // GROUND
		typeChart[11][11] = 0.5; // ICE 
		typeChart[11][12] = 1.0; // NORMAL
		typeChart[11][13] = 1.0; // POISON
		typeChart[11][14] = 1.0; // PSYCHIC
		typeChart[11][15] = 1.0; // ROCK	
		typeChart[11][16] = 0.5; // STEEL
		typeChart[11][17] = 0.5;// WATER
		
		/* NORMAL attacking */
		typeChart[12][0] = 1.0; // NO_TYPE
		typeChart[12][1] = 1.0; // BUG		
		typeChart[12][2] = 1.0; // DARK
		typeChart[12][3]= 1.0;  // DRAGON
		typeChart[12][4] = 1.0; // ELECTRIC
		typeChart[12][5] = 1.0; // FIGHTING
		typeChart[12][6] = 1.0; // FIRE
		typeChart[12][7] = 1.0; // FLYING
		typeChart[12][8] = 0.0; // GHOST
		typeChart[12][9] = 1.0; // GRASS
		typeChart[12][10] = 1.0; // GROUND
		typeChart[12][11] = 1.0; // ICE 
		typeChart[12][12] = 1.0; // NORMAL
		typeChart[12][13] = 1.0; // POISON
		typeChart[12][14] = 1.0; // PSYCHIC
		typeChart[12][15] = 0.5; // ROCK	
		typeChart[12][16] = 0.5; // STEEL
		typeChart[12][17] = 1.0;// WATER
			
		/* POISON attacking */
		typeChart[13][0] = 1.0; // NO_TYPE
		typeChart[13][1] = 1.0; // BUG		
		typeChart[13][2] = 1.0; // DARK
		typeChart[13][3]= 1.0;  // DRAGON
		typeChart[13][4] = 1.0; // ELECTRIC
		typeChart[13][5] = 1.0; // FIGHTING
		typeChart[13][6] = 1.0; // FIRE
		typeChart[13][7] = 1.0; // FLYING
		typeChart[13][8] = 0.5; // GHOST
		typeChart[13][9] = 2.0; // GRASS
		typeChart[13][10] = 0.5; // GROUND
		typeChart[13][11] = 1.0; // ICE 
		typeChart[13][12] = 1.0; // NORMAL
		typeChart[13][13] = 0.5; // POISON
		typeChart[13][14] = 1.0; // PSYCHIC
		typeChart[13][15] = 1.0; // ROCK	
		typeChart[13][16] = 0.0; // STEEL
		typeChart[13][17] = 1.0;// WATER
			
		/* PSYCHIC attacking */
		typeChart[14][0] = 1.0; // NO_TYPE
		typeChart[14][1] = 1.0; // BUG		
		typeChart[14][2] = 0.0; // DARK
		typeChart[14][3]= 1.0;  // DRAGON
		typeChart[14][4] = 1.0; // ELECTRIC
		typeChart[14][5] = 2.0; // FIGHTING
		typeChart[14][6] = 1.0; // FIRE
		typeChart[14][7] = 1.0; // FLYING
		typeChart[14][8] = 1.0; // GHOST
		typeChart[14][9] = 1.0; // GRASS
		typeChart[14][10] = 1.0; // GROUND
		typeChart[14][11] = 1.0; // ICE 
		typeChart[14][12] = 1.0; // NORMAL
		typeChart[14][13] = 2.0; // POISON
		typeChart[14][14] = 0.5; // PSYCHIC
		typeChart[14][15] = 1.0; // ROCK	
		typeChart[14][16] = 0.5; // STEEL
		typeChart[14][17] = 1.0;// WATER
				
		/* ROCK attacking */
		typeChart[15][0] = 1.0; // NO_TYPE
		typeChart[15][1] = 2.0; // BUG		
		typeChart[15][2] = 1.0; // DARK
		typeChart[15][3]= 1.0;  // DRAGON
		typeChart[15][4] = 1.0; // ELECTRIC
		typeChart[15][5] = 0.5; // FIGHTING
		typeChart[15][6] = 2.0; // FIRE
		typeChart[15][7] = 2.0; // FLYING
		typeChart[15][8] = 1.0; // GHOST
		typeChart[15][9] = 1.0; // GRASS
		typeChart[15][10] = 0.5; // GROUND
		typeChart[15][11] = 2.0; // ICE 
		typeChart[15][12] = 1.0; // NORMAL
		typeChart[15][13] = 1.0; // POISON
		typeChart[15][14] = 1.0; // PSYCHIC
		typeChart[15][15] = 1.0; // ROCK	
		typeChart[15][16] = 0.5; // STEEL
		typeChart[15][17] = 1.0;// WATER
				
		/* STEEL attacking */
		typeChart[16][0] = 1.0; // NO_TYPE
		typeChart[16][1] = 1.0; // BUG		
		typeChart[16][2] = 1.0; // DARK
		typeChart[16][3]= 1.0;  // DRAGON
		typeChart[16][4] = 0.5; // ELECTRIC
		typeChart[16][5] = 1.0; // FIGHTING
		typeChart[16][6] = 0.5; // FIRE
		typeChart[16][7] = 1.0; // FLYING
		typeChart[16][8] = 1.0; // GHOST
		typeChart[16][9] = 1.0; // GRASS
		typeChart[16][10] = 1.0; // GROUND
		typeChart[16][11] = 2.0; // ICE 
		typeChart[16][12] = 1.0; // NORMAL
		typeChart[16][13] = 1.0; // POISON
		typeChart[16][14] = 1.0; // PSYCHIC
		typeChart[16][15] = 2.0; // ROCK	
		typeChart[16][16] = 0.5; // STEEL
		typeChart[16][17] = 0.5;// WATER
				
		/* WATER attacking */
		typeChart[17][0] = 1.0; // NO_TYPE
		typeChart[17][1] = 1.0; // BUG		
		typeChart[17][2] = 1.0; // DARK
		typeChart[17][3] = 0.5;  // DRAGON
		typeChart[17][4] = 1.0; // ELECTRIC
		typeChart[17][5] = 1.0; // FIGHTING
		typeChart[17][6] = 2.0; // FIRE
		typeChart[17][7] = 1.0; // FLYING
		typeChart[17][8] = 1.0; // GHOST
		typeChart[17][9] = 0.5; // GRASS
		typeChart[17][10] = 2.0; // GROUND
		typeChart[17][11] = 1.0; // ICE 
		typeChart[17][12] = 1.0; // NORMAL
		typeChart[17][13] = 1.0; // POISON
		typeChart[17][14] = 1.0; // PSYCHIC
		typeChart[17][15] = 2.0; // ROCK	
		typeChart[17][16] = 1.0; // STEEL
		typeChart[17][17] = 0.5; // WATER
	}
	
	public double getWeaknessResistance(Type attacking, Type defending) {
		return typeChart[attacking.getIndex()][defending.getIndex()];
	}
	public double getWeaknessResistance(Type attacking, Type def1, Type def2) {
		return typeChart[attacking.getIndex()][def1.getIndex()] * typeChart[attacking.getIndex()][def2.getIndex()];
	}
}
