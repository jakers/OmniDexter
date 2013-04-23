package com.omnidexter.main;

import com.omnidex.db.DAO;


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
		
		Integer i = 50;;
		Integer j = 60;
		Integer k = 70;
		
		DAO.setValues(i,j,k);
		
//		 rc.sendChallengeRequestTo("01110", BattleRC.UU_CHALLENGE);
		
//		Pokemon switching = new DeepPokemon();
//		switching.setAbility(Ability.ADAPTABILITY);
//		
//		boolean blocked = Ability.SHADOW_TAG.preventsSwitching(switching);
//		System.out.println(blocked);
		
//		for (Move move : Move.values()) {
//			MoveDAO.updateMove(Move.ABSORB);
////		}
	}
}
