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

public class MercadoLibre {
	
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
		driver.navigate().to("https://mercadolibre.com.ar");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Mercado Libre Argentina");
	}
	
	@Test (priority=2)
	public void selectIngresaSection() {
		//TODO Para que lo hagan ustedes
		
	}
	
	@Test (priority=3)
	public void searchProduct() {
		MercadoLibreBuscarProducto mercadolibrebuscar = PageFactory.initElements(driver, MercadoLibreBuscarProducto.class);
		mercadolibrebuscar.search("gameboy");
		mercadolibrebuscar.scrollear();
	}
	  @Test (priority=4)
	  public void finishTest() {
		  if(driver!=null) {
			  driver.close();
			  driver = null;
		  }
		  System.out.println("Termino satisfactoriamente");
		  Assert.assertNull(driver);
	  }
}
