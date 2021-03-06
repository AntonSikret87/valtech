![Valtech logo](http://i.imgur.com/32Oipl4.png "Valtech logo")

QA exercise
==============================

Overview
--------

We are interested in your approach to the following problems.

Please do the test in Selenium with a proper Object Oriented Programming
language using automated testing best practices. This is expected to
take no more than 1 hour. 

Getting started
---------------
Fork this project.

Commit each exercise once you've finished with it.

Exercise #1
-----------
- Create Page Object Model framework for www.valtech.co.uk to do the exercise 2 & 3 
- Driver manager pattern. We should be able to run the test framework against Chrome, Firefox and Microsoft Edge browsers
  
Exercise #2
-----------
Navigate to www.valtech.co.uk HOME PAGE
- Assert that the “Partners” section is displaying
- Click on "Our Partners"button on the Partners page  
- Capture and Print a list of all the partners across industries in the test report or to the console 

Exercise #3
-----------
- a. Navigate to Uk Public sector 
- b. Verify and print a list of all public sector customers in the test report or to the console 
- Click on Talk to Us and verify if it navigates to Contact us page 

Exercise #4
-----------
README file - Include instructions on how to set up and execute your tests on a clean install of Windows/MacOS
Bonus point: Test execution on Docker instances 

Finish up
---------
Once you're finished, commit & push your changes, send us a link to your fork.




How to set up and execute tests 
==============================
- set java (download and set 'environment variables')
- set maven (download and set 'environment variables')
- set allure (download and set 'environment variables')

for allure execute: allure serve {path to allure-results} (for example : allure serve project_path\valtech\allure-results)


Drivers
---------
Drivers located in 'drivers' folder
- firefox  ver 68.9
- chrome   ver 84
- edge     ver 84

Uncomment row with needed browser for run (default  <parameter name="browser" value="chrome"/>) in testng.xml

Run
---------
right click on testng.xml file and run it
or
execute coommand in Terminal:
"mvn clean test"




