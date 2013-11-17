package PokemonShowdownRC;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LobbyRC {

	private WebDriver driver;
	private WebDriverWait wait;
	private boolean isLoggedIn;
	
	public LobbyRC() {
		isLoggedIn = false;
		this.driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 5000);
		driver.get("http://play.pokemonshowdown.com/lobby");
		driver.manage().window().maximize();
		System.out.println("Navigated to lobby");
	}

	public TeamBuilderRC goToTeamBuilder() {
		driver.findElement(By.id("tabtab-teambuilder")).click();
		System.out.println("Navigated to teambuilder");
		return new TeamBuilderRC(driver);
	}
	
	public void goToLobby() {
		driver.findElement(By.id("tabtab-lobby")).click();
		System.out.println("Navigated to lobby");
	}

	/**
	 * Sends the message to the chat log in server
	 * 
	 * @param message
	 *            the message
	 */
	public void sendAChatMessage(String message) {
		wait.until(ExpectedConditions.elementToBeClickable(By
				.tagName("textarea")));
		List<WebElement> chatBoxes = driver
				.findElements(By.tagName("textarea"));
		WebElement chatBox = chatBoxes.get(1);
		chatBox.sendKeys(message);
		chatBox.sendKeys(Keys.RETURN);
	}

	public void acceptBattle() {
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("lobby-gobutton")));
		/* click accept battle button */
		driver.findElement(By.id("lobby-gobutton")).click();
	}

	public void sendChallengeRequestTo(String username, int format) {
		String id = "userlist-user-"+username;
		/* click user name button */
		driver.findElement(By.id(id)).click();
		/* click challenge button */
		driver.findElement(By.className("action-form")).findElements(By.tagName("button")).get(1).click();
		
		new Select(driver.findElement(By.id("lobby-format"))).selectByIndex(format);
		
		
		/* makes the challenge */
		driver.findElement(By.id("lobby-gobutton")).click();
		BattleRC.loadOppTeam("UU", driver, wait);
	}

	public BattleRC lookForRandomBattle() {
		
		/* clicks find battle button */
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("lobby-gobutton"))).click();
		System.out.println("Searching for a battle...");
		/* waits for battle screen to appear */
		wait.until(ExpectedConditions.elementToBeClickable(By
				.className("movemenu")));
		System.out.println("Battle Found!!!");
		System.out.println("Navigated to random battle screen");
		return new BattleRC(driver);
	}
	
	public BattleRC lookForRandomBattle(int format, int team) {
		
		new Select(driver.findElement(By.id("lobby-format"))).selectByIndex(format);
		System.out.println("\tSearching for a "
					+ new Select(driver.findElement(By.id("lobby-format"))).getFirstSelectedOption().getText()
					+ " battle!");
		
		/* checking if the format specified allows for team selection */
		if (driver.findElements(By.id("lobby-team")).size() != 0) {
			new Select(driver.findElement(By.id("lobby-team"))).selectByIndex(team);
		}
		
		/* clicks find battle button */
		wait.until(ExpectedConditions.visibilityOf(driver
				.findElement(By.className("mainbutton")))).click();
		
		/* waits for battle screen to appear */
		wait.until(ExpectedConditions.elementToBeClickable(By
				.className("movemenu")));
		System.out.println("\tBattle Found!!!");
		System.out.println("Navigated to a battle");
		return new BattleRC(driver);
	}

	public void login(String username) {
		if (!isLoggedIn) {
			/* clicks login button */
			wait.until(ExpectedConditions.elementToBeClickable(By
					.className("mainbutton"))).click();
			
			/* populates username field */
			wait.until(ExpectedConditions.elementToBeClickable(By
					.className("textbox")));
			driver.findElement(By.className("textbox")).sendKeys(username);
			
			/* submits the username */
			driver.findElement(By.id("messagebox")).findElement(By.tagName("button")).click();
			isLoggedIn = true;
			
			/* waits for login to complete */
			wait.until(ExpectedConditions.textToBePresentInElement(By.id("userbar"), username));
			System.out.println("\tLogged in as '" + username + "'");
		}
	}
}
