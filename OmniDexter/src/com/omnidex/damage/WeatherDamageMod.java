package com.omnidex.damage;

import com.omnidex.battlefield.team.Team;
import com.omnidex.move.MoveWithPP;
import com.omnidex.type.Type;
import com.omnidex.weather.Weather;
import com.omnidexter.battlefield.BattleField;

public class WeatherDamageMod {

	public static double doRainOrSunMods(MoveWithPP move, BattleField bf,
			double damage) {
		damage = applySunnyDayMod(move, bf, damage);
		return applyRainDanceMod(move, bf, damage);
	}

	private static double applyRainDanceMod(MoveWithPP move, BattleField bf,
			double damage) {
		if (bf.isRain()) {
			if (move.isType(Type.FIRE)) {
				damage *= Weather.WEATHER_DAMAGE_DEBUFF_MOD;
			} else if (move.isType(Type.WATER)) {
				damage *= Weather.WEATHER_DAMAGE_BUFF_MOD;
			}
		}
		return (int)damage;
	}

	private static double applySunnyDayMod(MoveWithPP move, BattleField bf,
			double damage) {
		if (bf.isSun()) {
			if (move.isType(Type.FIRE)) {
				damage *= Weather.WEATHER_DAMAGE_BUFF_MOD;
			} else if (move.isType(Type.WATER)) {
				damage *= Weather.WEATHER_DAMAGE_DEBUFF_MOD;
			}
		}
		return (int) damage;
	}

	public static double doMudAndWaterSport(Team defend, MoveWithPP move,
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
