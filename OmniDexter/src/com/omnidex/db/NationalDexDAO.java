package com.omnidex.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.omnidex.type.Type;

public class NationalDexDAO extends DAO {

	public static List<String> getAllPokemon() {
		String query = "SELECT species FROM national_dex";
		return loadPokes(queryDB(query));
	}
	
	public static List<String> getAllPokemonByType(Type type) {
		String query = "SELECT DISTINCT nd.species FROM national_dex nd "
				+ "INNER JOIN form f ON nd.species=f.species "
				+ "WHERE f.first_type='" + type
				+ "' or f.second_type='"
				+ type + "'";
		return loadPokes(queryDB(query));
	}
	
	public static List<String> getAllPokemonByType(Type first, Type second) {
		String query = "SELECT DISTINCT nd.species FROM national_dex nd "
				+ "INNER JOIN form f ON nd.species=f.species "
				+ "WHERE f.first_type='" + first
				+ "' AND f.second_type='"
				+ second + "'";
		return loadPokes(queryDB(query));
	}
	
	private static List<String> loadPokes(ResultSet rs) {
		List<String> pokes = new ArrayList<String>();

		try {
			while (rs.next()) {
				pokes.add(rs.getString("species"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return pokes;
	}
}
