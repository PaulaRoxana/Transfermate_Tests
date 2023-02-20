package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "classpath:/features",
    glue = "org.example.stepdefinitions",
    plugin = {
        "html:target/results.html",
        "message:target/results.ndjson",
        "json:target/jsonReport/cucumber.json"},
    tags = "@none")
public class RunCucumberTest extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = false)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
