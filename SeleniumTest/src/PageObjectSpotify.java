import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageObjectSpotify 
{
	static WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver();
	}
	
	@Test (priority=1)
	public void browserTest() {
		  driver.navigate().to("https://open.spotify.com/browse/featured");
		  //WebDriverWait wait = new WebDriverWait(driver, 30); //Espera a que cargue la pag 
		  String titulo = driver.getTitle();
		  String expectedTitle = "Spotify – Web Player";
		  System.out.println(titulo);
		  //Comprobamos que realmente estamos en instagram. Buena Practica
		  assertEquals(titulo, expectedTitle);
	 }
	
	@Test (priority=2)
	public void loggin() {
		LoginClass logInSpotify = PageFactory.initElements(driver, LoginClass.class);
		logInSpotify.login("TDyVTudai", "12345");
	}
	
	@Test (priority=3)
	public void searchSong() {
		SearchSong searchSong = PageFactory.initElements(driver, SearchSong.class);
		searchSong.searchAndPlay("faded");
	}

	@Test (priority=4)
	public void closeDriver() {
		/*if(driver!=null)
			driver.close();*/
		System.out.println("Termino satisfactoriamente");
	}

}
