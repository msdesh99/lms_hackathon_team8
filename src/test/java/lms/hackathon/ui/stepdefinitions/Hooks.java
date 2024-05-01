package lms.hackathon.ui.stepdefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import lms.hackathon.ui.utilities.TestContextSetUp;

public class Hooks {
	TestContextSetUp testContextSetUp;
	
	public Hooks(TestContextSetUp testContextSetup)
	{
		this.testContextSetUp = testContextSetup;
	}
	
	@After
	public void AfterScenario() throws Throwable
	{
		testContextSetUp.base.WebDriverManager().quit();
	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws Throwable
	{
		WebDriver driver =testContextSetUp.base.WebDriverManager();
		if(scenario.isFailed())
		{
			//screenshot
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}

	}

}
