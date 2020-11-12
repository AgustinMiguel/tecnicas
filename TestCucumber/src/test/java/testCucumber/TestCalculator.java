package testCucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCalculator {
	int operandoA, operandoB, resultado;
	char operacion = ' ';

	@Given("que he introducido {int} en la calculadora")
	public void que_he_introducido_en_la_calculadora(Integer int1) {
		operandoA = int1.intValue();
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@Given("que tambien he introducido {int} en la calculadora")
	public void que_tambien_he_introducido_en_la_calculadora(Integer int1) {
		operandoB = int1.intValue();
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@When("oprimo el sub")
	public void oprimo_el_sub() {
		operacion = '-';
	}

	@When("oprimo el add")
	public void oprimo_el_add() {
		operacion = '+';
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@Then("el resultado debe ser {int} en la pantalla")
	public void el_resultado_debe_ser_en_la_pantalla(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		resultado = int1.intValue();
		if (operacion == '+')
			assert (resultado == (operandoA + operandoB));
		if (operacion == '-')
			assert (resultado == (operandoA - operandoB));
		// throw new io.cucumber.java.PendingException();
	}

	@Before(order = 1)
	public void beforeScenario() {
		System.out.println("Start the browser and Clear the cookies");
	}

	@Before(order = 0)
	public void beforeScenarioStart() {
		System.out.println("-----------------Start of Scenario-----------------");
	}

	@After(order = 0)
	public void afterScenarioFinish() {
		System.out.println("-----------------End of Scenario-----------------");
	}

	@After(order = 1)
	public void afterScenario() {
		System.out.println("Log out the user and close the browser");
	}

}
