package com.omnidexter.ai;

import com.omnidex.move.MoveWithPP;

public class Outcome {
	private double playerOnePayoff;
	private double playerTwoPayoff;
	
	private MoveWithPP playerOneMove;
	private MoveWithPP playerTwoMove;
	
	public Outcome(double playerOnePayoff, double playerTwoPlayoff,MoveWithPP playerOneMove, MoveWithPP playerTwoMove) {
		this.playerOnePayoff = playerOnePayoff;
		this.playerTwoPayoff = playerTwoPlayoff;
		this.playerOneMove = playerOneMove;
		this.playerTwoMove = playerTwoMove;
	}
	
	public double getPlayerOnePayOff() {
		return playerOnePayoff;
	}
	
	public double getPlayerTwoPayOff() {
		return playerTwoPayoff;
	}
	
	public MoveWithPP getPlayerOneMove() {
		return playerOneMove;
	}
	
	public MoveWithPP getPlayerTwoMove() {
		return playerTwoMove;
	}
	
    public String toString() {
    	return "["+playerOnePayoff+","+playerTwoPayoff+"]";
    }
}
