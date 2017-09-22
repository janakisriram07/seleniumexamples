Feature: Login Action

Scenario Outline: Successful Login with Valid Credentials
Given User is on Home Page
When User enters "<username>" and "<password>"
Then Message displayed Login Successfully
Examples:
	|username|password|
	|yagna.bitspilani|1234|
	|yagna@elephant-tamers.com|1234|