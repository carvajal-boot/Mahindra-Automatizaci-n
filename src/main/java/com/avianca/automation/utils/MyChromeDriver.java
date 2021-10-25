package com.avianca.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;


public class MyChromeDriver {

    private final Logger log = LoggerFactory.getLogger(MyChromeDriver.class);
    WebDriver driver = null;

    public WebDriver webChromeDriver() {
        try {
            System.setProperty("webdriver.chrome.driver", Constans.ROUTE_DRIVER);
            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);
            return driver;

        } catch (Exception e) {
            log.warn("Falló al crear driver Mobile");
        }
        return null;
    }


}
