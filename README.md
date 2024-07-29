
# Patient Medicine and Appointment System
## Overview
The Patient Medicine and Appointment System is a Java-based application developed using Spring Boot. It provides functionalities for managing patient information, scheduling appointments, and handling medication details. The frontend of the application is built using Thymeleaf, HTML, CSS, and JavaScript, creating a responsive and user-friendly interface.

## Table of Contents 
+ Features 
+ Technologies Used 
+ Setup and Configuration 
+ Running the Application 
+ API Endpoints 
+ Data Validation Rules 
+ Mandatory Information
## Features
+ ***User Registration and Authentication***: Secure registration and login functionalities.
+ ***Patient Management***: CRUD operations for patient information.
+ ***Appointment Scheduling***: Book, view, and manage appointments.
+ ***Medication Management***: Add, view, and manage patient medications.
+ ***Database Integration***: Persistent storage using JPA with entity mappings.
+ ***RESTful APIs***: Efficient data handling between frontend and backend.
+ ***Responsive Design***: User-friendly interface using Thymeleaf, HTML, CSS, and JavaScript.
+ ***Unit Testing***: Ensure code quality and reliability.

## Technologies Used 
+ Spring Boot 
+ Spring Security 
+ Spring Data JPA

+ Thymeleaf 
+ H2 Database (for development) 
+ MySQL (for production) 

## Setup and Configuration
1. Clone the repository:
 
git clone `https://github.com/yourusername/patient-medicine-appointment-system.git`

2. Set up the database:

Create a new database named patient_system.
Update the `application.properties`.

3. Build the project:

`mvn clean install`

## Running the Application
The application will be accessible at `http://localhost:8080`.

## API Endpoints
***User Registration and Authentication***

`GET /registration`: Show the registration form

`POST /registration`: Register a new user

***Patient Management***

`GET /home` -View the home page

`GET /displayMedicine` -View all medicines for the logged-in patient

`GET /addMedicine` -Show the form to add a new medicine

`POST /save` -Save a new medicine

`GET /medicineUpdateById` -Show the form to update medicine quantity

`PUT /saveUpdate` -Update the medicine quantity

***Doctor Management***
`GET /displayDoctors` -View all doctors

`GET /bookAppointment/{doctorId}` -Show the form to book an appointment with a doctor

***Appointment Management***

 `GET /appointment/{doctorId}` -Show the appointment form

`POST /saveAppointment` -Save a new appointment

`GET /displayAppointments` -View all appointments for the logged-in patient

## Data Validation Rules
+ Patient Registration 
  + firstName: Not empty 
  + lastName: Not empty 
  + email: Valid email format, not empty    
  + password: Not empty, minimum length of 6 characters
  + Medicine -name: Not empty 
  + quantity: Not empty, must be a positive integer

## Mandatory Information

`NOTE -`In this Project One User Configuration only available, So, there is no more ADMIN or CREDENTIAL Separate login Page. AS you, before you run my project You must add Insert table query for doctor details in your database that only you can see doctor availability in appointment section as well in this Document below, I will provide my Insert query You can Use it. When test my application.

## FrontEnd
In this project you can able to see FrontEnd as well as Documentation, and Screenshots 
## Acknowledgements
Special thanks to the Spring Boot, Thymeleaf, and MySQL communities for their excellent documentation and support.

---
Happy Coding!
