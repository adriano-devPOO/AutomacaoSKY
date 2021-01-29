package com.sky.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = "src/test/resources/feature", 
				glue = {"com.sky.steps" }, 
				tags = "@funcionalidade", 
				plugin = { "pretty", "html:target/report-html", "json:target/report.json" }, 
				monochrome = true, 
				snippets = SnippetType.CAMELCASE, 
				dryRun = false, 
				strict = true
				)

public class Start {

}
