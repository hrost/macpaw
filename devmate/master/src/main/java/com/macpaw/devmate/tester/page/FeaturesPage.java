package com.macpaw.devmate.tester.page;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import static com.macpaw.devmate.tester.util.Constants.TIMEOUT;

/**
 * Created by mykhailo.lukianenko on 10/8/2014.
 */
public class FeaturesPage extends FluentWebDriverPage {

  public FeaturesPage(WebDriverProvider driverProvider) {
    super(driverProvider);
  }

  public void checkSParkleScreenShotPresence() {
    within(TIMEOUT).img(By.cssSelector(".visual-slider-img.on img[alt='Sparkle-based updates framework']"));
  }

  public void openAppManagementPage() {
      get("http://devmate.com/features/app-management");
  }
}

