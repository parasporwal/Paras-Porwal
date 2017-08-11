package com.testng.dataprovider.email;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/FirstFeature.feature",
				glue={"src/test/java/stepdef/StepDef"}
		
		)
public class CukeRunner extends AbstractTestNGCucumberTests{

} 
