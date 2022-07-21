package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * If you want execute just only one scenarion: @RunWith(Cucumber.class)
 *
 * @CucumberOptions(
 *         features = {"src/test/resources/com.features/AccountPage.feature"},
 *         glue = {"stepdefinitions", "AppHooks"},
 *         plugin = {"pretty"
 *         }
 *
 * if all: @RunWith(Cucumber.class)
 * @CucumberOptions(
 *         features = {"src/test/resources/com.features"},
 *         glue = {"stepdefinitions", "AppHooks"},
 *         plugin = {"pretty"
 *         }
 * )
 * )
 */

@RunWith(Cucumber.class)
@CucumberOptions(
                features = {"src/test/resources/com.features/SearchPage.feature"},
        tags = "@Smoke",
        glue = {"stepdefinitions", "AppHooks"},
//        monochrome = true,
        dryRun = false,
        plugin = {"pretty",
        }
)

public class MyTestRunner {

}
