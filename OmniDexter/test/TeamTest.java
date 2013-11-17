import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.omnidex.battlefield.team.DeepTeam;
import com.omnidex.battlefield.team.Team;
import com.omnidex.pokemon.ActivePokemon;
import com.omnidexter.main.TestTeamBuilder;


public class TeamTest {

	private Team team;
	@Before
	public void setUp() throws Exception {
		team = TestTeamBuilder.getTestTeamOne();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDamageToParty() {
		assertEquals(207, team.getActivePokemon().getCurrHp());
		team.getActivePokemon().damage(5);
		team.getActivePokemon().setBurnt();
		assertEquals(202, team.getActivePokemon().getCurrHp());
		
		for (ActivePokemon poke :team.getParty()) {
			if (poke.isActivePokemon()) {
				assertEquals(202, poke.getCurrHp());
				assertTrue(poke.isBurnt());
			}
		}
	}

	@Test
	public void testNoAliasingForCopyingTeams() {
		Team temp = new DeepTeam(team);
		
		assertEquals(207, team.getActivePokemon().getCurrHp());
		assertEquals(207, temp.getActivePokemon().getCurrHp());
		temp.getActivePokemon().damage(5);
		assertEquals(207, team.getActivePokemon().getCurrHp());
		assertEquals(202, temp.getActivePokemon().getCurrHp());
	}

	
}
