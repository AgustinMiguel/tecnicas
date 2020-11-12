
public class Main {
	//https://chromedriver.chromium.org/downloads
	public static void main(String[] args) {
		/***************** Buscamos algo en google ******************/
		GoogleSearch googleSearch = new GoogleSearch();
		googleSearch.launchBrowser();
		googleSearch.launchTest();
		googleSearch.closeDriver();
	
		//Ahora lo mismo con TestNg!
		//Ejecutar TestSuite!
	}

}
