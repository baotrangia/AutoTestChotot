package LoginFeatures.support;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.masterthought.cucumber.presentation.PresentationMode.EXPAND_ALL_STEPS;


public class Report {
    @Test
    public void generateDemoReport() throws IOException {
        File reportOutputDirectory = new File("target/chototLoginFeatures");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/test-classes/reports/result.json");

        String buildNumber = "1";
        String projectName = "iPaper_web";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);

        configuration.addClassifications("Browser", "Firefox");
        configuration.addClassifications("Branch", "release/1.0");
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(EXPAND_ALL_STEPS);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
