package com.macpaw.devmate.tester.story.reporter;

import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.web.selenium.WebDriverProvider;

import java.io.File;
import java.io.PrintStream;

import static org.jbehave.core.reporters.FilePrintStreamFactory.FileConfiguration;

public class CustomHtmlFormat extends org.jbehave.core.reporters.Format {

  private final WebDriverProvider driverProvider;

  public CustomHtmlFormat(WebDriverProvider driverProvider) {
    super("HTML");
    this.driverProvider = driverProvider;
  }

  @Override
  public StoryReporter createStoryReporter(FilePrintStreamFactory factory,
                                           StoryReporterBuilder storyReporterBuilder) {
    FileConfiguration fileConfiguration = storyReporterBuilder.fileConfiguration("html");

    factory.useConfiguration(fileConfiguration);

    PrintStream printStream = factory.createPrintStream();
    Keywords keywords = storyReporterBuilder.keywords();
    File outputDirectory = storyReporterBuilder.outputDirectory();

    return new CustomHtmlOutput(printStream, keywords, outputDirectory, driverProvider)
        .doReportFailureTrace(storyReporterBuilder.reportFailureTrace())
        .doCompressFailureTrace(storyReporterBuilder.compressFailureTrace());
  }
}