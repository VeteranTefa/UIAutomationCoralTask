Feature: Customer Login
Scenario: Login for Customer
Given customer access to website
When customer click login
And select a name and click login button 
And make a deposit 1000 and withdraw 400 confirm on balance 
And click transaction button and show result
And confirmation about transaction type of withdraw
Then after all the successful processes, will close the browser

