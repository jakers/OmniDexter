package com.omnidex.damage;

import com.omnidex.battlefield.team.DeepTeam;
import com.omnidex.battlefield.team.Team;
import com.omnidex.pokemon.Nature;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.type.Type;

/**
 * @author jakers
 */
public class PokemonMath {/*
						 * private static final double PLUS_SIX = 4.0; private
						 * static final double PLUS_FIVE = 3.5; private static
						 * final double PLUS_FOUR = 3.0; private static final
						 * double PLUS_THREE = 2.5; private static final double
						 * PLUS_TWO = 2.0; private static final double PLUS_ONE
						 * = 1.5; private static final double NO_MOD = 1.0;
						 * private static final double MINUS_ONE = (2 / (double)
						 * 3); private static final double MINUS_TWO = 0.5;
						 * private static final double MINUS_THREE = 0.4;
						 * private static final double MINUS_FOUR = (2 /
						 * (double) 6); private static final double MINUS_FIVE =
						 * (2 / (double) 7); private static final double
						 * MINUS_SIX = 0.25;
						 */
	public static final double ONE_SIXTEENTH = 1/(double)16;
	public static final double ONE_EIGHTH = 1/(double)8;
	public static final double ONE_SIXTH = 1/(double)6;
	public static final double ONE_QUARTER = 0.25;
	public static final double ONE_HALF = 0.5;
	public static final double ONE_THIRTY_SECOND = 1/(double)32;

	public static Team[] getFasterPoke(Team omnidexter, Team opponent) {
		Team[] result = new DeepTeam[2];
				
		if (omnidexter.getActivePokemon().getCurrSpe() > opponent.getActivePokemon().getCurrSpe()) {
			result[0] = omnidexter;
			result[1] = opponent;
		} else if (omnidexter.getActivePokemon().getCurrSpe() < opponent.getActivePokemon().getCurrSpe()) {
			result[0] = opponent;
			result[1] = omnidexter;
		} else {
			if (Math.random() > 0.5) {
				result[0] = omnidexter;
				result[1] = opponent;
			} else {
				result[0] = opponent;
				result[1] = omnidexter;
			}
		}
		return result;
	}

	public static void applyFractionalDamage(Pokemon poke, double fraction) {
		poke.setCurrHp(poke.getCurrHp() - (int) (poke.getMaxHp() * fraction));
	}

	public static void applyFractionalHealing(Pokemon poke, double fraction) {
		poke.setCurrHp(poke.getCurrHp() + (int) (poke.getMaxHp() * fraction));
	}
	
	public static void applyFractionalLeeching(Pokemon damaged, Pokemon healed, double fraction) {
		int amountLost = (int)(damaged.getMaxHp() * fraction);
		int deltaHP = damaged.getCurrHp() - amountLost;
		if (deltaHP < 0) {
			amountLost = damaged.getCurrHp();
		}
		damaged.setCurrHp(deltaHP);
		healed.setCurrHp(healed.getCurrHp()+amountLost);
	}

	public static void toxicDamage(Pokemon poke) {
		PokemonMath.applyFractionalDamage(poke, poke.getToxCount()*PokemonMath.ONE_SIXTEENTH);
		poke.incrementToxCount();
	}

	static int calcHP(int level, int base, int iv, int ev) {
		/*
		 * if base = 1 then HP = 1
		 * 
		 * else HP = (IV + (2 * Base) + EV / A + B) * LEVEL + C
		 * ------------------------------------------ B
		 * 
		 * WHERE: A = 4.0 B = 100.0 C = 10.0
		 */
		double hp;

		if (base == 1) {
			hp = 1.0;
		} else {
			final double A = 4.0;
			final double B = 100.0;
			final double C = 10.0;

			hp = 2.0 * base + iv + B;
			hp += (ev / A);
			hp *= level;
			hp /= B;
			hp += C;
		}

		return (int) hp;
	}

	static int calcOtherStat(int level, int base, int iv, int ev,
			double natureMod) {
		/*
		 * +-- --+ |(IV + (2 * Base) + (EV / A)) * LEVEL + B | OtherStat =
		 * |---------------------------------------- | * NATUREMOD | C | +-- --+
		 * 
		 * WHERE: A = 4.0 B = 5.0 C = 100.0
		 */

		final double A = 4.0;
		final double B = 5.0;
		final double C = 100.0;

		double stat;

		stat = 2.0 * base;
		stat += iv;
		stat += (ev / A);
		stat *= level;
		stat /= C;
		stat += B;
		stat *= natureMod;

		return (int) stat;
	}

	public static int[] calcPokemon(int level, Nature nature, int[] baseStats,
			int[] iv, int[] ev) {
		int[] result = new int[baseStats.length];

		result[0] = calcHP(level, baseStats[0], iv[0], ev[0]);

		double[] statMods = nature.getStatMods();

		int i = 1;
		while (i < baseStats.length) {
			result[i] = calcOtherStat(level, baseStats[i], iv[i], ev[i],
					statMods[i - 1]);
			i++;
		}
		return result;
	}

	public static Type calcHiddenPower(int hpIv, int atkIv, int defIv,
			int spAtkIv, int spDefIv, int spdIv) {
		/*
		 * |(a + 2*b + 4*c+8*d + 16* e + 32*f)*15 | HP(type) = floor|
		 * ------------------------------------ | | 63 | a = hpIv --- --- b =
		 * atkIv c = defIv d = spdIv e = spAtkIv f = spDefIv
		 * 
		 * A = 4.0 B = 8.0 C = 16.0 D = 32.0 E = 15.0 F = 63.0
		 */

		final double A = 4.0;
		final double B = 8.0;
		final double C = 16.0;
		final double D = 32.0;
		final double E = 15.0;
		final double F = 63.0;

		if ((hpIv % 2) == 0) {
			hpIv = 0;
		} else {
			hpIv = 1;
		}
		if ((atkIv % 2) == 0) {
			atkIv = 0;
		} else {
			atkIv = 1;
		}
		if ((defIv % 2) == 0) {
			defIv = 0;
		} else {
			defIv = 1;
		}
		if ((spAtkIv % 2) == 0) {
			spAtkIv = 0;
		} else {
			spAtkIv = 1;
		}
		if ((spDefIv % 2) == 0) {
			spDefIv = 0;
		} else {
			spDefIv = 1;
		}
		if ((spdIv % 2) == 0) {
			spdIv = 0;
		} else {
			spdIv = 1;
		}

		double result;

		result = hpIv + 2.0 * atkIv + A * defIv + B * spdIv + C * spAtkIv + D
				* spDefIv;
		result = result * E;
		result = result / F;

		int i = (int) result;
		Type hiddenPower = Type.DARK;

		if (i == 0) {
			hiddenPower = Type.FIGHTING;
		} else if (i == 1) {
			hiddenPower = Type.FLYING;
		} else if (i == 2) {
			hiddenPower = Type.POISON;
		} else if (i == 3) {
			hiddenPower = Type.GROUND;
		} else if (i == 4) {
			hiddenPower = Type.ROCK;
		} else if (i == 5) {
			hiddenPower = Type.BUG;
		} else if (i == 6) {
			hiddenPower = Type.GHOST;
		} else if (i == 7) {
			hiddenPower = Type.STEEL;
		} else if (i == 8) {
			hiddenPower = Type.FIRE;
		} else if (i == 9) {
			hiddenPower = Type.WATER;
		} else if (i == 10) {
			hiddenPower = Type.GRASS;
		} else if (i == 11) {
			hiddenPower = Type.ELECTRIC;
		} else if (i == 12) {
			hiddenPower = Type.PSYCHIC;
		} else if (i == 13) {
			hiddenPower = Type.ICE;
		} else if (i == 14) {
			hiddenPower = Type.DRAGON;
		}

		return hiddenPower;
	}

	public static int calcHiddenPowerBasePower(int hpIv, int atkIv, int defIv,
			int spAtkIv, int spDefIv, int spdIv) {
		/*
		 * | (u + 2*v +A*w+B*x+C*y+D*z)*E + F | HP(power) = floor |
		 * ------------------------------- | | G | --- --- u = hpIv v = atkIv w
		 * = defIv x = spdIv y = spAtkIv z = spDefIv
		 * 
		 * A = 4.0 B = 8.0 C = 16.0 D = 32.0 E = 40.0 F = 30.0 G = 63.0
		 */

		final double A = 4.0;
		final double B = 8.0;
		final double C = 16.0;
		final double D = 32.0;
		final double E = 40.0;
		final double F = 30.0;
		final double G = 63.0;

		if (((hpIv % 4) == 2) || ((hpIv % 4) == 3)) {
			hpIv = 1;
		} else {
			hpIv = 0;
		}
		if (((atkIv % 4) == 2) || ((atkIv % 4) == 3)) {
			atkIv = 1;
		} else {
			atkIv = 0;
		}
		if (((defIv % 4) == 2) || ((defIv % 4) == 3)) {
			defIv = 1;
		} else {
			defIv = 0;
		}
		if (((spAtkIv % 4) == 2) || ((spAtkIv % 4) == 3)) {
			spAtkIv = 1;
		} else {
			spAtkIv = 0;
		}
		if (((spDefIv % 4) == 2) || ((spDefIv % 4) == 3)) {
			spDefIv = 1;
		} else {
			spDefIv = 0;
		}
		if (((spdIv % 4) == 2) || ((spdIv % 4) == 3)) {
			spdIv = 1;
		} else {
			spdIv = 0;
		}

		double result = hpIv + 2.0 * atkIv + A * defIv + B * spdIv;
		result = result + C * spAtkIv + D * spDefIv;
		result = result * E;
		result = result / G;
		result = result + F;

		return (int) result;
	}
}
