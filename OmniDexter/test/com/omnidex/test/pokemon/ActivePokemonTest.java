package com.omnidex.test.pokemon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.omnidex.ability.Ability;
import com.omnidex.item.Item;
import com.omnidex.move.Move;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Nature;
import com.omnidex.pokemon.Species;

public class ActivePokemonTest {

	private ActivePokemon ap;

	@Before
	public void setUp() {
		ap = new ActivePokemon();
	}

	@Test
	public void TestAttraction() {
		ap.activateAttract();
		assertTrue(ap.isAttracted());
	}

	@Test
	public void TestProtected() {
		ap.activateProtect();
		assertTrue(ap.isProtected());
	}

	@Test
	public void TestBreakProtect() {
		ap.activateProtect();
		ap.breakProtection();
		assertFalse(ap.isProtected());
	}

	@Test
	public void TestIngrain() {
		ap.activateIngrain();
		assertTrue(ap.isIngrained());
	}

	@Test
	public void TestAquaRing() {
		ap.activateAquaRing();
		assertTrue(ap.hasAquaRing());
	}

	@Test
	public void TestConfuse() {
		ap.activateConfused();
		assertTrue(ap.isConfused());
	}

	@Test
	public void TestPreventingConfusion() {
		ap.setAbility(Ability.OWN_TEMPO);
		ap.activateConfused();
		assertFalse(ap.isConfused());
	}

	@Test
	public void TestDrowsy() {
		ap.activateYawn();
		assertTrue(ap.hasBeenHitByYawn());
	}

	@Test
	public void TestDrowsyWithInsomia() {
		ap.setAbility(Ability.INSOMNIA);
		ap.activateYawn();
		assertFalse(ap.hasBeenHitByYawn());
	}

	@Test
	public void TestDrowsyWithVitalSpirit() {
		ap.setAbility(Ability.VITAL_SPIRT);
		ap.activateYawn();
		assertFalse(ap.hasBeenHitByYawn());
	}

	@Test
	public void TestDrowsyWithSubstitute() {
		ap.activateSubstitute();
		ap.activateYawn();
		assertFalse(ap.hasBeenHitByYawn());
	}

	@Test
	public void TestDrowsyWithMajorStatus() {
		ap.setBurnt();
		ap.activateYawn();
		assertFalse(ap.hasBeenHitByYawn());
	}

	@Test
	public void TestSeeding() {
		ap.activateSeeds();
		assertTrue(ap.isSeeded());
	}

	@Test
	public void TestSeedingOnGrassType() {
		ap.setSpecies(Species.ABOMASNOW);
		ap.activateSeeds();
		assertFalse(ap.isSeeded());
	}

	@Test
	public void TestSeedingOnSubstitute() {
		ap.activateSubstitute();
		ap.activateSeeds();
		assertFalse(ap.isSeeded());
	}

	@Test
	public void TestCursedOnGhost() {
		ap.setSpecies(Species.HAUNTER);
		ap.activateCurse();
		assertTrue(ap.isCursed());
	}

	@Test
	public void TestCurseOnNonGhost() {
		ap.setSpecies(Species.ABRA);
		ap.activateCurse();
		assertFalse(ap.isCursed());
	}

	@Test
	public void TestHide() {
		ap.activateHiding();
		assertTrue(ap.isHiding());
	}

	@Test
	public void TestFly() {
		ap.activateFly();
		assertTrue(ap.isHiding());
		assertTrue(ap.isFlying());
	}

	@Test
	public void TestDig() {
		ap.activateDig();
		assertTrue(ap.isHiding());
		assertTrue(ap.isDigging());
	}

	@Test
	public void TestDive() {
		ap.activateDive();
		assertTrue(ap.isHiding());
		assertTrue(ap.isDiving());
	}

	@Test
	public void TestShadowForce() {
		ap.activateShadowForce();
		assertTrue(ap.isHiding());
		assertTrue(ap.isUsingShadowForce());
	}

	@Test
	public void TestPerishSong() {
		ap.activatePerishSong();
		assertTrue(ap.willPerish());
		assertEquals(ap.getPerishCount(), 3);
	}

	@Test
	public void TestPerishOnSoundProof() {
		ap.setAbility(Ability.SOUNDPROOF);
		ap.activatePerishSong();
		assertFalse(ap.willPerish());
		assertEquals(ap.getPerishCount(), 0);
	}

	@Test
	public void TestDecrementingPerishSong() {
		ap.activatePerishSong();
		ap.decrementPerishSong();
		assertTrue(ap.willPerish());
		assertEquals(ap.getPerishCount(), 2);
		ap.decrementPerishSong();
		assertEquals(ap.getPerishCount(), 1);
		ap.decrementPerishSong();
		assertFalse(ap.willPerish());
		assertEquals(ap.getPerishCount(), 0);
		assertTrue(ap.hasFainted());
	}

	@Test
	public void TestEmbargo() {
		ap.activateEmbargo();
		assertTrue(ap.isEmbargoed());
	}

	@Test
	public void TestEncoreCount() {
		ap.activateEmbargo();
		assertEquals(ap.getEmbargoCount(), 5);
	}

	@Test
	public void TestEncoreDecrement() {
		ap.activateEmbargo();
		assertEquals(ap.getEmbargoCount(), 5);
		ap.decrementEmbargo();
		assertEquals(ap.getEmbargoCount(), 4);
		ap.decrementEmbargo();
		ap.decrementEmbargo();
		ap.decrementEmbargo();
		ap.decrementEmbargo();
		assertEquals(ap.getEmbargoCount(), 0);
		assertFalse(ap.isEmbargoed());
	}

	@Test
	public void TestEncore() {
		ap.activateEncore();
		assertTrue(ap.hasEncore());
		assertEquals(ap.getEncoreCount(), 3);
	}

	@Test
	public void TestFlinch() {
		ap.activateFlinch();
		assertTrue(ap.hasFlinched());
	}

	@Test
	public void TestFlinchAgainstPreventsFlinching() {
		ap.setAbility(Ability.INNER_FOCUS);
		ap.activateFlinch();
		assertFalse(ap.hasFlinched());
	}

	@Test
	public void TestHealBlock() {
		ap.activateHealBlock();
		assertTrue(ap.canNotHeal());
		assertEquals(ap.getHealBlockCount(), 5);
		ap.decrementHealBlock();
		assertEquals(ap.getHealBlockCount(), 4);
		ap.activateHealBlock();
		assertEquals(ap.getHealBlockCount(), 4);

	}

	@Test
	public void TestDecrementHealBlock() {
		ap.activateHealBlock();
		ap.decrementHealBlock();
		assertTrue(ap.canNotHeal());
		assertEquals(ap.getHealBlockCount(), 4);
		ap.decrementHealBlock();
		ap.decrementHealBlock();
		ap.decrementHealBlock();
		ap.decrementHealBlock();
		assertFalse(ap.canNotHeal());
		assertEquals(ap.getHealBlockCount(), 0);
	}

	@Test
	public void TestIgnoreFightingAndNormalImmunity() {
		ap.setSpecies(Species.HAUNTER);
		ap.activateIgnoreNormalAndFightingImmunity();
		assertTrue(ap.NormalAndFightingImmunityIgnored());
	}

	@Test
	public void TestIgnorePsychicImmunity() {
		ap.setSpecies(Species.ABSOL);
		ap.activateIgnorePsychicImmunity();
		assertTrue(ap.PsychicImmunityIgnored());
	}

	@Test
	public void TestNightnmare() {
		ap.setSleep(5);
		ap.activateNightmare();
		assertTrue(ap.hasNightmare());
	}

	@Test
	public void TestNightmareWhenNotSleeping() {
		ap.activateNightmare();
		assertFalse(ap.hasNightmare());
	}

	@Test
	public void TestMagmaStormWithGripClaw() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateMagmaStorm();
		assertTrue(ap.isPartiallyTrapped());
		assertEquals(ap.getMagmaStromCount(), 5);
	}

	@Test
	public void TestMagmaStormWithoutGripClaw() {
		ap.activateMagmaStorm();
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.hasMagmaStorm());
		assertTrue(ap.getMagmaStromCount() >= 2);
		assertTrue(ap.getMagmaStromCount() < 6);
	}

	@Test
	public void TestMagmaStormDecrement() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateMagmaStorm();

		for (int i = ap.getMagmaStromCount(); i > 0; i--) {
			ap.decrementMagmaStorm();
			assertEquals(i - 1, ap.getMagmaStromCount());
		}

		assertFalse(ap.hasMagmaStorm());
		assertFalse(ap.isPartiallyTrapped());
	}

	@Test
	public void TestSandTombWithGripClaw() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateSandTomb();
		assertEquals(5, ap.getSandTombCount());
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.hasSandTomb());
	}

	@Test
	public void TestSandTombWithoutGripClaw() {
		ap.activateSandTomb();
		assertTrue(ap.getSandTombCount() >= 2);
		assertTrue(ap.getSandTombCount() < 6);
	}

	@Test
	public void TestSandTombDecrement() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateSandTomb();

		for (int i = ap.getSandTombCount(); i > 0; i--) {
			ap.decrementSandTomb();
			assertEquals(i - 1, ap.getSandTombCount());
		}

		assertFalse(ap.hasSandTomb());
		assertFalse(ap.isPartiallyTrapped());
	}

	@Test
	public void TestWhirlpoolWithGripClaw() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateWhirlpool();
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.hasWhirlpool());
		assertEquals(5, ap.getWhirlpoolCount());
	}

	@Test
	public void TestWhirlpoolWithoutGripClaw() {
		ap.activateWhirlpool();
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.hasWhirlpool());
		assertTrue(ap.getWhirlpoolCount() >= 2);
		assertTrue(ap.getWhirlpoolCount() < 6);
	}

	@Test
	public void TestWhirlpoolDecrement() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateWhirlpool();

		for (int i = ap.getWhirlpoolCount(); i > 0; i--) {
			ap.decrementWhirlpool();
			assertEquals(i - 1, ap.getWhirlpoolCount());
		}

		assertFalse(ap.hasWhirlpool());
		assertFalse(ap.isPartiallyTrapped());
	}

	@Test
	public void TestWrapWithGripClaw() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateWrap();
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.isWrapped());
		assertEquals(5, ap.getWrapCount());
	}

	@Test
	public void TestWrapWithoutGripClaw() {
		ap.activateWrap();
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.isWrapped());
		assertTrue(ap.getWrapCount() >= 2);
		assertTrue(ap.getWrapCount() < 6);
	}

	@Test
	public void TestWrapDecrement() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateWrap();

		for (int i = ap.getWrapCount(); i > 0; i--) {
			ap.decrementWrap();
			assertEquals(i - 1, ap.getWrapCount());
		}

		assertFalse(ap.isWrapped());
		assertFalse(ap.isPartiallyTrapped());
	}

	@Test
	public void TestBindWithGripClaw() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateBind();
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.isBound());
		assertEquals(5, ap.getBindCount());
	}

	@Test
	public void TestBindWithoutGripClaw() {
		ap.activateBind();
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.isBound());
		assertTrue(ap.getBindCount() >= 2);
		assertTrue(ap.getBindCount() < 6);
	}

	@Test
	public void TestBindDecrement() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateBind();

		for (int i = ap.getBindCount(); i > 0; i--) {
			ap.decrementBind();
			assertEquals(i - 1, ap.getBindCount());
		}

		assertFalse(ap.isBound());
		assertFalse(ap.isPartiallyTrapped());
	}

	@Test
	public void TestClampWithGripClaw() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateClamp();
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.isClamped());
		assertEquals(5, ap.getClampCount());
	}

	@Test
	public void TestClampWithoutGripClaw() {
		ap.activateClamp();
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.isClamped());
		assertTrue(ap.getClampCount() >= 2);
		assertTrue(ap.getClampCount() < 6);
	}

	@Test
	public void TestClampDecrement() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateClamp();

		for (int i = ap.getClampCount(); i > 0; i--) {
			ap.decrementClamp();
			assertEquals(i - 1, ap.getClampCount());
		}

		assertFalse(ap.isClamped());
		assertFalse(ap.isPartiallyTrapped());
	}

	@Test
	public void TestFireSpinWithGripClaw() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateFireSpin();
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.hasFireSpin());
		assertEquals(5, ap.getFireSpinCount());
	}

	@Test
	public void TestFireSpinWithoutGripClaw() {
		ap.activateFireSpin();
		assertTrue(ap.isPartiallyTrapped());
		assertTrue(ap.hasFireSpin());
		assertTrue(ap.getFireSpinCount() >= 2);
		assertTrue(ap.getFireSpinCount() < 6);
	}

	@Test
	public void TestFireSpinDecrement() {
		ap.setItem(Item.GRIP_CLAW);
		ap.activateFireSpin();

		for (int i = ap.getFireSpinCount(); i > 0; i--) {
			ap.decrementFireSpin();
			assertEquals(i - 1, ap.getFireSpinCount());
		}

		assertFalse(ap.hasFireSpin());
		assertFalse(ap.isPartiallyTrapped());
	}

	@Test
	public void TestTelekineticLevitation() {
		ap.activateTelekineticLevitation();
		assertTrue(ap.isTelekineticlyLevitated());
	}

	@Test
	public void TestTelekineticLevitationOnIngrained() {
		ap.activateIngrain();
		ap.activateTelekineticLevitation();
		assertFalse(ap.isTelekineticlyLevitated());
	}

	@Test
	public void TestTelekineticLeviationThenIngrain() {
		ap.activateTelekineticLevitation();
		ap.activateIngrain();
		assertFalse(ap.isTelekineticlyLevitated());
	}

	@Test
	public void TestTelekineticLeviationOnIronBall() {
		ap.setItem(Item.IRON_BALL);
		ap.activateTelekineticLevitation();
		assertFalse(ap.isTelekineticlyLevitated());
	}

	@Test
	public void testTelekineticLeviationAfterGivenIronBall() {
		ap.activateTelekineticLevitation();
		ap.setItem(Item.IRON_BALL);
		assertFalse(ap.isTelekineticlyLevitated());
	}

	@Test
	public void TestTelekineticLeviationWithGravity() {
		ap.activateTelekineticLevitation();
		ap.activateGravity();
		assertFalse(ap.isTelekineticlyLevitated());
	}

	@Test
	public void TestTelekineticLeviationAfterGravity() {
		ap.activateGravity();
		ap.activateTelekineticLevitation();
		assertFalse(ap.isTelekineticlyLevitated());
	}

	@Test
	public void TestLastMove() {
		ap.setLastMove(Move.ABSORB);
		assertEquals(Move.ABSORB, ap.getLastMove());
	}

	@Test
	public void TestTorment() {
		ap.activateTorment();
		assertTrue(ap.isTormented());
	}

	@Test
	public void TestCannotUseLastMoveWhenTormented() {
		ap.setLastMove(Move.ABSORB);
		ap.activateTorment();
		assertFalse(ap.canUseMove(Move.ABSORB));
	}

	@Test
	public void TestUseLastMoveWhenNotTormented() {
		ap.setLastMove(Move.ABSORB);
		assertTrue(ap.canUseMove(Move.ABSORB));
	}

	@Test
	public void TestCanSwith() {
		assertTrue(ap.canSwith());
	}

	@Test
	public void TestCanSwitchWhenTrapped() {
		ap.activateTrapped();
		assertFalse(ap.canSwith());
	}

	@Test
	public void TestCanSwitchWhenShedShellEquipped() {
		ap.setItem(Item.SHED_SHELL);
		ap.activateTrapped();
		assertTrue(ap.canSwith());
	}

	@Test
	public void TestCanSwitchWhenTrappedThenGivenShedShell() {
		ap.activateTrapped();
		ap.setItem(Item.SHED_SHELL);
		assertTrue(ap.canSwith());
	}

	@Test
	public void TestBracing() {
		ap.activateBracing();
		assertTrue(ap.isBracing());
	}

	@Test
	public void TestBoostingRolloutAndIceBall() {
		ap.activateBoostRolloutAndIceBall();
		assertTrue(ap.hasBoostedRolloutAndIceBall());
	}

	@Test
	public void TestFocusEnergy() {
		ap.activateFocusEnergy();
		assertTrue(ap.hasFocusEnergy());
		assertEquals(3, ap.getCriticalHitStage());
	}

	@Test
	public void TestElectricMagniticLevitation() {
		ap.activateElectricMagniticLevitation();
		assertTrue(ap.hasElectricMagnitcLevitation());
		assertEquals(5, ap.getElectricMagnitcLevitationCount());
	}

	@Test
	public void TestElectricMagniticLevitationWithIronBall() {
		ap.setItem(Item.IRON_BALL);
		ap.activateElectricMagniticLevitation();
		assertFalse(ap.hasElectricMagnitcLevitation());
		assertEquals(0, ap.getElectricMagnitcLevitationCount());
	}

	@Test
	public void TestElectricMagnitcLevitationThenGiveIronBall() {
		ap.activateElectricMagniticLevitation();
		ap.setItem(Item.IRON_BALL);
		assertFalse(ap.hasElectricMagnitcLevitation());
		assertEquals(0, ap.getElectricMagnitcLevitationCount());
	}

	@Test
	public void TestDecrementElectricMagniticLevitiation() {
		ap.activateElectricMagniticLevitation();
		for (int i = 5; i > 0; i--) {
			ap.decrementElectricMagniticLeviation();
			assertEquals(i - 1, ap.getElectricMagnitcLevitationCount());
		}

		assertFalse(ap.hasElectricMagnitcLevitation());
	}

	@Test
	public void TestMinimize() {
		ap.activateMinimize();
		assertTrue(ap.isMinimized());
		assertEquals(2, ap.getEvasionStage());
	}

	@Test
	public void TestRecharing() {
		ap.activateRecharge();
		assertTrue(ap.hasToRecharge());
	}

	@Test
	public void TestEscapingRecharging() {
		useRechargeMoveAndWaitATurn();
		assertFalse(ap.hasToRecharge());
	}

	private void useRechargeMoveAndWaitATurn() {
		ap.activateRecharge();
		ap.endTurnCleanup();
		ap.endTurnCleanup();
	}

	@Test
	public void TestCharging() {
		ap.activateChargingMove();
		assertTrue(ap.hasToChargeMove());
	}

	@Test
	public void TestBeingFreedFromCharging() {
		ap.activateChargingMove();
		assertFalse(ap.canUseMove(Move.SOLARBEAM));
		ap.endTurnCleanup();
		assertFalse(ap.hasToChargeMove());
	}

	@Test
	public void TestSkullBashCharging() {
		ap.activateSkullBashBoost();
	}

	@Test
	public void TestTakingAim() {
		ap.setLastMove(Move.LOCK_ON);
		ap.activateTakingAim();
		assertTrue(ap.hasTakenAim());
		ap.endTurnCleanup();
		ap.setLastMove(Move.GUILLOTINE);
		ap.endTurnCleanup();
		assertFalse(ap.hasTakenAim());
	}

	@Test
	public void TestActivateFlashFire() {
		ap.activateFlashFireBoost();
		assertTrue(ap.hasFlashFireBoost());
	}
	
	@Test
	public void TestBoostAttackStats() {
		ap.setSpecies(Species.AGGRON);
		ap.setLevel(100);
		ap.setNature(Nature.ADAMANT);
		ap.setAtkEv(252);
		ap.setAtkIv(31);
		
		ap.boostAttackStage(2);
		assertEquals(700, ap.getCurrAtk());
	}

}
