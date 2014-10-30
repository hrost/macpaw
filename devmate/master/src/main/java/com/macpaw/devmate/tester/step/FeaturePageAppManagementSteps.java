package com.macpaw.devmate.tester.step;

import com.macpaw.devmate.tester.page.Pages;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by hrostik on 30.10.2014.
 */
public class FeaturePageAppManagementSteps {
    private final Pages pages;

    public FeaturePageAppManagementSteps(Pages pages) {
        this.pages = pages;
    }

    @Then("screenshot for 'Easy Updates' appears")
    public void ScreenShotForEasyUpdatesAppears() {
        pages.featuresAppManagement().checkEasyUpdatesScreenShotPresence();
    }
}
