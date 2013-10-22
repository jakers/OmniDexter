package com.omnidexter.ai;

import com.omnidex.battlefield.team.Team;
import com.omnidex.pokemon.Pokemon;

public class FitnessScore {
	
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
		double team1Score = calcTeamScore(t1);
		double team2Score = calcTeamScore(t2);
		
		double fitness = team1Score - team2Score;
		
		if (team1Score == 0.0 && team2Score == 0.0) {
			fitness = Fitness.DRAW;
		} else if (team1Score == 0.0) {
			fitness = Fitness.PLAYER_ONE_WINS;
		} else if (team2Score == 0.0) {
			fitness = Fitness.PLAYER_TWO_WINS;
		} else {
			fitness = team1Score - team2Score;
		}
		return fitness;
	}
	
	private static double calcTeamScore(Team team) {
		double teamScore = 0.0;
		for (Pokemon poke : team.getParty()) {
			double temp = poke.getCurrHp()
					/ (double) poke.getMaxHp();
			teamScore += temp;
		}
		
		teamScore /= team.teamSize();
		return teamScore;
	}
	
}
