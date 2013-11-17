package com.omnidexter.ai;

import java.util.ArrayList;
import java.util.List;

import com.omnidex.game.Game;
import com.omnidex.move.Move;
import com.omnidex.move.MoveWithPP;

public class MatrixBattleAi {
	public MoveWithPP getBestMove(Game game) {

		Outcome[][] outcomes = MatrixBuilder.buildMatrix(game);

		// getBestResponse(outcomes);

		return new MoveWithPP(Move.NONE);
	}

	public static Outcome[][] eleminateDominatedStrategies(Outcome[][] outcome) {

		for (int i = 0; i < outcome.length; i++) {
			for (int j = 0; j < outcome[0].length; j++) {
				outcome = rowBasedElimination(outcome, j, i);
				printOutcomes(outcome);
			}
		}

		for (int i = 0; i < outcome.length; i++) {
			for (int j = 0; j < outcome[0].length; j++) {
				outcome = columnBasedElimination(outcome, i, j);
			}
		}

		// this code performs cleanup incase it missed any columns the first time
		if (outcome.length > outcome[0].length) {
			for (int i = 0; i < outcome.length; i++) {
				for (int j = 0; j < outcome[0].length; j++) {
					outcome = rowBasedElimination(outcome, j, i);
				}
			}

		} else if (outcome.length < outcome[0].length) {
			for (int i = 0; i < outcome.length; i++) {
				for (int j = 0; j < outcome[0].length; j++) {
					outcome = columnBasedElimination(outcome, i, j);
				}
			}
		}

		return outcome;
	}

	private static Outcome[][] rowBasedElimination(Outcome[][] outcome,
			int startRow, int currentRow) {

		if (startRow != currentRow && startRow >= 0
				&& startRow < outcome.length && currentRow >= 0
				&& currentRow < outcome.length) {

			List<Double> baseRow = getRow(startRow, outcome, 0);

			int baseLesserCount = 0;
			int compLesserCount = 0;
			int sameCount = 0;
			List<Double> compareRow = getRow(currentRow, outcome, 0);

			for (int j = 0; j < baseRow.size(); j++) {
				if (baseRow.get(j) > compareRow.get(j)) {
					compLesserCount++;
				} else if (baseRow.get(j) < compareRow.get(j)) {
					baseLesserCount++;
				} else {
					sameCount++;
				}
			}
			if (compLesserCount == compareRow.size()) {
				outcome = MatrixUtils.removeRow(currentRow, outcome);
			} else if (baseLesserCount == baseRow.size()) {
				outcome = MatrixUtils.removeRow(startRow, outcome);
			} else if (sameCount == compareRow.size()) {
				outcome = MatrixUtils.removeRow(startRow, outcome);
			}
		}
		return outcome;
	}

	public static Outcome[][] columnBasedElimination(Outcome[][] outcome,
			int startColumn, int currentColumn) {

		if (startColumn != currentColumn && startColumn >= 0
				&& startColumn < outcome[0].length && currentColumn >= 0
				&& currentColumn < outcome[0].length) {
			List<Double> baseRow = getColumn(startColumn, outcome, 1);

			int baseLesserCount = 0;
			int compLesserCount = 0;
			int sameCount = 0;
			List<Double> compareColumn = getColumn(currentColumn, outcome, 1);

			for (int j = 0; j < baseRow.size(); j++) {
				if (baseRow.get(j) > compareColumn.get(j)) {
					compLesserCount++;
				} else if (baseRow.get(j) < compareColumn.get(j)) {
					baseLesserCount++;
				} else {
					sameCount++;
				}
			}
			if (compLesserCount == compareColumn.size()) {
				outcome = MatrixUtils.removeColumn(currentColumn, outcome);
			} else if (baseLesserCount == compareColumn.size()) {
				outcome = MatrixUtils.removeColumn(startColumn, outcome);
			} else if (sameCount == compareColumn.size()) {
				outcome = MatrixUtils.removeColumn(startColumn, outcome);
			}
		}
		return outcome;
	}

	private static List<Double> getRow(int index, Outcome[][] outcome,
			int player) {
		List<Double> row = new ArrayList<Double>();
		for (int i = 0; i < outcome[index].length; i++) {
			if (player == 0) {
				row.add(outcome[index][i].getPlayerOnePayOff());
			} else {
				row.add(outcome[index][i].getPlayerTwoPayOff());
			}
		}
		return row;
	}

	public static List<Double> getColumn(int index, Outcome[][] outcome,
			int player) {
		List<Double> column = new ArrayList<Double>();
		for (int i = 0; i < outcome.length; i++) {
			if (player == 0) {
				column.add(outcome[i][index].getPlayerOnePayOff());
			} else {
				column.add(outcome[i][index].getPlayerTwoPayOff());
			}
		}
		return column;
	}

public static void printOutcomes(Outcome[][] out) {
		
		for (int i = 0; i < out.length; i++) {
			for (int j = 0; j < out[0].length;j++) {
				System.out.print("["+out[i][j].getPlayerOnePayOff() +", "+ out[i][j].getPlayerTwoPayOff()+"]");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
	}
	
	
}
