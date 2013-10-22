package com.omnidex.game;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.omnidex.battlefield.team.Team;
import com.omnidexter.battlefield.BattleField;

public class HumanChoiceSelector extends ChoiceSelector {
	
	private static int FIGHT = 1;
	private static int SWITCH = 2;

	@Override
	public int getTurnChoice(Team self, Team opponent, BattleField bf) {
		GamePrinter.printBattleField(self, opponent);
		int fightOrSwitch = getFightOrSwitchInput();
		
		while (fightOrSwitch != FIGHT && fightOrSwitch != SWITCH) {
			fightOrSwitch = getFightOrSwitchInput();
		}
		if (fightOrSwitch == FIGHT) {
			return getFightChoice(self);
		} else if (fightOrSwitch == SWITCH) {
			return getSwitchChoice(self);
		} 
		
		return 0;
	}

	private int getSwitchChoice(Team self) {
		GamePrinter.printSwitchOption(self);
		return getSwitchChoice();
	}

	private int getFightChoice(Team self) {
		GamePrinter.printFightOption(self.getActivePokemon());
		int fightChoice = -1;
		while (fightChoice < 0 || fightChoice > self.getActivePokemon().getMoveCount()-1) {
			fightChoice = getFightChoice();
			if (fightChoice < 0 || fightChoice > self.getActivePokemon().getMoveCount()-1) {
				System.out.println("Invalid move option try again");
				GamePrinter.printFightOption(self.getActivePokemon());
			}
		}
		return fightChoice;
	}

	private int getFightOrSwitchInput() {
		return getIntChoice();
	}

	
	private int getFightChoice() {
		return getIntChoice();
	}

	private int getSwitchChoice() {
		return getIntChoice();
	}

	private int getIntChoice() {
		Scanner scan = new Scanner(System.in);
		int choice = -50;
		try {
			choice = scan.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("Invalid Choice try again:");
			return getIntChoice();
		}
		return choice;
	}
	
}
