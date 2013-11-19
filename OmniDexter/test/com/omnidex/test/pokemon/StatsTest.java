package com.omnidex.test.pokemon;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.omnidex.pokemon.Nature;
import com.omnidex.pokemon.PokeStats;
import com.omnidex.pokemon.Species;
import com.omnidex.pokemon.Stats;

public class StatsTest {

	private Stats perfectIvs;
	private Stats allZeroIvs;

	@Before
	public void setUp() throws Exception {
		perfectIvs = new PokeStats(Nature.HARDY, Species.ABOMASNOW, new int[] {
				31, 31, 31, 31, 31, 31 }, new int[] { 0, 0, 0, 0, 0, 0 });
		allZeroIvs = new PokeStats(Nature.HARDY, Species.ABOMASNOW, new int[] {
				0, 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0, 0 });
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void perfectIVsMaxHpEvs() {
		perfectIvs.setHpEv(Stats.MAX_EVS);
		assertEquals(384, perfectIvs.getMaxHp());
		assertEquals(384, perfectIvs.getCurrHp());
	}

	@Test
	public void perfectIVsMaxAtkEvsPlusAtkNature() {
		perfectIvs.setAtkEv(Stats.MAX_EVS);
		perfectIvs.setNature(Nature.ADAMANT);
		assertEquals(311, perfectIvs.getAtk());
	}

	@Test
	public void perfectIVsMaxDefEvsPlusDefNature() {
		perfectIvs.setDefEv(Stats.MAX_EVS);
		perfectIvs.setNature(Nature.BOLD);
		assertEquals(273, perfectIvs.getDef());
	}

	@Test
	public void perfectIVsMaxSpAtkEvsPlusSpAtkNature() {
		perfectIvs.setSpAtkEv(Stats.MAX_EVS);
		perfectIvs.setNature(Nature.MODEST);
		assertEquals(311, perfectIvs.getSpAtk());
	}

	@Test
	public void perfectIVsMaxSpDefEvsPlusSpDefNature() {
		perfectIvs.setSpDefEv(Stats.MAX_EVS);
		perfectIvs.setNature(Nature.SASSY);
		assertEquals(295, perfectIvs.getSpDef());
	}

	@Test
	public void perfectIVsMaxSpDefEvsPlusSpeedNature() {
		perfectIvs.setSpeEv(Stats.MAX_EVS);
		perfectIvs.setNature(Nature.TIMID);
		assertEquals(240, perfectIvs.getSpe());
	}

	@Test
	public void zeroIvsNoHPEvs() {
		assertEquals(290, allZeroIvs.getMaxHp());
	}

	@Test
	public void zeroIvsNoAtkEvsMinusAtkNature() {
		allZeroIvs.setNature(Nature.BOLD);
		assertEquals(170, allZeroIvs.getAtk());
	}

	@Test
	public void IvsNoDefEvsMinusDefNature() {
		allZeroIvs.setNature(Nature.HASTY);
		assertEquals(139, allZeroIvs.getDef());
	}

	@Test
	public void IvsNoSpAtkEvsMinusSpAtkNature() {
		allZeroIvs.setNature(Nature.ADAMANT);
		assertEquals(170, allZeroIvs.getSpAtk());
	}

	@Test
	public void IvsNoSpDefEvsMinusSpDefNature() {
		allZeroIvs.setNature(Nature.NAUGHTY);
		assertEquals(157, allZeroIvs.getSpDef());
	}

	@Test
	public void IvsNoSpeedEvsMinusSpeedNature() {
		allZeroIvs.setNature(Nature.BRAVE);
		assertEquals(112, allZeroIvs.getSpe());
	}
}
