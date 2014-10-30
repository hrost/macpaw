package com.macpaw.devmate.tester.step;

import com.macpaw.devmate.tester.page.Pages;

import org.jbehave.core.annotations.Then;

public class PagesSteps {

  private final Pages pages;

  public PagesSteps(Pages pages) {
    this.pages = pages;
  }

  @Then("check URL equals to '$expectedUrl'")
  public void checkUrlEqualsTo(String expectedUrl) {
    pages.checkUrlEqualsTo(expectedUrl);
  }
}
