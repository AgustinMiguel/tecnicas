package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import restaurant.Almacen;
import restaurant.Cocina;
import restaurant.Consumible;
import restaurant.Ingrediente;
import restaurant.ItemMenu;
import restaurant.ItemPedido;
import restaurant.ItemReceta;
import restaurant.Mostrador;
import restaurant.Pedido;
import restaurant.Producto;
import restaurant.ProductoBasico;
import restaurant.ProductoElaborado;
import restaurant.Receta;
import restaurant.SinSaldoException;
import restaurant.SinSuficientesIngredientesException;
import restaurant.StockOld;
import restaurant.Usuario;
import restaurant.Vendible;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import com.sun.tools.javac.Main;

//extends TestCase
public class RecetaTest {

	private Receta _defaultReceta;

	/**
	 * Metodo setup para propiedades de clase
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("TestReceta -> BeforeClass ");
	}

	/**
	 * Metodo tearDown para propiedades de clase
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("TestReceta -> TearDown ");
	}

	/**
	 * Metodo setup para instancias de test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		_defaultReceta = new Receta("tortilla", 10, 100);
		Ingrediente potato = new Ingrediente("potato", "kl", 700, 2);
		Ingrediente egg = new Ingrediente("egg", "unit", 36, 10);
		Ingrediente salt = new Ingrediente("salt", "kg", 900, 1);
		ItemReceta itemPotato = new ItemReceta(potato, 3);
		ItemReceta itemEgg = new ItemReceta(egg, 2);
		ItemReceta itemSalt = new ItemReceta(salt, 1);
		_defaultReceta.addIngrediente(itemPotato);
		_defaultReceta.addIngrediente(itemEgg);
		_defaultReceta.addIngrediente(itemSalt);
	}

	/**
	 * Metodo tearDown para instancias de test
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("TestReceta -> TearDown");
	}

	@Test
	public void testMakeReceta() {
		System.out.println("TestReceta -> testMakeReceta");
		ArrayList<ItemReceta> ingredientes = (ArrayList<ItemReceta>) _defaultReceta.getIngredientes();
		for (ItemReceta e : ingredientes) {
			if (e.getIngrediente().getNombre() == "potato") {
				assertEquals("potato", e.getIngrediente().getNombre());
			} else {
				if (e.getIngrediente().getNombre() == "salt") {
					assertEquals("salt", e.getIngrediente().getNombre());
				} else {
					if (e.getIngrediente().getNombre() == "egg") {
						assertEquals("egg", e.getIngrediente().getNombre());
					}
				}
			}
		}
	}
}