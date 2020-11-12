package test;
import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import Programacion.Programa;
import Programacion.Programacion;
import Programacion.ProgrmacionNoEncontradaException;
import Programacion.Tarea;

//extends TestCase
public class ProgramaTest {
	
	private Programa 		_defaultPrograma;
	private Programacion 	_defaultProgramacion;
	private Tarea			_defaultTarea;
	
	
	/**
	 * Metodo setup para propiedades de clase
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("TestPrograma -> BeforeClass ");
	}
	/**
	 * Metodo tearDown para propiedades de clase
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("TestPrograma -> TearDown ");
	}

	/**
	 * Metodo setup para instancias de test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		Date d1 = new Date(2015,12,24,22,00);
		Date d2 = new Date(2015,12,25,06,00);
		System.out.println("Setup");
		
		_defaultTarea 		 = new Tarea("Festejar Navidad");
		_defaultProgramacion = new Programacion(d1,d2,_defaultTarea);
		_defaultPrograma	 = new Programa();
	}
	/**
	 * Metodo tearDown para instancias de test
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("TestPrograma -> TearDown");
	}
	
	@Test
	public void testPrograma() {
		System.out.println("TestPrograma -> testPrograma");
	}
	/**
	 * Prueba el metodo de cantidad de ocurrencias
	 * La prueba se realiza vaciando las programaciones existentes y luego agrega tres
	 * programaciones. La cantidad de programaciones debe ser exactamente 3
	 */
	@Test
	public void testGetCantOcurrencias() {
		System.out.println("testGetCantOcurrencias");
		
		_defaultPrograma.eliminarProgramaciones();
		assertEquals(0, _defaultPrograma.getCantProgramaciones());
		
		_defaultPrograma.addProgramacion(_defaultProgramacion);
		Date d1 = new Date(2016,1,23,00,00);
		Date d2 = new Date(2016,1,23,23,59);
		Date d3 = new Date(2016,1,06,00,00);
		Date d4 = new Date(2016,1,06,06,00);
		
		Tarea t1	= new Tarea("Festejar Cumplea");
		Tarea t2	= new Tarea("Cortar pasto para camellos");
		
		Programacion cumpleanios	= new Programacion(d1, d2,t1);
		Programacion reyes			= new Programacion(d3, d4,t2);
		
		_defaultPrograma.addProgramacion(cumpleanios);
		_defaultPrograma.addProgramacion(reyes);
		
		assertEquals(3, _defaultPrograma.getCantProgramaciones());
	}
	/**
	 * Prueba el metodo getCantTareasEntre
	 * La prueba se realiza insertando tres tareas de las cuales exactamente 2
	 * cumplen los requisitos
	 */

	@Test
	public void testGetCantTareasEntre() {
		System.out.println("TestPrograma -> testGetCantTareasEntre");
	}

	/**
	 * Prueba el metodo addPrrogramacion
	 * La prueba se realiza insertando una programacion nueva. El resultado es un
	 * programa con una nueva programacion
	 */
	@Test
	public void testAddProgramacion() {
		System.out.println("testAddProgramacion");
		int programacionesHastaElMomento = _defaultPrograma.getCantProgramaciones();
		_defaultPrograma.addProgramacion(_defaultProgramacion);
		assertEquals(programacionesHastaElMomento+1,_defaultPrograma.getCantProgramaciones());
	}

	/**
	 * Prueba el metodo removeProgramacion
	 * La prueba se realiza insertando una programacion, 
	 * luego se calculan cuantas programaciones se tienen y posteriormente
	 * se elimina. La cantidad de programaciones debe haber disminuido
	 * @throws ProgrmacionNoEncontradaException 
	 */
	@Test
	public void testRemoveProgramacion() throws ProgrmacionNoEncontradaException {
		System.out.println("testRemoveProgramacion");
		Date d1 = new Date(2015,12,31,22,00);
		Date d2 = new Date(2016,1,1,06,00);
		Tarea t	= new Tarea("Recibir a񯠎uevo");
		
		Programacion otraProgramacion = new Programacion(d2, d2,t);
		_defaultPrograma.addProgramacion(otraProgramacion);
		int programacionesHastaElMomento = _defaultPrograma.getCantProgramaciones();
		
			_defaultPrograma.removeProgramacion(otraProgramacion);
			assertEquals(programacionesHastaElMomento-1,_defaultPrograma.getCantProgramaciones());
	
		
	}
	
	 @ Test(expected = ProgrmacionNoEncontradaException.class)

	public void testExcepcionPorNoEncontrada() throws ProgrmacionNoEncontradaException{
		_defaultPrograma.eliminarProgramaciones();
		_defaultPrograma.removeProgramacion(_defaultProgramacion);
	};
	//--------------------------------------------
	@Test
	public void testEliminarProgramaciones() {
		System.out.println("testEliminarProgramaciones");
		_defaultPrograma.eliminarProgramaciones();
		assertEquals(0,_defaultPrograma.getCantProgramaciones());
		
	}
	//-------------------------------------------
	@Test
	public void testProgramaVacio() {
		System.out.println("testProgramaVacio");
		_defaultPrograma.eliminarProgramaciones();
		assertEquals(true,_defaultPrograma.programaVacio());
	}
	//-----------------------------------------
	@Test(timeout=1)
	public void testIniciar() throws InterruptedException {
		
		System.out.println("Test Iniciar");
		_defaultPrograma.iniciar();;
	}
	
}