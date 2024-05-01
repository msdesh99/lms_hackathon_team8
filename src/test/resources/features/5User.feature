#@usersanity
Feature: User Page Validation

Background: Admin should see the ManageUser heading on User Page
Given Admin is on dashboardpage after login
When Admin Clicks user from Navigation Bar
Then Admin Should see a heading Manage User

# *******************By Sayali *******************************************
@tag48
Scenario: Admin should see the +Assign Student popup
Given Admin is on Manage User page
When Admin clicks "Assign Student" button
Then Admin should able to see Assign Student popup

@tag49
Scenario: Validate radio button in Assign Student Form 
Given Admin is on Manage User page
When Admin clicks "Assign Student" button
Then Admin should see two radio button for Status

@tag50
Scenario: Validate input fields and their text boxes in Assign Student form 
Given Admin is on Manage User page
When Admin clicks "Assign Student" button
Then Admin should see User Role as R03 with other mandatory fields

# ***********************BY Sayali ***************************************8 
@tag1E
Scenario: Admin should see the +Add New User popup
Given Admin is on Manage User page
When Admin clicks "Add New User" button
Then Admin should able to see "Add New User" popup

@tag18
Scenario: Validate User Details Popup Window
Given Admin is on Manage User page
When  Admin clicks "Add New User" button
Then  Admin checks "userdetailsfields" in the form

@tag19
Scenario: Validate input fields and text boxes in user details form
Given Admin is on Manage User page
When  Admin clicks "Add New User" button
Then  Admin checks "textboxes" in the form

@tag20
Scenario: Validate input fields and text boxes in user details form
Given Admin is on Manage User page
When  Admin clicks "Add New User" button
Then Admin checks "dropdowns" in the form

@tag21
Scenario: Check if user is created when only mandatory fields are entered with valid data
Given Admin is on Manage User page
And Admin is on  "Add New User" popup window
When Admin enters "user mandatory fields" in the form and clicks on "Submit" button
Then Admin gets message "User added Successfully"

@tag21Extra 
Scenario: Check if user is created when only mandatory fields are entered with valid data
Given Admin is on Manage User page
And Admin is on  "Add New User" popup window
When Admin enters "user mandatory fields negative" in the form and clicks on "Submit" button
Then Admin gets message "Failed"

@tag22Extra
Scenario: Check if user is created when only optional fields are entered with valid data
Given Admin is on Manage User page
And Admin is on  "Add New User" popup window
When Admin enters "skip text%" in the form and clicks on "Submit" button

#When Admin enters "skips all mandatory fields" in the form and clicks on "Submit" button
#When Admin enters "skip one field" in the form and clicks on "Submit" button

Then Admin should see error message below the test field and the field will be highlighed in red color

@tag22
Scenario: Check if user is created when only optional fields are entered with valid data
Given Admin is on Manage User page
And Admin is on  "Add New User" popup window
When Admin enters "skips all mandatory fields" in the form and clicks on "Submit" button
Then Admin should see error message below the test field and the field will be highlighed in red color

@tag23
Scenario: check if user is created when invalid data is entered in all of the fields
Given Admin is on Manage User page
And Admin is on  "Add New User" popup window
When Admin enters "invalid data" in the form and clicks on "Submit" button
Then Admin gets error message and user is not created

#@tag24
#Scenario: Empty form submission
#Given Admin is on Manage User page
#And Admin is on  "Add New User" popup window
#When Admin enters "without data" in the form and clicks on "Submit" button
#Then Admin should see error message below the test field and the field will be highlighed in red color

@tag25
Scenario: Validate Cancel/Close(X) icon on User Details form
Given Admin is on Manage User page
And Admin is on  "Add New User" popup window
When Admin clicks Cancel Close Icon on User Details form
Then User Details popup window should be closed without saving

@tag26
Scenario: Check if user is created when only mandatory fields are entered with valid data
Given Admin is on Manage User page
And Admin is on  "Add New User" popup window
When Admin enters "user mandatory fields" in the form and clicks on "Cancel" button
Then User Details popup window should be closed without saving

#@tag27
#Scenario: Check if the user details are added in data table
#Given Admin is on Manage User page
#And Admin is on  "Add New User" popup window
#When Admin enters "all fields" in the form and clicks on "Submit" button
#Then The newly added user should be present in the data table in Manage User page

@tag28
Scenario: Validate row level edit icon
Given Admin is on Manage User page
When Admin clicks on the edit icon 
#Then A new pop up with User details
Then  Admin checks "userdetailsfields" in the form


@tag29
Scenario: Check if the fields are updated with valid data
Given Admin is on Manage User page
And Admin clicks on the edit icon 
#And Admin is on  "User Details" popup window
When Admin enters "update all fields" in the form and clicks on "Submit" button
Then Admin gets message "User updated Successfully " and see the updated values in data table
#BUG --- Reocrds get updated with duplicate phone no and email address sending failed message


@tag30
Scenario: Check if the fields are updated with valid data
Given Admin is on Manage User page
And Admin clicks on the edit icon 
#And Admin is on  "User Details" popup window
When Admin enters "update all fields invalid" in the form and clicks on "Submit" button
Then Admin gets message "will not get any message " and see the old values in data table
#Bug--- Admin not able to see error message. popup window get refreshed with old data

@tag31
Scenario: Check if the fields are updated with valid data
Given Admin is on Manage User page
And Admin clicks on the edit icon 
#And Admin is on  "User Details" popup window
When Admin enters "update all mandatory fields" in the form and clicks on "Submit" button
Then Admin gets message "User updated Successfully " and see the updated values in data table

@tag32
Scenario: Check if the fields are updated with valid data
Given Admin is on Manage User page
And Admin clicks on the edit icon 
#And Admin is on  "User Details" popup window
When Admin enters "update optional without email" in the form and clicks on "Submit" button
Then Admin gets message "User updated Successfully " and see the updated values in data table
#BUG --- Reocrds displays Email Id required error message and record is not updated

@tag32A 
Scenario: Check if the fields are updated with valid data --------BUG
Given Admin is on Manage User page
And Admin clicks on the edit icon 
#And Admin is on  "User Details" popup window
When Admin enters "update optional with email" in the form and clicks on "Submit" button
Then Admin gets message "User updated Successfully " and see the updated values in data table
#BUG --- Reocrds accepts any Email Id and updated record and not able to know email ID is updated or not sending user updated successfully

@tag33
Scenario: Check if the fields are updated with valid data
Given Admin is on Manage User page
And Admin clicks on the edit icon 
#And Admin is on  "User Details" popup window
When Admin enters "update all text fields number" in the form and clicks on "Submit" button
Then Admin gets message "User updated Successfully " and see the updated values in data table
#Bug--- displays Email Id is required message. after submiting popup window get refreshed with old data

@tag34
Scenario: Check if the fields are updated with valid data
Given Admin is on Manage User page
And Admin clicks on the edit icon 
#And Admin is on  "User Details" popup window
When Admin enters "update all text fields special char" in the form and clicks on "Submit" button
Then Admin gets message "User updated Successfully " and see the updated values in data table
#Bug--- displays Email Id is required message. after submiting popup window get refreshed with old data

@tag35
Scenario: Sort user by id
Given Admin is on Manage User page
When Admin clicks on ID sort icon
Then Admin should see User details are sorted by "ID" column "1"

@tag36
Scenario: Sort user by id
Given Admin is on Manage User page
When Admin clicks on ID sort icon
Then Admin should see User details are sorted by "Name" column "2"
#Bug---- not in proper order

@tag37
Scenario: Sort user by name
Given Admin is on Manage User page
When Admin clicks on ID sort icon
Then Admin should see User details are sorted by "Location" column "3"
#Bug---- not in proper order


#@tag5
#Scenario: Admin should see the +Assign Student button
#Given Admin is on Manage User page
#When Admin clicks "Assign Student" button
#Then Admin should able to see "Assign Student" popup