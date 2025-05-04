# 📱Mobile App Login Automation (Appium + Java + TestNG)

> Project Description

> This project automates the login scenarios of the Sauce Labs demo mobile app using Appium, Java, and TestNG. It demonstrates a maintainable test structure using the Page Object Model (POM) design pattern and UIAutomator2 for Android automation. Build and dependency management are handled via Maven, and version control is managed with Git and GitHub.

## Built With
- Java
- Git/Github
- Maven
- TestNG
- Appium (UIAutomator2)
- Page Object Model (POM)

## Features
- Automation of valid and invalid login scenarios
- Scalable and modular test design using POM
- Organized test execution using TestNG
- Simple structure suitable for beginners and scalable for teams

## Demo
[Demo link](https://www.loom.com/share/f5609b5ba99045a09967558eca67cb50?sid=60772c93-c447-4c9e-8165-ef28d832a179)

### Prerequisites
- IDE, preferably Intellij but Eclipse should be fine too
## Getting Started
To get a local copy of the program running, follow these simple steps

### Install
- Java
- Android Studio
- Appium
- UIAutomator2


### Setup
- Open a command line terminal (Git bash preferably) and navigate to a directory where you would like to save the work folder using cd.
- Clone the repository with git clone https://github.com/wale-prog/E-Commerce_Mobile_Automation.git
- You will need appium to be able to run these scripts and since it is build in JS, you will need to first install Node. Checkout this [article](https://www.geeksforgeeks.org/installation-of-node-js-on-windows/) for guidance.
- Next is to install appium using the Command Line Interface ``npm install -g appium`` this [article](https://appium.io/docs/en/2.0/quickstart/install/) can be helpful
- Install UIAutomator2 driver using the Command Line Interface by running the following ``appium driver install uiautomator2`` this [article](https://appium.io/docs/en/2.4/quickstart/uiauto2-driver/) can be helpful
- Start Appium server by opening a terminal and run ``appium``
- Set up the Android emulator or connect a real device in developers mode and USB debugging turned on.
- Finally, open the project in your preferred IDE and wait for maven to download all project dependencies
    - navigate to the root directory and locate ``testng.xml`` file. Open, right-click anywhere within the file and select `Run`

### Output
- After the execution of the test, there will be two files generated.
    - Report: it will be located at Reports/. It is a HTML file that contains the status of each test case run with screenshots of failed test cases.
    - Logs: It will be located at src/test/java/utils/logs. It is a .log file that can be very useful to understand why there is an error and can proof invaluable in understanding how to fix errors.


## Author

👤 **Olawale Olapetan**

- GitHub: [@wale-prog](https://github.com/wale-prog)
- LinkedIn: [@walepetan](https://www.linkedin.com/in/walepetan/)
- Twitter: [@Wale_Petan](https://twitter.com/wale_Petan)


## 🤝 Contributing

Contributions, issues, and feature requests are welcome!


## Show your support

Give a ⭐️ if you like this project!

## Acknowledgments
- Shout out to [SauceLabs](https://saucelabs.com/) for the opportunity

## 📝 License

This project is [MIT](./LICENSE) licensed.
