## Description
The objective of this project is to establish a testing environment for the installation process of the CCleaner desktop application. The goal is to automate the process of downloading the application and testing its installer using a combination of Java, Selenide, Maven, Appium, and WinAppiDriver.

## Installation
#### Please note that it is expected that a user has prior knowledge of installing Java, Maven, Git, and setting up the necessary path and environment variables. Therefore, detailed instructions for these steps are not provided.
#### You can conveniently access and download all the necessary software by visiting the following link: [[Link](https://drive.google.com/drive/folders/1IaH37DKoRcgMAgLbEd4POCPa0D-hpYWx?usp=sharing)]
#### Alternatively, you can use the direct links provided below.


 1.  Windows 10 Home (x64) is used for testing purposes
 2.  Chrome browser - [[Link](https://www.google.com/intl/uk_ua/chrome/)]
 3.  Java 8 for Windows (x64) - [[Link](https://www.oracle.com/java/technologies/downloads/#java8-windows)], set up the environment variable as JAVA_HOME
 4.  Maven - [[Link](https://dlcdn.apache.org/maven/maven-3/3.9.2/binaries/apache-maven-3.9.2-bin.zip)], set up the environment variable as MAVEN_HOME
 5.  Git - [[Link](https://github.com/git-for-windows/git/releases/download/v2.41.0.windows.1/Git-2.41.0-64-bit.exe)], set up the path variable
 6.  WinAppDriver - [[Link](https://github.com/microsoft/WinAppDriver/releases/download/v1.2.1/WindowsApplicationDriver_1.2.1.msi)], after installation navigate to Settings -> For developers -> Enable developer mode
 7.  Node.js - [[Link](https://nodejs.org/dist/v18.16.0/node-v18.16.0-x64.msi)], Node.js is required for Appium
 8.  Appium. Open Power Shell and run the following commands
 - ```Set-ExecutionPolicy RemoteSigned```
 - ```npm i -g appium@next```
 - ```appium driver install --source=npm appium-windows-driver```
 - ```appium --base-path /wd/hub --relaxed-security``` Ensure that the Appium server starts successfully and remains in this mode.
 9. Clone the project from Github
 - ```cd C:\```
 - ```git clone https://github.com/oriahuzov/ccleaner.git```
 
 ## Testing
 1. Open a new tab for PowerShell
 2. Navigate to the project on the local storage - ```cd C:\ccleaner```
 3. Build and run the project - ```mvn clean test```
 
 ## Expected behavior
 1. The project should build successfully, and the tests should start executing.
 2. The Chrome browser should open automatically. It should navigate to the official CCleaner website, download the CCleaner installer, and then close the browser.
 3. The CCleaner installation process should begin automatically and complete successfully.
 4. After installation, the CCleaner application should remain open and ready for use.
 
 ## Tested guidelines
 1. (ACR-065) Show both links and assent language to the app's EULA and/or Terms of Service, Returns and Cancellation Policy, Privacy Policy.
 2. (ACR-040) Installation location is by default in standard locations, and identifies the name, source, and the actual install date.
 3. (ACR-046) Disclosures and options are conspicuous and visible without requiring scrolling or other user actions. The method to enable and disable options is clear and conspicuous.
 4. (ACR-055) Accept, cancel, skip, and decline options are obvious and/or explained to the consumer, consistently simple, and consistent across the install and offer experiences.

## Expected results
1. (ACR-065) - OK
2. (ACR-040) - OK
3. (ACR-046) - OK
4. (ACR-055) - NOT OK 
Note: To simulate a failure for the ACR-055 guideline, it was assumed that there should be a "Cancel" button on the CCleaner installer.

## Results storage
The test results are stored in the following directory: ```C:\ccleaner\target```
- ```result.txt``` contains information about the tested guidelines and their outcomes.
- Additionally, the folder includes screenshots in the format ```screen_ID.png```, which were captured during the test execution.
