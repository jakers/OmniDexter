package com.omnidex.move;

import com.omnidex.pokemon.Pokemon;

public class MoveWithPP {
	
	private boolean isDisabled;
	private int disabledCount;
	private Move move;
	private int currPP;
	
	public MoveWithPP(Move move) {
		this.move = move;
		currPP = move.getPP();
		isDisabled = false;
		disabledCount = 0;
	}
	
	public Move getMove() {
		return move;
	}
	
	public int getCurrPP() {
		return currPP;
	}
	
	public boolean isMoveUsable(){
		return currPP > 0 && !isDisabled;
	}
	
	public boolean isDisabled() {
		return isDisabled;
	}
	
	public void setDisabled(boolean state) {
		isDisabled = state;
		if (isDisabled) {
			disabledCount = 3;
		}
	}
	
	public void decrementPP(Pokemon target) {
		switch(target.getAbility()) {
			case PRESSURE:
				currPP -= 2;
				break;
			default:
				currPP--;
		}
	}
	
	public void decrementPP() {
		currPP--;
	}
}
