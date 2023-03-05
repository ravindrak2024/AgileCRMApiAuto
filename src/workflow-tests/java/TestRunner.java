import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/workflow-tests/resources/features"},
        glue = {"com/agilecrm/stepdefs"},
        plugin = {"pretty","json:reports/cucumber-reports/reports.json",

        "junit:reports/cucumber-reports/Cucumber.xml",

        "html:reports/cucumber-reports/reports.html"},monochrome = true,

        dryRun = false

)
public class TestRunner {

}
