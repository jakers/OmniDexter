package com.omnidex.db;

public class ItemDAO extends DAO {

	private static String INSERT_ITEM = "INSERT INTO item VALUES(?)";
	
	public static void insertItem(String item) {
		String insert = "INSERT INTO item VALUES('"
			+ item +"')";
		insertDB(insert);
	}

}
