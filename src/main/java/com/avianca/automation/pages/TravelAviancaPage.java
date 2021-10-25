package com.avianca.automation.pages;

import com.avianca.automation.utils.Helpers;
import lombok.experimental.Helper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avianca.automation.utils.Constans;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;

public class TravelAviancaPage extends PageObject {

	@FindBy(xpath = "(//label[contains(@class,'radio-button ')])[2]")
	WebElementFacade oneWay;
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[3]/div[4]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/label[1]/div[1]/input[1]")
	WebElementFacade fromOneWay;
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[3]/div[4]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[2]/div[2]/div[1]/label[1]/div[1]/input[1]")
	WebElementFacade toOneWay;
	@FindBy(xpath = "(//i[@class='material-icons'][contains(.,'event')])[3]")
	WebElementFacade calendarOneWay;
	@FindBy(xpath = "(//div[@data-day='2021.11.3'])[3]")
	WebElementFacade dateOneWay;
	@FindBy(xpath = "(//div[@class='col-xs-12 text-right col-sm-4 col-md-6 especial-padding-3 noPadl boton-container']//*[contains(.,'Search for flights')])[2]")
	WebElementFacade buttonSearch;
	@FindBy(xpath = "//span[@class='mat-button-wrapper'and contains(.,' Best price ')]")
	WebElementFacade bestPrice;
	@FindBy(xpath = "//span[@class='mat-button-wrapper'and contains(.,' Direct flights ')]")
	WebElementFacade directFlights;
	@FindBy(xpath = "(//div[@class='component-bound ng-star-inserted'])[1]")
	WebElementFacade chooseFlights;

	@FindBy(xpath = "(//label[contains(@class,'radio-button ')])[1]")
	WebElementFacade roundTrip;

	Helpers helpers = new Helpers();
	
	WebDriverWait wait = new WebDriverWait(this.getDriver(),30);

	public void openUrl() {
		this.getDriver().quit();
		this.getDriver().get(Constans.URL_AVE);
		this.getDriver().manage().window().maximize();
		
	}

	public String chooseTravel(String typeOfTravel) {

		if (typeOfTravel.equals("RoundTrip")) {
			roundTrip.click();
		} else if (typeOfTravel.equals("OneWay")) {
			oneWay.click();
		} else {
			System.out.println("Error: Type of travel not found");
		}

		return typeOfTravel;

	}

	public void flying(String travel, String from, String to) {

		switch (travel) {

		case "OneWay":
			if (fromOneWay.isEnabled()) {
				fromOneWay.click();
				fromOneWay.sendKeys(from);
				fromOneWay.sendKeys(Keys.DOWN, Keys.ENTER);
			}

			if (toOneWay.isClickable()) {
				toOneWay.click();
				toOneWay.sendKeys(to);
				toOneWay.sendKeys(Keys.DOWN, Keys.ENTER);
			}
			calendarOneWay.click();
			dateOneWay.click();

			String tipo = "bestprice";
			if (tipo.equals("bestprice")) {
				buttonSearch.click();
				wait.until(ExpectedConditions.visibilityOf(bestPrice));
			}
			if (tipo.equals("directflight")) {
				directFlights.click();
			}

			chooseFlights.click();

			break;

		case "RoundTrip":

			break;

		default:
			System.out.println("Error: Type of travel not found");
			break;
		}

	}

}
