package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

public class CucumberRunnerForAndroid {
    @CucumberOptions(
            features = {"src/test/resources/features/mobile/"},
            glue = {"step_defination"},
            monochrome = true,
            dryRun = false,
            plugin = {
                    "pretty",
                    "html:build/reports/Android.html"
            })
    @Test
    public class CucumberRunnerTest extends AbstractTestNGCucumberTests{

    }
}
