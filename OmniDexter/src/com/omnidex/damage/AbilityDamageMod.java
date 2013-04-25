package com.omnidex.damage;


import com.omnidex.pokemon.Pokemon;
import com.omnidex.pokemon.Terms;
import com.omnidex.type.Type;
import com.omnidex.ability.Ability;
import com.omnidex.move.*;
import com.omnidexter.battlefield.BattleField;

/**
 * A class of methods dealing with modifying damage output
 * using attacking an defending Pokemon.
 * @author jakers
 */
public class AbilityDamageMod {

    public static double doDefAbilityBasePowerMod(Pokemon defender, Move move,
            double damage) {
        if (defender.getAbility().equals(Ability.THICK_FAT)
                && (move.getType().equals(Type.ICE)
                || move.getType().equals(Type.FIRE))) {
            damage *= 0.5;
        } else if (defender.getAbility().equals(Ability.HEATPROOF)
                && move.getType().equals(Type.FIRE)) {
            damage *= 0.5;
        } else if (defender.getAbility().equals(Ability.DRY_SKIN)
                && move.getType().equals(Type.FIRE)) {
            damage *= 1.25;
        }
        damage = (int)damage;
        return damage;
    }

    public static double doFlashFireMod(Pokemon attacker, Move move,
                                        double damage) {
        if (attacker.hasFlashFireBoost() && move.getType().equals(Type.FIRE)) {
            damage *= 1.5;
            damage = (int)damage;
        }
        return damage;
    }

    public static double doSolarPowerDamageMod(Pokemon attacker, Move move,
            BattleField field, double damage) {
        if (attacker.getAbility().equals(Ability.SOLAR_POWER)
                && field.isSun()) {
            damage *= 1.5;
        }
        return damage;
    }

    public static double doAtkAbilityBasePowerMod(Pokemon attacker,
            Pokemon defender, Move move, double damage) {
        if (attacker.getAbility().equals(Ability.RIVALRY)) {
            if ((attacker.getGender().equals(Terms.MALE)
                    && defender.getGender().equals(Terms.MALE))
                    || (attacker.getGender().equals(Terms.FEMALE)
                    && defender.getGender().equals(Terms.FEMALE))) {
                damage *= 1.25;
                damage = (int) damage;
            } else if ((attacker.getGender().equals(Terms.MALE)
                    && defender.getGender().equals(Terms.FEMALE))
                    || (attacker.getGender().equals(Terms.FEMALE)
                    && defender.getGender().equals(Terms.MALE))) {
                damage *= 0.75;
                damage = (int) damage;
            }
        } else if (attacker.getAbility().equals(Ability.RECKLESS) &&
                   move.hasRecoil()) {
            damage *= 1.2;
            damage = (int) damage;
        } else if (attacker.getAbility().equals(Ability.IRON_FIST) &&
                   move.isPunch()) {
            damage *= 1.2;
            damage = (int) damage;
        } else if (attacker.getAbility().equals(Ability.TECHNICIAN)
                && move.getBasePower(attacker,defender) <= 60) {
            damage *= 1.5;
            damage = (int) damage;
        } else if (attacker.getCurrHp() / (double) attacker.getMaxHp()
                <= 1 / (double) 3) {
            if (attacker.getAbility().equals(Ability.BLAZE)
                    && move.getType().equals(Type.FIRE)) {
                damage *= 1.5;
                damage = (int) damage;
            } else if (attacker.getAbility().equals(Ability.OVERGROW)
                    && move.getType().equals(Type.GRASS)) {
                damage *= 1.5;
                damage = (int) damage;
            } else if (attacker.getAbility().equals(Ability.TORRENT)
                    && move.getType().equals(Type.WATER)) {
                damage *= 1.5;
                damage = (int) damage;
            }
        }
        return damage;
    }
}
