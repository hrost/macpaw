package com.macpaw.devmate.tester.story;

import com.macpaw.devmate.tester.driver.DmWebDriverProvider;
import com.macpaw.devmate.tester.page.Pages;
import com.macpaw.devmate.tester.step.*;
import com.macpaw.devmate.tester.reporter.DmHtmlFormat;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.executors.SameThreadExecutors;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.web.selenium.*;

import java.util.List;

import static java.lang.System.setProperty;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;

public class DevMateStories extends JUnitStories {

    private WebDriverProvider driverProvider = new DmWebDriverProvider();

    static {
        setProperty("webdriver.chrome.driver", "D:\\Java\\chromedriver.exe");
    }

    public DevMateStories() {
        configuredEmbedder().useExecutorService(
                new SameThreadExecutors().create(configuredEmbedder().embedderControls()));
    }

    @Override
    public Configuration configuration() {
        StoryReporterBuilder storyReporterBuilder = new StoryReporterBuilder()
                .withCodeLocation(codeLocationFromClass(getClass()))
                .withFailureTrace(true)
                .withDefaultFormats().withFormats(CONSOLE, new DmHtmlFormat(driverProvider));

        return new SeleniumConfiguration()
                .useWebDriverProvider(driverProvider)
                .useStoryLoader(new LoadFromClasspath(getClass()))
                .useStoryReporterBuilder(storyReporterBuilder);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        Configuration configuration = configuration();

        WebDriverSteps lifecycleSteps = new PerStoriesWebDriverSteps(driverProvider);

        WebDriverScreenshotOnFailure screenShotOnFailureSteps =
                new WebDriverScreenshotOnFailure(driverProvider, configuration.storyReporterBuilder());

        Pages pages = new Pages(driverProvider);

        PagesSteps pagesSteps = new PagesSteps(pages);

        MainPageSteps mainPageSteps = new MainPageSteps(pages);
        SignUpPageSteps signUpPageSteps = new SignUpPageSteps(pages);
        FeaturesPageSteps featuresPageSteps = new FeaturesPageSteps(pages);
        FeaturesAppManagementPageSteps featuresAppManagementPageSteps = new FeaturesAppManagementPageSteps(pages);

        return new InstanceStepsFactory(configuration, screenShotOnFailureSteps, lifecycleSteps, pagesSteps,
                mainPageSteps, signUpPageSteps, featuresPageSteps, featuresAppManagementPageSteps);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "");
    }
}
