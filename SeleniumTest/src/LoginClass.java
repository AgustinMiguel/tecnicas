import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginClass {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/div[2]/div[1]/header/div[4]/button[2]") WebElement loginButton;//Otra alternativa!
	
	public LoginClass(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String user, String pass) {
		loginButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		WebElement username = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));
		username.sendKeys(user);
		WebElement password = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password")));
		password.sendKeys(pass);
		WebElement button = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
		button.click();
	}
}
