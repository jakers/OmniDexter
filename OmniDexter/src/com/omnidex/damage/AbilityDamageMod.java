package com.omnidex.damage;

import com.omnidex.ability.Ability;
import com.omnidex.move.MoveWithPP;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Gender;
import com.omnidex.type.Type;
import com.omnidex.weather.Weather;
import com.omnidexter.battlefield.BattleField;

public class AbilityDamageMod {

    public static double doDefAbilityBasePowerMod(ActivePokemon defender, MoveWithPP move,
            double damage) {
        if (defender.hasAbility(Ability.THICK_FAT)
                && (move.isType(Type.ICE)
                || move.isType(Type.FIRE))) {
            damage *= 0.5;
        } else if (defender.hasAbility(Ability.HEATPROOF)
                && move.isType(Type.FIRE)) {
            damage *= 0.5;
        } else if (defender.hasAbility(Ability.DRY_SKIN)
                && move.isType(Type.FIRE)) {
            damage *= 1.25;
        }
        damage = (int) damage;
        return damage;
    }

    public static double doFlashFireMod(ActivePokemon attacker, MoveWithPP move,
                                        double damage) {
        if (attacker.hasFlashFireBoost() && move.isType(Type.FIRE)) {
            damage *= 1.5;
            damage = (int) damage;
        }
        return damage;
    }

    public static double doSolarPowerDamageMod(ActivePokemon attacker, MoveWithPP move,
            BattleField field, double damage) {
        if (attacker.hasAbility(Ability.SOLAR_POWER)
                && field.isSun()) {
            damage *= 1.5;
        }
        return damage;
    }

    public static double doFilterAnSolidRock(ActivePokemon defender, MoveWithPP move, double damage) {
    	if (defender.getAbility().weakensSEHits()) {
    		damage *= 0.75;
    	}
		return (int)damage;
    }
    
    public static double doMarvelScale(ActivePokemon defender, double damage) {
    	if (defender.hasAbility(Ability.MARVEL_SCALE) && !defender.isOk()) {
			damage /= 1.5;
		}
    	return (int) damage;
    }
    
    public static double doFlowerGiftAtkBoost(ActivePokemon attacker, Weather weather, double damage) {
    	if (attacker.hasAbility(Ability.FLOWER_GIFT) && weather.isSun()) {
    		damage *= 1.5;
    	}
    	return (int)damage;
    }
    
    public static double doFlowerGiftSpDefBoost(ActivePokemon defender, Weather weather, double damage) {
    	if (defender.hasAbility(Ability.FLOWER_GIFT) && weather.isSun()) {
    		damage *= 0.5;
    	}
    	return (int)damage;
    }
    
    public static double doAtkAbilityBasePowerMod(ActivePokemon attacker,
            ActivePokemon defender, MoveWithPP move, double damage) {
        if (attacker.hasAbility(Ability.RIVALRY)) {
            if ((attacker.isGender(Gender.MALE)
                    && defender.isGender(Gender.MALE))
                    || (attacker.isGender(Gender.FEMALE)
                    && defender.isGender(Gender.FEMALE))) {
                damage *= 1.25;
                damage = (int) damage;
            } else if ((attacker.isGender(Gender.MALE)
                    && defender.isGender(Gender.FEMALE))
                    || (attacker.isGender(Gender.FEMALE)
                    && defender.isGender(Gender.MALE))) {
                damage *= 0.75;
                damage = (int) damage;
            }
        } else if (attacker.hasAbility(Ability.RECKLESS) &&
                   move.hasRecoil()) {
            damage *= 1.2;
            damage = (int) damage;
        } else if (attacker.hasAbility(Ability.IRON_FIST) &&
                   move.isPunch()) {
            damage *= 1.2;
            damage = (int) damage;
        } else if (attacker.hasAbility(Ability.TECHNICIAN)
                && move.getBasePower(attacker, defender) <= 60) {
            damage *= 1.5;
            damage = (int) damage;
        } else if (attacker.getCurrHp() / (double) attacker.getMaxHp()
                <= 1 / (double) 3) {
            if (attacker.hasAbility(Ability.BLAZE)
                    && move.isType(Type.FIRE)) {
                damage *= 1.5;
                damage = (int) damage;
            } else if (attacker.hasAbility(Ability.OVERGROW)
                    && move.isType(Type.GRASS)) {
                damage *= 1.5;
                damage = (int) damage;
            } else if (attacker.hasAbility(Ability.TORRENT)
                    && move.isType(Type.WATER)) {
                damage *= 1.5;
                damage = (int) damage;
            }
        }
        return damage;
    }
}
