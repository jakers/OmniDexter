package com.omnidex.test.type;

import org.junit.Test;
import com.omnidex.type.Type;
import com.omnidex.type.TypeChart;

import static org.junit.Assert.*;

public class TypeChartTest {
	private TypeChart tc;
	public TypeChartTest() {
		 tc = new TypeChart();
	}
	@Test
	public void NO_TYPE_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.NO_TYPE), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_BUG() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.BUG), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_DARK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.DARK), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_DRAGON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.DRAGON), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.ELECTRIC), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_FIGHTING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.FIGHTING), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_FIRE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.FIRE), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_FLYING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.FLYING), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_GHOST() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.GHOST), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_GRASS() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.GRASS), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_GROUND() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.GROUND), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.ICE), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.NORMAL), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_POISON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.POISON), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_PSYCHIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.PSYCHIC), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_ROCK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.ROCK), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_STEEL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.STEEL), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_WATER() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NO_TYPE, Type.WATER), 0.0);
	}
	@Test
	public void BUG_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.BUG, Type.NO_TYPE), 0.0);
	}
	@Test
	public void BUG_attacking_BUG() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.BUG, Type.BUG), 0.0);
	}
	@Test
	public void BUG_attacking_DARK() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.BUG, Type.DARK), 0.0);
	}
	@Test
	public void BUG_attacking_DRAGON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.BUG, Type.DRAGON), 0.0);
	}
	@Test
	public void BUG_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.BUG, Type.ELECTRIC), 0.0);
	}
	@Test
	public void BUG_attacking_FIGHTING() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.BUG, Type.FIGHTING), 0.0);
	}
	@Test
	public void BUG_attacking_FIRE() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.BUG, Type.FIRE), 0.0);
	}
	@Test
	public void BUG_attacking_FLYING() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.BUG, Type.FLYING), 0.0);
	}
	@Test
	public void BUG_attacking_GHOST() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.BUG, Type.GHOST), 0.0);
	}
	@Test
	public void BUG_attacking_GRASS() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.BUG, Type.GRASS), 0.0);
	}
	@Test
	public void BUG_attacking_GROUND() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.BUG, Type.GROUND), 0.0);
	}
	@Test
	public void BUG_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.BUG, Type.ICE), 0.0);
	}
	@Test
	public void BUG_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.BUG, Type.NORMAL), 0.0);
	}
	@Test
	public void BUG_attacking_POISON() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.BUG, Type.POISON), 0.0);
	}
	@Test
	public void BUG_attacking_PSYCHIC() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.BUG, Type.PSYCHIC), 0.0);
	}
	@Test
	public void BUG_attacking_ROCK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.BUG, Type.ROCK), 0.0);
	}
	@Test
	public void BUG_attacking_STEEL() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.BUG, Type.STEEL), 0.0);
	}
	@Test
	public void BUG_attacking_WATER() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.BUG, Type.WATER), 0.0);
	}
	@Test
	public void DARK_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.NO_TYPE), 0.0);
	}
	@Test
	public void DARK_attacking_BUG() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.BUG), 0.0);
	}
	@Test
	public void DARK_attacking_DARK() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.DARK, Type.DARK), 0.0);
	}
	@Test
	public void DARK_attacking_DRAGON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.DRAGON), 0.0);
	}
	@Test
	public void DARK_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.ELECTRIC), 0.0);
	}
	@Test
	public void DARK_attacking_FIGHTING() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.DARK, Type.FIGHTING), 0.0);
	}
	@Test
	public void DARK_attacking_FIRE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.FIRE), 0.0);
	}
	@Test
	public void DARK_attacking_FLYING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.FLYING), 0.0);
	}
	@Test
	public void DARK_attacking_GHOST() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.DARK, Type.GHOST), 0.0);
	}
	@Test
	public void DARK_attacking_GRASS() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.GRASS), 0.0);
	}
	@Test
	public void DARK_attacking_GROUND() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.GROUND), 0.0);
	}
	@Test
	public void DARK_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.ICE), 0.0);
	}
	@Test
	public void DARK_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.NORMAL), 0.0);
	}
	@Test
	public void DARK_attacking_POISON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.POISON), 0.0);
	}
	@Test
	public void DARK_attacking_PSYCHIC() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.DARK, Type.PSYCHIC), 0.0);
	}
	@Test
	public void DARK_attacking_ROCK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.ROCK), 0.0);
	}
	@Test
	public void DARK_attacking_STEEL() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.DARK, Type.STEEL), 0.0);
	}
	@Test
	public void DARK_attacking_WATER() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DARK, Type.WATER), 0.0);
	}
	@Test
	public void DRAGON_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.NO_TYPE), 0.0);
	}
	@Test
	public void DRAGON_attacking_BUG() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.BUG), 0.0);
	}
	@Test
	public void DRAGON_attacking_DARK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.DARK), 0.0);
	}
	@Test
	public void DRAGON_attacking_DRAGON() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.DRAGON, Type.DRAGON), 0.0);
	}
	@Test
	public void DRAGON_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.ELECTRIC), 0.0);
	}
	@Test
	public void DRAGON_attacking_FIGHTING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.FIGHTING), 0.0);
	}
	@Test
	public void DRAGON_attacking_FIRE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.FIRE), 0.0);
	}
	@Test
	public void DRAGON_attacking_FLYING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.FLYING), 0.0);
	}
	@Test
	public void DRAGON_attacking_GHOST() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.GHOST), 0.0);
	}
	@Test
	public void DRAGON_attacking_GRASS() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.GRASS), 0.0);
	}
	@Test
	public void DRAGON_attacking_GROUND() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.GROUND), 0.0);
	}
	@Test
	public void DRAGON_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.ICE), 0.0);
	}
	@Test
	public void DRAGON_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.NORMAL), 0.0);
	}
	@Test
	public void DRAGON_attacking_POISON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.POISON), 0.0);
	}
	@Test
	public void DRAGON_attacking_PSYCHIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.PSYCHIC), 0.0);
	}
	@Test
	public void DRAGON_attacking_ROCK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.ROCK), 0.0);
	}
	@Test
	public void DRAGON_attacking_STEEL() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.DRAGON, Type.STEEL), 0.0);
	}
	@Test
	public void DRAGON_attacking_WATER() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.DRAGON, Type.WATER), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.NO_TYPE), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_BUG() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.BUG), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_DARK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.DARK), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_DRAGON() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.ELECTRIC, Type.DRAGON), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_ELECTRIC() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.ELECTRIC, Type.ELECTRIC), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_FIGHTING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.FIGHTING), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_FIRE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.FIRE), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_FLYING() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.FLYING), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_GHOST() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.GHOST), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_GRASS() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.ELECTRIC, Type.GRASS), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_GROUND() {
		assertEquals(0.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.GROUND), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.ICE), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.NORMAL), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_POISON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.POISON), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_PSYCHIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.PSYCHIC), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_ROCK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.ROCK), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_STEEL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.STEEL), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_WATER() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.ELECTRIC, Type.WATER), 0.0);
	}
	@Test
	public void FIGHTING_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIGHTING, Type.NO_TYPE), 0.0);
	}
	@Test
	public void FIGHTING_attacking_BUG() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.FIGHTING, Type.BUG), 0.0);
	}
	@Test
	public void FIGHTING_attacking_DARK() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FIGHTING, Type.DARK), 0.0);
	}
	@Test
	public void FIGHTING_attacking_DRAGON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIGHTING, Type.DRAGON), 0.0);
	}
	@Test
	public void FIGHTING_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIGHTING, Type.ELECTRIC), 0.0);
	}
	@Test
	public void FIGHTING_attacking_FIGHTING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIGHTING, Type.FIGHTING), 0.0);
	}
	@Test
	public void FIGHTING_attacking_FIRE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIGHTING, Type.FIRE), 0.0);
	}
	@Test
	public void FIGHTING_attacking_FLYING() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.FIGHTING, Type.FLYING), 0.0);
	}
	@Test
	public void FIGHTING_attacking_GHOST() {
		assertEquals(0.0,tc.getWeaknessResistance(Type.FIGHTING, Type.GHOST), 0.0);
	}
	@Test
	public void FIGHTING_attacking_GRASS() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIGHTING, Type.GRASS), 0.0);
	}
	@Test
	public void FIGHTING_attacking_GROUND() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIGHTING, Type.GROUND), 0.0);
	}
	@Test
	public void FIGHTING_attacking_ICE() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FIGHTING, Type.ICE), 0.0);
	}
	@Test
	public void FIGHTING_attacking_NORMAL() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FIGHTING, Type.NORMAL), 0.0);
	}
	@Test
	public void FIGHTING_attacking_POISON() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.FIGHTING, Type.POISON), 0.0);
	}
	@Test
	public void FIGHTING_attacking_PSYCHIC() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.FIGHTING, Type.PSYCHIC), 0.0);
	}
	@Test
	public void FIGHTING_attacking_ROCK() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FIGHTING, Type.ROCK), 0.0);
	}
	@Test
	public void FIGHTING_attacking_STEEL() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FIGHTING, Type.STEEL), 0.0);
	}
	@Test
	public void FIGHTING_attacking_WATER() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIGHTING, Type.WATER), 0.0);
	}
	@Test
	public void FIRE_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIRE, Type.NO_TYPE), 0.0);
	}
	@Test
	public void FIRE_attacking_BUG() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FIRE, Type.BUG), 0.0);
	}
	@Test
	public void FIRE_attacking_DARK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIRE, Type.DARK), 0.0);
	}
	@Test
	public void FIRE_attacking_DRAGON() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.FIRE, Type.DRAGON), 0.0);
	}
	@Test
	public void FIRE_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIRE, Type.ELECTRIC), 0.0);
	}
	@Test
	public void FIRE_attacking_FIGHTING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIRE, Type.FIGHTING), 0.0);
	}
	@Test
	public void FIRE_attacking_FIRE() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.FIRE, Type.FIRE), 0.0);
	}
	@Test
	public void FIRE_attacking_FLYING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIRE, Type.FLYING), 0.0);
	}
	@Test
	public void FIRE_attacking_GHOST() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIRE, Type.GHOST), 0.0);
	}
	@Test
	public void FIRE_attacking_GRASS() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FIRE, Type.GRASS), 0.0);
	}
	@Test
	public void FIRE_attacking_GROUND() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIRE, Type.GROUND), 0.0);
	}
	@Test
	public void FIRE_attacking_ICE() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FIRE, Type.ICE), 0.0);
	}
	@Test
	public void FIRE_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIRE, Type.NORMAL), 0.0);
	}
	@Test
	public void FIRE_attacking_POISON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIRE, Type.POISON), 0.0);
	}
	@Test
	public void FIRE_attacking_PSYCHIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FIRE, Type.PSYCHIC), 0.0);
	}
	@Test
	public void FIRE_attacking_ROCK() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.FIRE, Type.ROCK), 0.0);
	}
	@Test
	public void FIRE_attacking_STEEL() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FIRE, Type.STEEL), 0.0);
	}
	@Test
	public void FIRE_attacking_WATER() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.FIRE, Type.WATER), 0.0);
	}
	@Test
	public void FLYING_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.NO_TYPE), 0.0);
	}
	@Test
	public void FLYING_attacking_BUG() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FLYING, Type.BUG), 0.0);
	}
	@Test
	public void FLYING_attacking_DARK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.DARK), 0.0);
	}
	@Test
	public void FLYING_attacking_DRAGON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.DRAGON), 0.0);
	}
	@Test
	public void FLYING_attacking_ELECTRIC() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.FLYING, Type.ELECTRIC), 0.0);
	}
	@Test
	public void FLYING_attacking_FIGHTING() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FLYING, Type.FIGHTING), 0.0);
	}
	@Test
	public void FLYING_attacking_FIRE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.FIRE), 0.0);
	}
	@Test
	public void FLYING_attacking_FLYING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.FLYING), 0.0);
	}
	@Test
	public void FLYING_attacking_GHOST() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.GHOST), 0.0);
	}
	@Test
	public void FLYING_attacking_GRASS() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.FLYING, Type.GRASS), 0.0);
	}
	@Test
	public void FLYING_attacking_GROUND() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.GROUND), 0.0);
	}
	@Test
	public void FLYING_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.ICE), 0.0);
	}
	@Test
	public void FLYING_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.NORMAL), 0.0);
	}
	@Test
	public void FLYING_attacking_POISON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.POISON), 0.0);
	}
	@Test
	public void FLYING_attacking_PSYCHIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.PSYCHIC), 0.0);
	}
	@Test
	public void FLYING_attacking_ROCK() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.FLYING, Type.ROCK), 0.0);
	}
	@Test
	public void FLYING_attacking_STEEL() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.FLYING, Type.STEEL), 0.0);
	}
	@Test
	public void FLYING_attacking_WATER() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.FLYING, Type.WATER), 0.0);
	}
	@Test
	public void GHOST_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.NO_TYPE), 0.0);
	}
	@Test
	public void GHOST_attacking_BUG() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.BUG), 0.0);
	}
	@Test
	public void GHOST_attacking_DARK() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.GHOST, Type.DARK), 0.0);
	}
	@Test
	public void GHOST_attacking_DRAGON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.DRAGON), 0.0);
	}
	@Test
	public void GHOST_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.ELECTRIC), 0.0);
	}
	@Test
	public void GHOST_attacking_FIGHTING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.FIGHTING), 0.0);
	}
	@Test
	public void GHOST_attacking_FIRE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.FIRE), 0.0);
	}
	@Test
	public void GHOST_attacking_FLYING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.FLYING), 0.0);
	}
	@Test
	public void GHOST_attacking_GHOST() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.GHOST, Type.GHOST), 0.0);
	}
	@Test
	public void GHOST_attacking_GRASS() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.GRASS), 0.0);
	}
	@Test
	public void GHOST_attacking_GROUND() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.GROUND), 0.0);
	}
	@Test
	public void GHOST_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.ICE), 0.0);
	}
	@Test
	public void GHOST_attacking_NORMAL() {
		assertEquals(0.0,tc.getWeaknessResistance(Type.GHOST, Type.NORMAL), 0.0);
	}
	@Test
	public void GHOST_attacking_POISON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.POISON), 0.0);
	}
	@Test
	public void GHOST_attacking_PSYCHIC() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.GHOST, Type.PSYCHIC), 0.0);
	}
	@Test
	public void GHOST_attacking_ROCK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.ROCK), 0.0);
	}
	@Test
	public void GHOST_attacking_STEEL() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.GHOST, Type.STEEL), 0.0);
	}
	@Test
	public void GHOST_attacking_WATER() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GHOST, Type.WATER), 0.0);
	}
	@Test
	public void GRASS_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GRASS, Type.NO_TYPE), 0.0);
	}
	@Test
	public void GRASS_attacking_BUG() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.GRASS, Type.BUG), 0.0);
	}
	@Test
	public void GRASS_attacking_DARK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GRASS, Type.DARK), 0.0);
	}
	@Test
	public void GRASS_attacking_DRAGON() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.GRASS, Type.DRAGON), 0.0);
	}
	@Test
	public void GRASS_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GRASS, Type.ELECTRIC), 0.0);
	}
	@Test
	public void GRASS_attacking_FIGHTING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GRASS, Type.FIGHTING), 0.0);
	}
	@Test
	public void GRASS_attacking_FIRE() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.GRASS, Type.FIRE), 0.0);
	}
	@Test
	public void GRASS_attacking_FLYING() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.GRASS, Type.FLYING), 0.0);
	}
	@Test
	public void GRASS_attacking_GHOST() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GRASS, Type.GHOST), 0.0);
	}
	@Test
	public void GRASS_attacking_GRASS() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.GRASS, Type.GRASS), 0.0);
	}
	@Test
	public void GRASS_attacking_GROUND() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.GRASS, Type.GROUND), 0.0);
	}
	@Test
	public void GRASS_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GRASS, Type.ICE), 0.0);
	}
	@Test
	public void GRASS_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GRASS, Type.NORMAL), 0.0);
	}
	@Test
	public void GRASS_attacking_POISON() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.GRASS, Type.POISON), 0.0);
	}
	@Test
	public void GRASS_attacking_PSYCHIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GRASS, Type.PSYCHIC), 0.0);
	}
	@Test
	public void GRASS_attacking_ROCK() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.GRASS, Type.ROCK), 0.0);
	}
	@Test
	public void GRASS_attacking_STEEL() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.GRASS, Type.STEEL), 0.0);
	}
	@Test
	public void GRASS_attacking_WATER() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.GRASS, Type.WATER), 0.0);
	}
	@Test
	public void GROUND_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GROUND, Type.NO_TYPE), 0.0);
	}
	@Test
	public void GROUND_attacking_BUG() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.GROUND, Type.BUG), 0.0);
	}
	@Test
	public void GROUND_attacking_DARK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GROUND, Type.DARK), 0.0);
	}
	@Test
	public void GROUND_attacking_DRAGON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GROUND, Type.DRAGON), 0.0);
	}
	@Test
	public void GROUND_attacking_ELECTRIC() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.GROUND, Type.ELECTRIC), 0.0);
	}
	@Test
	public void GROUND_attacking_FIGHTING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GROUND, Type.FIGHTING), 0.0);
	}
	@Test
	public void GROUND_attacking_FIRE() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.GROUND, Type.FIRE), 0.0);
	}
	@Test
	public void GROUND_attacking_FLYING() {
		assertEquals(0.0,tc.getWeaknessResistance(Type.GROUND, Type.FLYING), 0.0);
	}
	@Test
	public void GROUND_attacking_GHOST() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GROUND, Type.GHOST), 0.0);
	}
	@Test
	public void GROUND_attacking_GRASS() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.GROUND, Type.GRASS), 0.0);
	}
	@Test
	public void GROUND_attacking_GROUND() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GROUND, Type.GROUND), 0.0);
	}
	@Test
	public void GROUND_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GROUND, Type.ICE), 0.0);
	}
	@Test
	public void GROUND_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GROUND, Type.NORMAL), 0.0);
	}
	@Test
	public void GROUND_attacking_POISON() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.GROUND, Type.POISON), 0.0);
	}
	@Test
	public void GROUND_attacking_PSYCHIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GROUND, Type.PSYCHIC), 0.0);
	}
	@Test
	public void GROUND_attacking_ROCK() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.GROUND, Type.ROCK), 0.0);
	}
	@Test
	public void GROUND_attacking_STEEL() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.GROUND, Type.STEEL), 0.0);
	}
	@Test
	public void GROUND_attacking_WATER() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.GROUND, Type.WATER), 0.0);
	}
	@Test
	public void ICE_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ICE, Type.NO_TYPE), 0.0);
	}
	@Test
	public void ICE_attacking_BUG() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ICE, Type.BUG), 0.0);
	}
	@Test
	public void ICE_attacking_DARK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ICE, Type.DARK), 0.0);
	}
	@Test
	public void ICE_attacking_DRAGON() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.ICE, Type.DRAGON), 0.0);
	}
	@Test
	public void ICE_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ICE, Type.ELECTRIC), 0.0);
	}
	@Test
	public void ICE_attacking_FIGHTING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ICE, Type.FIGHTING), 0.0);
	}
	@Test
	public void ICE_attacking_FIRE() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.ICE, Type.FIRE), 0.0);
	}
	@Test
	public void ICE_attacking_FLYING() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.ICE, Type.FLYING), 0.0);
	}
	@Test
	public void ICE_attacking_GHOST() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ICE, Type.GHOST), 0.0);
	}
	@Test
	public void ICE_attacking_GRASS() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.ICE, Type.GRASS), 0.0);
	}
	@Test
	public void ICE_attacking_GROUND() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.ICE, Type.GROUND), 0.0);
	}
	@Test
	public void ICE_attacking_ICE() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.ICE, Type.ICE), 0.0);
	}
	@Test
	public void ICE_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ICE, Type.NORMAL), 0.0);
	}
	@Test
	public void ICE_attacking_POISON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ICE, Type.POISON), 0.0);
	}
	@Test
	public void ICE_attacking_PSYCHIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ICE, Type.PSYCHIC), 0.0);
	}
	@Test
	public void ICE_attacking_ROCK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ICE, Type.ROCK), 0.0);
	}
	@Test
	public void ICE_attacking_STEEL() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.ICE, Type.STEEL), 0.0);
	}
	@Test
	public void ICE_attacking_WATER() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.ICE, Type.WATER), 0.0);
	}
	@Test
	public void NORMAL_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.NO_TYPE), 0.0);
	}
	@Test
	public void NORMAL_attacking_BUG() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.BUG), 0.0);
	}
	@Test
	public void NORMAL_attacking_DARK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.DARK), 0.0);
	}
	@Test
	public void NORMAL_attacking_DRAGON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.DRAGON), 0.0);
	}
	@Test
	public void NORMAL_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.ELECTRIC), 0.0);
	}
	@Test
	public void NORMAL_attacking_FIGHTING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.FIGHTING), 0.0);
	}
	@Test
	public void NORMAL_attacking_FIRE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.FIRE), 0.0);
	}
	@Test
	public void NORMAL_attacking_FLYING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.FLYING), 0.0);
	}
	@Test
	public void NORMAL_attacking_GHOST() {
		assertEquals(0.0,tc.getWeaknessResistance(Type.NORMAL, Type.GHOST), 0.0);
	}
	@Test
	public void NORMAL_attacking_GRASS() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.GRASS), 0.0);
	}
	@Test
	public void NORMAL_attacking_GROUND() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.GROUND), 0.0);
	}
	@Test
	public void NORMAL_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.ICE), 0.0);
	}
	@Test
	public void NORMAL_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.NORMAL), 0.0);
	}
	@Test
	public void NORMAL_attacking_POISON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.POISON), 0.0);
	}
	@Test
	public void NORMAL_attacking_PSYCHIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.PSYCHIC), 0.0);
	}
	@Test
	public void NORMAL_attacking_ROCK() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.NORMAL, Type.ROCK), 0.0);
	}
	@Test
	public void NORMAL_attacking_STEEL() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.NORMAL, Type.STEEL), 0.0);
	}
	@Test
	public void NORMAL_attacking_WATER() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.NORMAL, Type.WATER), 0.0);
	}
	@Test
	public void POISON_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.NO_TYPE), 0.0);
	}
	@Test
	public void POISON_attacking_BUG() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.BUG), 0.0);
	}
	@Test
	public void POISON_attacking_DARK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.DARK), 0.0);
	}
	@Test
	public void POISON_attacking_DRAGON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.DRAGON), 0.0);
	}
	@Test
	public void POISON_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.ELECTRIC), 0.0);
	}
	@Test
	public void POISON_attacking_FIGHTING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.FIGHTING), 0.0);
	}
	@Test
	public void POISON_attacking_FIRE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.FIRE), 0.0);
	}
	@Test
	public void POISON_attacking_FLYING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.FLYING), 0.0);
	}
	@Test
	public void POISON_attacking_GHOST() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.POISON, Type.GHOST), 0.0);
	}
	@Test
	public void POISON_attacking_GRASS() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.POISON, Type.GRASS), 0.0);
	}
	@Test
	public void POISON_attacking_GROUND() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.POISON, Type.GROUND), 0.0);
	}
	@Test
	public void POISON_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.ICE), 0.0);
	}
	@Test
	public void POISON_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.NORMAL), 0.0);
	}
	@Test
	public void POISON_attacking_POISON() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.POISON, Type.POISON), 0.0);
	}
	@Test
	public void POISON_attacking_PSYCHIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.PSYCHIC), 0.0);
	}
	@Test
	public void POISON_attacking_ROCK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.ROCK), 0.0);
	}
	@Test
	public void POISON_attacking_STEEL() {
		assertEquals(0.0,tc.getWeaknessResistance(Type.POISON, Type.STEEL), 0.0);
	}
	@Test
	public void POISON_attacking_WATER() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.POISON, Type.WATER), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.NO_TYPE), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_BUG() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.BUG), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_DARK() {
		assertEquals(0.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.DARK), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_DRAGON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.DRAGON), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.ELECTRIC), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_FIGHTING() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.FIGHTING), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_FIRE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.FIRE), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_FLYING() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.FLYING), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_GHOST() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.GHOST), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_GRASS() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.GRASS), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_GROUND() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.GROUND), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_ICE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.ICE), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_NORMAL() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.NORMAL), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_POISON() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.POISON), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_PSYCHIC() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.PSYCHIC, Type.PSYCHIC), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_ROCK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.ROCK), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_STEEL() {
		assertEquals(0.5,tc.getWeaknessResistance(Type.PSYCHIC, Type.STEEL), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_WATER() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.PSYCHIC, Type.WATER), 0.0);
	}
	@Test
	public void ROCK_attacking_NO_TYPE() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ROCK, Type.NO_TYPE), 0.0);
	}
	@Test
	public void ROCK_attacking_BUG() {
		assertEquals(2.0,tc.getWeaknessResistance(Type.ROCK, Type.BUG), 0.0);
	}
	@Test
	public void ROCK_attacking_DARK() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ROCK, Type.DARK), 0.0);
	}
	@Test
	public void ROCK_attacking_DRAGON() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ROCK, Type.DRAGON), 0.0);
	}
	@Test
	public void ROCK_attacking_ELECTRIC() {
		assertEquals(1.0,tc.getWeaknessResistance(Type.ROCK, Type.ELECTRIC), 0.0);
	}
	@Test
	public void ROCK_attacking_FIGHTING() {
		assertEquals(0.5, tc.getWeaknessResistance(Type.ROCK, Type.FIGHTING), 0.0);
	}
	@Test
	public void ROCK_attacking_FIRE() {
		assertEquals(2.0, tc.getWeaknessResistance(Type.ROCK, Type.FIRE), 0.0);
	}
	@Test
	public void ROCK_attacking_FLYING() {
		assertEquals(2.0, tc.getWeaknessResistance(Type.ROCK, Type.FLYING), 0.0);
	}
	@Test
	public void ROCK_attacking_GHOST() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.ROCK, Type.GHOST), 0.0);
	}
	@Test
	public void ROCK_attacking_GRASS() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.ROCK, Type.GRASS), 0.0);
	}
	@Test
	public void ROCK_attacking_GROUND() {
		assertEquals(0.5, tc.getWeaknessResistance(Type.ROCK, Type.GROUND), 0.0);
	}
	@Test
	public void ROCK_attacking_ICE() {
		assertEquals(2.0, tc.getWeaknessResistance(Type.ROCK, Type.ICE), 0.0);
	}
	@Test
	public void ROCK_attacking_NORMAL() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.ROCK, Type.NORMAL), 0.0);
	}
	@Test
	public void ROCK_attacking_POISON() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.ROCK, Type.POISON), 0.0);
	}
	@Test
	public void ROCK_attacking_PSYCHIC() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.ROCK, Type.PSYCHIC), 0.0);
	}
	@Test
	public void ROCK_attacking_ROCK() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.ROCK, Type.ROCK), 0.0);
	}
	@Test
	public void ROCK_attacking_STEEL() {
		assertEquals(0.5, tc.getWeaknessResistance(Type.ROCK, Type.STEEL), 0.0);
	}
	@Test
	public void ROCK_attacking_WATER() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.ROCK, Type.WATER), 0.0);
	}
	@Test
	public void STEEL_attacking_NO_TYPE() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.NO_TYPE), 0.0);
	}
	@Test
	public void STEEL_attacking_BUG() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.BUG), 0.0);
	}
	@Test
	public void STEEL_attacking_DARK() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.DARK), 0.0);
	}
	@Test
	public void STEEL_attacking_DRAGON() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.DRAGON), 0.0);
	}
	@Test
	public void STEEL_attacking_ELECTRIC() {
		assertEquals(0.5, tc.getWeaknessResistance(Type.STEEL, Type.ELECTRIC), 0.0);
	}
	@Test
	public void STEEL_attacking_FIGHTING() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.FIGHTING), 0.0);
	}
	@Test
	public void STEEL_attacking_FIRE() {
		assertEquals(0.5, tc.getWeaknessResistance(Type.STEEL, Type.FIRE), 0.0);
	}
	@Test
	public void STEEL_attacking_FLYING() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.FLYING), 0.0);
	}
	@Test
	public void STEEL_attacking_GHOST() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.GHOST), 0.0);
	}
	@Test
	public void STEEL_attacking_GRASS() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.GRASS), 0.0);
	}
	@Test
	public void STEEL_attacking_GROUND() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.GROUND), 0.0);
	}
	@Test
	public void STEEL_attacking_ICE() {
		assertEquals(2.0, tc.getWeaknessResistance(Type.STEEL, Type.ICE), 0.0);
	}
	@Test
	public void STEEL_attacking_NORMAL() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.NORMAL), 0.0);
	}
	@Test
	public void STEEL_attacking_POISON() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.POISON), 0.0);
	}
	@Test
	public void STEEL_attacking_PSYCHIC() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.STEEL, Type.PSYCHIC), 0.0);
	}
	@Test
	public void STEEL_attacking_ROCK() {
		assertEquals(2.0, tc.getWeaknessResistance(Type.STEEL, Type.ROCK), 0.0);
	}	
	@Test
	public void STEEL_attacking_STEEL() {
		assertEquals(0.5, tc.getWeaknessResistance(Type.STEEL, Type.STEEL), 0.0);
	}
	@Test
	public void STEEL_attacking_WATER() {
		assertEquals(0.5, tc.getWeaknessResistance(Type.STEEL, Type.WATER), 0.0);
	}	
	@Test
	public void WATER_attacking_NO_TYPE() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.NO_TYPE), 0.0);
	}
	@Test
	public void WATER_attacking_BUG() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.BUG), 0.0);
	}
	@Test
	public void WATER_attacking_DARK() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.DARK), 0.0);
	}
	@Test
	public void WATER_attacking_DRAGON() {
		assertEquals(0.5, tc.getWeaknessResistance(Type.WATER, Type.DRAGON), 0.0);
	}
	@Test
	public void WATER_attacking_ELECTRIC() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.ELECTRIC), 0.0);
	}
	@Test
	public void WATER_attacking_FIGHTING() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.FIGHTING), 0.0);
	}
	@Test
	public void WATER_attacking_FIRE() {
		assertEquals(2.0, tc.getWeaknessResistance(Type.WATER, Type.FIRE), 0.0);
	}
	@Test
	public void WATER_attacking_FLYING() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.FLYING), 0.0);
	}
	@Test
	public void WATER_attacking_GHOST() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.GHOST), 0.0);
	}
	@Test
	public void WATER_attacking_GRASS() {
		assertEquals(0.5, tc.getWeaknessResistance(Type.WATER, Type.GRASS), 0.0);
	}
	@Test
	public void WATER_attacking_GROUND() {
		assertEquals(2.0, tc.getWeaknessResistance(Type.WATER, Type.GROUND), 0.0);
	}
	@Test
	public void WATER_attacking_ICE() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.ICE), 0.0);
	}
	@Test
	public void WATER_attacking_NORMAL() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.NORMAL), 0.0);
	}
	@Test
	public void WATER_attacking_POISON() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.POISON), 0.0);
	}
	@Test
	public void WATER_attacking_PSYCHIC() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.PSYCHIC), 0.0);
	}
	@Test
	public void WATER_attacking_ROCK() {
		assertEquals(2.0, tc.getWeaknessResistance(Type.WATER, Type.ROCK), 0.0);
	}
	@Test
	public void WATER_attacking_STEEL() {
		assertEquals(1.0, tc.getWeaknessResistance(Type.WATER, Type.STEEL), 0.0);
	}
	@Test
	public void WATER_attacking_WATER() {
		assertEquals(0.5, tc.getWeaknessResistance(Type.WATER, Type.WATER), 0.0);
	}	
}