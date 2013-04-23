package com.omnidex.db;

import com.omnidex.pokemon.DeepPokemon;
import com.omnidex.pokemon.Pokemon;

public class MovesetDAO extends DAO {

	public static Pokemon guessMoveset(String form, String tier) {
		String query = "SELECT sm.* from statistical_movesets sm INNER JOIN "
				+"form f on sm.form=f.form where tier='"+tier+"' and f.form='" 
				+form+"'";
		return new DeepPokemon(queryDB(query));
	}
	
	
	
	public static void insertStaticalMoveset(String form, String tier, String ability, String item,
			String move1, String move2, String move3, String move4, int hp, int atk, int def, int spatk, int spdef, int spe, String nature) {
		String insert = "INSERT INTO statistical_movesets VALUES(\""
				+ form
				+ "\", '" + tier
				+ "', '" + ability
				+ "', \"" + item
				+ "\", \"" + move1
				+ "\", \""+ move2
				+ "\", \""+ move3
				+ "\", \""+ move4
				+ "\", '" + hp
				+ "', '" + atk
				+ "', '" + def
				+ "', '" + spatk
				+ "', '" + spdef
				+ "', '" + spe 
				+ "', '" + nature
				+ "')";
		insertDB(insert);
	}

}
