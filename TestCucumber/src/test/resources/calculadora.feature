#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: suma

@tag
	Scenario Outline: Sumar dos números
		Given que he introducido <operando_1> en la calculadora
		And que tambien he introducido <operando_2> en la calculadora
		When oprimo el <boton>
		Then el resultado debe ser <resultado> en la pantalla

    
		Examples:
			|operando_1 | operando_2 | boton | resultado | 
			| 20        | 30        | add   | 50        | 
			| 2         | 5         | add   | 7         | 
			| 0         | 40        | add   | -40        |
	