package com.omnidex.damage;

import com.omnidex.item.Item;
import com.omnidex.move.MoveWithPP;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.pokemon.Species;
import com.omnidex.type.Type;

public class ItemDamageMod {

    public static double doSpecialItemMod(Pokemon attacker, MoveWithPP move,
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

    public static double doPysicalItemMod(Pokemon attacker, MoveWithPP move,
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
    
    public static double doBasePowerItemMod(Pokemon attacker, MoveWithPP move,
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
    
    public static double berryModifiers(MoveWithPP move, ActivePokemon defender,
			double damage) {
    	   	
    	if (move.isType(Type.NORMAL)
				&& defender.hasItem(Item.CHILAN_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.CHILAN_BERRY, Type.NORMAL);
		}
    	    	
		if (move.isType(Type.BUG) && defender.hasItem(Item.TANGA_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.TANGA_BERRY, Type.BUG);
		} else if (move.isType(Type.DARK)
				&& defender.hasItem(Item.COLBUR_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.COLBUR_BERRY, Type.DARK);
		} else if (move.isType(Type.ICE) && defender.hasItem(Item.YACHE_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.YACHE_BERRY, Type.ICE);
		} else if (move.isType(Type.ELECTRIC)
				&& defender.hasItem(Item.WACAN_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.WACAN_BERRY,
					Type.ELECTRIC);
		} else if (move.isType(Type.GRASS)
				&& defender.hasItem(Item.RINDO_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.RINDO_BERRY, Type.GRASS);
		} else if (move.isType(Type.GROUND)
				&& defender.hasItem(Item.SHUCA_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.SHUCA_BERRY, Type.GROUND);
		} else if (move.isType(Type.FIRE) && defender.hasItem(Item.OCCA_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.OCCA_BERRY, Type.FIRE);
		} else if (move.isType(Type.WATER)
				&& defender.hasItem(Item.PASSHO_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.PASSHO_BERRY, Type.WATER);
		} else if (move.isType(Type.STEEL)
				&& defender.hasItem(Item.BABIRI_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.BABIRI_BERRY, Type.STEEL);
		} else if (move.isType(Type.POISON)
				&& defender.hasItem(Item.KEBIA_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.KEBIA_BERRY, Type.POISON);
		} else if (move.isType(Type.FLYING)
				&& defender.hasItem(Item.COBA_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.COBA_BERRY, Type.FLYING);
		} else if (move.isType(Type.PSYCHIC)
				&& defender.hasItem(Item.PAYAPA_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.PAYAPA_BERRY,
					Type.PSYCHIC);
		} else if (move.isType(Type.ROCK)
				&& defender.hasItem(Item.CHARTI_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.CHARTI_BERRY, Type.ROCK);
		} else if (move.isType(Type.GHOST)
				&& defender.hasItem(Item.KASIB_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.KASIB_BERRY, Type.GHOST);
		} else if (move.isType(Type.DRAGON)
				&& defender.hasItem(Item.HABAN_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.HABAN_BERRY, Type.DRAGON);
		} else if (move.isType(Type.FIGHTING)
				&& defender.hasItem(Item.CHOPLE_BERRY)) {
			damage *= 0.5;
			damage = (int) damage;
			printBerryMsg(defender.getSpecies(), Item.CHOPLE_BERRY,
					Type.FIGHTING);
		}
		return damage;
	}

    private static void printBerryMsg(Species forme, Item berry, Type typing) {
		System.out.println(forme + "'s " + berry + " activates, weakening "
				+ typing + " type moves!");
	}

    public static double doLifeOrb(ActivePokemon attacker, double damage) {
    	if (attacker.hasItem(Item.LIFE_ORB)) {
    		damage *= 1.3;
    	}
    	return (int) damage;
    }
    
    public static double doMetalPowder(ActivePokemon defender, double damage) {
    	if (defender.isSpecies(Species.DITTO)
				&& defender.hasItem(Item.METAL_POWDER)) {
			damage /= 1.5;
    	}
    	return (int) damage;
    }
    
	public static double doExpertBelt(ActivePokemon attacker,
			ActivePokemon defender, MoveWithPP move, double damage) {
		
		if (attacker.hasItem(Item.EXPERT_BELT) && move.getType().isSuperEffective(defender)) {
			damage *= 1.2;
		}
		return (int) damage;
	}
}

