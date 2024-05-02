package lms.hackathon.ui.stepdefinitions;

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