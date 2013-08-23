package com.omnidex.damage;

import com.omnidex.item.Item;
import com.omnidex.move.Move;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.pokemon.Species;
import com.omnidex.type.Type;

public class ItemDamageMod {

    public static double doSpecialItemMod(Pokemon attacker, Move move,
            double damage) {
        if (attacker.hasItem(Item.CHOICE_SPECS)) {
            damage *= 1.5;
        } else if (attacker.hasItem(Item.LIGHT_BALL)
                && attacker.isSpecies(Species.PIKACHU)) {
            damage *= 2.0;
            damage = (int) damage;
        } else if (attacker.hasItem(Item.SOUL_DEW)
                && (attacker.isSpecies(Species.LATIAS)
                || attacker.isSpecies(Species.LATIOS))) {
            damage *= 1.5;
        } else if (attacker.hasItem(Item.DEEPSEATOOTH)
                && (attacker.isSpecies(Species.CLAMPERL))) {
            damage *= 2.0;
        }

        return damage;
    }

    public static double doPysicalItemMod(Pokemon attacker, Move move,
            double damage) {
    	if (attacker.hasItem(Item.CHOICE_BAND)) {
            damage *= 1.5;
            damage = (int) damage;
        } else if (attacker.hasItem(Item.LIGHT_BALL)
                && attacker.isSpecies(Species.PIKACHU)) {
            damage *= 2.0;
            damage = (int) damage;
        }
        return damage;
    }  
    
    public static double doBasePowerItemMod(Pokemon attacker, Move move,
            double damage) {
        if (attacker.hasItem(Item.ADAMANT_ORB)
                && attacker.isSpecies(Species.DIALGA)
                && (move.isType(Type.DRAGON)
                || move.isType(Type.STEEL))) {
            damage *= 1.2;
        } else if (attacker.hasItem(Item.GRISEOUS_ORB)
                && (attacker.isSpecies(Species.GIRATINA)
                || attacker.isSpecies(Species.GIRATINA_O))
                && (move.isType(Type.DRAGON)
                || move.isType(Type.GHOST))) {
            damage *= 1.2;
        } else if (attacker.hasItem(Item.LUSTROUS_ORB)
                && attacker.isSpecies(Species.PALKIA)
                && (move.isType(Type.DRAGON)
                || move.isType(Type.WATER))) {
            damage *= 1.2;
        } else if (attacker.hasItem(Item.MUSCLE_BAND)
                && move.isPhysical()) {
            damage *= 1.1;
        } else if (attacker.hasItem(Item.WISE_GLASSES)
                && move.isSpecial()) {
            damage *= 1.1;
        }

        return damage;
    }
}

