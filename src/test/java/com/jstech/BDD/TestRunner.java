package com.jstech.BDD;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.*;

@CucumberOptions (
        features = "./features/"
        ,glue = {"com.jstech.BDD.stepDef"}
        ,tags = {"@MMTFlightSearch"}
        ,monochrome = true)
public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner ;
    
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {    	
        testNGCucumberRunner = new TestNGCucumberRunner(TestRunner.class);
        System.out.println("Mai chl chuka hu");
    }

    @Test(dataProvider = "features")    
    public void feature(CucumberFeatureWrapper cucumberFeature) throws Throwable {
    	testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    	//testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
    }
    
    @DataProvider//(parallel=true)
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();    	
    	 //return testNGCucumberRunner.provideScenarios();
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {    	
        testNGCucumberRunner.finish();        
    }
}
