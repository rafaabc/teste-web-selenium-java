# Framework of Automated Tests with Selenium WebDriver, Java, JUnit 5 and Maven
[![Build](https://github.com/rafaabc/teste-web-selenium-java/actions/workflows/sonar.yml/badge.svg)](https://github.com/rafaabc/teste-web-selenium-java/actions/workflows/sonar.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=rafaabc_teste-web-selenium-java&metric=alert_status)](https://sonarcloud.io/dashboard?id=rafaabc_teste-web-selenium-java)

<p align="justify"> To consolidate the knowledge that I have been acquiring on the subject, I created this practical example
of an automated web testing framework built with SeleniumWebdriver + Java. </p>

<p align="justify"> I used the test site http://the-internet.herokuapp.com/login to simulate the following scenarios: </p>

1. Login successfully
2. Attempt to log in with an invalid user
3. Attempt to log in with an invalid password
4. Attempt to login without passing any credentials

<p align="justify"> I created 2 test classes with the same scenarios: one with
the use of Page Object design pattern and the other does not. I used the Data-driven testing approach to
populate a .csv file with the mass of data. In addition to being able to run the tests via the command line with the help of the plugin
Surfire, it was possible to verify the results with the help of Allure Report, a test report framework.
 </p> 

# Requirements

Tools:
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download)
- [Java SE Development Kit 8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)
- [Allure](https://github.com/allure-framework/allure2/releases/tag/2.13.8)

Dependencies:
- [JUnit 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.7.0)
- [Selenium Webdriver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59)

# Directory Structure

```
./project
├─ src/
    ├─ main
    └─ test/
       └─ java/
           ├─ pages/
           ├─ suporte/
           └─ test/
                ├─ LoginTest
                └─ LoginPageObjectTest
       └─ resources/
```


- src: main directory
- main: directory with application source code
- test: directory where the initial test script will be built
- java: default directory created as soon as we start a project
- pages: package containing the PageObject-oriented classes
- support: package containing the classes that help in basic scripts
- test: package containing the created test classes
- LoginTest: test class containing the first test script in a basic way
- LoginPageObjectTest: test class containing the same test script but with Page Object design pattern
- resources: directory with the .csv files with mass data


# Running via command line
<p align="justify"> To run the tests via the command line of all test classes in the project: </p>

` mvn surfire:test`

<p align="justify"> Once the tests are executed, a folder will be created inside the "target" directory, called "surefire-reports". </p>

# Report
<p align="justify"> To open the Allure test report via the command line: </p>

`allure serve /PATH`*

<p align="justify"> *The path must be changed to the path of the "surefire-reports" folder created in the previous step. </p>
