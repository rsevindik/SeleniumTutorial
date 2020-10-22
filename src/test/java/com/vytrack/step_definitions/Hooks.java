package com.vytrack.step_definitions;


import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Empty hook before");
    }
    @Before ("@scenario_1") // only works for this special scenario
    public void specialSetup(){
        System.out.println("Special empty hook before");
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
        System.out.println("Empty hook after");
    }
    @After ("@scenario_1") // only works for this special scenario
    public void specialTearDown(){
        System.out.println("Special empty hook after");
    }
}
