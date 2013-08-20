package com.omnidexter.main;

import com.omnidex.db.DAO;
import com.omnidex.move.Move;
import com.omnidex.move.MoveWithPP;
import com.omnidex.pokemon.DeepPokemon;

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

		// Integer i = 50;;
		// Integer j = 60;
		// Integer k = 70;
		//
		// DAO.setValues(i,j,k);

		MoveWithPP m1 = new MoveWithPP(Move.TRUMP_CARD);
		Move m2 = Move.TRUMP_CARD;

		System.out.println(m1.getPP());
		System.out.println(m2.getPP());
		System.out.println("=================");
		m1.decrementPP(new DeepPokemon());
		System.out.println(m1.getPP());
		System.out.println(m2.getPP());
		// TODO fix pp alias problem

		// rc.sendChallengeRequestTo("01110", BattleRC.UU_CHALLENGE);

		// Pokemon switching = new DeepPokemon();
		// switching.setAbility(Ability.ADAPTABILITY);
		//
		// boolean blocked = Ability.SHADOW_TAG.preventsSwitching(switching);
		// System.out.println(blocked);

		// for (Move move : Move.values()) {
		// MoveDAO.updateMove(Move.ABSORB);
		// // }

		someStuff(new Object(), new Object(), new Integer[] { 30, 50 });
	}

	public static void someStuff(Object x, Object y, Integer... values) {
		something:
			
			for (int n = 0; n < 10; n++) {
			System.out.println(n);

			if (n % 2 == 0) {
				continue something;
			}
			System.out.println(":D");
		}

	}

}
