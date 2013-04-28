package PokemonShowdownRC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class TeamBuilderRC {
	
	public static final int OU = 1;
	public static final int UBERS = 5;
	public static final int UU = 5;
	public static final int RU = 6;
	public static final int NU = 7;
	public static final int LC = 8;
	private WebDriver driver;
	private WebDriverWait wait;
	
	public TeamBuilderRC(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Wait.DEFAULT_TIMEOUT);
	}
	
	public void buildTeam(String teamName, int format, String teamFile) {
		
		/* clicks on new team */
		driver.findElement(By.tagName("button")).click();
		System.out.println("\tBuilding new Team: " + teamName);
		
		/* select team's format */
		Select formatSelect = new Select(driver.findElement(By.tagName("select")));
		formatSelect.selectByIndex(format);
		
		/* select team import */
		List<WebElement> btns = driver.findElements(By.tagName("button"));
		WebElement importBtn = btns.get(5);
		importBtn.click();

		/* name the team */
		wait.until(ExpectedConditions.elementToBeClickable(By.tagName("input")));
		WebElement teamNameField = driver.findElement(By.tagName("input"));
		teamNameField.clear();
		teamNameField.sendKeys(teamName);

		/* paste team */
		WebElement teamImportTextArea = driver.findElement(By
				.className("teamedit"));
		teamImportTextArea.sendKeys(readInTeam(teamFile));

		/* saves team and returns to main team editor */
		driver.findElement(By.className("savebutton")).click();
		driver.findElement(By.className("savebutton")).click();
		System.out.println("\tSaved team: " + teamName);
	}
	
	/**
	 * Helper method for handling reading in a team
	 * from the PO file format
	 * @param team
	 * @return
	 */
	private String readInTeam(String team) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(team));
			String line = br.readLine();
			while (line != null) {
				sb.append(line + '\n');
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	
}
