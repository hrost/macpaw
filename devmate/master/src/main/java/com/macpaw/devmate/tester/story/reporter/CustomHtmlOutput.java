package com.macpaw.devmate.tester.story.reporter;

import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.reporters.HtmlOutput;
import org.jbehave.web.selenium.WebDriverProvider;

import java.io.File;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class CustomHtmlOutput extends HtmlOutput {

  private final File outputDirectory;
  private final WebDriverProvider driverProvider;

  public CustomHtmlOutput(PrintStream output, Keywords keywords, File outputDirectory,
                          WebDriverProvider driverProvider) {
    super(output, keywords);
    this.outputDirectory = outputDirectory;
    this.driverProvider = driverProvider;

    super.overwritePattern("failed",
                           "<div class=\"step failed\">{0} <span class=\"keyword failed\">({1})"
                           + "</span><br/><span class=\"message failed\">{2}</span><br/>"
                           + "<a color=\"red\" target=\"jb_scn_shot\" "
                           + "href=\"../screenshots/failed-scenario-{3}.png\">FAIL SCREEN SHOT</a>"
                           + "</div>\n");
  }

  @Override
  public void successful(String step) {
    super.successful(step);

    UUID screenShotUuid = randomUUID();
    String screenShotPath = MessageFormat.format("{0}/screenshots/success-step-{1}.png",
                                                 outputDirectory, screenShotUuid);

    driverProvider.saveScreenshotTo(screenShotPath);

    print(MessageFormat.format("<a color=\"black\" target=\"jb_scn_shot\" "
                               + "href=\"../screenshots/success-step-{0}.png\">"
                               + "SUCCESS SCREEN SHOT</a></div>\n", screenShotUuid));
  }
}
