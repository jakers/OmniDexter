package com.omnidex.damage;

import com.omnidex.ability.Ability;
import com.omnidex.battlefield.team.Team;
import com.omnidex.move.Category;
import com.omnidex.move.Move;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.pokemon.Species;
import com.omnidex.item.Item;
import com.omnidex.type.Type;
import com.omnidex.type.TypeChart;
import com.omnidexter.battlefield.BattleField;

/**
 * @author jakers
 */
public class MainDamageFormula {

    /*
     *Damage Formula = 
     * (((((((Level × 2 ÷ 5) + 2) × BasePower × [Sp]Atk ÷ 50) ÷ [Sp]Def) × Mod1)
     * + 2) × CH × Mod2 × R ÷ 100) × STAB × Type1 × Type2 × Mod3)
     * A = 10
     * B = 250
     * Modifier = STAB * Type * Critical Hit * other *(rand(0.85, 1.0))
     * Type = Type effectiviness
     * Critical Hit 2 if a critical hit otherwise 1. If the attacking
     * pokemon's ability is Sniper than 3 is applied.
     */
    public static int[] damage(Team attack, Team defend,
            BattleField bf, Move move) {
        double damage = 1.0;
        final int A = 5;
        final double B = 50;

        Pokemon attacker = attack.getActivePokemon();
        Pokemon defender = defend.getActivePokemon();
        
        
        damage = attacker.getLevel() * 2 / A + 2;
        
        // TODO extra base power calculation
        
        damage *= move.getBasePower(attacker,defender);

        damage = ItemDamageMod.doBasePowerItemMod(attacker, move, damage);

        // TODO Impement Charge modifier

        /* Mud Sport/Water Sport modifier */
        if (defend.   hasMudSport() && move.getType().equals(Type.ELECTRIC)) {
            damage *= 0.5;
            damage = (int) damage;
        } else if (defend.hasWaterSport() && move.getType().equals(Type.FIRE)) {
            damage *= 0.5;
            damage = (int) damage;
        }

        damage = AbilityDamageMod.doAtkAbilityBasePowerMod(attacker, defender,
                move, damage);

        damage = AbilityDamageMod.doDefAbilityBasePowerMod(defender, move, damage);

        if (move.isPhysical()) {
            // Implement Unaware ability check for Attack
            if (defender.getAbility().equals(Ability.UNAWARE)) {
                damage *= attacker.getAtk();
            } else if (attacker.getAbility().equals(Ability.SIMPLE)) {
                // TODO Implement Simple ability check for Attack
            } else {
                damage *= attacker.getCurrAtk();
            }
            damage = (int) damage;

            if (attacker.getAbility().equals(Ability.HUGE_POWER)
                    || attacker.getAbility().equals(Ability.PURE_POWER)) {
                damage *= 2.0;
            } else if (attacker.getAbility().equals(Ability.FLOWER_GIFT)
                    && bf.isSun()) {
                damage *= 1.5;
            } else if (attacker.getAbility().ignoresBurnDebuff() && !attacker.isOk()) {
                damage *= 1.5;
            } else if (attacker.getAbility().equals(Ability.HUSTLE)) {
                damage *= 1.5;
            }
            damage = (int) damage;
        
            ItemDamageMod.doPysicalItemMod(attacker, move, damage);
            damage /= B;
            damage = (int) damage;

            if (attacker.getAbility().equals(Ability.UNAWARE)) {
                damage /= defender.getDef();
            } else if (defender.getAbility().equals(Ability.SIMPLE)) {
                // TODO Implement Simple ability check for Attack
            } else {
                damage /= defender.getCurrDef();
            }
            damage = (int) damage;

            if (defender.getAbility().equals(Ability.MARVEL_SCALE) && !defender.isOk()) {
                damage /= 1.5;
            } else if (defender.getSpecies().equals(Species.DITTO)
                    && defender.getItem().equals(Item.METAL_POWDER)) {
                damage /= 1.5;
            }
            if (attacker.isBurnt() && !attacker.getAbility().ignoresBurnDebuff()) {
                damage *= 0.5;
            }
           if (defend.hasRelfect()) {
                damage *= 0.5;
            } 
        } else if (move.getCategory().equals(Category.SPECIAL)) {
            if (defender.getAbility().equals(Ability.UNAWARE)) {
                damage *= attacker.getSpAtk();
            } else if (attacker.getAbility().equals(Ability.SIMPLE)) {
                // TODO Implement Simple ability check for Attack
            } else {
                damage *= attacker.getCurrSpAtk();
            }
            damage = (int) damage;

            damage = AbilityDamageMod.doSolarPowerDamageMod(attacker, move,
                    bf, damage);
            damage = ItemDamageMod.doSpecialItemMod(attacker, move, damage);

            damage /= B;
            damage = (int) damage;
            if (attacker.getAbility().equals(Ability.UNAWARE)) {
                damage /= defender.getSpDef();
            } else if (defender.getAbility().equals(Ability.SIMPLE)) {
                // TODO Implement Simple ability check for Attack
            } else {
                damage /= defender.getCurrSpDef();
            }
            damage = (int) damage;
            if (defend.hasLightScreen()) {
                damage *= 0.5;
            }
        }
        
        /* Flash Fire mod */
        damage = AbilityDamageMod.doFlashFireMod(attacker, move, damage);

        /* Sun and Rain modifiers */
        damage = WeatherDamageMod.doRainOrSunMods(move, bf, damage);
        
        damage += 2.0;
        
        // TODO Mod 2
        if (attacker.getItem().equals(Item.LIFE_ORB)) {
            damage *= 1.3;
        }
        // TODO Metronome
        // TODO Me First
        
        // mod 3

        /* STAB */
        if (move.getType().equals(attacker.getFirstType())
                || move.getType().equals(attacker.getSecondType())) {
            if (attacker.getAbility().buffsSTAB()) {
                damage *= 2.0;
            } else {
                damage *= 1.5;
            }
            damage = (int) damage;
        }

        /* deal with type chart modifiers */
        TypeChart typeChart = new TypeChart();
        double typeEffectiveness1 = typeChart.getWeaknessResistance(move.getType(), defender.getFirstType());           
        double typeEffectiveness2 = typeChart.getWeaknessResistance(move.getType(), defender.getSecondType());
        damage *= typeEffectiveness1;
        damage = (int) damage;
        damage *= typeEffectiveness2;
        damage = (int) damage;
        

        /* Normal type berry modifier */
        if (move.getType().equals(Type.NORMAL)
                && defender.getItem().equals(Item.CHILAN_BERRY)) {
            damage *= 0.5;
            damage = (int) damage;
            printBerryMsg(defender.getSpecies(), Item.CHILAN_BERRY,
                    Type.NORMAL);
        }

        /* Super effective modifiers */
        double typingMod = typeEffectiveness1 * typeEffectiveness2;
        if (typingMod > 1.0) {
        	/* Solid Rock/Filter modifiers */
            if (defender.getAbility().weakensSEHits()) {
                damage *= 0.75;
            }
            
            /* Expert Belt */
            if (attacker.getItem().equals(Item.EXPERT_BELT)) {
                damage *= 1.2;
            }

            /* Berry modifiers */
            if (move.getType().equals(Type.BUG)
                    && defender.getItem().equals(Item.TANGA_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.TANGA_BERRY,
                        Type.BUG);
            }
            else if (move.getType().equals(Type.DARK)
                    && defender.getItem().equals(Item.COLBUR_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.COLBUR_BERRY,
                        Type.DARK);
            }
            else if (move.getType().equals(Type.ICE)
                    && defender.getItem().equals(Item.YACHE_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.YACHE_BERRY,
                        Type.ICE);
            }
            else if (move.getType().equals(Type.ELECTRIC)
                    && defender.getItem().equals(Item.WACAN_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.WACAN_BERRY,
                        Type.ELECTRIC);
            }
            else if (move.getType().equals(Type.GRASS)
                    && defender.getItem().equals(Item.RINDO_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.RINDO_BERRY, Type.GRASS);
            }
            else if (move.getType().equals(Type.GROUND)
                    && defender.getItem().equals(Item.SHUCA_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.SHUCA_BERRY,
                        Type.GROUND);
            }
            else if (move.getType().equals(Type.FIRE)
                    && defender.getItem().equals(Item.OCCA_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.OCCA_BERRY, Type.FIRE);
            }
            else if (move.getType().equals(Type.WATER)
                    && defender.getItem().equals(Item.PASSHO_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.PASSHO_BERRY,
                        Type.WATER);
            }
            else if (move.getType().equals(Type.STEEL)
                    && defender.getItem().equals(Item.BABIRI_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.BABIRI_BERRY,
                        Type.STEEL);
            }
            else if (move.getType().equals(Type.POISON)
                    && defender.getItem().equals(Item.KEBIA_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.KEBIA_BERRY,
                        Type.POISON);
            }
            else if (move.getType().equals(Type.FLYING)
                    && defender.getItem().equals(Item.COBA_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.COBA_BERRY,
                        Type.FLYING);
            }
            else if (move.getType().equals(Type.PSYCHIC)
                    && defender.getItem().equals(Item.PAYAPA_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.PAYAPA_BERRY,
                        Type.PSYCHIC);
            }
            else if (move.getType().equals(Type.ROCK)
                    && defender.getItem().equals(Item.CHARTI_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.CHARTI_BERRY,
                        Type.ROCK);
            }
            else if (move.getType().equals(Type.GHOST)
                    && defender.getItem().equals(Item.KASIB_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.KASIB_BERRY, Type.GHOST);
            }
            else if (move.getType().equals(Type.DRAGON)
                    && defender.getItem().equals(Item.HABAN_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.HABAN_BERRY,
                        Type.DRAGON);
            }
            else if (move.getType().equals(Type.FIGHTING)
                    && defender.getItem().equals(Item.CHOPLE_BERRY)) {
                damage *= 0.5;
                damage = (int) damage;
                printBerryMsg(defender.getSpecies(), Item.CHOPLE_BERRY,
                        Type.FIGHTING);
            }
        }
        
        
        double minDamage = 85 * damage;
        minDamage/= 100.0;
        int result[] = new int[] {(int)(minDamage+1.0),(int)damage};
        return result;
    }

    static private void printBerryMsg(Species forme, Item berry, Type typing) {
        System.out.println(forme + "'s " + berry + " activates, weakening "
                + typing + " type moves!");
    }
}
