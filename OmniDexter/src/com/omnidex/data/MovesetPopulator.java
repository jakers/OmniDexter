package com.omnidex.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.omnidex.db.MovesetDAO;

/**
 * This class loads in monthly usage stats from textfiles
 * and populates the usage data into the Omnidex
 * @author jakers
 *
 */
public class MovesetPopulator {
	public static void load(String file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));

		String tier = br.readLine();
		System.out.println("Loading "+tier+" usage stats...");
		while (br.readLine() != null) {
			String poke = loadPokemon(br);
			String ability = loadAbility(br);
			String item = loadItem(br);

			String nature = "";
			Integer[] evs = new Integer[6];
			Map<String, Integer[]> map = getSpread(br);
			for (Map.Entry<String, Integer[]> entry : map.entrySet()) {
				nature = entry.getKey();
				evs = entry.getValue();
			}

			List<String> moveset = loadMoveset(br);

			skipTeammates(br);
			skipTeammates(br);

			for (int i = moveset.size(); i < 4; i++) {
				moveset.add("Nothing");
			}

			MovesetDAO.insertStaticalMoveset(poke, tier, ability, item,
					moveset.get(0), moveset.get(1), moveset.get(2),
					moveset.get(3), evs[0], evs[1], evs[2], evs[3], evs[4],
					evs[5], nature);
		}
		br.close();
		System.out.println(tier +" stats loaded successfully!");
	}

	private static void skipTeammates(BufferedReader br) throws IOException {
		String line = br.readLine();

		while (!line.contains("+-")) {
			line = br.readLine();
		}
	}

	public static List<String> loadMoveset(BufferedReader br)
			throws IOException {
		List<String> moveset = new ArrayList<String>();
		br.readLine();
		String line = br.readLine();
		int i = 0;
		while (!line.contains("+") && i < 4) {
			StringTokenizer token = new StringTokenizer(line);
			token.nextToken();
			String move = token.nextToken();
			String optionalMove = token.nextToken();
			
			while (!optionalMove.contains(".")) {
				move = move + " " + optionalMove;
				optionalMove = token.nextToken();
			}
			moveset.add(move);
			i++;

			line = br.readLine();
		}

//		while (!line.contains("+")) {
//			line = br.readLine();
//		}
		skipToNextHeader(br);

		return moveset;
	}

	public static Map<String, Integer[]> getSpread(BufferedReader br)
			throws IOException {
		Map<String, Integer[]> map = new HashMap<String, Integer[]>();

		br.readLine();
		String line = br.readLine();
		StringTokenizer token = new StringTokenizer(line);
		token.nextToken();
		String spread = token.nextToken();

		String nature = spread.substring(0, spread.indexOf(':'));
		String ints = spread.substring(spread.indexOf(':') + 1);
		token = new StringTokenizer(ints, "/");
		Integer[] ivs = new Integer[6];
		ivs[0] = Integer.parseInt(token.nextToken());
		ivs[1] = Integer.parseInt(token.nextToken());
		ivs[2] = Integer.parseInt(token.nextToken());
		ivs[3] = Integer.parseInt(token.nextToken());
		ivs[4] = Integer.parseInt(token.nextToken());
		ivs[5] = Integer.parseInt(token.nextToken());

		skipToNextHeader(br);
		
		map.put(nature, ivs);
		return map;
	}

	public static String loadItem(BufferedReader br) throws IOException {
		br.readLine();
		String line = br.readLine();
		StringTokenizer token = new StringTokenizer(line);
		token.nextToken();
		String item = token.nextToken();
		String optionAbility = token.nextToken();
		if (!optionAbility.contains(".")) {
			item = item + " " + optionAbility;
		}

		skipToNextHeader(br);

		/* handles king's rock exception */
		if (item.equals("King\'s Rock")){
			item = "King\'s Rock";
		}
		
		return item;
	}

	public static String loadPokemon(BufferedReader br) throws IOException {
		String species = br.readLine();
		StringTokenizer token = new StringTokenizer(species);
		token.nextToken();
		String poke = token.nextToken();
		String optionalPoke = token.nextToken();
		while (!optionalPoke.contains("|")) {
			poke = poke + " "+ optionalPoke;
			optionalPoke = token.nextToken();
		}
		
		return poke;
	}

	public static String loadAbility(BufferedReader br) throws IOException {
		br.readLine();
		br.readLine();
		br.readLine();
		br.readLine();
		br.readLine();

		String line = br.readLine();
		StringTokenizer token = new StringTokenizer(line);
		token.nextToken();
		String ability = token.nextToken();
		String optionAbility = token.nextToken();
		if (!optionAbility.contains(".")) {
			ability = ability + " " + optionAbility;
		}

//		line = br.readLine();
//
//		while (!line.contains("+")) {
//			line = br.readLine();
//		}

		skipToNextHeader(br);
		
		return ability;
	}

	private static void skipToNextHeader(BufferedReader br) {
		String line;
		try {
			line = br.readLine();
			while (!line.contains("+")) {
				line = br.readLine();
			}
		} catch (IOException e) {
			System.err.println("Failed to skip to next header");
			e.printStackTrace();
		}
	}
	
	
}
