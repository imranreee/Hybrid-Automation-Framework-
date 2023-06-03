package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

public class APIRunner {
    @CucumberOptions(
            features = {"src/test/resources/features/api/api_post_reg.feature"},
            glue = {"step_defination"},
            monochrome = true,
            dryRun = false,
            plugin = {
                    "pretty",
                    "html:build/reports/ger_user_list.html"
            })
    @Test
    public class CucumberRunnerTest extends AbstractTestNGCucumberTests{

    }
}
