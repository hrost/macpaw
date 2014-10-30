package com.macpaw.devmate.tester.page;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import static com.macpaw.devmate.tester.util.Constants.TIMEOUT;

public class MainPage extends FluentWebDriverPage {

  public MainPage(WebDriverProvider driverProvider) {
    super(driverProvider);
  }

  public void open() {
    get("http://devmate.com/");
  }

  public void clickSignUpNowButton() {
    within(TIMEOUT).link(By.cssSelector(".index-head-slider .btn-sign-up-now")).click();
  }

  public void clickFeaturesHeaderLink() {
    within(TIMEOUT).link(By.cssSelector("header .container nav a[href=\"/features/frameworks\"]"))
        .click();
  }
}
