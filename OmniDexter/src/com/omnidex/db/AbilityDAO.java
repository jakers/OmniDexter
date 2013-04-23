package com.omnidex.db;

import com.omnidex.pokemon.Species;

public class AbilityDAO extends DAO {

	private static String INSERT_ABILITY = "INSERT INTO pokemon_ability VALUES (?,?)";
	private static String INSERT_FORM = "INSERT INTO form VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
	public static void insertAbility(String form, String ability) {
		String insert = "INSERT INTO pokemon_ability VALUES ('"
				+ form + "', '" + ability + "')";
		insertDB(insert);
	}
	
	public static void insertForm(String s, Species form) {
		String insert = "INSERT INTO form VALUES ('"
				+ form + "', '" + s
				+ "','"
				+ form.getHpBase()
				+ "','"
				+ form.getAtkBase()
				+ "','"
				+ form.getDefBase()
				+ "','"
				+ form.getspAtkBase()
				+ "','"
				+ form.getspDefBase()
				+ "','"
				+ form.getspeBase()
				+ "','"
				+ form.getFirstType()
				+ "','"
				+ form.getSecondType()
				+ "',"
				+ null
				+ ")";
		insertDB(insert);
	}

}
