package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definition",
        monochrome = true,
        plugin={"pretty", "html:target/HtmlReport.html",
                            "json:target/JsonReport.json",
                            "junit:target/XmlReport.xml"}
)
public class TestRunner {
}
