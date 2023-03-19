# ImmuniGuard Vaccine Management System

ImmuniGuard is a OSGi Eclips plug-in designed to simplify the management of patient appointments, vaccine administration, and employee scheduling in healthcare facilities. With its user-friendly interface and comprehensive features, ImmuniGuard allows healthcare providers to streamline their workflows, reduce administrative burdens, and enhance patient care.

With ImmuniGuard, healthcare facilities can easily schedule patient appointments, manage vaccine inventory and administration, and track employee schedules and time off. The software also includes reporting and analytics features that enable providers to monitor their operations and identify areas for improvement.

Overall, ImmuniGuard is a valuable tool for healthcare providers looking to optimize their operations and provide high-quality care to their patients.

## The system consists of three tiers:

1. Service Tier: This tier comprises of various bundles acting as producers, including the appointment producer, chemical producer, test report producer, lab test producer, and login producer.
2. Controller Tier: This tier comprises of bundles acting as both producers and consumers. It includes the patient consumer, lab assistant consumer, medical rep consumer, and technician consumer.
3. Presentation Tier: This tier acts as the main consumer and includes the main menu.

## Technologies Used

- Eclipse Plug-in OSGi Equinox (Open-Source Gateway Initiative) framework
- Java

## Features

- Patient management: The system allows managing patient details and appointments.
- Inventory management: The system manages vaccine details, stock, and equipment stocks.
- Employee management: The system manages Employees, asign shifts and take leave requests.
- Appointment management: The system allows seeing patient appointments and approving appointments.


## Installation

1. Clone the repository: `git clone https://github.com/username/Medical_Lab.git`
2. Open Eclipse IDE and import the project.
3. Run the application as OSGI Framework.

## License

This project is licensed under the terms of the MIT License, which is an open source and free software license.
