# ImmuniGuard Vaccine Management System

ImmuniGuard is a Hospital Management System. The system consists of four main services. Employee Service manages all employee details. Employee details can only be managed by Admins of the system. Admins has the ability to add, update, view, delete, assign shifts and request leaves of employees from the system. The Patient Service manages all patient details. A patient can add and search appointments. They also can get appointment bills, view test reports and lab reports. The Vaccination Management System manages the vaccine details of the hospital. Vaccine Management System can be accessed only by Admins. Admins and add, update, view, delete and search vaccination details. Finally, the Lab Test Management System manages all lab details of the hospital. Lab Test Manage can be accessed only by the admins and they can add, update, view, delete and search lab tests. The software is developed using Java Language and OSGi Framework.
The purpose of this application is to simplify the management of the employees and patients in a hospital. With its user-friendly interface and comprehensive features, ImmuniGuard allows healthcare providers to streamline their workflows, reduce administrative burdens, and enhance patient care.


## The system consists of three tiers:

1. Service Tier: This tier comprises of various bundles acting as producers, including the appointment producer, chemical producer, test report producer, lab test producer, and login producer.
2. Controller Tier: This tier comprises of bundles acting as both producers and consumers. It includes the patient consumer, lab assistant consumer, medical rep consumer, and technician consumer.
3. Presentation Tier: This tier acts as the main consumer and includes the main menu.

## Technologies Used

- Eclipse Plug-in OSGi Equinox (Open-Source Gateway Initiative) framework
- Java

## Features

- Patient management: The system allows managing patient details and appointments.
- Vaccine management: The system manages vaccine details, stock, and equipment stocks.
- Employee management: The system manages Employees, asign shifts and take leave requests.
- Appointment management: The system allows seeing patient appointments and approving appointments.


## Installation

1. Clone the repository: `git clone https://github.com/username/Medical_Lab.git`
2. Open Eclipse IDE and import the project.
3. Run the application as OSGI Framework.

## License

This project is licensed under the terms of the MIT License, which is an open source and free software license.
