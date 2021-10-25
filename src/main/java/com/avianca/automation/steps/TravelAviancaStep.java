package com.avianca.automation.steps;

import com.avianca.automation.pages.TravelAviancaPage;

import net.thucydides.core.annotations.Step;

public class TravelAviancaStep {

	TravelAviancaPage TravelAviancaSteps;

	@Step
	public void openUrl() {
		TravelAviancaSteps.openUrl();
	}
	
	@Step
	public String typeOfTravel(String typeOfTravel) {
		TravelAviancaSteps.chooseTravel(typeOfTravel);
		return typeOfTravel;
	}
	
	@Step
	public void flaying(String travel, String from, String to) {
		TravelAviancaSteps.flying(travel, from, to);
		
	}

}
