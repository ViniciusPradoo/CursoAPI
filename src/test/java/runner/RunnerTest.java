package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources",
		snippets = SnippetType.CAMELCASE,
		tags = {},
		glue = {"steps"},
		plugin = { "json:target/reports/CucumberReport.json", "pretty" },
		monochrome = true
		)

public class RunnerTest {
	


}
