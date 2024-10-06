package com.options;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features =
        "src/test/java/com/features",
        plugin = "json:target/jsonReports/cucumber-report.json",
        glue = {"com/stepDefinitions"}
         )
public class TestRunner {
//    tags = "{@AddPlaceAndDelete}"

    /*

    How to Start the jenkins server
    1. launch the Command prompt Change the directory to the jenkins war file path
    2. java -jar jenkins.war -httpPort=9090 --- use this command to start the server
    3. next launch the browser try to hit localhost 8080
    4. There you have to login and enter in to there
    Note:-
    This command will help you to trigger @AddPlaceAndDelete jenkins build
    mvn test -Dcucumberoptions='--tags @AddPlaceAndDelete'
     */



}
