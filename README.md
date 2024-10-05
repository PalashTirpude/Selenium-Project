
## Getting Started

### Prerequisites

- **Java 8+**: Ensure that JDK is installed and properly set up.
- **Maven**: Install Maven to manage dependencies and run tests.
- **WebDriver**: Ensure the appropriate WebDriver executables (Chrome, Edge) are available in the `driver-resources/` folder.
  
### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/PalashTirpude/Selenium-Project.git
    ```

2. Navigate to the project directory:
    ```bash
    cd Selenium-Project
    ```

3. Install the dependencies:
    ```bash
    mvn clean install
    ```

### Running Tests

- To run tests for **LetCode**, use the following command:
    ```bash
    mvn test -DsuiteXmlFile=test-suites/letcode.xml
    ```

- To run tests for **MakeMyTrip**, use the following command:
    ```bash
    mvn test -DsuiteXmlFile=test-suites/makemytrip.xml
    ```

### Test Reports

- After the test execution, reports will be generated in the `reports/` directory.
- You can view detailed execution reports for each test suite in their respective folders.

### Project Configuration

- **Browser Drivers**: Place the `chromedriver.exe` and `msedgedriver.exe` files in the `driver-resources/` directory.
- **Test Suites**: Modify the TestNG suite files (`letcode.xml`, `makemytrip.xml`) to add or remove test cases.

### Dependencies

This project uses the following dependencies, managed via Maven:

- **Selenium**: For browser automation.
- **TestNG**: For test case management and execution.
- **WebDriverManager** (optional): To automatically manage browser drivers.

Refer to the `pom.xml` for the full list of dependencies.

## Authors

- **Palash Tirpude** - *Initial work* - https://github.com/PalashTirpude
