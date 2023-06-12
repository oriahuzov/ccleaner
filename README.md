### Description

The objective of the project is to utilize Java, Selenide, Appium, and WebAppDriver to create an automated system for downloading and installing the CCleaner desktop application.

### Installation

Please be aware that the assumption is that the reviewer possesses prior knowledge of installing Java, Maven, and Git. As a result, we do not provide detailed instructions for these steps.

To obtain all the necessary software, please access the following link: [[Link](https://drive.google.com/drive/folders/1IaH37DKoRcgMAgLbEd4POCPa0D-hpYWx?usp=sharing)] 

1. Windows 10 Home (x64) is required.
2. Install Java 8
3. Install Maven
4. Install Git
5. Install WinAppDriver, after installation navigate to Settings -> For developers - Enable developer mode
6. Install node.js (required for Appium)
7. Install Appium. Open PowerShell and run the following commands
- ```Set-ExecutionPolicy RemoteSigned```
- ```npm i -g appium@next```
- ```appium driver install --source=npm appium-windows-driver```
- ```appium --base-path /wd/hub --relaxed-security```
8. Ensure that the Appium server starts successfully and remains in this mode.
9. To clone the project from GitHub, navigate to the desired directory:
-  ```cd C:\```
-  ```git clone https://github.com/oriahuzov/ccleaner.git```

### Testing
To build and run the project, follow these steps:

1. Open a new tab in PowerShell.
2. Navigate to the project's local storage location using the command: ```cd C:\ccleaner```.
3. Build and run the project using the command: ```mvn clean test```.

### Expected behavior

1. The project should build successfully, and the tests should start executing.
2. The Chrome browser should open automatically. It should navigate to the official CCleaner website, download the CCleaner installer, and then close the browser.
3. The CCleaner installation process should begin automatically and complete successfully. After installation, the CCleaner application should remain open and ready for use.

### Tested guidelines

1. (ACR-065) Show both links and assent language to the app's EULA and/or Terms of Service, Returns and Cancellation Policy, Privacy Policy.
2. (ACR-040) Installation location is by default in standard locations, and identifies the name, source, and the actual install date.
3. (ACR-046) Disclosures and options are conspicuous and visible without requiring scrolling or other user actions. The method to enable and disable options is clear and conspicuous.
4. (ACR-055) Accept, cancel, skip, and decline options are obvious and/or explained to the consumer, consistently simple, and consistent across the install and offer experiences.

### Expected results

1. (ACR-065) - OK
2. (ACR-040) - OK
3. (ACR-046) - OK
4. (ACR-055) - OK

### Results storage
The test results are stored in the following directory: ```C:\ccleaner\target```.
- The file ```result.txt``` contains detailed information about the tested guidelines and their outcomes.
- Additionally, the folder includes screenshots in the format ```screen_ID.png```, which were captured during the test execution.
