package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

public class HybridCucumberRunner {
    @CucumberOptions(
            features = {"src/test/resources/Features/api/api_post_login.feature",
            "src/test/resources/features/api/api_post_reg.feature",
            "src/test/resources/features/mobile/mob_login_bank.feature",
            "src/test/resources/features/web"},
            glue = {"step_defination"},
            monochrome = true,
            dryRun = false,
            plugin = {
                    "pretty",
                    "html:build/reports/hybrid_test_result.html"
            })
    @Test
    public class CucumberRunnerTest extends AbstractTestNGCucumberTests{

    }
}
