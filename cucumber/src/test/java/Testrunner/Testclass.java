package Testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\java\\Simplebooks\\books.feature"},glue= {"Defination"},
dryRun = false,
tags="@Authenticate",
plugin={"html:Reportoutput/APIcucumber.html","junit:Reportoutput/APIcucumber.xml","json:Reportoutput/APIcucumber.json"})
public class Testclass {

}
