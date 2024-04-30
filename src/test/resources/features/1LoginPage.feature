Feature: trial

Background: Admin should see the ManageUser heading on User Page
Given Admin is on dashboardpage after login
When Admin Clicks user from Navigation Bar
Then Admin Should see a heading Manage User

@tag29
Scenario: Check if the fields are updated with valid data
Given Admin is on Manage User page
And Admin is on  "User Details" popup window
When Admin enters "update single field" in the form and clicks on "Submit" button
Then Admin gets message "User updated Successfully " and see the updated values in data table

