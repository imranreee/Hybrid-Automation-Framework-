package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

public class CucumberRunner {
    @CucumberOptions(
            features = {"src/test/resources/features/web/web_bank_manager_login.feature"},
            glue = {"step_defination"},
            tags = "@practice",
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
