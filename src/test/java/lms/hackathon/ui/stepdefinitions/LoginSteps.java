package lms.hackathon.ui.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.hackathon.ui.pageobjects.LoginPage;
import lms.hackathon.ui.utilities.TestContextSetUp;

public class LoginSteps {

	public LoginPage loginpage;
	TestContextSetUp testContSetup;
	


	public LoginSteps(TestContextSetUp testContSetup) {
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();
		

	}

	
}