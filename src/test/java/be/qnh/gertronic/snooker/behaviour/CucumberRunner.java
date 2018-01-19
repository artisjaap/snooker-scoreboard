package be.qnh.gertronic.snooker.behaviour;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true
        , features="classpath:features"
        , glue = "be.qnh.gertronic.snooker.behaviour"
        )
public class CucumberRunner {

}
