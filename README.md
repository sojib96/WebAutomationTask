# Web Automation Task

This project is a comprehensive web automation framework designed to test the functionality of a sample e-commerce website [`SauceDemo`](https://www.saucedemo.com/). It utilizes Selenium WebDriver, TestNG, and the Allure reporting framework to provide robust and detailed test execution and reporting.
## Project Overview

The primary goal of this project is to automate various test scenarios on the SauceDemo website, ensuring the reliability and correctness of its features. The project covers key functionalities such as:

-   **Login Functionality:** Validating both valid and invalid login attempts.
-   **Add to Cart Functionality:** Testing the addition and removal of products from the cart.
-   **Checkout Process Validation:** Ensuring a smooth and successful checkout process.
-   **Sorting Products Validation:** Verifying the correct sorting of products based on different criteria.
-   **Logout Functionality:** Confirming the proper logout functionality.
-   **Locked-Out User Validation:** Handling and validating locked-out user scenarios.
-   **Cart Badge Count Validation:** Ensuring the cart badge accurately reflects the number of items in the cart.

## Technologies Used
- **Java:** Primary programming language for automation scripts.
- **Selenium WebDriver:** For automating browser interactions.
- **Maven:** For dependency management and project building.
- **TestNG:** For test management and execution.
- **Allure Framework:** For detailed and visually appealing test reports.
- **Lombok:** For reducing boilerplate code.
- **Gson:** For handling JSON data.
- **Log4j2:** For logging.

## Project Structure


The project is structured as follows:

```
allure-report/
├── index.html
src/
├── test/
│   ├── java/
│   │   ├── models/      
│   │   ├── pages/      
│   │   ├── tests/       
│   │   └── utils/      
│   └── resources/
│       ├── environment/ 
│       ├── testdata/    
│       ├── log4j2.xml  
│       └── testng.xml
```
-   `allure-report`: Allure report directory.
-   `src/test/java`: Test classes and utility classes.
    -   `models/`: Data models representing various entities (e.g., `ValidUserData`, `CheckoutData`).
    -   `pages/`: Page object classes representing different pages of the web application (e.g., `LoginPage`, `ProductPage`).
    -   `tests/`: Test classes containing TestNG test methods (e.g., `LoginFunctionalityTest`, `AddToCartFunctionalityTest`).
    -   `utils/`: Utility classes for common tasks (e.g., `DriverManager`, `DataUtils`).
-   `src/test/resources`: Test resources such as test data, environment configurations, and the TestNG XML configuration file.
    -   `environment/`: Environment-specific configuration files (e.g., `prod.json`).
    -   `testdata/`: JSON files containing test data (e.g., `validUserData.json`, `checkoutData.json`).
    -   `testng.xml`: TestNG suite configuration file.
    -   `log4j2.xml`: Log4j2 configuration file.
-   `pom.xml`: Maven project configuration file.
-   `Readme.MD`: Project documentation.

## Code Highlights and Skills Demonstrated

-   **Page Object Model (POM):** The project implements the Page Object Model design pattern, which enhances code maintainability and reusability. Each page of the web application is represented by a corresponding page object class (e.g., [`LoginPage`](src/test/java/pages/LoginPage.java), [`ProductPage`](src/test/java/pages/ProductPage.java)). This approach encapsulates the page's elements and actions, making the tests more readable and easier to update when the UI changes. Additionally, all test cases are organized within a dedicated test package, with each test implemented in a separate class to ensure better test structure and modularity ([`LoginFunctionalityTest`](src/test/java/tests/LoginFunctionalityTest.java)).
-   **Abstraction and Reusability:** The project includes a [`BasePage`](src/test/java/pages/BasePage.java) class that provides common methods for interacting with web elements. This class is extended by all page object classes, promoting code reuse and reducing redundancy.
-   **WebDriver Management:** The [`DriverManager`](src/test/java/utils/DriverManager.java) class manages the WebDriver instance, ensuring that it is properly initialized and closed after each test. It is designed to be thread-safe by implementing ThreadLocal, allowing parallel execution without conflicts. Additionally, it supports cross-browser testing, enabling test execution on Chrome, Firefox, and Edge while managing browser-specific configurations and capabilities.
-   **Utility Classes:** The project includes several utility classes (e.g.,[`DataUtils`](src/test/java/utils/DataUtils.java), [`SortingUtils`](src/test/java/utils/SortingUtils.java)) that provide common functionality used across the test suite.
-   **Data-Driven Testing (DDT):** The project utilizes data-driven testing to execute the same test scenarios with different sets of data. This is achieved by reading test data from JSON files (e.g., [`validUserData.json`](src/test/resources/testdata/validUserData.json), [`checkoutData.json`](src/test/resources/testdata/checkoutData.json)) and passing it to the test methods. This approach increases test coverage and reduces code duplication.
-   **Logging:** The project uses Log4j2 for logging test execution details. This helps in debugging and analyzing test results. The logging configuration is defined in [`log4j2.xml`](src/test/resources/log4j2.xml).
-   **Parallel Test Execution:** The TestNG configuration file ([`testng.xml`](src/test/resources/testng.xml)) is set up to run tests in parallel, reducing the overall test execution time.
-   **Reporting:** The project integrates with the Allure reporting framework to generate detailed and visually appealing test reports. These reports provide insights into test execution, including test results, execution time.


## Prerequisites

Before running the project, ensure you have the following installed:

- **Java Development Kit (JDK):** Version 17 or higher.
- **Maven:** Version 3.6 or higher.
- **Web Browsers:** Google Chrome, Mozilla Firefox, or Microsoft Edge.
- **Allure Command-Line Tool:** Required for generating and viewing Allure reports.

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/sojib96/WebAutomationTask.git
    cd WebAutomationTask
    ```

2. Open the project in your preferred IDE.



### Running the Tests Locally

1. Clean the projects using Maven:

    ```bash
    mvn clean
    ```

2. Run the test using Maven:

    ```bash
    mvn test -Dbrowser=chrome
   ```
   In case you want to run the tests in another browser, replace `chrome` with `firefox` or `edge`. By default, it will run in the `Chrome` browser if you do not specify anything.

### Generating the Allure Report

#### For Temporary Viewing (This will generate and open the Allure report in your browser for quick viewing)
1. Navigate to the `target` directory:
    ```bash
    cd target
    ```

2. Serve the Allure report temporarily:
    ```bash
    allure serve
    ```

#### For Sharing with Others (This will create a html file for viewing and sharing)
1. Generate the Allure report as a single file:
    ```bash
    allure generate target/allure-results --single-file
    ```

2. Open the generated report:
    ```bash
    allure open
    ```


##  Contributing

Feel free to submit issues, fork the repository, and create pull requests for any improvements.

## License

This project is licensed under the MIT License.
