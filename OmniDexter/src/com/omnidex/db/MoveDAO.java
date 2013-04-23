package com.omnidex.db;

import com.omnidex.move.Move;

public class MoveDAO extends DAO {

	private static String INSERT_MOVE = "INSERT INTO move VALUES(?,?,?,?,?,?,?,?)";
	private static String UPDATE_MOVE = "UPDATE move SET type=?, base_power=?,move_category=?,priority=?,pp=?,target=?,accuracy=? WHERE move=?";
	
	public static void insertMove(Move move) {
		System.out.println(move);
		
		String insert = "INSERT INTO move VALUES ('"
				+ move
				+"', '" + move.getType() 
				+ "', '" + move.getBasePower()
				+ "', '"  + move.getCategory() + "')";
		insertDB(insert);
	}

	public static void updateMove(Move move) {
		String update = "UPDATE move SET type='"+move.getType()
				+"', base_power='"+move.getBasePower()+"', move_category='"+move.getCategory()
				+"', priority='"+move.getPriority()+"', pp='" + move.getPP()+"', target='"+move.getTarget()+
				"' WHERE move='"+move.getName()+"'";
		updateDB(update);
	}
}
