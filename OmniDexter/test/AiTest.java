import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.omnidex.battlefield.team.Team;
import com.omnidex.damage.MathUtils;
import com.omnidex.game.Game;
import com.omnidex.game.GamePrinter;
import com.omnidex.game.HumanChoiceSelector;
import com.omnidex.move.Move;
import com.omnidex.move.MoveWithPP;
import com.omnidexter.ai.MatrixBattleAi;
import com.omnidexter.ai.MatrixBuilder;
import com.omnidexter.ai.Outcome;
import com.omnidexter.battlefield.BattleField;
import com.omnidexter.main.TestTeamBuilder;


public class AiTest {

	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void considerPriority() {
		Team fasterNoPriorityTeam = TestTeamBuilder.getMonoTestTeamWithOutPriority();
		Team slowerWithPriorityTeam = TestTeamBuilder.getMonoTestTeamWithPriority();
		
		fasterNoPriorityTeam.setChoice(new MoveWithPP(Move.SCRATCH));
		slowerWithPriorityTeam.setChoice(new MoveWithPP(Move.AQUA_JET));
		
		assertTrue(new MoveWithPP(Move.AQUA_JET).getPriority() > new MoveWithPP(Move.SCRATCH).getPriority());
		MathUtils.getFasterPoke(fasterNoPriorityTeam, slowerWithPriorityTeam);
	}
	
	

}
