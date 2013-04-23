package com.omnidexter.ai;

import java.util.List;


import com.omnidex.battlefield.team.Team;
import com.omnidex.game.Game;

/**
 * @author jakers
 */
public class BattleAI {

	public static int MAX_DEPTH = 1;
	
    public static int getNextPoke(Game game, int player, int depth) {
    	AiWriter.setSearchMode(true);
        double maxFitness = -3.0;
        double alpha = -5.0;
        double beta = 5.0;
        int maxPoke = 0;
        
        Team team;
        
        if (player == Game.OMNIDEXTER) {
        	team = game.getOmnidexter();
        } else {
        	team = game.getOpponent();
        }
        
        for (int i = 0; i < team.getParty().size(); i++) {
            Game temp = new Game(game);

            team.switchActivePokemon(i);
            
            double tmpFitness = minUtility(temp, depth - 1, alpha, beta);
            if (tmpFitness > maxFitness) {
                maxFitness = tmpFitness;
                maxPoke = i;
            }
        }
        return maxPoke;
    }

    public static int getBestMove(Game game, int depth) {
        int bestMove = -2; // this value is still being tested
        double maxFitness = -3.0; // made -3 to avoid possible issues with state valuation
//        Double alpha = -5.0; // made small to avoid possible issues with maximizing
//        Double beta = 5.0; // made big to avoid possible issues with minimizing

        // get all possible move combos
        // foreach possible move make it then check utility of it
        List<Integer> allMoves = game.getAllPossibleMoves();
        for (int i = 0; i < allMoves.size(); i += 2) {
            Game temp = new Game(game);

            temp.applyTurn(allMoves.get(i), allMoves.get(i + 1));
            temp.applieAfterTurnAffects();
//            double tempMax = minUtility(temp, depth - 1, alpha, beta);
//            double tempMax
            
          
            
            double fitness = FitnessScore.calcFitness(temp.getOmnidexter(), temp.getOpponent());            
            
            if (fitness > maxFitness) { // right directions?
                maxFitness = fitness;
                bestMove = allMoves.get(i);
            }
        }
//        System.out.println("maxFitness = " + maxFitness);
//        System.out.println("best move = "+bestMove);
        return bestMove;
    }

    private static double minUtility(Game game, int depth, Double alpha, Double beta) {
        double min = 2.5;
        double fitness = FitnessScore.calcFitness(game.getOmnidexter(),
                game.getOpponent());
        if (fitness == Fitness.PLAYER_TWO_WINS) {
            min = Fitness.PLAYER_TWO_WINS;
        } else if (fitness == Fitness.DRAW) {
            min = 0;
        } else if (depth > 0) {
            List<Integer> allMoves = game.getAllPossibleMoves();
            for (int i = 0; i < allMoves.size() / 2; i += 2) {
                Game temp = new Game(game);
                temp.applyTurn(allMoves.get(i), allMoves.get(i + 1));
                temp.applieAfterTurnAffects();
                double tmpFitness = maxUtility(temp, depth - 1, alpha, beta);
                
                System.out.println("maxxx = ");
                
                if (tmpFitness < min) { // directions
                	System.out.println("minimizing max from"+ min+ "to "+tmpFitness);
                    min = tmpFitness;
                }
                if (tmpFitness >= alpha) {
                    return tmpFitness;
                }
                if (tmpFitness > beta) {
                    beta = tmpFitness;
                }
            }
        } else {
            min = fitness;
        }
        return min;
    }

    public static double maxUtility(Game game, int depth, Double alpha, Double beta) {
        double max = -2.5;

        double fitness = FitnessScore.calcFitness(game.getOmnidexter(), game.getOpponent());

        if (fitness == Fitness.PLAYER_ONE_WINS) {
            max = Fitness.PLAYER_ONE_WINS;
        } else if (fitness == Fitness.DRAW) {
            max = 0;
        } else if (depth > 0) {
            List<Integer> allMoves = game.getAllPossibleMoves();
            for (int i = 0; i < allMoves.size() / 2; i += 2) {
                Game tmpBf = new Game(game);
                tmpBf.applyTurn(allMoves.get(i), allMoves.get(i + 1));
                tmpBf.applieAfterTurnAffects();
                double tmpFitness = maxUtility(tmpBf, depth - 1, alpha, beta);
                if (tmpFitness > max) { // directions
                    max = tmpFitness;
                }
                if (tmpFitness > alpha) {
                    alpha = tmpFitness;
                }
                if (tmpFitness >= beta) {
                    return beta;
                }
            }
        } else {
            max = fitness;
        }

        return max;
    }
}
