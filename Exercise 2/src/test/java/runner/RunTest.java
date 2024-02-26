package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "stepDef",
        tags = "@negative14",
        plugin = {"pretty", "html:target/RegressionReport.html"}
)

public class RunTest {
}