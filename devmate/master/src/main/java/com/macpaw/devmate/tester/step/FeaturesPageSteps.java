package com.macpaw.devmate.tester.step;

import com.macpaw.devmate.tester.page.Pages;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FeaturesPageSteps {

  private final Pages pages;

  public FeaturesPageSteps(Pages pages) {
    this.pages = pages;
  }

  @Then("screen shot for 'Sparkle-based Updates Framework' appears")
  public void checkScreenShotForSparkleBasedUpdatesFrameworkAppears() {
    pages.features().checkSParkleScreenShotPresence();
  }

  @When("go to features app management page")
  public void goToFeaturesAppManagementPape() {
      pages.features().openAppManagementPage();
  }
}
