package com.omnidex.move;

import com.omnidex.pokemon.ActivePokemon;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.type.Type;

public class MoveWithPP {
	
	private int disabledCount;
	private Move move;
	private int currPP;
	
	public MoveWithPP(Move move) {
		this.move = move;
		currPP = move.getPP();
		disabledCount = 0;
	}
	
	@Override
	public String toString() {
		return move.getName();
	}
	
	public Move getMove() {
		return move;
	}
	
	public int getCurrPP() {
		return currPP;
	}
	
	public boolean isMoveUsable(){
		return currPP > 0 && !isDisabled();
	}
	
	public boolean isDisabled() {
		return disabledCount > 0;
	}
	
	public void activateDisabled() {
		disabledCount = 3;
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
	
	public int getBasePower(ActivePokemon attacker, ActivePokemon target) {
		return move.getBasePower(attacker, target);
	}
	
	public boolean isType(Type type) {
		return move.isType(type);
	}
	
	public boolean isPhysical() {
		return move.isPhysical();
	}
	
	public boolean isSpecial() {
		return move.isSpecial();
	}
	
	public boolean hasRecoil() {
		return move.hasRecoil();
	}
	
	public boolean isPunch() {
		return move.isPunch();
	}
	
	public Type getType() {
		return move.getType();
	}
	
	public String getName() {
		return move.getName();
	}
	
	public boolean isSwitch() {
		return move.isSwitch();
	}
	
	public boolean isAttack() {
		return !move.isSwitch();
	}
	
	public int getPriority() {
		return move.getPriority();
	}
}
