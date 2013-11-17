package com.omnidex.damage;

import com.omnidex.ability.Ability;
import com.omnidex.battlefield.team.Team;
import com.omnidex.move.MoveWithPP;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidexter.battlefield.BattleField;

public class MainDamageFormula {

	/*
	 * Damage Formula = (((((((Level × 2 ÷ 5) + 2) × BasePower × [Sp]Atk ÷ 50) ÷
	 * [Sp]Def) × Mod1) + 2) × CH × Mod2 × R ÷ 100) × STAB × Type1 × Type2 ×
	 * Mod3) A = 10 B = 250 Modifier = STAB * Type * Critical Hit * other
	 * *(rand(0.85, 1.0)) Type = Type effectiviness Critical Hit 2 if a critical
	 * hit otherwise 1. If the attacking pokemon's ability is Sniper than 3 is
	 * applied.
	 */
	public static int[] damage(Team attack, Team defend, BattleField bf,
			MoveWithPP move) {
		double damage = 1.0;
		final int A = 5;
		final double B = 50;

		ActivePokemon attacker = attack.getActivePokemon();
		ActivePokemon defender = defend.getActivePokemon();

		damage = attacker.getLevel() * 2 / A + 2;

		// TODO extra base power calculation

		damage *= move.getBasePower(attacker, defender);

		damage = ItemDamageMod.doBasePowerItemMod(attacker, move, damage);

		// TODO Impement Charge modifier

		/* Mud Sport/Water Sport modifier */
		damage = WeatherDamageMod.doMudAndWaterSport(defend, move, damage);

		damage = AbilityDamageMod.doAtkAbilityBasePowerMod(attacker, defender,
				move, damage);

		damage = AbilityDamageMod.doDefAbilityBasePowerMod(defender, move,
				damage);

		if (move.isPhysical()) {
			// Implement Unaware ability check for Attack
			if (defender.hasAbility(Ability.UNAWARE)) {
				damage *= attacker.getAtk();
			} else if (attacker.hasAbility(Ability.SIMPLE)) {
				// TODO Implement Simple ability check for Attack
			} else {
				damage *= attacker.getCurrAtk();
			}
			damage = (int) damage;

			if (attacker.hasAbility(Ability.HUGE_POWER)
					|| attacker.hasAbility(Ability.PURE_POWER)) {
				damage *= 2.0;
			} else if (attacker.hasAbility(Ability.FLOWER_GIFT) && bf.isSun()) {
				damage *= 1.5;
			} else if (attacker.getAbility().ignoresBurnDebuff()
					&& !attacker.isOk()) {
				damage *= 1.5;
			} else if (attacker.hasAbility(Ability.HUSTLE)) {
				damage *= 1.5;
			}
			damage = (int) damage;

			ItemDamageMod.doPysicalItemMod(attacker, move, damage);
			damage /= B;
			damage = (int) damage;

			if (attacker.hasAbility(Ability.UNAWARE)) {
				damage /= defender.getDef();
			} else if (defender.hasAbility(Ability.SIMPLE)) {
				// TODO Implement Simple ability check for Attack
			} else {
				damage /= defender.getCurrDef();
			}
			damage = (int) damage;

			damage = AbilityDamageMod.doMarvelScale(defender, damage);
			damage = ItemDamageMod.doMetalPowder(defender, damage);
			
			if (attacker.isBurnt()
					&& !attacker.getAbility().ignoresBurnDebuff()) {
				damage *= 0.5;
			}
			if (defend.hasRelfect()) {
				damage *= 0.5;
			}
		} else if (move.isSpecial()) {
			if (defender.hasAbility(Ability.UNAWARE)) {
				damage *= attacker.getSpAtk();
			} else if (attacker.hasAbility(Ability.SIMPLE)) {
				// TODO Implement Simple ability check for Attack
			} else {
				damage *= attacker.getCurrSpAtk();
			}
			damage = (int) damage;

			damage = AbilityDamageMod.doSolarPowerDamageMod(attacker, move, bf,
					damage);
			damage = ItemDamageMod.doSpecialItemMod(attacker, move, damage);

			damage /= B;
			damage = (int) damage;
			if (attacker.hasAbility(Ability.UNAWARE)) {
				damage /= defender.getSpDef();
			} else if (defender.hasAbility(Ability.SIMPLE)) {
				// TODO Implement Simple ability check for Attack
			} else {
				damage /= defender.getCurrSpDef();
			}
			damage = (int) damage;
			if (defend.hasLightScreen()) {
				damage *= 0.5;
			}
		}

		damage = AbilityDamageMod.doFlashFireMod(attacker, move, damage);

		damage = WeatherDamageMod.doRainOrSunMods(move, bf, damage);

		damage += 2.0;

		// TODO Mod 2
		
		damage = ItemDamageMod.doLifeOrb(attacker, damage);
		// TODO Metronome
		// TODO Me First

		// mod 3

		/* STAB */
		damage = BasePower.applyStab(attacker, move, damage);

		damage *= move.getType().getEffectiveness(defender);
				
		damage = (int) damage;

		damage = AbilityDamageMod.doFilterAnSolidRock(defender, move, damage);

		damage = ItemDamageMod.doExpertBelt(attacker, defender, move, damage);

		damage = ItemDamageMod.berryModifiers(move, defender, damage);

		double minDamage = 85 * damage;
		minDamage /= 100.0;
		int result[] = new int[] { (int) (minDamage + 1.0), (int) damage };
		return result;
	}

	
}
