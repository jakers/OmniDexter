package com.omnidex.db;

import com.omnidex.pokemon.Nature;


public class NatureDAO extends DAO {
	
	public static String INSERT_NATURE = "INSERT INTO nature VALUES(?,?,?,?,?,?)";
	public static String DELETE_NATURE = "DELETE FROM nature WHERE nature=?";
	public static String UPDATE_NATURE = "UPDATE nature SET atk=?, def=?, spatk=?, spdef=?, spe=? WHERE nature=?";
	
	
	public static void insertNature(Nature n) {
		String insert = "INSERT INTO nature VALUES ('"
				+ n.toString()
				+ "','"
				+ n.getAtkMod()
				+ "', '"
				+ n.getDefMod()
				+ "', '"
				+ n.getSpAtkMod()
				+ "', '"
				+ n.getSpDefMod()
				+ "', '"
				+ n.getSpeMod() 
				+ "')";
		insertDB(insert);
	}
	
	public static void deleteNature(Nature n) {
		String delete = "DELETE FROM nature WHERE nature='"+n+"'";
		deleteRecord(delete);
	}
	
	public static void updateNature(Nature n, double atk, double def, double spatk, double spdef, double spe) {
		String update = "UPDATE nature SET atk='"+atk
				+"', def='"+ def
				+"', spatk='"+spatk
				+"', spdef='"+spdef
				+"',spe='"+spe
				+"' WHERE nature = '"+n.toString()+"'";
		updateDB(update);
	}
	
}
