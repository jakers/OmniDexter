package com.omnidexter.main;

import com.omnidex.battlefield.team.DeepTeam;
import com.omnidex.battlefield.team.Team;
import com.omnidex.game.ChoiceSelector;
import com.omnidex.game.Game;
import com.omnidex.game.GamePrinter;
import com.omnidex.game.HumanChoiceSelector;
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

	private static final int SWITCH = 2;
	private static final int FIGHT = 1;

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

		BattleField bf = new SingleBattleField();
		Team team1 = TestTeamBuilder.getTestTeamOne();
		Team team2 = TestTeamBuilder.getTestTeamTwo();
		
		ChoiceSelector player1 = new HumanChoiceSelector();
		ChoiceSelector player2 = new HumanChoiceSelector();
		Game g = new Game(bf, team1, team2, "Chad", player1, player2);

		while (!g.isGameOver()) {
			int choice = player1.getTurnChoice(team1, team2, bf);
			
			g.applyTurn(choice, 1);
			g.applieAfterTurnAffects();
		}
	}
}
