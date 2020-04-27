package TestRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import ProjectUtility.GenerateExtentReport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		 monochrome = true,
    features = {
        "src/test/resources/Features"
    },
    glue = {
        "StepDefination"
    },
    tags = {
          "@APIStatusCodeCheck,"
        + " @APIStatusCodeCheckwithPastDate,"
        + " @JSONResponseCheck,"
        + " @IncorrectAPIsStatuscodeCheck,"
        + " @JSONResponseonSpecificdate,"
        + " @JSONResponseforfutureDate"
    		//"@JSONResponseforfutureDate7"
    })
public class MyTestRunner {
	@AfterClass
	 public static void extentReportExecution() {
		
		GenerateExtentReport generateReport = new GenerateExtentReport();
		generateReport.setupExtendReport();
 
	}
}