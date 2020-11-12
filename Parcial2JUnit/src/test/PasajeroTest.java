package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PasajeroTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Pasajero -> setupBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	System.out.println("Pasajero -> tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
	System.out.println("Pasajero -> Pasajero");
	}

	@After
	public void tearDown() throws Exception {
	System.out.println("Pasajero -> TearDownPasajero");
	}
	/**
	 *  
	 */
	@Test
	public void testPasajero() {
	System.out.println("Pasajero -> TestProgramacion");
	}
}
