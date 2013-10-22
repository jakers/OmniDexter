package com.omnidex.ability;

import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.type.Type;
import com.omnidex.weather.Weather;

public enum Ability {
	NO_ABILITY("(none)"),
	UNKNOWN_ABILITY("(unknown)"),

	/* A abilities */
	ADAPTABILITY("Adaptability"),
	AFTERMATH("Aftermath"),
	AIR_LOCK("Air Lock"),
	ANALYTIC("Analytic"),
	ANGER_POINT("Anger Point"),
	ANTICIPATION("Anticipation"),
	ARENA_TRAP("Arena Trap"),

	/* B abilities */
	BAD_DREAMS("Bad Dreams"),
	BATTLE_ARMOR("Battle Armor"),
	BIG_PECKS("Big Pecks"),
	BLAZE("Blaze"),

	/* C abilities */
	CHLOROPHYLL("Chlorophyll"),
	CLEAR_BODY("Clear Body"),
	CLOUD_NINE("Cloud Nine"),
	COLOR_CHANGE("Color Change"),
	COMPOUND_EYES("Compound Eyes"),
	CONTRARY("Contrary"),
	CURSED_BODY("Cursed Body"),
	CUTE_CHARM("Cute Charm"),

	/* C abilities */
	DAMP("Damp"),
	DEAFEATIST("Deafeatist"),
	DEFIANT("Defiant"),
	DOWNLOAD("Download"),
	DRIZZLE("Drizzle"),
	DROUGHT("Drought"),
	DRY_SKIN("Dry Skin"),

	/* E abilities */
	EARLY_BIRD("Early Bird"),
	EFFECT_SPORE("Effect Spore"),

	/* F abilities */
	FILTER("Filter"),
	FLAME_BODY("Flame Body"),
	FLARE_BOOST("Flare Boost"),
	FLASH_FIRE("Flash Fire"),
	FLOWER_GIFT("Flower Gift"),
	FORECAST("Forecast"),
	FOREWARN("Forewarn"),
	FRIEND_GUARD("Friend Guard"),
	FRISK("Frisk"),

	/* G abilities */
	GLUTTONY("Gluttony"),
	GUTS("Guts"),

	/* H abilities */
	HARVEST("Harvest"),
	HEALER("Healer"),
	HEATPROOF("Heatproof"),
	HEAVY_METAL("Heavy Metal"),
	HONEY_GATHER("Honey Gather"),
	HUGE_POWER("Huge Power"),
	HUSTLE("Hustle"),
	HYDRATION("Hydration"),
	HYPER_CUTTER("Hyper Cutter"),

	/* I abilities */
	ICE_BODY("Ice Body"),
	ILLUMINATE("Illuminate"),
	ILLUSION("Illusion"),
	IMMUNITY("Immunity"),
	IMPOSTER("Imposter"),
	INFILTRATOR("Infiltrator"),
	INNER_FOCUS("Inner Focus"),
	INSOMNIA("Insomnia"),
	INTIMIDATE("Intimidate"), 
	IRON_BARBS("Iron Barbs"),
	IRON_FIST("Iron Fist"),

	/* J abilities */
	JUSTIFIED("Justified"),

	/* K abilities */
	KEEN_EYE("Keen Eye"),
	KLUTZ("Klutz"),

	/* L abilities */
	LEAF_GUARD("Leaf Guard"),
	LEVITATE("Levitate"),
	LIGHT_METAL("Light Metal"),
	LIGHTNINGROD("LightningRod"),
	LIMBER("Limber"),
	LIQUID_OOZE("Liquid Ooze"),

	/* M abilities */
	MAGIC_BOUNCE("Magic Bounce"),
	MAGIC_GUARD("Magic Guard"),
	MAGMA_ARMOR("Magma Armor"),
	MAGNET_PULL("Magnet Pull"),
	MARVEL_SCALE("Marvel Scale"),
	MINUS("Minus"),
	MOLD_BREAKER("Mold Breaker"),
	MOODY("Moody"),
	MOTOR_DRIVE("Motor Drive"),
	MOXIE("Moxie"),
	MULTISCALE("Multiscale"),
	MULTITYPE("Multitype"),
	MUMMY("Mummy"),

	/* N abilities */
	NATURAL_CURE("Natural Cure"),
	NO_GUARD("No Guard"),
	NORMALIZE("Normalize"),

	/* O abilities */
	OBLIVIOUS("Oblivious"),
	OVERCOAT("Overcoat"),
	OVERGROW("Overgrow"),
	OWN_TEMPO("Own Tempo"),

	/* P abilities */
	PICK_UP("Pick Up"),
	PICKPOCKET("Pickpocket"),
	PLUS("Plus"),
	POISON_HEAL("Poison Heal"),
	POISON_POINT("Poison Point"), 
    POISON_TOUCH("Poison Touch"),
    PRANKSTER("Prankster"),
    PRESSURE("Pressure"),
    PURE_POWER("Pure Power"),

	/* Q abilities */
	QUCIK_FEET("Qucik Feet"),

	/* R abilities */
	RAIN_DISH("Rain Dish"),
	RATTLED("Rattled"),
	RECKLESS("Reckless"),
	REGENERATOR("Regenerator"),
	RIVALRY("Rivalry"),
	ROCK_HEAD("Rock Head"),
	ROUGH_SKIN("Rough Skin"),
	RUN_AWAY("Run Away"),

	/* S abilities */
	SAND_FORCE("Sand Force"),
	SAND_RUSH("Sand Rush"),
	SAND_STREAM("Sand Stream"),
	SAND_VEIL("Sand Veil"),
	SAP_SIPPER("Sap Sipper"),
	SERENE_GRACE("Serene Grace"),
	SHADOW_TAG("Shadow Tag"),
	SHED_SKIN("Shed Skin"),
	SHEER_FORCE("Sheer Force"),
	SHELL_ARMOR("Shell Armor"),
	SHIELD_DUST("Shield Dust"),
	SIMPLE("Simple"),
	SKILL_LINK("Skill Link"),
	SLOW_START("Slow Start"),
	SNIPER("Sniper"),
	SNOW_CLOAK("Snow Cloak"),
	SNOW_WARNING("Snow Warning"),
	SOLAR_POWER("Solar Power"),
	SOLID_ROCK("Solid Rock"),
	SOUNDPROOF("Soundproof"),
	SPEED_BOOST("Speed Boost"),
	STALL("Stall"),
	STATIC("Static"),
	STEADFAST("Steadfast"),
	STENCH("Stench"),
	STICKY_HOLD("Sticky Hold"),
	STORM_DRAIN("Storm Drain"),
	STURDY("Sturdy"),
	SUCTION_CUPS("Suction Cups"),
	SUPER_LUCK("Super Luck"),
	SWARM("Swarm"),
	SWIFT_SWIM("Swift Swim"),
	SYNCHRONIZE("Synchronize"),

	/* T abilities */
	TANGLED_FEET("Tangled Feet"),
	TECHNICIAN("Technician"),
	TELEPATHY("Telepathy"),
	TERAVOLT("Teravolt"),
	THICK_FAT("Thick Fat"),
	TINTED_LENS("Tinted Lens"),
	TORRENT("Torrent"),
	TOXIC_BOOST("Toxic Boost"),
	TRACE("Trace"),
	TRUANT("Truant"),
	TURBOBLAZE("Turboblaze"),

	/* U abilities */
	UNAWARE("Unaware"),
	UNBURDEN("Unburden"),
	UNNERVE("Unnerve"),

	/* V abilities */
	VICTORY_STAR("Victory Star"),
	VITAL_SPIRT("Vital Spirt"),
	VOLT_ABSORB("Volt Absorb"),

	/* W abilities */
	WATER_ABSORB("Water_Absorb"),
	WATER_VEIL("Water Veil"),
	WEAK_ARMOR("Weak Armor"),
	WHITE_SMOKE("White Smoke"),
	WONDER_GUARD("Wonder Guard"),
	WONDER_SKIN("Wonder Skin"),

	/* X abilities */

	/* Y abilities */

	/* Z abilities */
	ZEN_MODE("Zen Mode");

	private String name;

	Ability(String name) {
		this.name = name;
	}

	public static Ability findAbilityByName(String name) {
		Ability ability = null;
		for (Ability ab : Ability.values()) {
			if (ab.toString().toLowerCase().equals(name.toLowerCase())) {
				ability = ab;
				break;
			}
		}
		return ability;
	}

	public boolean preventsSwitching(Pokemon switching) {
		switch (this) {
			case SHADOW_TAG:
				return switching.getAbility() != SHADOW_TAG;
			case MAGNET_PULL:
				return switching.isType(Type.STEEL);
			case ARENA_TRAP:
				// TODO implement arena trap ability
				return false;
			default:
				return false;
		}
	}

	public boolean preventsWeather() {
		switch (this) {
			case CLOUD_NINE:
			case AIR_LOCK:
				return true;
			default:
				return false;
		}
	}

	public boolean preventsBurn(Weather weather) {
		switch (this) {
			case WATER_VEIL:
				return true;
			case LEAF_GUARD:
				return weather.isSun();
			default:
				return false;
		}
	}
	
	public boolean accuracyCheckRequired(Pokemon target) {
		switch (this) {
			case NO_GUARD:
				return false;
			default:
				return target.getAbility() == NO_GUARD;
		}
	}
	
	public boolean preventsPoision(Pokemon target) {
		return this == IMMUNITY;
	}
	
	public boolean preventsParalysis(Pokemon target) {
		return this == LIMBER;
	}

	public boolean preventsSleep() {
		switch(this) {
			case INSOMNIA:
			case VITAL_SPIRT:
				return true;
			default:
				return false;
		} 
	}
	
	public boolean preventsFreezing(Pokemon target) {
		return this == FLAME_BODY;
	}
	
	public boolean preventsConfusion() {
		return this == OWN_TEMPO;
	}
	
	public boolean reflectsStatus(Pokemon self) {
		switch(this) {
		case SYNCHRONIZE:
			return !self.isOk();
		default:
			return false;
		}
	}
	
	public boolean ignoresBurnDebuff() {
		return this == GUTS;
	}
	
	public boolean ignoreParaSpeedDebuff() {
		return this == QUCIK_FEET;
	}

	public boolean healsWhenPoisoned() {
		return this == POISON_HEAL;
	}
	
	// TODO can cure own status
	
	public boolean preventsSoundMoves() {
		return this == SOUNDPROOF;
	}
	
	public boolean regenerates() {
		return this == REGENERATOR;
	}
	
	public boolean clearsStatusAfterSwitch() {
		return this == NATURAL_CURE;
	}
	
	// TODO immune to ground
	// TODO early wake up
	// TODO reduces fire damage
	// TODO prevents phazing
		
	public boolean causesBadDreams() {
		return this == BAD_DREAMS;
	}
	
	public boolean preventsRecoil() {
		switch(this) {
		case ROCK_HEAD:
		case MAGIC_GUARD:
			return true;
		default:
			return false;
		}
	}
	
	public boolean preventsSecondaryDamage() {
		return this == MAGIC_GUARD;
	}
	
	public boolean hurtsLeecher() {
		return this == LIQUID_OOZE;
	}
	
	public boolean weakensSEHits() {
		switch(this) {
		case FILTER:
		case SOLID_ROCK:
			return true;
		default:
			return false;
		}
	}
	
	public boolean strengthensNVEHits() {
		return this == TINTED_LENS;
	}
	
	public boolean burnsExtraPP() {
		return this == PRESSURE;
	}

	public boolean ignoresDamagePreventingAbilities() {
		switch(this) {
		case MOLD_BREAKER:
		case TERAVOLT:
		case FLARE_BOOST:
			return true;
		default:
				return false;
		}
	}
	
	public boolean buffsCritDamage() {
		return this == SNIPER;
	}

	// TODO buffs defense
	// TODO buffs spatk
	// TODO buffs spdef
	// TODO boost speed
	
	// TODO boost speed if flinched

	public boolean buffsSTAB() {
		return this == ADAPTABILITY;
	}
	
	public boolean isLoafing(boolean loaf) {
		return this == TRUANT && loaf;
	}
	
	public void switchActivatedAbility(ActivePokemon switchIn, ActivePokemon opponent, Weather weather) {
		switch (switchIn.getAbility()) {
			case DRIZZLE:
				weather.setRain(Weather.PERMANENT);
				break;
			case DROUGHT:
				weather.setSun(Weather.PERMANENT);
				break;
			case SAND_STREAM:
				weather.setSand(Weather.PERMANENT);
				break;
			case SNOW_WARNING:
				weather.setHail(Weather.PERMANENT);
				break;
			case INTIMIDATE:
				opponent.decreaseAttackStage(1);
				break;
			case DOWNLOAD:
				AbilityActivation.activateDownload(switchIn, opponent);
				break;
			case TRACE:
				switchIn.setAbility(opponent.getAbility());
				break;
			case FORECAST:
				AbilityActivation.activateForecast(switchIn, weather);
				break;
			default:
				break;
		}
	}

	public boolean preventsFlinching() {
		return this == INNER_FOCUS;
	}
	
	public String toString() {
		return name;
	}
}
