package com.omnidex.damage;

import com.omnidex.item.Item;
import com.omnidex.move.Move;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.pokemon.Species;
import com.omnidex.type.Type;

/**
 * @author jakers
 */
public class ItemDamageMod {

    public static double doSpecialItemMod(Pokemon attacker, Move move,
            double damage) {
        if (attacker.getItem().equals(Item.CHOICE_SPECS)) {
            damage *= 1.5;
        } else if (attacker.getItem().equals(Item.LIGHT_BALL)
                && attacker.getSpecies().equals(Species.PIKACHU)) {
            damage *= 2.0;
            damage = (int) damage;
        } else if (attacker.getItem().equals(Item.SOUL_DEW)
                && (attacker.getSpecies().equals(Species.LATIAS)
                || attacker.getSpecies().equals(Species.LATIOS))) {
            damage *= 1.5;
        } else if (attacker.getItem().equals(Item.DEEPSEATOOTH)
                && (attacker.getSpecies().equals(Species.CLAMPERL))) {
            damage *= 2.0;
        }

        return damage;
    }

    public static double doPysicalItemMod(Pokemon attacker, Move move,
            double damage) {
    	if (attacker.getItem().equals(Item.CHOICE_BAND)) {
            damage *= 1.5;
            damage = (int) damage;
        } else if (attacker.getItem().equals(Item.LIGHT_BALL)
                && attacker.getSpecies().equals(Species.PIKACHU)) {
            damage *= 2.0;
            damage = (int) damage;
        }
        return damage;
    }  
    
    public static double doBasePowerItemMod(Pokemon attacker, Move move,
            double damage) {
        if (attacker.getItem().equals(Item.ADAMANT_ORB)
                && attacker.getSpecies().equals(Species.DIALGA)
                && (move.getType().equals(Type.DRAGON)
                || move.getType().equals(Type.STEEL))) {
            damage *= 1.2;
        } else if (attacker.getItem().equals(Item.GRISEOUS_ORB)
                && (attacker.getSpecies().equals(Species.GIRATINA)
                || attacker.getSpecies().equals(Species.GIRATINA_O))
                && (move.getType().equals(Type.DRAGON)
                || move.getType().equals(Type.GHOST))) {
            damage *= 1.2;
        } else if (attacker.getItem().equals(Item.LUSTROUS_ORB)
                && attacker.getSpecies().equals(Species.PALKIA)
                && (move.getType().equals(Type.DRAGON)
                || move.getType().equals(Type.WATER))) {
            damage *= 1.2;
        } else if (attacker.getItem().equals(Item.MUSCLE_BAND)
                && move.isPhysical()) {
            damage *= 1.1;
        } else if (attacker.getItem().equals(Item.WISE_GLASSES)
                && move.isSpecial()) {
            damage *= 1.1;
        }

        return damage;
    }
}

