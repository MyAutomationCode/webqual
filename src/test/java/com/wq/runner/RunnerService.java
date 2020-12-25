package com.wq.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Work\\workspace\\Automation\\eclipse\\Moneytap-WQ\\src\\test\\java\\com\\wq\\features", //path of the feature files
				glue={"com.wq.stepdefinations"}, //path of the step definition files
				dryRun=false, //verify all mappings between feature files and step-definitions when flag is true without executing test scripts.
				monochrome=true, //give output in readable format
				tags= "@smoke") 
public class RunnerService extends AbstractTestNGCucumberTests {
}