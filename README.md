Hepsiburada Test Automation Project

This project is an automation framework that tests the tablet purchasing process on the Hepsiburada website.

Technologies Used
	•	Java 11
	•	Selenium WebDriver 4.11.0
	•	Cucumber 7.11.0
	•	JUnit 4.13.2
	•	Maven

Project Structure
	•	src/test/java/pages: Page Object Model (POM) classes
	•	src/test/java/stepdefinitions: Cucumber step definitions
	•	src/test/resources/features: Cucumber feature files

Test Scenario
	1.	Navigate to the Hepsiburada homepage
	2.	Go to the Tablet category (All Categories -> Electronics -> Tablet)
	3.	Apply filters: Brand: Apple, Screen Size: 13.2 inches
	4.	Select the most expensive product
	5.	Add the product to the cart
	6.	Verify the product price in the cart

Running the Project
	1.	Clone the project
	2.	Load Maven dependencies
	3.	Install ChromeDriver on your system and add it to the PATH
	4.	Run the feature file or test runner

Notes
	•	The project follows the Page Object Model (POM) design pattern
	•	The Cucumber framework is used for the Behavior-Driven Development (BDD) approach
	•	Selenium WebDriver is used for web automation