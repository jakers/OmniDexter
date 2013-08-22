package com.omnidexter.main;

import com.omnidex.move.Move;
import com.omnidex.move.MoveWithPP;
import com.omnidex.pokemon.InactivePokemon;

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

		// System.out.println(m1.getPP());
		System.out.println(m2.getPP());
		System.out.println("=================");
		m1.decrementPP(new InactivePokemon());
		// System.out.println(m1.getPP());
		System.out.println(m2.getPP());

		// rc.sendChallengeRequestTo("01110", BattleRC.UU_CHALLENGE);

	}
}
