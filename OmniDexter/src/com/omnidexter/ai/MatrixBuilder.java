package com.omnidexter.ai;

import java.util.List;

import com.omnidex.game.Game;
import com.omnidex.move.MoveWithPP;

public class MatrixBuilder {
	public static Outcome[][] buildMatrix(Game game) {

		List<MoveWithPP> t1Choices = game.getOmnidexter().getAllChoices();
		List<MoveWithPP> t2Choices = game.getOpponent().getAllChoices();

		Outcome[][] outcomeMatrix = new Outcome[t1Choices.size()][t2Choices
				.size()];

		for (int i = 0; i < t1Choices.size(); i++) {
			for (int j = 0; j < t2Choices.size(); j++) {
				Game temp = new Game(game);
				temp.applyTurn(t1Choices.get(i), t2Choices.get(j));
				double t1Fit = FitnessScore.calcFitness(temp.getOmnidexter(),
						temp.getOpponent());
				double t2Fit = FitnessScore.calcFitness(temp.getOpponent(),
						temp.getOmnidexter());

				outcomeMatrix[i][j] = new Outcome(t1Fit, t2Fit, t1Choices.get(i), t2Choices.get(j));
			}
		}

		return outcomeMatrix;
	}
}
