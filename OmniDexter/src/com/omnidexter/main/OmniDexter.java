package com.omnidexter.main;

import com.omnidex.battlefield.team.Team;
import com.omnidex.game.ChoiceSelector;
import com.omnidex.game.Game;
import com.omnidex.game.HumanChoiceSelector;
import com.omnidex.move.Move;
import com.omnidex.move.MoveWithPP;
import com.omnidexter.ai.FitnessScore;
import com.omnidexter.ai.MatrixBattleAi;
import com.omnidexter.ai.MatrixBuilder;
import com.omnidexter.ai.Outcome;
import com.omnidexter.battlefield.BattleField;
import com.omnidexter.battlefield.BattleField;

/**
 * @author jakers
 */
public class OmniDexter {

	private static final int SWITCH = 2;
	private static final int FIGHT = 1;

	public static void main(String[] args) {

//		 String teamCode =
//		 "C:\\Users\\Marci\\Desktop\\andrew.txt";
//		 /* open PS and login */
//		 LobbyRC rc = new LobbyRC();
//		 rc.login("01111");
//		
//		 /* input a team from a file */
//		 TeamBuilderRC tb = rc.goToTeamBuilder();
//		 tb.buildTeam("test", TeamBuilderRC.UU, teamCode);
//		
//		 /* return to lobby for a battle with the new team */
//		 rc.goToLobby();

		BattleField bf = new BattleField();
		Team team2 = TestTeamBuilder.getDualTestTeamOne();
		Team team1 = TestTeamBuilder.getMonoTestTeamTwo();
		
		ChoiceSelector player1 = new HumanChoiceSelector();
		ChoiceSelector player2 = new HumanChoiceSelector();
		Game g = new Game(bf, team1, team2, "Chad", player1, player2);
		
		g.applyTurn(new MoveWithPP(Move.SCRATCH), new MoveWithPP(Move.BUBBLE));
		
		System.out.println("SCORE == " +FitnessScore.calcFitness(team1, team2));
		
		Outcome[][] out = MatrixBuilder.buildMatrix(g);
		
		double max = -5000;
		MatrixBattleAi.printOutcomes(out);
		out = MatrixBattleAi.eleminateDominatedStrategies(out);
		
		System.out.println("============");
		MatrixBattleAi.printOutcomes(out);
		
		System.out.println("Player one should use: " + out[0][0].getPlayerOneMove());
		System.out.println("Player two should use: " + out[0][0].getPlayerTwoMove());
		
		
//		MatrixBattleAi mba = new MatrixBattleAi();
//		System.out.println(mba.getBestMove(g));
//		while (!g.isGameOver()) {
//			int choice = player1.getTurnChoice(team1, team2, bf);
//			
//			g.applyTurn(choice, 1);
//			g.applieAfterTurnAffects();
//		}
	}
}
