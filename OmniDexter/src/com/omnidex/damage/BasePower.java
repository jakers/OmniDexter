package com.omnidex.damage;

import java.util.Random;

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

	public static int Psywave(Pokemon attacker) {
		Random r = new Random();
		return (int) ((r.nextInt(11) + 5) * (attacker.getLevel() / 10.0));
	}

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

}
