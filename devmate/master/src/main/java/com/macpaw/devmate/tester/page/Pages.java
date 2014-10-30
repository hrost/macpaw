package com.macpaw.devmate.tester.page;

import org.jbehave.web.selenium.WebDriverProvider;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class Pages {

  private final WebDriverProvider driverProvider;
  private MainPage main;
  private SignUpPage signUp;
  private FeaturesPage features;
  private FeaturesPageAppManagement featuresAppManagement;

  public Pages(WebDriverProvider driverProvider) {
    this.driverProvider = driverProvider;
  }

  public MainPage main() {
    if (null == main) {
      main = new MainPage(driverProvider);
    }
    return main;
  }

  public SignUpPage signUp() {
    if (null == signUp) {
      signUp = new SignUpPage(driverProvider);
    }
    return signUp;
  }

  public FeaturesPage features() {
        if (null == features) {
            features = new FeaturesPage(driverProvider);
        }
        return features;
    }

  public FeaturesPageAppManagement featuresAppManagement() {
        if (null == featuresAppManagement) {
            featuresAppManagement = new FeaturesPageAppManagement(driverProvider);
        }
        return featuresAppManagement;
    }

  public void checkUrlEqualsTo(String expectedUrl) {
    String actualUrl = driverProvider.get().getCurrentUrl();
    assertThat(actualUrl, equalTo(expectedUrl));
  }
}