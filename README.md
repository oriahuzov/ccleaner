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
-  ```cd git clone https://github.com/oriahuzov/ccleaner.git```

### Testing
To build and run the project, follow these steps:

1. Open a new tab in PowerShell.
2. Navigate to the project's local storage location using the command: ```cd C:\ccleaner```.
3. Build and run the project using the command: ```mvn clean test```.
