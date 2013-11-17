package com.omnidexter.ai;

import com.omnidex.battlefield.team.Team;

/**
 * Interface that promises behavior for calculating the fitness of a battlefield
 * condition.
 * 
 * Creation Date: 3/12/2012
 * @author Akers
 */
public interface Fitness
{ 
    final double DRAW = 3.0;
    final double PLAYER_ONE_WINS = 25.0;
    final double PLAYER_TWO_WINS = -25.0;

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
    double calcFitness(Team t1, Team t2);
}
