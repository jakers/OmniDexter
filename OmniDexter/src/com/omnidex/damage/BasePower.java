package com.omnidex.damage;

import java.util.Random;

import com.omnidex.battlefield.team.Team;
import com.omnidex.pokemon.Pokemon;

public class BasePower {
	public static int LowKickOrGrassKnot(Pokemon target) {
		double weight = target.getWeight();
		if (weight >= 0.1 && weight <= 21.8) {
			return 20;
		} else if (weight <= 54.9) {
			return 40;
		} else if (weight <= 110.0) {
			return 60;
		} else if (weight <= 220.2) {
			return 80;
		} else if (weight <= 440.7) {
			return 100;
		} else {
			return 120;
		}
	}

//	public static int Psywave(Pokemon attacker) {
//		Random r = new Random();
//		return (int) ((r.nextInt(11) + 5) * (attacker.getLevel() / 10.0));
//	}

	public static int EruptionOrWaterSpout(Pokemon attacker) {
		return 150 * (attacker.getCurrHp()/attacker.getMaxHp());
	}
	
	
	public static int Flail(Pokemon attacker) {

		int p = (int) (48.0 * attacker.getCurrHp()) / attacker.getMaxHp();
		if (p > 32) {
			return 20;
		} else if (p <= 32 && p >= 17) {
			return 40;
		} else if (p <= 16 && p >= 10) {
			return 80;
		} else if (p <= 9 && p >= 5) {
			return 100;
		} else if (p <= 4 && p >= 2) {
			return 120;
		} else {
			return 150;
		}

	}

	public static int Reversal(Pokemon attacker) {
		double percentage = attacker.getCurrAtk()
				/ (double) attacker.getMaxHp();
		if (percentage <= 0.04) {
			return 200;
		} else if (percentage <= 0.1) {
			return 150;
		} else if (percentage <= 0.2) {
			return 100;
		} else if (percentage <= 0.35) {
			return 80;
		} else if (percentage <= 0.7) {
			return 40;
		} else {
			return 20;
		}
	}

	public static int BeatUp(Pokemon attacker) {
		return attacker.getAtkBase()/10 +5;
	}
	
	public static int CrushGripOrWringOut(Pokemon target) {
		return 120 * (target.getCurrHp()/target.getMaxHp()); 
	}
	
	public static int ElectroBall(Pokemon attacker, Pokemon target) {
		
		double n = (int)(target.getCurrSpe()/ attacker.getCurrSpe())*100;

		if (n <= 0.25) {
			return 150;
		} else if (n > 0.25 && n < 1/(double)3) {
			return 120;
		} else if (n > 1/(double)3 && n < 0.5) {
			return 80;
		} else {
			return 60;
		}
	}
	
	public static int Fling(Pokemon attacker) {
		
		switch(attacker.getItem()) {
			case IRON_BALL:
				return 130;
			case HARD_STONE:
			case RARE_BONE:
			case HELIX_FOSSIL:
			case DOME_FOSSIL:
			case OLD_AMBER:
			case ROOT_FOSSIL:
			case CLAW_FOSSIL:
			case SKULL_FOSSIL:
			case ARMOR_FOSSIL:
			case COVER_FOSSIL:
			case PLUME_FOSSIL:
				return 100;
			case DRACO_PLATE:
			case DREAD_PLATE:
			case EARTH_PLATE:
			case FIST_PLATE:
			case FLAME_PLATE:
			case ICICLE_PLATE:
			case INSECT_PLATE:
			case IRON_PLATE:
			case SKY_PLATE:
			case SPLASH_PLATE:
			case SPOOKY_PLATE:
			case STONE_PLATE:
			case TOXIC_PLATE:
			case ZAP_PLATE:
			case DEEP_SEA_TOOTH:
			case THICK_CLUB:
			case GRIP_CLAW:
				return 90;
			case SHINY_STONE:
			case DUSK_STONE:
			case DAWN_STONE:
			case OVAL_STONE:
			case ODD_KEYSTONE:
			case QUICK_CLAW:
			case STICKY_BARB:
			case PROTECTOR:
			case ELECTIRIZER:
			case MAGMARIZER:
			case RAZOR_CLAW:
				return 80;
			// TODO fling bp 70
		    // TODO fling bp 60
		    // TODO fling bp 50
			// TODO fling bp 40
			// TODO fling bp 10
			default:
				return 30;
		}
		
		
	}
	
	
	
}
