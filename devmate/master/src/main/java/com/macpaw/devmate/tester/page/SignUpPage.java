package com.macpaw.devmate.tester.page;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import static com.macpaw.devmate.tester.util.Constants.TIMEOUT;

/**
 * Created by mykhailo.lukianenko on 10/7/2014.
 */
public class SignUpPage extends FluentWebDriverPage {

  public SignUpPage(WebDriverProvider driverProvider) {
    super(driverProvider);
  }

  public void selectSellingOutsideAppStore() {within(TIMEOUT).input(By.name("selling_outside_app_store")).click(); }

  public void checkSolutionFormPresence() {
    within(TIMEOUT).input(By.name("solution"));
  }
}