package lms.hackathon.ui.stepdefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.Assert;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.hackathon.ui.pageobjects.UserPage;
import lms.hackathon.ui.utilities.FilloExcel;
import lms.hackathon.ui.utilities.TestContextSetUp;

public class UserSteps {
	
	public UserPage userPage;
	public TestContextSetUp testContextSetUp;
	
	public UserSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		userPage = testContextSetUp.pageObjManager.getUserPage();
	}
	
	@Given("Admin is on dashboardpage after login")
	public void admin_is_on_dashboardpage_after_login() throws InterruptedException {
	    String userName = testContextSetUp.base.configs.getUserName();
	    String password = testContextSetUp.base.configs.getPassword();
	    userPage.login(userName, password);
	}
	@When("Admin Clicks user from Navigation Bar")
	public void admin_clicks_user_from_navigation_bar() throws InterruptedException {
		userPage.navigate();	   
	}
	@Then("Admin Should see a heading Manage User")
	public void admin_should_see_a_heading_manage_user() {
		System.out.println(userPage.validate());	   
	}
	
	@Given("Admin is on Manage User page")
	public void admin_is_on_manage_user_page() throws InterruptedException {
		//System.out.println("handle");
		//userPage.getHandle();
	}
	@When("Admin clicks {string} button")
	public void admin_clicks_button(String button) throws InterruptedException {
		userPage.locateButton(button);	    
	}
	@Then("Admin should able to see {string} popup")
	public void admin_should_able_to_see_popup(String validateButton) {
	    
	}
	/*
	@Then("Admin should able to see all {string}")
	public void admin_should_able_to_see_all(String listType, DataTable dataTable) {
		List<String> expectedList = dataTable.asList(String.class);
        List<String> actualList = new ArrayList<String>();
		
        if(listType.contains("Fields"))
			 actualList =  userPage.validatePopUp();
		if(listType.contains("TextBoxes"))
			actualList = userPage.validateTextBoxes();			
		
		List<String> absentText = actualList.stream()
  					.filter(s->!expectedList.contains(s))
  					.collect(Collectors.toList());
		if(absentText.size()==0) System.out.println("Sceanrio for validation of DropDown boxes is PASSED");
		for(String absent: absentText)
				System.out.println("absent: "+absent);
		//Assert.assertEquals(absentText.size(),0,"Some Fields are missing in popup window");		
	}*/
	@Given("Admin is on  {string} popup window")
	public void admin_is_on_popup_window(String button) {
		try {
			userPage.locateButton(button);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}	    
	}
	@When("Admin enters {string} in the form and clicks on {string} button")
	public void admin_enters_in_the_form_and_clicks_on_button(String runType, String actionType) throws InterruptedException {
		//System.out.println("runty: "+runType+ " mat: "+ runType.matches("update.*"));
		if(runType.matches("update.*")) 
			userPage.updateUser(runType,actionType);
		else
		   userPage.addUser(runType,actionType);
		
	}
	
	@Then("Admin checks {string} in the form")
	public void admin_checks_in_the_form(String runType) throws InterruptedException {
	   String fileName = System.getProperty("user.dir")+"/src/test/resources/testdata/usertestdata.xlsx";
  	   String sheetName ="UserSheet";
  	   Map<String,String> dataMap = new HashMap<String,String>(); 	
  	   if(runType.contains("userdetailsfields")|| 
  			   runType.contains("dropdowns"))
  	   dataMap = FilloExcel.getSingleData(fileName,sheetName,"userdetailsfields");

  	   List<String> actualList = new ArrayList<String>();
  	   //List<String> dropList = new ArrayList<String>();
       Map<String,String> actualMap = new HashMap<String,String>();
    	 if(runType.contains("userdetailsfields") ||
    			 runType.contains("dropdowns")) {
             // actualList =  userPage.validatePopUp();
              actualMap = userPage.isPopUpDisplayed(runType);
    	 }       	 
    	// else actualList = userPage.validateTextBoxes();
    	 else actualMap = userPage.isTextBoxedisplay();
        for(Map.Entry<String, String> map: actualMap.entrySet()) {
          if(map.getKey()!=null)	{
 	    	//System.out.println(runType +" : Is Display: "+ map.getKey() +" : "+map.getValue());
           
        	Assert.assertTrue(map.getValue().equalsIgnoreCase("true"));
          }	
        }
    	 
  	  /* for(String box: actualList){
  		  // System.out.println("act: "+box);
  		   //System.out.println("expe: "+ dataMap.get(box));
	    System.out.println("Actual: "+box +" Expected: "+dataMap.get(box));
        
  	   Assert.assertTrue(box.equalsIgnoreCase(dataMap.get(box)));
  	   }*/
  	   Thread.sleep(1000);
		//userPage.addUser(runType,"NoAction");
	}


	@Then("Admin gets message {string}")
	public void admin_gets_message(String expectedmessage) throws InterruptedException {
	        userPage.validateAddUser();
	}

	@Then("Admin can see the User details popup disappears without adding any user")
	public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() throws InterruptedException {
		userPage.validateAddUser();
	   
	}
	@Then("Admin should see error message below the test field and the field will be highlighed in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() {
		//userPage.validateTextField();
	}

	@When("Admin clicks Cancel Close Icon on User Details form")
	public void admin_clicks_cancel_close_x_icon_on_user_details_form() {
		userPage.clickClose();
	  
	}

	@Then("User Details popup window should be closed without saving")
	public void user_details_popup_window_should_be_closed_without_saving() {
		System.out.println(userPage.validate());	
		Assert.assertTrue(userPage.validate().matches(".*Manage User.*"));

	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
	    userPage.selectEditUser();
	}

	@Then("A new pop up with User details")
	public void a_new_pop_up_with_user_details() {
	   
	}
	@Then("Admin gets error message and user is not created")
	public void admin_gets_error_message_and_user_is_not_created() throws InterruptedException {
		//userPage.validateAddUser();

	   
	}
	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {
	}
	
	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) throws InterruptedException {
		userPage.validateAddUser();
		
	}
	@Then("Admin gets message {string} and see the old values in data table")
	public void admin_gets_message_and_see_the_old_values_in_data_table(String string) throws InterruptedException {
		userPage.validateUpdateInvalidData();

 
	}

// ******************************** By Sayali********************************
	@Then("Admin should able to see Assign Student popup")
	public void admin_should_able_to_see_assign_student_popup() {
		userPage.validateAssignStudentPopUp();
		Assert.assertEquals(userPage.validatePopUpSavebtn(), true);
	    Assert.assertEquals(userPage.validatePopUpClosebtn(), true);
	    Assert.assertEquals(userPage.validatePopUpCancelbtn(), true);	
	}
	
	@Then("Admin should see two radio button for Status")
	public void admin_should_see_two_radio_button_for_status() {
	    Assert.assertEquals(userPage.validateAssignStudentRadio(), true);
	}
	@Then("Admin should see User Role as R03 with other mandatory fields")
	public void admin_should_see_user_role_as_r03_with_other_mandatory_fields(){
		userPage.validateAssignStudentPopUp();
	      // userPage.validateAssignStudentPopUpFields();
			Assert.assertEquals(userPage.validateStudentRoleIddisplay(), true);
			Assert.assertEquals(userPage.validateStudentEmaildisplay(), true);
			Assert.assertEquals(userPage.validateStudentProgramdisplay(), true);
			Assert.assertEquals(userPage.validateStudentBatchdisplay(), true);
			Assert.assertEquals(userPage.validateStudentStatusdisplay(), true);			
	}

	

}
