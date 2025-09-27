📘 Project Overview

This repository contains a comprehensive Appium-based mobile automation framework developed for testing native and hybrid mobile applications on both Android and iOS platforms. Utilizing Java, TestNG, and Maven, the framework is designed to be scalable, maintainable, and easily integrable into Continuous Integration/Continuous Deployment (CI/CD) pipelines.

🔧 Technologies & Tools

Programming Language: Java 21

Automation Tool: Appium 2.x

Testing Framework: TestNG

Build Tool: Maven

Mobile Platforms: Android & iOS

Browser Drivers: Android Emulator, Xcode Simulator

CI/CD Integration: Jenkins (optional)

Version Control: Git

🛠️ Features

Cross-Platform Testing: Supports both Android and iOS devices.

Data-Driven Testing: Integrates with external data sources like CSV or Excel files for parameterized tests.

Page Object Model (POM): Implements the POM design pattern for better code organization.

Parallel Test Execution: Configured for parallel test execution to reduce test suite runtime.

Screenshots on Failure: Captures screenshots upon test failure for better debugging.

Test Reports: Generates detailed HTML reports using TestNG listeners.

📂 Project Structure
AppiumMobileAssignment/
│
├─ src/main/java/       # Reusable utility classes, POM classes
├─ src/test/java/       # Test classes
├─ src/test/resources   # Test input files (CSV, Excel)
├─ reports/             # TestNG and automation reports
├─ pom.xml              # Maven dependencies
└─ README.md            # Project documentation

🚀 Installation & Setup
Prerequisites

Ensure the following are installed:

Java JDK 21 or higher

Maven

Android Studio (for Android testing)

Xcode (for iOS testing)

Appium Server

Steps"

Clone the repository: git clone https://github.com/Visalatchi-Sambandam/AppiumMobileAssignment.git
                      cd AppiumMobileAssignment

Install dependencies: mvn clean install

Start the Appium server: appium

Run tests: mvn test


For parallel test execution, modify the testng.xml suite file to specify the desired number of threads.
