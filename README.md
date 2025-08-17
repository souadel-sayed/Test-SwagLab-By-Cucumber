# Swag Labs Automation Testing (Cucumber + Selenium + Java)

## 📌 Project Overview
This project automates end-to-end testing of the **Swag Labs application** using **BDD with Cucumber** and **Selenium WebDriver**.  
It follows the **Page Object Model (POM)** design pattern to ensure reusability and maintainability.  

## 🛠 Tech Stack
- **Java**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **JUnit/TestNG**
- **Extent Reports**

## 📂 Project Structure
- **Features**: Gherkin-based feature files describing scenarios.  
- **Step Definitions**: Implementation of Gherkin steps with Selenium.  
- **Page Objects**: Encapsulates UI elements and actions.  
- **Hooks**: For setup and teardown.  
- **Utils**:  
  - `GenericUtils`: Custom functions (click, type, navigate, scrollToElement).  
  - `Waits`: Soft & hard waits.  
  - `Assertions`: Soft and hard assertion handling.  

## 🚀 How to Run
1. Clone the repository  
   ```bash
   git clone <repo-link>
📊 Reporting

Extent Reports are integrated for detailed execution reports.

✅ Features Tested

Login functionality

Product selection and adding to cart

Checkout process

Information form submission
