package com.omnidex.pokemon;

import java.util.Random;

import com.omnidex.item.Item;
import com.omnidex.type.Type;

public class ActivePokemon extends DeepPokemon {

	private static final int INITIAL_PERISH_COUNT = 3;
	private static final int INITIAL_EMBARGO_COUNT = 5;
	private static final int INITIAL_ENCORE_COUNT = 3;
	private static final int INITIAL_HEAL_BLOCK_COUNT = 5;
	private static final int MAX_PARTIAL_TRAPPING_COUNT = 5;
	private boolean isAttracted;
	private boolean isProtected;
	private boolean isIngrained;
	private boolean hasAquaRing;
	private boolean isConfused;
	private boolean hasBeenHitByYawn;
	private boolean isBehindSub;
	private boolean isSeeded;
	private boolean isCursed;
	private boolean isHidden;
	private boolean isFlying;
	private boolean isDigging;
	private boolean isDiving;
	private boolean isUsingShadowForce;
	private int perishCount;
	private int embargoCount;
	private int encoreCount;
	private boolean hasFlinched;
	private int healBlockCount;
	private boolean hasBeenIdentified;
	private boolean isIgnoringFightingAndNormalImmunity;
	private boolean isIgnoringPsychicImmunity;
	private boolean hasNightmare;
	private int magmaStormCount;
	private int sandTombCount;
	private int whirlpoolCount;
	private int wrapCount;
	private int bindCount;
	private int clampCount;
	private int fireSpinCount;

	public ActivePokemon() {
		isAttracted = false;
		isProtected = false;
		isIngrained = false;
		hasAquaRing = false;
		isConfused = false;
		hasBeenHitByYawn = false;
		isBehindSub = false;
		isSeeded = false;
		isCursed = false;
		isHidden = false;
		isFlying = false;
		isDigging = false;
		isDiving = false;
		isUsingShadowForce = false;
		perishCount = 0;
		embargoCount = 0;
		encoreCount = 0;
		hasFlinched = false;
		healBlockCount = 0;
	}

	public void activateAttract() {
		isAttracted = true;
	}

	public boolean isAttracted() {
		return isAttracted;
	}

	public void activateProtect() {
		isProtected = true;
	}

	public boolean isProtected() {
		return isProtected;
	}

	public void breakProtection() {
		isProtected = false;
	}

	public void activateIngrain() {
		isIngrained = true;
	}

	public boolean isIngrained() {
		return isIngrained;
	}

	public void activateAquaRing() {
		hasAquaRing = true;
	}

	public boolean hasAquaRing() {
		return hasAquaRing;
	}

	public void activateConfused() {
		if (getAbility().preventsConfusion()) {
			isConfused = false;
		} else {
			isConfused = true;
		}
	}

	public boolean isConfused() {
		return isConfused;
	}

	public void activateYawn() {
		boolean affectedByYawn = getAbility().preventsSleep() || isBehindSub
				|| !isOk();

		if (affectedByYawn) {
			hasBeenHitByYawn = false;
		} else {
			hasBeenHitByYawn = true;
		}
	}

	public boolean isBehindSub() {
		return isBehindSub;
	}

	public boolean hasBeenHitByYawn() {
		return hasBeenHitByYawn;
	}

	public void activateSubstitute() {
		isBehindSub = true;
	}

	public void activateSeeds() {
		if (isType(Type.GRASS) || isBehindSub) {
			isSeeded = false;
		} else {
			isSeeded = true;
		}
	}

	public boolean isSeeded() {
		return isSeeded;
	}

	public void activateCurse() {
		if (isType(Type.GHOST)) {
			isCursed = true;
		} else {
			isCursed = false;
		}
	}

	public boolean isCursed() {
		return isCursed;
	}

	public void activateHiding() {
		isHidden = true;
	}

	public boolean isHiding() {
		return isHidden;
	}

	public void activateFly() {
		activateHiding();
		isFlying = true;
	}

	public boolean isFlying() {
		return isFlying;
	}

	public void activateDig() {
		activateHiding();
		isDigging = true;
	}

	public boolean isDigging() {
		return isDigging;
	}

	public void activateDive() {
		activateHiding();
		isDiving = true;
	}

	public boolean isDiving() {
		return isDiving;
	}

	public void activateShadowForce() {
		activateHiding();
		isUsingShadowForce = true;
	}

	public boolean isUsingShadowForce() {
		return isUsingShadowForce;
	}

	public void activatePerishSong() {

		if (getAbility().preventsSoundMoves() || willPerish()) {
			perishCount = 0;
		} else {
			perishCount = INITIAL_PERISH_COUNT;
		}
	}

	public int getPerishCount() {
		return perishCount;
	}

	public boolean willPerish() {
		return perishCount > 0;
	}

	public void decrementPerishSong() {
		if (willPerish()) {
			perishCount--;
			if (perishCount == 0) {
				setFainted();
			}
		}
	}

	public void activateEmbargo() {
		if (embargoCount == 0) {
			embargoCount = INITIAL_EMBARGO_COUNT;
		}
	}

	public boolean isEmbargoed() {
		return embargoCount > 0;
	}

	public int getEmbargoCount() {
		return embargoCount;
	}

	public void decrementEmbargo() {
		if (embargoCount > 0) {
			embargoCount--;
		}
	}

	public void activateEncore() {
		if (encoreCount == 0) {
			encoreCount = INITIAL_ENCORE_COUNT;
		}
	}

	public boolean hasEncore() {
		return encoreCount > 0;
	}

	public int getEncoreCount() {
		return encoreCount;
	}

	public void activateFlinch() {
		if (getAbility().preventsFlinching()) {
			hasFlinched = false;
		} else {
			hasFlinched = true;
		}
	}

	public boolean hasFlinched() {
		return hasFlinched;
	}

	public void activateHealBlock() {
		if (healBlockCount == 0) {
			healBlockCount = INITIAL_HEAL_BLOCK_COUNT;
		}
	}

	public boolean canNotHeal() {
		return healBlockCount > 0;
	}
	
	public int getHealBlockCount() {
		return healBlockCount;
	}

	public void decrementHealBlock() {
		if (healBlockCount > 0) {
			healBlockCount--;
		}
	}

	public void activateIdentification() {
		hasBeenIdentified = true;
	}

	public void activateIgnoreNormalAndFightingImmunity() {
		if (isType(Type.GHOST)) {
			isIgnoringFightingAndNormalImmunity = true;
		} else {
			isIgnoringFightingAndNormalImmunity = false;
		}
	}

	public boolean NormalAndFightingImmunityIgnored() {
		return isIgnoringFightingAndNormalImmunity;
	}

	public void activateIgnorePsychicImmunity() {
		if (isType(Type.DARK)) {
			isIgnoringPsychicImmunity = true;
		} else {
			isIgnoringPsychicImmunity = false;
		}
	}

	public boolean PsychicImmunityIgnored() {
		return isIgnoringPsychicImmunity;
	}

	public void activateNightmare() {
		if (isAsleep()) {
			hasNightmare = true;
		} else {
			hasNightmare = false;
		}
	}

	public boolean hasNightmare() {
		return hasNightmare;
	}

	public void activateMagmaStorm() {
		magmaStormCount = determinePartialTrapCount();
	}

	public boolean isPartiallyTrapped() {
		return hasMagmaStorm() || hasSandTomb() || hasWhirlpool() || isWrapped() || isBound() || isClamped() || hasFireSpin(); 
	}

	public int getMagmaStromCount() {
		return magmaStormCount;
	}

	public boolean hasMagmaStorm() {
		return magmaStormCount > 0;
	}

	public void decrementMagmaStorm() {
		if (magmaStormCount > 0) {
			magmaStormCount--;
		}
	}

	public void activateSandTomb() {
		sandTombCount = determinePartialTrapCount();
	}

	public int getSandTombCount() {
		return sandTombCount;
	}

	public boolean hasSandTomb() {
		return sandTombCount > 0;
	}

	private int determinePartialTrapCount() {
		int count = 0;
		if (getItem().equals(Item.GRIP_CLAW)) {
			count = MAX_PARTIAL_TRAPPING_COUNT;
		} else {
			count = new Random().nextInt(4) + 2;
		}
		return count;
	}

	public void decrementSandTomb() {
		if (sandTombCount > 0) {
			sandTombCount--;
		}
	}

	public void activateWhirlpool() {
		whirlpoolCount = determinePartialTrapCount();
	}

	public boolean hasWhirlpool() {
		return whirlpoolCount > 0;
	}

	public int getWhirlpoolCount() {
		return whirlpoolCount;
	}

	public void decrementWhirlpool() {
		if (whirlpoolCount > 0) {
			whirlpoolCount--;
		}
	}

	public void activateWrap() {
		wrapCount = determinePartialTrapCount();
	}

	public boolean isWrapped() {
		return wrapCount > 0;
	}

	public int getWrapCount() {
		return wrapCount;
	}

	public void decrementWrap() {
		if (wrapCount > 0) {
			wrapCount--;
		}
	}

	public void activateBind() {
		bindCount = determinePartialTrapCount();
	}
	
	public boolean isBound() {
		return bindCount > 0;
	}

	public int getBindCount() {
		return bindCount;
	}

	public void decrementBind() {
		if (bindCount > 0) {
			bindCount--;
		}
	}

	public void activateClamp() {
		clampCount = determinePartialTrapCount();
	}
	
	public boolean isClamped() {
		return clampCount > 0;
	}

	public int getClampCount() {
		return clampCount;
	}

	public void decrementClamp() {
		if (clampCount > 0) {
			clampCount--;
		}
	}

	public void activateFireSpin() {
		fireSpinCount = determinePartialTrapCount();
	}

	public boolean hasFireSpin() {
		return fireSpinCount > 0;
	}

	public int getFireSpinCount() {
		return fireSpinCount;
	}

	public void decrementFireSpin() {
		if (fireSpinCount > 0) {
			fireSpinCount--;
		}
	}
	

}
