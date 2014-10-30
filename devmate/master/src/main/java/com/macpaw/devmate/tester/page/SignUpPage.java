package com.macpaw.devmate.tester.page;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import static com.macpaw.devmate.tester.util.Constants.TIMEOUT;

public class SignUpPage extends FluentWebDriverPage {

  public SignUpPage(WebDriverProvider driverProvider) {
    super(driverProvider);
  }

  public void selectSellingOutsideAppStore() {within(TIMEOUT).input(By.name("selling_outside_app_store")).click(); }

  public void checkSolutionFormPresence() {
    within(TIMEOUT).input(By.name("solution"));
  }
}