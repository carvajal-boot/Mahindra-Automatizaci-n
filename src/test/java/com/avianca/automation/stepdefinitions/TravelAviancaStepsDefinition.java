package com.avianca.automation.stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import com.avianca.automation.steps.TravelAviancaStep;
import com.avianca.automation.utils.DataDrivenExcel;
import com.avianca.automation.utils.Excel;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TravelAviancaStepsDefinition {
	
	
	DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<>();

    @Steps
    TravelAviancaStep stepson;
    

    @Given("open the page avianca {int}")
    public void open_the_page_AVE(int row, DataTable datosExcel) {
        data = datosExcel.asMap(String.class, String.class);
        Excel excel = new Excel(data.get("Route Excel"), data.get("Tab"), true, row);
        data = dataDriverExcel.leerExcel(excel);
        stepson.openUrl();


    }

    @When("complete the type of flight")
    public void compleTheFlight() {
        stepson.typeOfTravel(data.get("Type of travel"));

    }

    @And("select the best price of fligth")
    public void selectTheBestPrice() {
        stepson.flaying(data.get("Type of travel"), data.get("From"), data.get("To"));
    }

    @Then("validate the informattion of fligth")
    public void validateInformation() {

    }

}
