package com.macpaw.devmate.tester.step;

import com.macpaw.devmate.tester.page.Pages;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


/**
 * Created by mykhailo.lukianenko on 10/8/2014.
 */
public class FeaturePageSteps {

  private final Pages pages;

  public FeaturePageSteps(Pages pages) {
    this.pages = pages;
  }

  @Then("screen shot for 'Sparkle-based Updates Framework' appears")
  public void checkScreenShotForSparkleBasedUpdatesFrameworkAppears() {
    pages.features().checkSParkleScreenShotPresence();
  }

  @When("go to features page app management")
  public void goToAppManagementPape() {
      pages.features().openAppManagementPage();
  }
}
