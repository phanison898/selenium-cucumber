@spring
Feature: Spirng Boot App

  Scenario: Verify page title
		Given user opens spring boot website
		Then page content should be 'hello world!'
