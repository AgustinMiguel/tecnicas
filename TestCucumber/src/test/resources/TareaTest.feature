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

Feature: Test Background Feature
Description: The purpose of this feature is to test the Background keyword
 
Background: El usuario se loguea
 Given Estoy en la pagina de login
 When ingreso username and password
 Then deberia ingresar 
 
Scenario: Buscar un producto y agregar el primero al carrito
 Given El usuario busca una Laptop Lenovo 
 When agrego la primer laptop que aparece en los resultados de busqueda al carrito
 Then el carrito deberia mostrar el nuevo item agregado
 
Scenario: Navegar a un producto y agregarlo al carrito
 Given Usuario navega por una Laptop Lenovo
 When agrega el laptop al carrito
 Then el carrito deberia mostrar el nuevo item agregado

