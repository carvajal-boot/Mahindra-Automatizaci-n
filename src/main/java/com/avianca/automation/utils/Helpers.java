package com.avianca.automation.utils;

import net.thucydides.core.pages.PageObject;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helpers extends PageObject {
    Logger logger = Logger.getLogger(Helpers.class.getName());

    public void esperaSelenium(int seconds) {
        try {
            Thread.sleep(seconds * (long) 1000);
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
    }

    public void switchWindow(){
        Set<String> allWindows = getDriver().getWindowHandles();
        for(String currentWindow : allWindows){
            getDriver().switchTo().window(currentWindow);
        }
    }
}
