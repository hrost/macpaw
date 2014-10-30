package com.macpaw.devmate.tester.step;

import com.macpaw.devmate.tester.page.Pages;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FeaturesAppManagementPageSteps {
    private final Pages pages;

    public FeaturesAppManagementPageSteps(Pages pages) {
        this.pages = pages;
    }

    @Then("screenshot for 'Easy Updates' appears")
    public void screenShotForEasyUpdatesAppears() {
        pages.featuresAppManagement().checkEasyUpdatesScreenShotPresence();
    }
}
