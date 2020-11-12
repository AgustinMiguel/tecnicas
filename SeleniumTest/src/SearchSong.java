import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchSong {
	WebDriver driver;
	
	public SearchSong(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchAndPlay(String song) {
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		WebElement searchButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/nav/ul/li[2]/a")));
		searchButton.click();
		WebElement searchBar = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/header/div[3]/div/div/input")));
		searchBar.sendKeys(song);
		WebElement firstSong = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchPage\"]/div/div/section[1]/div[2]/div/div/div/div/div[4]")));
		
		Actions action = new Actions(driver);//Para movimientos del mouse mas complejos! drag and drop
		action.doubleClick(firstSong).perform();
	}
}
