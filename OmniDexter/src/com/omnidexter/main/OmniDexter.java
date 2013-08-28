package com.omnidexter.main;

import com.omnidex.battlefield.team.DeepTeam;
import com.omnidex.battlefield.team.Team;
import com.omnidex.game.Game;
import com.omnidex.game.GamePrinter;
import com.omnidex.move.Move;
import com.omnidex.move.MoveWithPP;
import com.omnidex.pokemon.InactivePokemon;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.pokemon.Species;
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
		Team team1 = new DeepTeam();// = TestTeamBuilder.getTestTeamOne();
		
		Pokemon p = new InactivePokemon(Species.BULBASAUR);
		for (int i = 0; i < 6; i++) {
			team1.addTeamMate(p);
		}
		
		
		Team team2 = TestTeamBuilder.getTestTeamTwo();
		System.out.println("team 1 size = " + team1.size());
		Game g = new Game(bf, team1, team2, "Chad");

		GamePrinter.printBattleField(team1, team2);
		int choice = g.getFightOrSwitchInput();
		if (choice == 1) {
			GamePrinter.printFightOption(team1.getActivePokemon());

			g.applyTurn(Pokemon.SWITCH_ONE, 1);
		} else if (choice == 2) {
			GamePrinter.printSwitchOption(team1);
			int switchChoice = g.getSwitchChoice();
			g.applyTurn(switchChoice, 1);
		}
		GamePrinter.printBattleField(g.getOmnidexter(), g.getOpponent());
		System.out.println("Game OVER!!!");
	}
}
