package com.omnidex.game;

import java.util.ArrayList;
import java.util.List;

import com.omnidex.battlefield.team.DeepTeam;
import com.omnidex.battlefield.team.Team;
import com.omnidex.damage.MainDamageFormula;
import com.omnidex.damage.PokemonMath;
import com.omnidex.damage.StatusDamage;
import com.omnidex.damage.WeatherDamage;
import com.omnidex.item.ItemActivation;
import com.omnidex.pokemon.Pokemon;
import com.omnidexter.ai.AiWriter;
import com.omnidexter.ai.BattleAI;
import com.omnidexter.ai.Fitness;
import com.omnidexter.ai.FitnessScore;
import com.omnidexter.battlefield.BattleField;
import com.omnidexter.battlefield.SingleBattleField;

public class Game {

	public static final int OMNIDEXTER = 0;
	public static final int OPPONENT = 1;

	private Team omnidexter;
	private String opponentName;
	private Team opponent;
	private BattleField bf;
	
	public Game(BattleField bf, Team omnidexter, Team opponent, String oppentName) {
		this.bf = bf;
		this.omnidexter = omnidexter;
		omnidexter.setTeamId(OMNIDEXTER);
		this.opponent = opponent;
		opponent.setTeamId(OPPONENT);
		this.opponentName = oppentName;
	}

	public Game(Game game) {
		omnidexter = game.getOmnidexter();
		opponent = game.getOpponent();
		bf = game.getBf();
	}

	public boolean isGameOver() {
		double fitness = FitnessScore.calcFitness(omnidexter, opponent);
		return fitness == Fitness.PLAYER_ONE_WINS
				|| fitness == Fitness.PLAYER_TWO_WINS;
	}

	public void printBattleField() {
		System.out.println(opponentName);
		for (int i = 0; i < opponent.getParty().size() + 1; i++) {
			System.out.print("* ");
		}

		System.out.println("\n" + opponent.getActivePokemon() + "Lv:"+ opponent.getActivePokemon().getLevel());
		printHpBar(opponent.getActivePokemon());

		System.out.print("\t\t\t");
		for (int i = 0; i < omnidexter.getParty().size() + 1; i++) {
			System.out.print("* ");
		}
		System.out.println();
		System.out.println("\t\t\t" + omnidexter.getActivePokemon() + " Lv:"+omnidexter.getActivePokemon().getLevel());
		System.out.print("\t\t\t");
		System.out.println(omnidexter.getActivePokemon().getCurrHp() + "/"
				+ omnidexter.getActivePokemon().getMaxHp());
		printMoves(omnidexter.getActivePokemon());
		System.out.println("---------------------------");
		printSwitchOption(Game.OMNIDEXTER);
	}

	private void printHpBar(Pokemon poke) {
		double hpbar = (poke.getCurrHp() / (double) poke.getMaxHp()) * 100;
		hpbar = Math.floor(hpbar);
		System.out.println(hpbar + "%");
	}

	private void printMoves(Pokemon poke) {
		for (int i = 0; i < 4; i++) {
			System.out.println(i + ") " + poke.getMove(i).getName());
		}
	}

	public List<Integer> getAllPossibleMoves() {
		List<Integer> allPossibleMoves = new ArrayList<Integer>();
		// Populate attacking options by integer values first
		// int = team 1 second int = team 2
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				allPossibleMoves.add(i);
				allPossibleMoves.add(j);
			}
		}
		int omnidextersize = omnidexter.getParty().size();
		int opponentsize = opponent.getParty().size();

		if (omnidextersize > 0) {
			for (int i = -1; i > -omnidextersize; i--) {
				for (int j = 0; j < 4; j++) {
					allPossibleMoves.add(i);
					allPossibleMoves.add(j);
				}
			}
		}
		if (opponentsize > 0) {
			for (int i = -1; i > -opponentsize; i--) {
				for (int j = 0; j < 4; j++) {
					allPossibleMoves.add(j);
					allPossibleMoves.add(i);
				}
			}
		}
		if (omnidextersize > 0 && opponentsize > 0) {
			for (int i = -1; i > -omnidextersize; i--) {
				for (int j = -1; j > -opponentsize; j--) {
					allPossibleMoves.add(i);
					allPossibleMoves.add(j);
				}
			}
		}
		return allPossibleMoves;
	}

	public void printSwitchOption(int player) {
		List<Pokemon> party = new ArrayList<Pokemon>();
		if (player == OMNIDEXTER) {
			party = omnidexter.getParty();
		} else {
			party = opponent.getParty();
		}

		if (party.isEmpty()) {
			System.out.println("No avaliable switches");
		} else {
			for (int i = 1; i <= party.size(); i++) {
				System.out.println(-i + ")" + party.get(i - 1) + " "
						+ party.get(i - 1).getCurrHp() + "/"
						+ party.get(i - 1).getMaxHp());
			}
		}
	}

	public void applyTurn(int player1Choice, int player2Choice) {

		omnidexter.setChoice(player1Choice);
		opponent.setChoice(player2Choice);

		Team[] speedOrder = PokemonMath.getFasterPoke(omnidexter, opponent);
		Team first = speedOrder[0];
		Team second = speedOrder[1];

		if (first.getChoice() < 0) {
			first.switchActivePokemon(first.getChoice());
		}

		if (second.getChoice() < 0) {
			second.switchActivePokemon(second.getChoice());
		}

		if (first.getChoice() >= 0) {
			attack(first.getTeamId(), first.getChoice());
		}

		if (second.getChoice() >= 0 && !second.getActivePokemon().hasFainted()) {
			attack(second.getTeamId(), second.getChoice());
		}
	}

	// @Override
	public void applieAfterTurnAffects() {
		// Calcs the faster of the two Pokemon
		Team[] temp = PokemonMath.getFasterPoke(omnidexter, opponent);
		Team first = temp[0];
		Team second = temp[1];

		// NOTE: Speed isn't calc'd here because the screens dropping doesn't
		// affect competitively

		// Check if Reflect wears off
		omnidexter.decrementRelfect();
		opponent.decrementRelfect();

		// Check if Light Screen wears off
		omnidexter.decrementLightScreen();
		opponent.decrementLightScreen();

		// Check if Mist wears off
		omnidexter.decrementMist();
		opponent.decrementMist();

		// Check if Safeguard wears off
		omnidexter.decrementSafeguard();
		opponent.decrementSafeguard();

		// Check if Tailwind wears off
		omnidexter.decrementTailWind();
		opponent.decrementTailWind();

		// Check if Lucky Chant wears off
		omnidexter.decrementLuckyChant();
		opponent.decrementLuckyChant();

		// Check if Wish comes true
		omnidexter.decrementWishCount();
		opponent.decrementWishCount();

		// Check if Damaging/Healing Weather is applied
		if (!bf.isClear()) {
			WeatherDamage.applyDamagingWeather(bf, first.getActivePokemon());
			WeatherDamage.applyDamagingWeather(bf, second.getActivePokemon());

			// Check if Weather abilities activate
			WeatherDamage.applyHealingWeather(bf, first.getActivePokemon());
			WeatherDamage.applyHealingWeather(bf, second.getActivePokemon());
		}

		// Check if Gravity wears off
		bf.decrementGravity();

		// applies damage/healing from status
		StatusDamage.applyIngrainHealing(first.getActivePokemon());
		StatusDamage.applyIngrainHealing(second.getActivePokemon());

		StatusDamage.applyAquaRingHealing(first.getActivePokemon());
		StatusDamage.applyAquaRingHealing(second.getActivePokemon());

		// TODO Check for Speed Boost/Shed Skin activation

		ItemActivation.applyHealingItems(first.getActivePokemon());
		ItemActivation.applyHealingItems(second.getActivePokemon());

		StatusDamage.applyLeechSeed(second.getActivePokemon(),
				first.getActivePokemon());
		StatusDamage.applyLeechSeed(first.getActivePokemon(),
				second.getActivePokemon());

		// Check for Status Damage/Nightmare
		// Checks for fainting inside healing method.
		if (!first.getActivePokemon().hasFainted()
				&& !first.getActivePokemon().isOk()) {
			StatusDamage.applyStatusDamage(first.getActivePokemon());
			StatusDamage.applyStatusHealing(first.getActivePokemon());
		}
		if (!second.getActivePokemon().hasFainted()
				&& !second.getActivePokemon().isOk()) {
			StatusDamage.applyStatusDamage(second.getActivePokemon());
			StatusDamage.applyStatusHealing(second.getActivePokemon());
		}

		// Check for Flame/Toxic Orb activation
		if (first.getActivePokemon().isOk()) {
			ItemActivation.burnOrbActivation(first.getActivePokemon());
			ItemActivation.toxicOrbActivation(first.getActivePokemon());
		}
		if (second.getActivePokemon().isOk()) {
			ItemActivation.burnOrbActivation(second.getActivePokemon());
			ItemActivation.toxicOrbActivation(second.getActivePokemon());
		}

		StatusDamage.applyCurseDamage(first.getActivePokemon());
		StatusDamage.applyCurseDamage(second.getActivePokemon());

		// TODO Check for Bind, Clamp, Fire Spin, Magma Storm, Sand Tomb,
		// Whirlpool, Wrap
		// Check for Bad Dreams
		StatusDamage.applyBadDreams(second.getActivePokemon(),
				first.getActivePokemon());
		StatusDamage.applyBadDreams(first.getActivePokemon(),
				second.getActivePokemon());

		// TODO Check for end of outrage, petal dance, uproar, thrash
		// TODO Check for end of disable
		// TODO Check for Encore ending
		// TODO Check for Taunt

		// Check for Magnet Rise
		first.getActivePokemon().decrementMagnetRise();
		second.getActivePokemon().decrementMagnetRise();

		// TODO Check Heal Block
		// TODO Check Embargo
		// TODO Check Yawn
		// TODO Sticky Barb
		// TODO Doom Desire, Future Sight
		// TODO Perish Song

		// Trick Room
		bf.decrementTrickRoom();
		// TODO verify these happen here
		bf.decrementMagicRoom();
		bf.decrementWonderRoom();

		// handle faster team end turn switch
		if (first.getActivePokemon().hasFainted()
				&& first.getParty().size() > 0) {
			int choice;
			if (first.getTeamId() == OMNIDEXTER) {
				choice = BattleAI.getNextPoke(this, OMNIDEXTER,
						BattleAI.MAX_DEPTH);
			} else if (AiWriter.isSearchMode) {
				choice = BattleAI.getNextPoke(this, OPPONENT,
						BattleAI.MAX_DEPTH);
			} else {
				printSwitchOption(OPPONENT);
				
//				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				System.out.println("Please choice a new pokemon");
//				String string_choice;
				choice = -1;
//				try {
//					string_choice = br.readLine();
//					choice = Integer.valueOf(string_choice);
//					br.close();
//				} catch (IOException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
//					System.exit(1);
//				}
//				scan.close();
				
			}
			AiWriter.setSearchMode(true);
			first.switchActivePokemon(choice);
		}

		// handle slower team end turn switch
		if (second.getActivePokemon().hasFainted()
				&& second.getParty().size() > 0) {
			int choice;
			if (second.getTeamId() == OMNIDEXTER) {
				choice = BattleAI.getNextPoke(this, OMNIDEXTER,
						BattleAI.MAX_DEPTH);
			} else if (AiWriter.isSearchMode) {
				// auto chooses human player's pokemon
				choice = BattleAI.getNextPoke(this, OPPONENT,
						BattleAI.MAX_DEPTH);
			} else {
				// human manual switch
				printSwitchOption(OPPONENT);
//				Scanner scan = new Scanner(System.in);
				System.out.println("Please choice a new pokemon");
//				String string_choice = scan.nextLine();
//				scan.close();
				choice = -1;
			}
			second.switchActivePokemon(choice);
		}

		// TODO Slow Start
	}

	public void attack(int player, int moveSlot) {
		int damage[];

		Team attack;
		Team defend;

		if (player == OMNIDEXTER) {
			attack = omnidexter;
			defend = opponent;
		} else {
			attack = opponent;
			defend = omnidexter;
		}

		damage = MainDamageFormula.damage(attack, defend, bf,
				attack.getActivePokemon().getMove(moveSlot));

		defend.getActivePokemon().setCurrHp(defend.getActivePokemon().getCurrHp() - damage[1]);

		AiWriter.writeAttack(attack.getActivePokemon(), moveSlot, damage[1], player);
	}

	public Team getOmnidexter() {
		return new DeepTeam(omnidexter);
	}

	public void setOmnidexter(Team omnidexter) {
		this.omnidexter = omnidexter;
	}

	public Team getOpponent() {
		return new DeepTeam(opponent);
	}

	public void setOpponent(Team opponent) {
		this.opponent = opponent;
	}

	public BattleField getBf() {
		return new SingleBattleField(bf);
	}

	public void setBf(BattleField bf) {
		this.bf = bf;
	}
}
