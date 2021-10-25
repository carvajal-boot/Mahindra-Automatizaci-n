package com.avianca.automation.runners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(features = "src/test/resources/features/travelAvianca.feature", glue = "com.avianca.automation.stepdefinitions", snippets = CucumberOptions.SnippetType.CAMELCASE, tags = "@avianca")
public class TravelAviancaRunner extends AbstractTestNGCucumberTests {

}
