package com.omnidexter.test.damage;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.omnidex.ability.Ability;
import com.omnidex.battlefield.team.DeepTeam;
import com.omnidex.battlefield.team.Team;
import com.omnidex.damage.WeatherDamage;
import com.omnidex.pokemon.InactivePokemon;
import com.omnidex.pokemon.Species;
import com.omnidex.weather.FieldWeather;
import com.omnidex.weather.Weather;

/**
 * This class houses the junit tests for all Weather-related damage
 * 
 * @author jakers
 */
public class WeatherDamageTest {

	private Weather weather;

	@Before
	public void createWeather() {
		weather = new FieldWeather();
	}

	/**
	 * Test of applyDamagingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyDamagingWeather_Hail_no_immunitity() {
		System.out.println("applyDamagingWeather hail on non-ice type no"
				+ " immunity");
		weather.setHail(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.QUAGSIRE));

		team.getActivePokemon().setHpEv(252);
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());

		WeatherDamage.applyDamagingWeather(weather, team.getActivePokemon());
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());
		assertEquals(370, team.getActivePokemon().getCurrHp());
	}

	/**
	 * Test of applyDamagingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyDamagingWeather_Hail_with_ice_immunity() {
		System.out.println("applyDamagingWeather hail on ice type");
		weather.setHail(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.JYNX));

		team.getActivePokemon().setHpEv(252);
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());

		WeatherDamage.applyDamagingWeather(weather, team.getActivePokemon());
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());
		assertEquals(334, team.getActivePokemon().getCurrHp());
	}

	/**
	 * Test of applyDamagingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyDamagingWeather_Hail_with_MagicGuard() {
		System.out.println("applyDamagingWeather hail on ice type");
		weather.setHail(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.CLEFABLE));

		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setAbility(Ability.MAGIC_GUARD);
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());

		WeatherDamage.applyDamagingWeather(weather, team.getActivePokemon());
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());
		assertEquals(394, team.getActivePokemon().getCurrHp());
	}

	/**
	 * Test of applyDamagingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyDamagingWeather_Hail_with_Overcoat() {
		System.out.println("applyDamagingWeather hail on OVERCOAT");
		weather.setHail(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.PINECO));

		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setAbility(Ability.OVERCOAT);
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());

		WeatherDamage.applyDamagingWeather(weather, team.getActivePokemon());
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());
		assertEquals(304, team.getActivePokemon().getCurrHp());
	}

	/**
	 * Test of applyDamagingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyDamagingWeather_Hail_with_Ice_Body() {
		System.out.println("applyDamagingWeather hail on ICEBODY");
		weather.setHail(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.SPHEAL));

		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setAbility(Ability.ICE_BODY);
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());

		WeatherDamage.applyDamagingWeather(weather, team.getActivePokemon());
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());
		assertEquals(344, team.getActivePokemon().getCurrHp());
	}

	/**
	 * Test of applyDamagingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyDamagingWeather_Hail_with_Snow_Cloak() {
		System.out.println("applyDamagingWeather hail on Snow Cloak");
		weather.setHail(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.FROSLASS));

		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setAbility(Ability.SNOW_CLOAK);
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());

		WeatherDamage.applyDamagingWeather(weather, team.getActivePokemon());
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());
		assertEquals(344, team.getActivePokemon().getCurrHp());
	}

	/**
	 * Test of applyDamagingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyDamagingWeather_Sand_with_Rock_Typing() {
		System.out.println("applyDamagingWeather sand w/ rock type");
		weather.setSand(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.NOSEPASS));

		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setAbility(Ability.STURDY);
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());

		WeatherDamage.applyDamagingWeather(weather, team.getActivePokemon());
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());
		assertEquals(264, team.getActivePokemon().getCurrHp());
	}

	/**
	 * Test of applyDamagingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyDamagingWeather_Sand_with_Steel_Typing() {
		System.out.println("applyDamagingWeather sand w/ steel type");
		weather.setSand(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.MAWILE));

		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setAbility(Ability.INTIMIDATE);
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());

		WeatherDamage.applyDamagingWeather(weather, team.getActivePokemon());
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());
		assertEquals(304, team.getActivePokemon().getCurrHp());
	}

	/**
	 * Test of applyDamagingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyDamagingWeather_Sun_SolarPower() {
		System.out.println("applyDamagingWeather solar power");
		weather.setSun(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.CHARIZARD));

		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setAbility(Ability.SOLAR_POWER);
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());

		WeatherDamage.applyDamagingWeather(weather, team.getActivePokemon());
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());
		assertEquals(315, team.getActivePokemon().getCurrHp());
	}

	/**
	 * Test of applyDamagingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyDamagingWeather_Sun_DrySkin() {
		System.out.println("applyDamagingWeather dry Skin");
		weather.setSun(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.TOXICROAK));

		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setAbility(Ability.DRY_SKIN);
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());

		WeatherDamage.applyDamagingWeather(weather, team.getActivePokemon());
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());
		assertEquals(324, team.getActivePokemon().getCurrHp());
	}

	/**
	 * Test of applyDamagingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyDamagingWeather_Sand_with_Ground_Typing() {
		System.out.println("applyDamagingWeather sand w/ ground type");
		weather.setSand(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.SANDSHREW));

		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setAbility(Ability.SAND_VEIL);
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());

		WeatherDamage.applyDamagingWeather(weather, team.getActivePokemon());
		System.out.println(team.getActivePokemon().getCurrHp() + "/"
				+ team.getActivePokemon().getMaxHp());
		assertEquals(304, team.getActivePokemon().getCurrHp());
	}

	/**
	 * Test of applyHealingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyHealingWeather_Rain_DrySkin() {
		System.out.println("applyHealingWeather Rain dry skin");
		weather.setRain(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.TOXICROAK));
		team.getActivePokemon().setAbility(Ability.DRY_SKIN);
		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setCurrHp(100);
		WeatherDamage.applyHealingWeather(weather, team.getActivePokemon());
		assertEquals(146, team.getActivePokemon().getCurrHp());
	}

	@Test
	public void testApplyHealingWeather_Rain_Hydration_Cure() {
		System.out.println("applyHealingWeather Rain dry skin");
		weather.setRain(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.SEEL));
		team.getActivePokemon().setAbility(Ability.HYDRATION);
		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setFrozen();
		WeatherDamage.applyHealingWeather(weather, team.getActivePokemon());
		assertEquals(false, team.getActivePokemon().isFrozen());
		assertEquals(true, team.getActivePokemon().isOk());
	}

	/**
	 * Test of applyHealingWeather method, of class WeatherDamage.
	 */
	@Test
	public void testApplyHealingWeather_Ice_body() {
		System.out.println("applyHealingWeather ice body");
		weather.setHail(5);
		Team team = new DeepTeam();
		team.addTeamMate(new InactivePokemon(Species.SPHEAL));
		team.getActivePokemon().setAbility(Ability.ICE_BODY);
		team.getActivePokemon().setHpEv(252);
		team.getActivePokemon().setCurrHp(100);
		WeatherDamage.applyHealingWeather(weather, team.getActivePokemon());
		assertEquals(121, team.getActivePokemon().getCurrHp());
	}

	@After
	public void tearDown() {
		weather = null;
	}

}
