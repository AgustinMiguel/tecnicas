import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *  Search Google example.	 
 */
public class GoogleSearch
{
	static WebDriver driver;
	    
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver();
	}

	public void launchTest() {
		driver.navigate().to("https://www.google.com.ar");
		String titulo = driver.getTitle();	
		System.out.println("Entro en "+titulo);
		
		//Esperamos a que cargue la barra de busqueda
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q']")));
			
		//Escribimos "Los simpsons"
		element.sendKeys("Los simpsons");
			
		//Por �ltimo hacemos click en "buscar"
		element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='btnK']")));
		element.click();
	}
		
	public void closeDriver() {
		/*if(driver!=null)
			driver.close();*/
		System.out.println("Termino satisfactoriamente");
	}
}









































