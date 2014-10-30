package com.macpaw.devmate.tester.page;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import static com.macpaw.devmate.tester.util.Constants.TIMEOUT;

/**
 * Created by hrostik on 30.10.2014.
 */
public class FeaturesPageAppManagement extends FluentWebDriverPage{

    public FeaturesPageAppManagement(WebDriverProvider driverProvider) { super(driverProvider); }

    public void checkEasyUpdatesScreenShotPresence() {
        within(TIMEOUT).img(By.cssSelector(".visual-slider-img.on img[alt='Easy Updates']"));
    }
}
