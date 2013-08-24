package com.omnidexter.main;

import com.omnidex.battlefield.team.Team;
import com.omnidex.game.Game;
import com.omnidex.game.GamePrinter;
import com.omnidex.move.Move;
import com.omnidex.move.MoveWithPP;
import com.omnidex.pokemon.InactivePokemon;
import com.omnidexter.battlefield.BattleField;
import com.omnidexter.battlefield.SingleBattleField;

/**
 * @author jakers
 */
public class OmniDexter {

	/**
	 * @param args
	 *            the command line arguments
	 * @throws IOException
	 */
	public static void main(String[] args) {

		// String teamCode =
		// "C:\\Users\\Marci\\Desktop\\andrew.txt";
		// /* open PS and login */
		// LobbyRC rc = new LobbyRC();
		// rc.login("01111");
		//
		// /* input a team from a file */
		// TeamBuilderRC tb = rc.goToTeamBuilder();
		// tb.buildTeam("test", TeamBuilderRC.UU, teamCode);
		//
		// /* return to lobby for a battle with the new team */
		// rc.goToLobby();

		MoveWithPP m1 = new MoveWithPP(Move.TRUMP_CARD);
		Move m2 = Move.TRUMP_CARD;

		BattleField bf = new SingleBattleField();
		Team team1 = TestTeamBuilder.getTestTeamOne();
		Team team2 = TestTeamBuilder.getTestTeamTwo();

		Game g = new Game(bf, team1, team2, "Chad");

		// while (!g.isGameOver()) {
		GamePrinter.printBattleField(team1, team2);
		int choice = g.getFightOrSwitchInput();
		if (choice == 1) {
			GamePrinter.printFightOption(team1.getActivePokemon());
		} else if (choice == 2) {
			GamePrinter.printSwitchOption(team1);
		}

		// }

		// rc.sendChallengeRequestTo("01110", BattleRC.UU_CHALLENGE);

	}
}
