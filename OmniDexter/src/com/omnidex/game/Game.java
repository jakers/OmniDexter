package com.omnidex.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.omnidex.ability.AbilityActivation;
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

	public Game(BattleField bf, Team omnidexter, Team opponent,
			String oppentName) {
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

	public int getFightOrSwitchInput() {
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		scan.close();
		return choice;
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

	public void applyTurn(int player1Choice, int player2Choice) {

		omnidexter.setChoice(player1Choice);
		opponent.setChoice(player2Choice);

		Team[] speedOrder = PokemonMath.getFasterPoke(omnidexter, opponent);
		Team first = speedOrder[0];
		Team second = speedOrder[1];

		if (first.getChoice() < 0) {
			first.switchActivePokemon(first.getActivePokemon().getMove(
					first.getChoice()));
		}

		if (second.getChoice() < 0) {
			second.switchActivePokemon(second.getActivePokemon().getMove(
					second.getChoice()));
		}

		if (first.getChoice() >= 0) {
			attack(first.getTeamId(), first.getChoice());
		}

		if (second.getChoice() >= 0 && !second.getActivePokemon().hasFainted()) {
			attack(second.getTeamId(), second.getChoice());
		}
	}

	public void applieAfterTurnAffects() {
		Team[] temp = PokemonMath.getFasterPoke(omnidexter, opponent);
		Team fasterTeam = temp[0];
		Team slowerTeam = temp[1];

		omnidexter.decrementRelfect();
		opponent.decrementRelfect();

		omnidexter.decrementLightScreen();
		opponent.decrementLightScreen();

		omnidexter.decrementMist();
		opponent.decrementMist();

		omnidexter.decrementSafeguard();
		opponent.decrementSafeguard();

		omnidexter.decrementTailWind();
		opponent.decrementTailWind();

		omnidexter.decrementLuckyChant();
		opponent.decrementLuckyChant();

		omnidexter.decrementWishCount();
		opponent.decrementWishCount();

		WeatherDamage.applyDamagingWeather(bf, fasterTeam.getActivePokemon());
		WeatherDamage.applyDamagingWeather(bf, slowerTeam.getActivePokemon());

		WeatherDamage.applyHealingWeather(bf, fasterTeam.getActivePokemon());
		WeatherDamage.applyHealingWeather(bf, slowerTeam.getActivePokemon());

		// Check if Gravity wears off
		bf.decrementGravity();

		// applies damage/healing from status
		StatusDamage.applyIngrainHealing(fasterTeam.getActivePokemon());
		StatusDamage.applyIngrainHealing(slowerTeam.getActivePokemon());

		StatusDamage.applyAquaRingHealing(fasterTeam.getActivePokemon());
		StatusDamage.applyAquaRingHealing(slowerTeam.getActivePokemon());

		AbilityActivation.activateSpeedBoost(fasterTeam.getActivePokemon());
		AbilityActivation.activateSpeedBoost(slowerTeam.getActivePokemon());

		AbilityActivation.activateShedSkin(fasterTeam.getActivePokemon());
		AbilityActivation.activateShedSkin(slowerTeam.getActivePokemon());

		ItemActivation.applyHealingItems(fasterTeam.getActivePokemon());
		ItemActivation.applyHealingItems(slowerTeam.getActivePokemon());

		StatusDamage.applyLeechSeed(slowerTeam.getActivePokemon(),
				fasterTeam.getActivePokemon());
		StatusDamage.applyLeechSeed(fasterTeam.getActivePokemon(),
				slowerTeam.getActivePokemon());

		// Check for Status Damage/Nightmare
		// Checks for fainting inside healing method.
		if (!fasterTeam.getActivePokemon().hasFainted()
				&& !fasterTeam.getActivePokemon().isOk()) {
			StatusDamage.applyStatusDamage(fasterTeam.getActivePokemon());
			StatusDamage.applyStatusHealing(fasterTeam.getActivePokemon());
		}
		if (!slowerTeam.getActivePokemon().hasFainted()
				&& !slowerTeam.getActivePokemon().isOk()) {
			StatusDamage.applyStatusDamage(slowerTeam.getActivePokemon());
			StatusDamage.applyStatusHealing(slowerTeam.getActivePokemon());
		}

		ItemActivation.burnOrbActivation(fasterTeam.getActivePokemon());
		ItemActivation.toxicOrbActivation(fasterTeam.getActivePokemon());

		ItemActivation.burnOrbActivation(slowerTeam.getActivePokemon());
		ItemActivation.toxicOrbActivation(slowerTeam.getActivePokemon());

		StatusDamage.applyCurseDamage(fasterTeam.getActivePokemon());
		StatusDamage.applyCurseDamage(slowerTeam.getActivePokemon());

		StatusDamage.applyPartialTrappingDamage(fasterTeam.getActivePokemon(),
				slowerTeam.getActivePokemon());
		StatusDamage.applyPartialTrappingDamage(slowerTeam.getActivePokemon(),
				fasterTeam.getActivePokemon());

		StatusDamage.applyBadDreams(slowerTeam.getActivePokemon(),
				fasterTeam.getActivePokemon());
		StatusDamage.applyBadDreams(fasterTeam.getActivePokemon(),
				slowerTeam.getActivePokemon());

		// TODO Check for end of outrage, petal dance, uproar, thrash
		// TODO Check for end of disable

		fasterTeam.getActivePokemon().decrementEncore();
		slowerTeam.getActivePokemon().decrementEncore();

		// TODO Check for Taunt

		fasterTeam.getActivePokemon().decrementElectricMagniticLeviation();
		slowerTeam.getActivePokemon().decrementElectricMagniticLeviation();

		fasterTeam.getActivePokemon().decrementHealBlock();
		slowerTeam.getActivePokemon().decrementHealBlock();

		fasterTeam.getActivePokemon().decrementEmbargo();
		slowerTeam.getActivePokemon().decrementEmbargo();

		fasterTeam.getActivePokemon().decrementYawn();
		slowerTeam.getActivePokemon().decrementYawn();

		ItemActivation.activateStickBarb(fasterTeam.getActivePokemon());
		ItemActivation.activateStickBarb(slowerTeam.getActivePokemon());

		// TODO Doom Desire, Future Sight

		fasterTeam.getActivePokemon().decrementPerishSong();
		slowerTeam.getActivePokemon().decrementPerishSong();

		// Trick Room
		bf.decrementTrickRoom();
		bf.decrementMagicRoom();
		bf.decrementWonderRoom();

		switchIfFainted(fasterTeam);

		switchIfFainted(slowerTeam);

		fasterTeam.getActivePokemon().decrementSlowStart();
		slowerTeam.getActivePokemon().decrementSlowStart();
	}

	public void switchIfFainted(Team first) {
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
//				printSwitchOption(OPPONENT);
				System.out.println("Please choice a new pokemon");
				choice = -1;
			}
			AiWriter.setSearchMode(true);
			first.switchActivePokemon(first.getActivePokemon().getMove(choice));
		}
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

		damage = MainDamageFormula.damage(attack, defend, bf, attack
				.getActivePokemon().getMove(moveSlot).getMove());

		defend.getActivePokemon().setCurrHp(
				defend.getActivePokemon().getCurrHp() - damage[1]);

		AiWriter.writeAttack(attack.getActivePokemon(), moveSlot, damage[1],
				player);
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
