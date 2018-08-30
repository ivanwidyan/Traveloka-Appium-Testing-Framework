## Traveloka-Testing-Framework
Testing Framework for Traveloka Android and Web App

[![traveloka-icon](https://user-images.githubusercontent.com/12959761/44567746-109a0200-a79e-11e8-8e57-8bed67ac3087.png)](https://www.traveloka.com/en/)

This Traveloka framework is Java implementation of the [Appium](https://github.com/appium/appium)
framework and [Selenium](https://github.com/SeleniumHQ/selenium) software-testing framework with [TestNG](https://github.com/cbeust/testng) 
testing framework to create easy automate testing for Traveloka Android Application which written in Java & XML.

This testing framework is applying the automation build using [Maven](https://maven.apache.org/) and [Jenkins](https://jenkins.io/) 
with GitHub to help manage the deployment process so continuous integration for testing can be achieved.

### Development Technology
Included in `pom.xml` for maven dependency
* [Selenium](https://github.com/SeleniumHQ/selenium)
* [Appium](https://github.com/appium/appium)
* [TestNG](https://github.com/cbeust/testng)

### Build Automation Tools
* GitHub
* [Maven](https://maven.apache.org/)
* [Jenkins](https://jenkins.io/)

### Supported Platforms
* Android
* Web Application

### API Features
* Wait Get Element By ID, ClassName, XPath, CSSSelector
* Wait for Click Element By ID, ClassName, XPath, CSSSelector
* Wait to Send Keys Element By ID, ClassName, XPath, CSSSelector
* Wait to Get Elements By ID, ClassName, XPath, CSSSelector
* Wait Get Elements By ID, ClassName, XPath, CSSSelector (Support index)
* Wait Click Elements By ID, ClassName, XPath, CSSSelector (Support Index)
* Tap By Coordinates
* Swipe Vertically, Horizontally, & By Coordinates

### Suites Capabilities:
* Test Suites (Collection of Test Cases)
* Multiple Test Suites
* Parallel Execution (Multithreading) Test
* Multiplatform Parallel Execution Test (e.g. Android & Web at the same time)

### Functionality Capabilities:
**Splash Screen: (Android Only)**
* Select Country & Language
* Skip Splash Screen

**Home: (Android & Web)**
* Navigate to Flights
* Navigate to Log In and Register

**Member: (Android & Web)**
* Click Log In & Register

**Login: (Android & Web)**
* Login with Email, Facebook, & Google

**Search Flights: (Android & Web)**
* Set Origin, Destination, Departure Date, Passenger, Seat Class, & Return Date
* Swap Origin & Destination
* Return Switch
* Search Flights

**Select Flight: (Android & Web)**
* Sort By
* Print & Select Flight

**Booking Summary: (Android & Web)**
* Select

**Fill in Details - Book: (Android & Web)**
* Fill in Contact & Traveler Details
* Continue

### Examples
**Flight Purchase:**
* Selenium, Appium, TestNG Automation - Test FL_PR_001
[![Example_FL_PR_001](https://user-images.githubusercontent.com/12959761/44569569-0cbdae00-a7a5-11e8-9369-e6dde61e0fac.png)](https://youtu.be/vVNFc6-9pRs)

* Continuous Integration using Maven & Jenkins with GitHub - Test FL_PR_002 Example_FL_PR_002
[![Example_FL_PR_002](https://user-images.githubusercontent.com/12959761/44630067-5b746f00-a982-11e8-8fde-02aa9cd91a85.png)](https://youtu.be/6Zx3cgFN-74)

* Parallel Execution and Multithreading - Test FL_PR_001 & FL_PR_002
[![Parallel_Test](https://user-images.githubusercontent.com/12959761/44637859-e33b9700-a9dd-11e8-8505-c3403d626536.png)](https://youtu.be/fSANbFw6QFY)

### Authors
Ivan Widyan - Creator & Developer (ivanwidyan@yahoo.com)