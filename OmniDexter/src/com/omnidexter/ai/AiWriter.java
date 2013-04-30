package com.omnidexter.ai;

import com.omnidex.game.Game;
import com.omnidex.pokemon.Pokemon;

/**
 * @author jakers
 */
public class AiWriter {

	public static boolean isSearchMode = false;

	public static void setSearchMode(boolean mode) {
		isSearchMode = mode;
	}

	public static void writeFaint(Pokemon poke) {
		if (!isSearchMode) {
			if (poke.hasFainted()) {
				System.out.println(poke + " has fainted!");
			}
		}
	}

	public static void writeAttack(Pokemon poke, int moveChoice, boolean isMe) {
		if (!isSearchMode) {
			String statement = "%s";
			if (isMe) {
				statement = String.format(statement, "OmniDexter's");
			} else {
				statement = String.format(statement, "Opponent");
			}
			statement = statement.concat(" %s uses %s.");
			String moveName = poke.getMove(moveChoice).getMove().getName();
			statement = String.format(statement, poke, moveName);
			System.out.println(statement);
		}
	}

	public static void writeAttack(Pokemon poke, int moveChoice, int damage,
			int teamId) {
		if (!isSearchMode) {
			String statement = "%s";
			if (teamId == Game.OMNIDEXTER) {
				statement = String.format(statement, "OmniDexter's");
			} else {
				statement = String.format(statement, "Opponent");
			}
			statement = statement.concat(" %s uses %s, dealing %d damage!");
			String moveName = poke.getMove(moveChoice).getMove().getName();
			statement = String.format(statement, poke, moveName, damage);
			System.out.println(statement);
		}
	}

	public static void writeSwitch(Pokemon poke, int teamId) {
		if (!isSearchMode) {
			String statement = "%s switchs out to %s.";
			if (teamId == Game.OMNIDEXTER) {
				statement = String.format(statement, "OmniDexter", poke);
			} else {
				statement = String.format(statement, "Opponent", poke);
			}
			System.out.println(statement);
		}
	}
}
