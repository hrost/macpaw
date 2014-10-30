package com.macpaw.devmate.tester.step;

import com.macpaw.devmate.tester.page.Pages;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

public class MainPageSteps {

  private final Pages pages;

  public MainPageSteps(Pages pages) {
    this.pages = pages;
  }

  @Given("open main page")
  public void openMainPage() {
    pages.main().open();
  }

  @Given("go to sign up page")
  public void goToSignupPage() {
    pages.main().clickSignUpNowButton();
  }

  @When("go to features page")
  public void goToFeaturesPage() {
    pages.main().clickFeaturesHeaderLink();
  }
}
