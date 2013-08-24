package com.omnidex.game;

import java.util.ArrayList;
import java.util.List;

import com.omnidex.battlefield.team.Team;
import com.omnidex.pokemon.Pokemon;

public class GamePrinter {
	public static void printBattleField(Team omnidexter, Team opponent) {
		printOpponentSide(opponent);
		printSpacingBetweenTeams(3);
		printOmniDexterSide(omnidexter);
		printOptions();
	}

	private static void printOptions() {
		System.out.println("---------------------------------");
		System.out.println("[1] Fight \t[2]Switch");
	}

	private static void printSpacingBetweenTeams(int spacing) {
		for (int i = 0; i < spacing; i++) {
			System.out.println();
		}
	}
	
	private static void printOmniDexterSide(Team team) {
		printTeamPokeballs(team);
		System.out.println();
		printPokemon(team);
		printHpBar(team.getActivePokemon());
	}

	private static void printOpponentSide(Team team) {
		System.out.print("\t\t\t");
		printTeamPokeballs(team);
		System.out.print("\n\t\t\t");
		printPokemon(team);
		System.out.print("\t\t\t");
		printHpBar(team.getActivePokemon());
	}
	
	
	private static void printPokemon(Team team) {
		System.out.println(team.getActivePokemon().getSpecies() + " Lv:"
				+ team.getActivePokemon().getLevel());
	}

	private static void printTeamPokeballs(Team team) {
		for (int i = 0; i < team.getParty().size() + 1; i++) {
			System.out.print("* ");
		}
	}

	private static void printHpBar(Pokemon poke) {
		double hpbar = (poke.getCurrHp() / (double) poke.getMaxHp()) * 100;
		hpbar = Math.floor(hpbar);
		System.out.println(hpbar + "%");
	}

	public static void printFightOption(Pokemon poke) {
		for (int i = 0; i < 4; i++) {
			System.out.println(i + ") " + poke.getMove(i).getMove().getName());
		}
	}
	
	public static void printSwitchOption(Team team) {
		List<Pokemon> party = team.getParty();

		if (party.isEmpty()) {
			System.out.println("No avaliable switches");
		} else {
			for (int i = 1; i <= party.size(); i++) {
				System.out.println(-i + ") " + party.get(i - 1).getSpecies() + " "
						+ party.get(i - 1).getCurrHp() + "/"
						+ party.get(i - 1).getMaxHp());
			}
		}
	}
	
	
}
