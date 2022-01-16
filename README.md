# Customer Data Platform - NTH Energy Supplier

This application **Customer Data Platform - NTH Energy Supplier** is the desktop application where admin users can log into the system. Admins can perform all their everyday tasks such as storing the information about tariffs, customers, payments, invoices etc. Admin users can also add other admin users to access this application. 

© 2022. All Rights Reserved.

## Technology Stack and libraries
```sh
- JavaFX
- CSS
- JUnit
- SMTP Email
- iText PDF
```

## Getting Started
- Clone the repo and open the project in IntelliJ or any IDE. [Clone Repo](https://github.com/ashwingrg11/NTHEnergy)
- Install JavaFX and Maven
- Open Login.java file from the java/application/ directory.
- Run

## Built With

- [JavaFX](https://openjfx.io/) - Fully Featured Toolkit
- [Maven](https://maven.apache.org/) - Dependency Management

## Dependencies and plugins

```sh
"itextpdf": "5.5.13.2",
"javafx-controls": "17.0.0.1",
"javafx-fxml": "17.0.0.1",
"javafx-web": "17.0.0.1",
"tilesfx": "11.48",
"junit-jupiter-api": "5.7.1",
"maven-compiler-plugin": "3.8.1",
"javafx-maven-plugin": "0.0.7"
```
## Folder Structure

```sh
nthenergy/
|-- data/
|-- extra/
|-- invoices/
|-- src/
    |-- main
        |-- java
            |-- controllers
                |-- AdminController.java
                |-- CustomerCardController.java
                |-- DashboardController.java
                |-- InvoiceController.java
                |-- LoginController.java
                |-- MeterReadingController.java
                |-- TariffController.java
            |-- core
                |-- enums
                |-- Exceptions
                |-- GeneratePdf.java
                |-- Helper.java
                |-- SendEmail.java
                |-- Serialization.java
            |-- models
                |-- Customer.java
                |-- CustomerCard.java
                |-- Invoice.java
                |-- MeterReading.java
                |-- Tariff.java
                |-- User.java
            |-- Login.java
        |-- resources
            |-- application
                |-- assets
                    |-- css
                    |-- icons
                    |-- images
                |-- views
|-- tests/
    |-- customers
    |-- tariffs
    |-- resources
```
Each of these directories have special types of files and logics:

**` models/ `**
This folder is used to store all the model files of this application. Various getter and setter methods as well as other business logics are written in the model classes. Model classes such as Customer, User, Invoice, and Tariff are created in this directory.\

**` views/ `**
The views folder reflects the views of the application. Each view inside this folder has its own screen.\
A scene will contain children from master layout and they are integrated in a scene together..

**` controllers/ `**
This directory contains controller classes for all modules. Controller class basically handles user requests, communicate with the model and helper classes, and update the views accordingly. User actions such as clicking a button, editing user details are handled in the controllers.

**` assets/ `**\
The assets folder contains images, relevant files and css folder for styling. In this project architecture, we are using global styling with CSS file. .

**` core/ `**\
The core folder is just a place to locate some utility and helper functions that used repeatedly in the project. Files in the utils folder should only contain some functions like date formatting, string conversion, data validations, etc. This folder also includes other utility classes such as generating pdf, sending email, and object serializations.

**` Login.java `**\
This is the index file and starting point of the project, from which this project starts.

**` tests/ `**\
This folder contains the JUnit test cases for this project. Currently, there are two test cases written, one is for customer card serialization test and another one is for validating the tariff object which is return by the getByTariffId function of Tariff model. This folder also contains resources folder, in which generated/essential data files or resources for the test cases are stored to run the test cases.

## Running the tests and Test files
- Open unit tests from tests/ folder.
- Files available for unit tests are,
  - CustomerCardSerializationTest
  - TariffGetByTariffIdTest
- Click on run tests from the test case classes.

## Previews
<img width="797" alt="login" src="https://user-images.githubusercontent.com/89626432/149674043-f7d9e8c1-cca5-4dea-ba58-691ac442c67d.png">

<img width="1103" alt="dashboard" src="https://user-images.githubusercontent.com/89626432/149674038-026caecb-5cb0-402a-9053-7bc8de4c6424.png">

<img width="1099" alt="new-tariff" src="https://user-images.githubusercontent.com/89626432/149674110-d9199e46-6094-4f27-b85e-11e50b11bf93.png">

<img width="1098" alt="all-invoices" src="https://user-images.githubusercontent.com/89626432/149674105-3b3a51ce-c4c0-411a-9c9c-a57c780c0604.png">

<img width="1103" alt="invoice-details" src="https://user-images.githubusercontent.com/89626432/149674117-a7f9d92e-0fdc-43f7-b99d-dcdd296ebbdd.png">



