package PokemonShowdownRC;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.omnidex.battlefield.team.DeepTeam;
import com.omnidex.battlefield.team.Team;
import com.omnidex.db.MovesetDAO;
import com.omnidex.game.Game;
import com.omnidex.move.Move;
import com.omnidex.pokemon.InactivePokemon;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.pokemon.Species;
import com.omnidexter.ai.BattleAI;
import com.omnidexter.battlefield.SingleBattleField;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BattleRC {

	public static final int RANDOM_BATTLE = 0;
	public static final int OU = 5;
	public static final int UBERS = 8;
	public static final int UU = 9;
	public static final int RU = 10;
	public static final int NU = 11;
	public static final int LC = 12;
	public static final int UU_CHALLENGE = 8;

	private WebDriver driver;
	private WebElement element;
	private WebDriverWait wait;
	private Team omnidexter;
	private Team opponent;
	private Game game;

	public BattleRC(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver,
				WebDriverWait.DEFAULT_SLEEP_TIMEOUT);
		omnidexter = new DeepTeam();
		opponent = new DeepTeam();
		loadGame();
	}

	public void lookForABattle(Team omnidexter) {
		element = wait.until(ExpectedConditions.visibilityOf(driver
				.findElement(By.className("mainbutton"))));
		System.out.println("Searching for random battle");
		element.click();
		loadGame();
	}

	public void loadGame() {
		loadTeam();
		//loadOppTeam();
		
		
		
		
		String oppName = driver.findElement(By.className("rightbar"))
				.findElement(By.className("trainer")).getText();
		game = new Game(new SingleBattleField(), omnidexter, opponent, oppName);
//		game.printBattleField();
	}

	public void sendGoodGameMessage() {
		WebElement textarea = driver.findElement(By.className("textbox"));
		textarea.sendKeys("gg" + Keys.ENTER);
	}

	
	
	
	private void loadPokemonMoves(Pokemon poke, boolean isActive, int index) {

		if (isActive) {
			wait.until(ExpectedConditions.elementToBeClickable(By
					.className("movemenu")));
			element = driver.findElement(By.className("movemenu"));
			List<WebElement> attackBtn = element.findElements(By
					.tagName("button"));
			String s = driver
					.findElement(By.cssSelector("div.statbar.rstatbar"))
					.findElements(By.tagName("small")).get(1).getText();
			
			s = s.substring(1);
			
			poke.setLevel(Integer.valueOf(s));
			for (int i = 0; i < attackBtn.size(); i++) {
				String movename = attackBtn.get(i).getText();
				StringTokenizer token = new StringTokenizer(movename, "\n");
				Move move = Move.findMoveByName(token.nextToken());
				poke.setMove(move, i);
			}
		} else {
			Actions mouseover = new Actions(driver);

			List<WebElement> switchOptions = driver.findElement(
					By.className("switchmenu")).findElements(
					By.tagName("button"));
			mouseover.moveToElement(switchOptions.get(index)).build().perform();
		}
	}

	private void loadTeam() {

		List<String> teamList = getOwnParty();

		boolean isActive = true;
		for (int i = 0; i < teamList.size(); i++) {
			Pokemon poke = new InactivePokemon(Species.findSpeciesByName(teamList
					.get(i)));

			loadPokemonMoves(poke, isActive, i);

			isActive = false;
			omnidexter.addTeamMate(poke);
		}
	}

	public String getOpponentsActivePokemon() {
		List<WebElement> oppActive = driver.findElements(By.tagName("img"));
		return stripImageUrl(oppActive.get(1).getAttribute("src"));
	}

	public List<String> getOwnParty() {
		List<WebElement> switchOptions = driver.findElement(
				By.className("switchmenu")).findElements(By.tagName("button"));
		List<String> party = new ArrayList<String>();
		for (int i = 0; i < switchOptions.size(); i++) {
			party.add(switchOptions.get(i).getText());
		}
		return party;
	}

	public void deliberate() {
		clickAttack(BattleAI.getBestMove(game, 1));
	}

	public void clickAttack(int moveslot) {
		wait.until(ExpectedConditions.elementToBeClickable(By
				.className("movemenu")));
		element = driver.findElement(By.className("movemenu"));
		List<WebElement> attackBtn = element.findElements(By.tagName("button"));

		if (moveslot < attackBtn.size()) {
			System.out.println(attackBtn.get(moveslot).getText());
			attackBtn.get(moveslot).click();
		} else {
			// handles lock on situations ie outrage
			attackBtn.get(0).click();
		}
	}

	public static void loadOppTeam(String tier, WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable((By.className("innerbattle"))));
		List<WebElement> imgs=  driver.findElement(By.className("innerbattle")).findElements(By.tagName("img"));
		for (int i = 0; i < imgs.size(); i ++) {
			System.out.println(imgs.get(i).getAttribute("src"));
			String form = stripImageUrl(imgs.get(i).getAttribute("src"));
			
			Pokemon poke = MovesetDAO.guessMoveset(form,tier);
			System.out.println(poke);
			System.out.println("===============================");
		}
	}
	
	/**
	 * Retrieves pokemon name from image recourse
	 * 
	 * @param url
	 *            image path to pokemon
	 * @return
	 */
	private static String stripImageUrl(String url) {

		/* strips file path */
		int position = url.lastIndexOf('/');
		url = url.substring(position + 1);

		/* strips file ext */
		position = url.indexOf('.');
		url = url.substring(0, position);

		/* strips gender from url */
		if (url.contains("-f") || url.contains("-m")) {
			url = url.substring(0, url.indexOf('-'));
		}

		// unown
		if (url.contains("unown")) {
			url = "unown";
		}

		return url;
	}
}
