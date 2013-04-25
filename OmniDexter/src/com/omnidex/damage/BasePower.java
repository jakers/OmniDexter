package com.omnidex.damage;

import java.util.Random;

import com.omnidex.battlefield.team.Team;
import com.omnidex.pokemon.Pokemon;

public class BasePower {
	public static int LowKickOrGrassKnot(Pokemon target) {
		double weight = target.getWeight();
		if (weight >= 0.1 && weight <= 21.8) {
			return 20;
		} else if (weight <= 54.9) {
			return 40;
		} else if (weight <= 110.0) {
			return 60;
		} else if (weight <= 220.2) {
			return 80;
		} else if (weight <= 440.7) {
			return 100;
		} else {
			return 120;
		}
	}

//	public static int Psywave(Pokemon attacker) {
//		Random r = new Random();
//		return (int) ((r.nextInt(11) + 5) * (attacker.getLevel() / 10.0));
//	}

	public static int EruptionOrWaterSpout(Pokemon attacker) {
		return 150 * (attacker.getCurrHp()/attacker.getMaxHp());
	}
	
	
	public static int Flail(Pokemon attacker) {

		int p = (int) (48.0 * attacker.getCurrHp()) / attacker.getMaxHp();
		if (p > 32) {
			return 20;
		} else if (p <= 32 && p >= 17) {
			return 40;
		} else if (p <= 16 && p >= 10) {
			return 80;
		} else if (p <= 9 && p >= 5) {
			return 100;
		} else if (p <= 4 && p >= 2) {
			return 120;
		} else {
			return 150;
		}

	}

	public static int Reversal(Pokemon attacker) {
		double percentage = attacker.getCurrAtk()
				/ (double) attacker.getMaxHp();
		if (percentage <= 0.04) {
			return 200;
		} else if (percentage <= 0.1) {
			return 150;
		} else if (percentage <= 0.2) {
			return 100;
		} else if (percentage <= 0.35) {
			return 80;
		} else if (percentage <= 0.7) {
			return 40;
		} else {
			return 20;
		}
	}

	public static int BeatUp(Pokemon attacker) {
		return attacker.getAtkBase()/10 +5;
	}
	
	public static int CrushGripOrWringOut(Pokemon target) {
		return 120 * (target.getCurrHp()/target.getMaxHp()); 
	}
	
	public static int ElectroBall(Pokemon attacker, Pokemon target) {
		
		double n = (int)(target.getCurrSpe()/ attacker.getCurrSpe())*100;

		if (n <= 0.25) {
			return 150;
		} else if (n > 0.25 && n < 1/(double)3) {
			return 120;
		} else if (n > 1/(double)3 && n < 0.5) {
			return 80;
		} else {
			return 60;
		}
	}
	
	public static int Fling(Pokemon attacker) {
		
		switch(attacker.getItem()) {
			case IRON_BALL:
				return 130;
			case HARD_STONE:
			case RARE_BONE:
			case HELIX_FOSSIL:
			case DOME_FOSSIL:
			case OLD_AMBER:
			case ROOT_FOSSIL:
			case CLAW_FOSSIL:
			case SKULL_FOSSIL:
			case ARMOR_FOSSIL:
			case COVER_FOSSIL:
			case PLUME_FOSSIL:
				return 100;
			case DRACO_PLATE:
			case DREAD_PLATE:
			case EARTH_PLATE:
			case FIST_PLATE:
			case FLAME_PLATE:
			case ICICLE_PLATE:
			case INSECT_PLATE:
			case IRON_PLATE:
			case SKY_PLATE:
			case SPLASH_PLATE:
			case SPOOKY_PLATE:
			case STONE_PLATE:
			case TOXIC_PLATE:
			case ZAP_PLATE:
			case DEEPSEATOOTH:
			case THICK_CLUB:
			case GRIP_CLAW:
				return 90;
			case SHINY_STONE:
			case DUSK_STONE:
			case DAWN_STONE:
			case OVAL_STONE:
			case ODD_KEYSTONE:
			case QUICK_CLAW:
			case STICKY_BARB:
			case PROTECTOR:
			case ELECTIRIZER:
			case MAGMARIZER:
			case RAZOR_CLAW:
				return 80;
			case POISON_BARB:
			case DRAGON_FANG:
			case POWER_BRACER:
			case POWER_BELT:
			case POWER_LENS:
			case POWER_BAND:
			case POWER_ANKLET:
			case POWER_WEIGHT:
				return 70;
			case ADAMANT_ORB:
			case LUSTROUS_ORB:
			case MACHO_BRACE:
			case STICK:
			case HEAT_ROCK:
			case DAMP_ROCK:
				return 60;
			case SHARP_BEAK:
			case DUBIOUS_DISC:
				return 50;
			case LUCKY_PUNCH:
			case ICY_ROCK:
				return 40;
			case ANTIDOTE:
			case PARLYZ_HEAL:
			case AWAKENING:
			case BURN_HEAL:
			case ICE_HEAL:
			case FULL_HEAL:
			case FULL_RESTORE:
			case LAVA_COOKIE:
			case OLD_GATEAU:
			case CASTELIACONE:
			case HEAL_POWDER:
			case ENERGYPOWDER:
			case ENERGY_ROOT:
			case REVIVAL_HERB:
			case REVIVE:
			case MAX_REVIVE:
			case FRESH_WATER:
			case SODA_POP:
			case LEMONADE:
			case MOOMOO_MILK:
			case BERRY_JUICE:
			case ETHER:
			case MAX_ETHER:
			case ELIXIR:
			case MAX_ELIXIR:
			case REPEL:
			case SUPER_REPEL:
			case MAX_REPEL:
			case HP_UP:
			case PROTEIN:
			case IRON:
			case CALCIUM:
			case ZINC:
			case CARBOS:
			case PP_UP:
			case PP_MAX:
			case RARE_CANDY:
			case RED_SHARD:
			case GREEN_SHARD:
			case BLUE_SHARD:
			case YELLOW_SHARD:
			case GROWTH_MULCH:
			case DAMP_MULCH:
			case STABLE_MULCH:
			case GOOEY_MULCH:
			case X_ATTACK:
			case X_DEFEND:
			case X_SPECIAL:
			case X_SPDEF:
			case X_SPEED:
			case X_ACCURAY:
			case DIRE_HIT:
			case GUARD_SPEC:
			case BLACK_FLUTE:
			case BLUE_FLUTE:
			case RED_FLUTE:
			case WHITE_FLUTE:
			case YELLOW_FLUTE:
			case SACRED_ASH:
			case POKE_DOLL:
			case FLUFFY_TAIL:
			case SHOAL_SALT:
			case SHOAL_SHELL:
			case ESCAPE_ROPE:
			case SUN_STONE:
			case MOON_STONE:
			case FIRE_STONE:
			case THUNDERSTONE:
			case WATER_STONE:
			case LEAF_STONE:
			case EVERSTONE:
			case TINYMUSHROOM:
			case BIG_MUSHROOM:
			case PEARL:
			case BIG_PEARL:
			case STARDUST:
			case STAR_PIECE:
			case NUGGET:
			case HEART_SCALE:
			case HONEY:
			case EXP_SHARE:
			case KINGS_ROCK:
			case AMULET_COIN:
			case CLEANSE_TAG:
			case SOUL_DEW:
			case DEEPSEASCALE:
			case LUCKY_EGG:
			case SCOPE_LENS:
			case METAL_COAT:
			case DRAGON_SCALE:
			case LIGHT_BALL:
			case SMOKE_BALL:
			case MIRACLE_SEED:
			case BLACKGLASSES:
			case BLACK_BELT:
			case MAGNET:
			case MYSTIC_WATER:
			case NEVERMELTICE:
			case SPELL_TAG:
			case TWISTEDSPOON:
			case CHARCOAL:
			case UP_GRADE:
			case SHELL_BELL:
			case LIGHT_CLAY:
			case LIFE_ORB:
			case TOXIC_ORB:
			case FLAME_ORB:
			case METRONOME:
			case BLACK_SLUDGE:
			case RAZOR_FANG:
				return 30;
			case CHERI_BERRY:
			case CHESTO_BERRY:
			case PECHA_BERRY:
			case RAWST_BERRY:
			case ASPEAR_BERRY:
			case LEPPA_BERRY:
			case ORAN_BERRY:
			case PERSIM_BERRY:
			case LUM_BERRY:
			case SITRUS_BERRY:
			case FIGY_BERRY:
			case WIKI_BERRY:
			case MAGO_BERRY:
			case AGUAV_BERRY:
			case IAPAPA_BERRY:
			case RAZZ_BERRY:
			case BLUK_BERRY:
			case NANAB_BERRY:
			case WEPEAR_BERRY:
			case PINAP_BERRY:
			case POMEG_BERRY:
			case KELPSY_BERRY:
			case QUALOT_BERRY:
			case HONDEW_BERRY:
			case GREPA_BERRY:
			case TAMATO_BERRY:
			case CORNN_BERRY:
			case MAGOST_BERRY:
			case RABUTA_BERRY:
			case NOMEL_BERRY:
			case SPELON_BERRY:
			case PAMTRE_BERRY:
			case WATMEL_BERRY:
			case DURNIN_BERRY:
			case BELUE_BERRY:
			case LIECHI_BERRY:
			case GANLON_BERRY:
			case SALAC_BERRY:
			case PETAYA_BERRY:
			case APICOT_BERRY:
			case LANSAT_BERRY:
			case STARF_BERRY:
			case ENIGMA_BERRY:
			case OCCA_BERRY:
			case PASSHO_BERRY:
			case WACAN_BERRY:
			case RINDO_BERRY:
			case YACHE_BERRY:
			case CHOPLE_BERRY:
			case KEBIA_BERRY:
			case SHUCA_BERRY:
			case COBA_BERRY:
			case PAYAPA_BERRY:
			case TANGA_BERRY:
			case CHARTI_BERRY:
			case KASIB_BERRY:
			case HABAN_BERRY:
			case COLBUR_BERRY:
			case BABIRI_BERRY:
			case CHILAN_BERRY:
			case MICLE_BERRY:
			case CUSTAP_BERRY:
			case JABOCA_BERRY:
			case ROWAP_BERRY:
			case FULL_INCENSE:
			case LAX_INCENSE:
			case LUCK_INCENSE:
			case ODD_INCENSE:
			case PURE_INCENSE:
			case ROCK_INCENSE:
			case ROSE_INCENSE:
			case SEA_INCENSE:
			case WAVE_INCENSE:
			case BLUE_SCARF:
			case GREEN_SCARF:
			case PINK_SCARF:
			case RED_SCARF:
			case YELLOW_SCARF:
			case BRIGHTPOWDER:
			case WHITE_HERB:
			case SOOTHE_BELL:
			case MENTAL_HERB:
			case CHOICE_BAND:
			case SILVERPOWDER:
			case FOCUS_BAND:
			case LEFTOVERS:
			case SOFT_SAND:
			case METAL_POWDER:
			case WIDE_LENS:
			case EXPERT_BELT:
			case POWER_HERB:
			case QUICK_POWDER:
			case FOCUS_SASH:
			case ZOOM_LENS:
			case LAGGING_TAIL:
			case DESTINY_KNOT:
			case SMOOTH_ROCK:
			case SHED_SHELL:
			case BIG_ROOT:
			case CHOICE_SPECS:
			case REAPER_CLOTH:
				return 10;
			default:
				return 0;
		}
		
		
	}
	
	
	
}
