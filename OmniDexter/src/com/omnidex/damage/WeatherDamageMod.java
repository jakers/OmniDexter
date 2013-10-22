package com.omnidex.damage;

import com.omnidex.battlefield.team.Team;
import com.omnidex.move.Move;
import com.omnidex.type.Type;
import com.omnidex.weather.Weather;
import com.omnidexter.battlefield.BattleField;

public class WeatherDamageMod {

	public static double doRainOrSunMods(Move move, BattleField bf,
			double damage) {
		damage = applySunnyDayMod(move, bf, damage);
		return applyRainDanceMod(move, bf, damage);
	}

	private static double applyRainDanceMod(Move move, BattleField bf,
			double damage) {
		if (bf.isRain()) {
			if (move.isType(Type.FIRE)) {
				damage *= Weather.RAIN_SUN_NEG_MOD;
			} else if (move.isType(Type.WATER)) {
				damage *= Weather.RAIN_SUN_BOOST_MOD;
			}
		}
		return (int)damage;
	}

	private static double applySunnyDayMod(Move move, BattleField bf,
			double damage) {
		if (bf.isSun()) {
			if (move.isType(Type.FIRE)) {
				damage *= Weather.RAIN_SUN_BOOST_MOD;
			} else if (move.isType(Type.WATER)) {
				damage *= Weather.RAIN_SUN_NEG_MOD;
			}
		}
		return (int) damage;
	}

	public static double doMudAndWaterSport(Team defend, Move move,
			double damage) {
		if (defend.hasMudSport() && move.isType(Type.ELECTRIC)) {
			damage *= 0.5;
			damage = (int) damage;
		} else if (defend.hasWaterSport() && move.isType(Type.FIRE)) {
			damage *= 0.5;
			damage = (int) damage;
		}
		return damage;
	}
	
	
}
