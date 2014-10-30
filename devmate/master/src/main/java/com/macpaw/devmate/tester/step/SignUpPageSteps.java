package com.macpaw.devmate.tester.step;

import com.macpaw.devmate.tester.page.Pages;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SignUpPageSteps {

  private final Pages pages;

  public SignUpPageSteps(Pages pages) {
    this.pages = pages;
  }

  @When("select 'selling outside app store'")
  public void selectSellingOutsideAppStore() {
    pages.signUp().selectSellingOutsideAppStore();
  }

  @Then("solution form appears")
  public void checkSolutionFormAppears() {
    pages.signUp().checkSolutionFormPresence();
  }
}
