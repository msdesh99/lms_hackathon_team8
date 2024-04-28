package lms.hackathon.ui.utilities;

import lms.hackathon.ui.pageobjects.PageObjectManager;

public class TestContextSetUp {
	
	public PageObjectManager pageObjManager;
	public Base base;
	
	public  TestContextSetUp() throws Throwable {
		base = new Base();
		pageObjManager = new PageObjectManager(base.WebDriverManager(), base.getConfigs());
	}
}
