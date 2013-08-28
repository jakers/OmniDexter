package com.omnidexter.ai;

import java.util.List;

import com.omnidex.battlefield.team.Team;
import com.omnidex.pokemon.Pokemon;

public class FitnessScore {
	
	private final static double DRAW = 3.0;
	private final static double PLAYER_ONE_WINS = 1.0;
	private final static double PLAYER_TWO_WINS = -1.0;
	
	/**
	 * @param t1 a DeepTeam object that represents team 1
	 * @param t2 a DeepTeam object that represents team 2
	 * @return a double representing the fitness of a situation.
	 * the closer the value returned is to 1.0 the more fit the situation is
	 * for player 1. the closer to -1.0 the more fit the situation is for
	 * player 2
	 * if 1.0 is returned that means player 1 wins. If -1.0 is returned then
	 * player 2
	 * wins
	 * if match is a draw (both players all Pokemon's hp = zero) then returns
	 * 3.0
	 * 
	 * (%Hp of team 1/t1 size) - (%Hp of team2)/(t2 size)
	 */
	public static double calcFitness(Team t1, Team t2) {
		double result = 0.0;
		double team1Score = 0.0;
//		team1Score = t1.getActivePokemon().getCurrHp()
//				/ (double) t1.getActivePokemon().getMaxHp();

		List<Pokemon> team1Party = t1.getParty();
		for (int i = 0; i < team1Party.size(); i++) {
			double temp = team1Party.get(i).getCurrHp()
					/ (double) team1Party.get(i).getMaxHp();
			team1Score += temp;
		}
		team1Score /= t1.teamSize();
		double team2Score = 0.0;
		team2Score = t2.getActivePokemon().getCurrHp()
				/ (double) t2.getActivePokemon().getMaxHp();

		List<Pokemon> team2Party = t2.getParty();
		for (int i = 0; i < team2Party.size(); i++) {
			double temp = team2Party.get(i).getCurrHp()
					/ (double) team2Party.get(i).getMaxHp();
			team2Score += temp;
		}
		team2Score /= t2.teamSize();
		if (team1Score == 0.0 && team2Score == 0.0) {
			result = DRAW;
		} else if (team1Score == 0.0) {
			result = PLAYER_ONE_WINS;
		} else if (team2Score == 0.0) {
			result = PLAYER_TWO_WINS;
		} else {
			result = team1Score - team2Score;
		}
		return result;
	}
	
	public double calcTeamScore(Team team) {
		double teamScore = 0.0;
		List<Pokemon> party = team.getParty();
		for (int i = 0; i < party.size(); i++) {
			double temp = party.get(i).getCurrHp()
					/ (double) party.get(i).getMaxHp();
			teamScore += temp;
		}
		teamScore /= team.teamSize();
		return teamScore;
	}
	
}
