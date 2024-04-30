Feature: trest
Scenario: Sort user by id
Given Admin is on Manage User page
When Admin clicks on ID sort icon
Then Admin should see User details are sorted by "ID" column "1"