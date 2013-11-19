package com.omnidexter.ai;

public class MatrixUtils {
	public static Outcome[][] removeColumn(int column, Outcome[][] outcome) {
		Outcome[][] temp = new Outcome[outcome.length][outcome[0].length - 1];
		if (outcome != null) {
			for (int i = 0; i < outcome.length; i++) {
				int k = 0;
				for (int j = 0; j < outcome[i].length; j++) {
					if (j == column) {

					} else {
						temp[i][k] = outcome[i][j];
						k++;
					}
				}
			}
		}
		return temp;
	}

	public static Outcome[][] removeRow(int row, Outcome[][] outcome) {
		Outcome[][] temp = new Outcome[outcome.length - 1][outcome[0].length];
		if (outcome != null) {
			int k = 0;
			for (int i = 0; i < outcome.length; i++) {
				for (int j = 0; j < outcome[i].length; j++) {
					if (i == row) {}
					else {
						temp[k][j] = outcome[i][j];
					}
				}
				if (i != row) {
					k++;
				}
				
			}

		}
		return temp;
	}

}
