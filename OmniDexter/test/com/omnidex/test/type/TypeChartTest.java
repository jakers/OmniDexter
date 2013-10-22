package com.omnidex.test.type;

import org.junit.Test;
import com.omnidex.type.Type;

import static org.junit.Assert.*;

public class TypeChartTest {
	@Test
	public void NO_TYPE_attacking_NO_TYPE() {
		assertEquals(1.0, Type.NO_TYPE.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_BUG() {
		assertEquals(1.0, Type.NO_TYPE.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_DARK() {
		assertEquals(1.0, Type.NO_TYPE.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_DRAGON() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_ELECTRIC() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_FIGHTING() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_FIRE() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_FLYING() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_GHOST() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_GRASS() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_GROUND() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_ICE() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_NORMAL() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_POISON() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_PSYCHIC() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_ROCK() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_STEEL() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_WATER() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void NO_TYPE_attacking_FAIRY() {
		assertEquals(1.0,Type.NO_TYPE.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void BUG_attacking_NO_TYPE() {
		assertEquals(1.0,Type.BUG.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void BUG_attacking_BUG() {
		assertEquals(1.0,Type.BUG.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void BUG_attacking_DARK() {
		assertEquals(2.0,Type.BUG.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void BUG_attacking_DRAGON() {
		assertEquals(1.0,Type.BUG.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void BUG_attacking_ELECTRIC() {
		assertEquals(1.0,Type.BUG.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void BUG_attacking_FIGHTING() {
		assertEquals(0.5,Type.BUG.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void BUG_attacking_FIRE() {
		assertEquals(0.5,Type.BUG.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void BUG_attacking_FLYING() {
		assertEquals(0.5,Type.BUG.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void BUG_attacking_GHOST() {
		assertEquals(0.5,Type.BUG.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void BUG_attacking_GRASS() {
		assertEquals(2.0,Type.BUG.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void BUG_attacking_GROUND() {
		assertEquals(1.0,Type.BUG.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void BUG_attacking_ICE() {
		assertEquals(1.0,Type.BUG.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void BUG_attacking_NORMAL() {
		assertEquals(1.0,Type.BUG.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void BUG_attacking_POISON() {
		assertEquals(0.5,Type.BUG.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void BUG_attacking_PSYCHIC() {
		assertEquals(2.0,Type.BUG.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void BUG_attacking_ROCK() {
		assertEquals(1.0,Type.BUG.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void BUG_attacking_STEEL() {
		assertEquals(0.5,Type.BUG.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void BUG_attacking_WATER() {
		assertEquals(1.0,Type.BUG.getEffectiveness(Type.WATER), 0.0);
	}
	
	@Test
	public void BUG_attacking_FAIRY() {
		assertEquals(0.5,Type.BUG.getEffectiveness(Type.FAIRY), 0.0);
	}
	
	@Test
	public void DARK_attacking_NO_TYPE() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void DARK_attacking_BUG() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void DARK_attacking_DARK() {
		assertEquals(0.5,Type.DARK.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void DARK_attacking_DRAGON() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void DARK_attacking_ELECTRIC() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void DARK_attacking_FIGHTING() {
		assertEquals(0.5,Type.DARK.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void DARK_attacking_FIRE() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void DARK_attacking_FLYING() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void DARK_attacking_GHOST() {
		assertEquals(2.0,Type.DARK.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void DARK_attacking_GRASS() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void DARK_attacking_GROUND() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void DARK_attacking_ICE() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void DARK_attacking_NORMAL() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void DARK_attacking_POISON() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void DARK_attacking_PSYCHIC() {
		assertEquals(2.0,Type.DARK.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void DARK_attacking_ROCK() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void DARK_attacking_STEEL() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void DARK_attacking_WATER() {
		assertEquals(1.0,Type.DARK.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void DARK_attacking_FAIRY() {
		assertEquals(0.5,Type.DARK.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void DRAGON_attacking_NO_TYPE() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void DRAGON_attacking_BUG() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void DRAGON_attacking_DARK() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void DRAGON_attacking_DRAGON() {
		assertEquals(2.0,Type.DRAGON.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void DRAGON_attacking_ELECTRIC() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void DRAGON_attacking_FIGHTING() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void DRAGON_attacking_FIRE() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void DRAGON_attacking_FLYING() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void DRAGON_attacking_GHOST() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void DRAGON_attacking_GRASS() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void DRAGON_attacking_GROUND() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void DRAGON_attacking_ICE() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void DRAGON_attacking_NORMAL() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void DRAGON_attacking_POISON() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void DRAGON_attacking_PSYCHIC() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void DRAGON_attacking_ROCK() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void DRAGON_attacking_STEEL() {
		assertEquals(0.5,Type.DRAGON.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void DRAGON_attacking_WATER() {
		assertEquals(1.0,Type.DRAGON.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void DRAGON_attacking_FAIRY() {
		assertEquals(0.0,Type.DRAGON.getEffectiveness(Type.FAIRY), 0.0);
	}
	
	@Test
	public void ELECTRIC_attacking_NO_TYPE() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_BUG() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_DARK() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_DRAGON() {
		assertEquals(0.5,Type.ELECTRIC.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_ELECTRIC() {
		assertEquals(0.5,Type.ELECTRIC.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_FIGHTING() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_FIRE() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_FLYING() {
		assertEquals(2.0,Type.ELECTRIC.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_GHOST() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_GRASS() {
		assertEquals(0.5,Type.ELECTRIC.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_GROUND() {
		assertEquals(0.0,Type.ELECTRIC.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_ICE() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_NORMAL() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_POISON() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_PSYCHIC() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_ROCK() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_STEEL() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_WATER() {
		assertEquals(2.0,Type.ELECTRIC.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void ELECTRIC_attacking_FAIRY() {
		assertEquals(1.0,Type.ELECTRIC.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void FIGHTING_attacking_NO_TYPE() {
		assertEquals(1.0,Type.FIGHTING.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void FIGHTING_attacking_BUG() {
		assertEquals(0.5,Type.FIGHTING.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void FIGHTING_attacking_DARK() {
		assertEquals(2.0,Type.FIGHTING.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void FIGHTING_attacking_DRAGON() {
		assertEquals(1.0,Type.FIGHTING.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void FIGHTING_attacking_ELECTRIC() {
		assertEquals(1.0,Type.FIGHTING.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void FIGHTING_attacking_FIGHTING() {
		assertEquals(1.0,Type.FIGHTING.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void FIGHTING_attacking_FIRE() {
		assertEquals(1.0,Type.FIGHTING.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void FIGHTING_attacking_FLYING() {
		assertEquals(0.5,Type.FIGHTING.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void FIGHTING_attacking_GHOST() {
		assertEquals(0.0,Type.FIGHTING.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void FIGHTING_attacking_GRASS() {
		assertEquals(1.0,Type.FIGHTING.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void FIGHTING_attacking_GROUND() {
		assertEquals(1.0,Type.FIGHTING.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void FIGHTING_attacking_ICE() {
		assertEquals(2.0,Type.FIGHTING.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void FIGHTING_attacking_NORMAL() {
		assertEquals(2.0,Type.FIGHTING.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void FIGHTING_attacking_POISON() {
		assertEquals(0.5,Type.FIGHTING.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void FIGHTING_attacking_PSYCHIC() {
		assertEquals(0.5,Type.FIGHTING.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void FIGHTING_attacking_ROCK() {
		assertEquals(2.0,Type.FIGHTING.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void FIGHTING_attacking_STEEL() {
		assertEquals(2.0,Type.FIGHTING.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void FIGHTING_attacking_WATER() {
		assertEquals(1.0,Type.FIGHTING.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void FIGHTING_attacking_FAIRY() {
		assertEquals(0.5,Type.FIGHTING.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void FIRE_attacking_NO_TYPE() {
		assertEquals(1.0,Type.FIRE.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void FIRE_attacking_BUG() {
		assertEquals(2.0,Type.FIRE.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void FIRE_attacking_DARK() {
		assertEquals(1.0,Type.FIRE.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void FIRE_attacking_DRAGON() {
		assertEquals(0.5,Type.FIRE.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void FIRE_attacking_ELECTRIC() {
		assertEquals(1.0,Type.FIRE.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void FIRE_attacking_FIGHTING() {
		assertEquals(1.0,Type.FIRE.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void FIRE_attacking_FIRE() {
		assertEquals(0.5,Type.FIRE.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void FIRE_attacking_FLYING() {
		assertEquals(1.0,Type.FIRE.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void FIRE_attacking_GHOST() {
		assertEquals(1.0,Type.FIRE.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void FIRE_attacking_GRASS() {
		assertEquals(2.0,Type.FIRE.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void FIRE_attacking_GROUND() {
		assertEquals(1.0,Type.FIRE.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void FIRE_attacking_ICE() {
		assertEquals(2.0,Type.FIRE.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void FIRE_attacking_NORMAL() {
		assertEquals(1.0,Type.FIRE.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void FIRE_attacking_POISON() {
		assertEquals(1.0,Type.FIRE.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void FIRE_attacking_PSYCHIC() {
		assertEquals(1.0,Type.FIRE.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void FIRE_attacking_ROCK() {
		assertEquals(0.5,Type.FIRE.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void FIRE_attacking_STEEL() {
		assertEquals(2.0,Type.FIRE.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void FIRE_attacking_WATER() {
		assertEquals(0.5,Type.FIRE.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void FIRE_attacking_FAIRY() {
		assertEquals(1.0,Type.FIRE.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void FLYING_attacking_NO_TYPE() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void FLYING_attacking_BUG() {
		assertEquals(2.0,Type.FLYING.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void FLYING_attacking_DARK() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void FLYING_attacking_DRAGON() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void FLYING_attacking_ELECTRIC() {
		assertEquals(0.5,Type.FLYING.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void FLYING_attacking_FIGHTING() {
		assertEquals(2.0,Type.FLYING.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void FLYING_attacking_FIRE() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void FLYING_attacking_FLYING() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void FLYING_attacking_GHOST() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void FLYING_attacking_GRASS() {
		assertEquals(2.0,Type.FLYING.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void FLYING_attacking_GROUND() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void FLYING_attacking_ICE() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void FLYING_attacking_NORMAL() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void FLYING_attacking_POISON() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void FLYING_attacking_PSYCHIC() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void FLYING_attacking_ROCK() {
		assertEquals(0.5,Type.FLYING.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void FLYING_attacking_STEEL() {
		assertEquals(0.5,Type.FLYING.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void FLYING_attacking_WATER() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void FLYING_attacking_FAIRY() {
		assertEquals(1.0,Type.FLYING.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void GHOST_attacking_NO_TYPE() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void GHOST_attacking_BUG() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void GHOST_attacking_DARK() {
		assertEquals(0.5,Type.GHOST.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void GHOST_attacking_DRAGON() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void GHOST_attacking_ELECTRIC() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void GHOST_attacking_FIGHTING() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void GHOST_attacking_FIRE() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void GHOST_attacking_FLYING() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void GHOST_attacking_GHOST() {
		assertEquals(2.0,Type.GHOST.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void GHOST_attacking_GRASS() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void GHOST_attacking_GROUND() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void GHOST_attacking_ICE() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void GHOST_attacking_NORMAL() {
		assertEquals(0.0,Type.GHOST.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void GHOST_attacking_POISON() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void GHOST_attacking_PSYCHIC() {
		assertEquals(2.0,Type.GHOST.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void GHOST_attacking_ROCK() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void GHOST_attacking_STEEL() {
		assertEquals(0.5,Type.GHOST.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void GHOST_attacking_WATER() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void GHOST_attacking_FAIRY() {
		assertEquals(1.0,Type.GHOST.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void GRASS_attacking_NO_TYPE() {
		assertEquals(1.0,Type.GRASS.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void GRASS_attacking_BUG() {
		assertEquals(0.5,Type.GRASS.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void GRASS_attacking_DARK() {
		assertEquals(1.0,Type.GRASS.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void GRASS_attacking_DRAGON() {
		assertEquals(0.5,Type.GRASS.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void GRASS_attacking_ELECTRIC() {
		assertEquals(1.0,Type.GRASS.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void GRASS_attacking_FIGHTING() {
		assertEquals(1.0,Type.GRASS.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void GRASS_attacking_FIRE() {
		assertEquals(0.5,Type.GRASS.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void GRASS_attacking_FLYING() {
		assertEquals(0.5,Type.GRASS.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void GRASS_attacking_GHOST() {
		assertEquals(1.0,Type.GRASS.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void GRASS_attacking_GRASS() {
		assertEquals(0.5,Type.GRASS.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void GRASS_attacking_GROUND() {
		assertEquals(2.0,Type.GRASS.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void GRASS_attacking_ICE() {
		assertEquals(1.0,Type.GRASS.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void GRASS_attacking_NORMAL() {
		assertEquals(1.0,Type.GRASS.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void GRASS_attacking_POISON() {
		assertEquals(0.5,Type.GRASS.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void GRASS_attacking_PSYCHIC() {
		assertEquals(1.0,Type.GRASS.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void GRASS_attacking_ROCK() {
		assertEquals(2.0,Type.GRASS.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void GRASS_attacking_STEEL() {
		assertEquals(0.5,Type.GRASS.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void GRASS_attacking_WATER() {
		assertEquals(2.0,Type.GRASS.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void GRASS_attacking_FAIRY() {
		assertEquals(1.0,Type.GRASS.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void GROUND_attacking_NO_TYPE() {
		assertEquals(1.0,Type.GROUND.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void GROUND_attacking_BUG() {
		assertEquals(0.5,Type.GROUND.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void GROUND_attacking_DARK() {
		assertEquals(1.0,Type.GROUND.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void GROUND_attacking_DRAGON() {
		assertEquals(1.0,Type.GROUND.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void GROUND_attacking_ELECTRIC() {
		assertEquals(2.0,Type.GROUND.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void GROUND_attacking_FIGHTING() {
		assertEquals(1.0,Type.GROUND.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void GROUND_attacking_FIRE() {
		assertEquals(2.0,Type.GROUND.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void GROUND_attacking_FLYING() {
		assertEquals(0.0,Type.GROUND.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void GROUND_attacking_GHOST() {
		assertEquals(1.0,Type.GROUND.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void GROUND_attacking_GRASS() {
		assertEquals(0.5,Type.GROUND.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void GROUND_attacking_GROUND() {
		assertEquals(1.0,Type.GROUND.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void GROUND_attacking_ICE() {
		assertEquals(1.0,Type.GROUND.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void GROUND_attacking_NORMAL() {
		assertEquals(1.0,Type.GROUND.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void GROUND_attacking_POISON() {
		assertEquals(2.0,Type.GROUND.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void GROUND_attacking_PSYCHIC() {
		assertEquals(1.0,Type.GROUND.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void GROUND_attacking_ROCK() {
		assertEquals(2.0,Type.GROUND.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void GROUND_attacking_STEEL() {
		assertEquals(2.0,Type.GROUND.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void GROUND_attacking_WATER() {
		assertEquals(1.0,Type.GROUND.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void GROUND_attacking_FAIY() {
		assertEquals(1.0,Type.GROUND.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void ICE_attacking_NO_TYPE() {
		assertEquals(1.0,Type.ICE.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void ICE_attacking_BUG() {
		assertEquals(1.0,Type.ICE.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void ICE_attacking_DARK() {
		assertEquals(1.0,Type.ICE.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void ICE_attacking_DRAGON() {
		assertEquals(2.0,Type.ICE.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void ICE_attacking_ELECTRIC() {
		assertEquals(1.0,Type.ICE.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void ICE_attacking_FIGHTING() {
		assertEquals(1.0,Type.ICE.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void ICE_attacking_FIRE() {
		assertEquals(0.5,Type.ICE.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void ICE_attacking_FLYING() {
		assertEquals(2.0,Type.ICE.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void ICE_attacking_GHOST() {
		assertEquals(1.0,Type.ICE.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void ICE_attacking_GRASS() {
		assertEquals(2.0,Type.ICE.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void ICE_attacking_GROUND() {
		assertEquals(2.0,Type.ICE.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void ICE_attacking_ICE() {
		assertEquals(0.5,Type.ICE.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void ICE_attacking_NORMAL() {
		assertEquals(1.0,Type.ICE.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void ICE_attacking_POISON() {
		assertEquals(1.0,Type.ICE.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void ICE_attacking_PSYCHIC() {
		assertEquals(1.0,Type.ICE.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void ICE_attacking_ROCK() {
		assertEquals(1.0,Type.ICE.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void ICE_attacking_STEEL() {
		assertEquals(0.5,Type.ICE.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void ICE_attacking_WATER() {
		assertEquals(0.5,Type.ICE.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void ICE_attacking_FAIRY() {
		assertEquals(1.0,Type.ICE.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void NORMAL_attacking_NO_TYPE() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void NORMAL_attacking_BUG() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void NORMAL_attacking_DARK() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void NORMAL_attacking_DRAGON() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void NORMAL_attacking_ELECTRIC() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void NORMAL_attacking_FIGHTING() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void NORMAL_attacking_FIRE() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void NORMAL_attacking_FLYING() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void NORMAL_attacking_GHOST() {
		assertEquals(0.0,Type.NORMAL.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void NORMAL_attacking_GRASS() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void NORMAL_attacking_GROUND() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void NORMAL_attacking_ICE() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void NORMAL_attacking_NORMAL() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void NORMAL_attacking_POISON() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void NORMAL_attacking_PSYCHIC() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void NORMAL_attacking_ROCK() {
		assertEquals(0.5,Type.NORMAL.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void NORMAL_attacking_STEEL() {
		assertEquals(0.5,Type.NORMAL.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void NORMAL_attacking_WATER() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void NORMAL_attacking_FAIRY() {
		assertEquals(1.0,Type.NORMAL.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void POISON_attacking_NO_TYPE() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void POISON_attacking_BUG() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void POISON_attacking_DARK() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void POISON_attacking_DRAGON() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void POISON_attacking_ELECTRIC() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void POISON_attacking_FIGHTING() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void POISON_attacking_FIRE() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void POISON_attacking_FLYING() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void POISON_attacking_GHOST() {
		assertEquals(0.5,Type.POISON.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void POISON_attacking_GRASS() {
		assertEquals(2.0,Type.POISON.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void POISON_attacking_GROUND() {
		assertEquals(0.5,Type.POISON.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void POISON_attacking_ICE() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void POISON_attacking_NORMAL() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void POISON_attacking_POISON() {
		assertEquals(0.5,Type.POISON.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void POISON_attacking_PSYCHIC() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void POISON_attacking_ROCK() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void POISON_attacking_STEEL() {
		assertEquals(0.0,Type.POISON.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void POISON_attacking_WATER() {
		assertEquals(1.0,Type.POISON.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void POISON_attacking_FAIRY() {
		assertEquals(2.0,Type.POISON.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_NO_TYPE() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_BUG() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_DARK() {
		assertEquals(0.0,Type.PSYCHIC.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_DRAGON() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_ELECTRIC() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_FIGHTING() {
		assertEquals(2.0,Type.PSYCHIC.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_FIRE() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_FLYING() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_GHOST() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_GRASS() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_GROUND() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_ICE() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_NORMAL() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_POISON() {
		assertEquals(2.0,Type.PSYCHIC.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_PSYCHIC() {
		assertEquals(0.5,Type.PSYCHIC.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_ROCK() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_STEEL() {
		assertEquals(0.5,Type.PSYCHIC.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_WATER() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void PSYCHIC_attacking_FAIRY() {
		assertEquals(1.0,Type.PSYCHIC.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void ROCK_attacking_NO_TYPE() {
		assertEquals(1.0,Type.ROCK.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void ROCK_attacking_BUG() {
		assertEquals(2.0,Type.ROCK.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void ROCK_attacking_DARK() {
		assertEquals(1.0,Type.ROCK.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void ROCK_attacking_DRAGON() {
		assertEquals(1.0,Type.ROCK.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void ROCK_attacking_ELECTRIC() {
		assertEquals(1.0,Type.ROCK.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void ROCK_attacking_FIGHTING() {
		assertEquals(0.5, Type.ROCK.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void ROCK_attacking_FIRE() {
		assertEquals(2.0, Type.ROCK.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void ROCK_attacking_FLYING() {
		assertEquals(2.0, Type.ROCK.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void ROCK_attacking_GHOST() {
		assertEquals(1.0, Type.ROCK.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void ROCK_attacking_GRASS() {
		assertEquals(1.0, Type.ROCK.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void ROCK_attacking_GROUND() {
		assertEquals(0.5, Type.ROCK.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void ROCK_attacking_ICE() {
		assertEquals(2.0, Type.ROCK.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void ROCK_attacking_NORMAL() {
		assertEquals(1.0, Type.ROCK.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void ROCK_attacking_POISON() {
		assertEquals(1.0, Type.ROCK.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void ROCK_attacking_PSYCHIC() {
		assertEquals(1.0, Type.ROCK.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void ROCK_attacking_ROCK() {
		assertEquals(1.0, Type.ROCK.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void ROCK_attacking_STEEL() {
		assertEquals(0.5, Type.ROCK.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void ROCK_attacking_WATER() {
		assertEquals(1.0, Type.ROCK.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void ROCK_attacking_FAIRY() {
		assertEquals(1.0, Type.ROCK.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void STEEL_attacking_NO_TYPE() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void STEEL_attacking_BUG() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void STEEL_attacking_DARK() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void STEEL_attacking_DRAGON() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void STEEL_attacking_ELECTRIC() {
		assertEquals(0.5, Type.STEEL.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void STEEL_attacking_FIGHTING() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void STEEL_attacking_FIRE() {
		assertEquals(0.5, Type.STEEL.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void STEEL_attacking_FLYING() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void STEEL_attacking_GHOST() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void STEEL_attacking_GRASS() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void STEEL_attacking_GROUND() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void STEEL_attacking_ICE() {
		assertEquals(2.0, Type.STEEL.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void STEEL_attacking_NORMAL() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void STEEL_attacking_POISON() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void STEEL_attacking_PSYCHIC() {
		assertEquals(1.0, Type.STEEL.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void STEEL_attacking_ROCK() {
		assertEquals(2.0, Type.STEEL.getEffectiveness(Type.ROCK), 0.0);
	}	
	@Test
	public void STEEL_attacking_STEEL() {
		assertEquals(0.5, Type.STEEL.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void STEEL_attacking_WATER() {
		assertEquals(0.5, Type.STEEL.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void STEEL_attacking_FAIRY() {
		assertEquals(2.0, Type.STEEL.getEffectiveness(Type.FAIRY), 0.0);
	}
	@Test
	public void WATER_attacking_NO_TYPE() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void WATER_attacking_BUG() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void WATER_attacking_DARK() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void WATER_attacking_DRAGON() {
		assertEquals(0.5, Type.WATER.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void WATER_attacking_ELECTRIC() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void WATER_attacking_FIGHTING() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void WATER_attacking_FIRE() {
		assertEquals(2.0, Type.WATER.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void WATER_attacking_FLYING() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void WATER_attacking_GHOST() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void WATER_attacking_GRASS() {
		assertEquals(0.5, Type.WATER.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void WATER_attacking_GROUND() {
		assertEquals(2.0, Type.WATER.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void WATER_attacking_ICE() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void WATER_attacking_NORMAL() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void WATER_attacking_POISON() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void WATER_attacking_PSYCHIC() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void WATER_attacking_ROCK() {
		assertEquals(2.0, Type.WATER.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void WATER_attacking_STEEL() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void WATER_attacking_WATER() {
		assertEquals(0.5, Type.WATER.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void WATER_attacking_FAIRY() {
		assertEquals(1.0, Type.WATER.getEffectiveness(Type.FAIRY), 0.0);
	}
	
	@Test
	public void FAIRY_attacking_NO_TYPE() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.NO_TYPE), 0.0);
	}
	@Test
	public void FAIRY_attacking_BUG() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.BUG), 0.0);
	}
	@Test
	public void FAIRY_attacking_DARK() {
		assertEquals(2.0, Type.FAIRY.getEffectiveness(Type.DARK), 0.0);
	}
	@Test
	public void FAIRY_attacking_DRAGON() {
		assertEquals(2.0, Type.FAIRY.getEffectiveness(Type.DRAGON), 0.0);
	}
	@Test
	public void FAIRY_attacking_ELECTRIC() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.ELECTRIC), 0.0);
	}
	@Test
	public void FAIRY_attacking_FIGHTING() {
		assertEquals(2.0, Type.FAIRY.getEffectiveness(Type.FIGHTING), 0.0);
	}
	@Test
	public void FAIRY_attacking_FIRE() {
		assertEquals(0.5, Type.FAIRY.getEffectiveness(Type.FIRE), 0.0);
	}
	@Test
	public void FAIRY_attacking_FLYING() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.FLYING), 0.0);
	}
	@Test
	public void FAIRY_attacking_GHOST() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.GHOST), 0.0);
	}
	@Test
	public void FAIRY_attacking_GRASS() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.GRASS), 0.0);
	}
	@Test
	public void FAIRY_attacking_GROUND() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.GROUND), 0.0);
	}
	@Test
	public void FAIRY_attacking_ICE() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.ICE), 0.0);
	}
	@Test
	public void FAIRY_attacking_NORMAL() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.NORMAL), 0.0);
	}
	@Test
	public void FAIRY_attacking_POISON() {
		assertEquals(0.5, Type.FAIRY.getEffectiveness(Type.POISON), 0.0);
	}
	@Test
	public void FAIRY_attacking_PSYCHIC() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.PSYCHIC), 0.0);
	}
	@Test
	public void FAIRY_attacking_ROCK() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.ROCK), 0.0);
	}
	@Test
	public void FAIRY_attacking_STEEL() {
		assertEquals(0.5, Type.FAIRY.getEffectiveness(Type.STEEL), 0.0);
	}
	@Test
	public void FAIRY_attacking_WATER() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.WATER), 0.0);
	}
	@Test
	public void FAIRY_attacking_FAIRY() {
		assertEquals(1.0, Type.FAIRY.getEffectiveness(Type.FAIRY), 0.0);
	}
	
	
	
}