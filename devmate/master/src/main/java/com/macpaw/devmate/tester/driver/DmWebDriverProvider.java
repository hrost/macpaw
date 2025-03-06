package com.macpaw.devmate.tester.driver;

import org.jbehave.web.selenium.TypeWebDriverProvider;
import org.openqa.selenium.chrome.ChromeDriver;

/*
* Created by hrostik on 30.10.2014.
*/
public class DmWebDriverProvider extends TypeWebDriverProvider {

    public DmWebDriverProvider() {
        super(ChromeDriver.class);
    }

    @Override
    public void initialize() {
        super.initialize();

        get().manage().window().maximize();
    }
}
