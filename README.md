# OrangeHRM – Add Employee Hybrid Automation Framework

## Overview
Hybrid Automation Framework developed using Selenium WebDriver with Java to automate the Add Employee workflow in the OrangeHRM web application. The framework follows Page Object Model (POM) and data-driven testing principles.

## Application Under Test
- Application: OrangeHRM
- URL: https://opensource-demo.orangehrmlive.com
- Module: PIM → Add Employee

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Apache POI (Excel)

## Framework Features
- Hybrid Automation Framework
- Page Object Model (POM)
- Data-driven testing using Excel
- Configuration management using properties file

## Project Structure
src/test/java
  ├── base
  ├── pages
  ├── tests
  └── utils

src/test/resources
  ├── config.properties
  └── EmployeeData.xlsx

## Test Flow
1. Launch browser
2. Login to OrangeHRM
3. Navigate to PIM module
4. Add employee using Excel data
5. Validate application behavior
6. Close browser

## How to Run
- Run using TestNG or Maven command:
