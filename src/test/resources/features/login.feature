Feature: Login

Scenario: Check warning message when user enters only username
	Given user opens sauce demo website
	When user enters only username
	And clicks login button
	Then "Password is required" warning should appear

Scenario: Check warning message when user enters only password
	Given user opens sauce demo website
	When user enters only password
	And clicks login button
	Then "Username is required" warning should appear
	
Scenario: Check warning message when user enters neither username nor password
	Given user opens sauce demo website
	When clicks login button
	Then "Username is required" warning should appear

Scenario: Check when user enters both username and password
	Given user opens sauce demo website
	When user enters correct username and password
	And clicks login button
	Then url should contains "inventory" string