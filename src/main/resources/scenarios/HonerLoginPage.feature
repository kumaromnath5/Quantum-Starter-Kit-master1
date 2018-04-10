@Honer_login

Feature: verify i am logedin to honer page

@Verify_the_entered_userid_password_are_correct 

Scenario: Verify I am able to login on facebook

Given I am on huaweiHonor home page of India

And I  enter user id "komal.jha26@gmail.com"

And  I enter password "Komal@123456"

Then I click on login button 

Then  I login successfully
 
Then I logout from Facebook page

@NegativeTest

 
Scenario Outline: Verify I am able to login on facebook with multiple crdential
 
Given I am on huaweiHonor home page of India
 
 And I enter "<username>" and "<password>"
 
 Then I click on login button 
 
 Then  I login successfully
 
 Then I logout from Facebook page
 
Examples 
|username  | password|
|kom.jha26 |PAss     |
|oman      |nath     |

 