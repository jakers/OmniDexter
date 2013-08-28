package com.omnidex.damage;

import com.omnidex.move.Move;
import com.omnidex.type.Type;
import com.omnidexter.battlefield.BattleField;

public class WeatherDamageMod {

	public static double doRainOrSunMods(Move move, BattleField bf, double damage) {
		if (bf.isSun()) {
            if (move.isType(Type.FIRE)) {
                damage *= 1.5;
            } else if (move.isType(Type.WATER)) {
                damage *= 0.5;
            }
        } else if (bf.isRain()) {
            if (move.isType(Type.FIRE)) {
                damage *= 0.5;
            } else if (move.isType(Type.WATER)) {
                damage *= 1.5;
            }
        }
		return (int)damage;
	}
	
	
}
