package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sistema.fullFlightException;
import sistema.Pasajero;
import sistema.Vuelo;

public class VueloTest {

	private Vuelo _defaultVuelo;
	private Pasajero _defaultPasajero;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("TestVuelo -> BeforeClass ");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("TestVuelo -> TearDown ");
	}
	
	public void setUp() throws Exception {
		System.out.println("setUp");
		_defaultVuelo 		 = new Vuelo(200);
		_defaultPasajero = new Pasajero("Agustin", "Miguel");

	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("TestVuelo -> TearDown");
	}
	
	@Test
	public void fullFlightException() throws fullFlightException {
		System.out.println("testVueloCompleto");		
		while(_defaultVuelo.getLugaresvacios() > 0) {
			_defaultVuelo.addPasajero(_defaultPasajero);
			assertEquals(0, _defaultVuelo.getLugaresvacios());
		}
	}
	
	@Test
	public void testVueloCerrado () {
		System.out.println("testVueloCerrado");		
			assertEquals(0, _defaultVuelo.getLugaresvacios());
		}
}
