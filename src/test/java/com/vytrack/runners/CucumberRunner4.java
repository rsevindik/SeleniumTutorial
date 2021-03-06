package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)  // has to be on the top of the class. it's the
@CucumberOptions(
     features = "src/test/resources/features",
     glue = "com/vytrack/step_definitions", //also refer to the hooks (it's stored) and can go to any StepDefinitionClass
     dryRun = false,  // it should be false during execution but make it true while implementing new feature
     tags = "@scenario_outline",//"@add_car",//"@login",//"@negative_login or @parametrized_test", // to execute only this scenario but if you delete it or assign to "" empty then you can execute the whole scenarios
     //since we move @login to the top of Feature: then each scencario will run @login .!!
     plugin = "json:target/cucumber4.json",
     publish = false // to get the report in cloud.!!
)
public class CucumberRunner4 {

}
