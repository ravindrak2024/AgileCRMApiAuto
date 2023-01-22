import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com/agilecrm/stepdefs"},
        plugin = {"pretty","json:build/cucumber-reports/reports.json",

        "junit:build/cucumber-reports/Cucumber.xml",

        "html:build/cucumber-reports/reports.html"},monochrome = true,

        dryRun = false,
        tags="@smoke"
)
public class TestRunner {

}
