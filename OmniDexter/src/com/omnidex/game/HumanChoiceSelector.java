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
		
		while (isNotValidMainMenuOption(fightOrSwitch)) {
			fightOrSwitch = getFightOrSwitchInput();
		}
		if (fightOrSwitch == FIGHT) {
			return getFightChoice(self);
		} else {
			return getSwitchChoice(self);
		} 
	}

	private boolean isNotValidMainMenuOption(int fightOrSwitch) {
		return fightOrSwitch != FIGHT && fightOrSwitch != SWITCH;
	}

	private int getSwitchChoice(Team self) {
		GamePrinter.printSwitchOption(self);
		int switchChoice = -1;
		while (switchChoice == -1 || isNotValidSwitchOption(self,switchChoice)) {
			switchChoice = getSwitchChoice();
			
			if (isNotValidSwitchOption(self, switchChoice)) {
				System.out.println("Invalid move option try again");
				GamePrinter.printSwitchOption(self);
			}
		}
		
		return -1*switchChoice;
	}

	private boolean isNotValidSwitchOption(Team self, int switchChoice) {
		return switchChoice < 0 || switchChoice > self.getParty().size() || self.getValidSwitch()[switchChoice];
	}

	private int getFightChoice(Team self) {
		GamePrinter.printFightOption(self.getActivePokemon());
		int fightChoice = -1;
		while (isNotValidAttackOption(self, fightChoice)) {
			fightChoice = getFightChoice();
			if (isNotValidAttackOption(self, fightChoice)) {
				System.out.println("Invalid move option try again");
				GamePrinter.printFightOption(self.getActivePokemon());
			}
		}
		return fightChoice;
	}

	private boolean isNotValidAttackOption(Team self, int fightChoice) {
		return fightChoice < 0 || fightChoice > self.getActivePokemon().getMoveCount()-1;
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
		@SuppressWarnings("resource")
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

	@Override
	public int getEndTurnSwitchChoice(Team self, Team opponent, BattleField bf) {
		return getSwitchChoice(self);
	}
	
}
