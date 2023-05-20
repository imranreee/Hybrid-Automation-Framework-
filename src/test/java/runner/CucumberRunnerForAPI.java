package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

public class CucumberRunnerForAPI {
    @CucumberOptions(
            features = {"src/test/resources/Features/api/"},
            glue = {"step_defination"},
            monochrome = true,
            dryRun = false,
            plugin = {
                    "pretty",
                    "html:build/reports/feature.html"
            })
    @Test
    public class CucumberRunnerTest extends AbstractTestNGCucumberTests{

    }
}
