import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompraGamer {
	static WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver();
	}
	
	@Test (priority=1)
	public void loadPage() {
		driver.navigate().to("https://compragamer.com/");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "COMPRA GAMER | Compra Gamer" );
	}
	
	  @Test (priority=2)
	  public void closePopUp() {
		  WebDriverWait wait = new WebDriverWait(driver, 1);
		  WebElement popUp = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarNotificacion")));
		  popUp.click();
	  }
	  
	  @Test (priority=3)
	  public void pcSelector () {
		  WebDriverWait wait = new WebDriverWait(driver, 1);
		  WebElement menu = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[2]/a")));
		  menu.click();
	  }
	  
	  @Test (priority=4)
	  public void amdSelector () {
		  WebDriverWait wait = new WebDriverWait(driver, 1);
		  WebElement amd = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/div/div[2]/div[2]/a/img")));
		  amd.click();
	  }
	  
	  @Test (priority=6)
	  public void motherSelector () {
		  WebDriverWait wait = new WebDriverWait(driver, 1);
		  WebElement mother = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mother MSI B450M PRO-M2 MAX")));
		  mother.click();
	  }
	
	
	  @Test (priority=7)
	  public void finishTest() {
		  if(driver!=null) {
			 // driver.close();
			  //driver = null;
		  }
		  System.out.println("Termino satisfactoriamente");
		  Assert.assertNull(driver);
	  }
}
