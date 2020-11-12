package test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import sistema.Pasajero;
import sistema.Vuelo;


public class VueloTest {
	Vuelo vuelo = new Vuelo(25);
	
	@Test(dataProvider = "dp")
	  public void f(Integer n, String s) {
		  System.out.println("f("+s+")");
	  }
	  
	@BeforeMethod
	  public void beforeMethod() {
		  System.out.println("beforeMethod()");
	  }
	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("afterMethod()");
	  }

	  @DataProvider (name = "gen-pasajeros")
	  public Object[][] generatePasajeros() {
		  Object [][] v =new Object[25][2];;
		  for(int i=0;i<25;i++){
			  Pasajero pasajero	= 	new Pasajero("Agustin","Miguel");
			  v[i][0]	=	new Integer(i);
			  v[i][1]	=	pasajero;
			  vuelo.addPasajero(pasajero);
		}  
		return v;
	  }
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("beforeClass");
	  }  
	  
	  @AfterClass
	  public void afterClass() {
		  System.out.println("afterClass()");
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("beforeTest()");
		  
	  }
	  
	  @AfterTest
	  public void afterTest() {
		  System.out.println("afterTest()");
	  }
	  
	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("beforeSuite()");
	  }
	  
	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("afterSuite()");
	  }
	  
	  @Test(dataProvider = "gen-pasajeros")
	  public void add(String a ,String b) {
		  Pasajero pasajero = new Pasajero(a,b);
		  vuelo.addPasajero(pasajero);
	  }


}
