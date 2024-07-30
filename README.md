# Getting Started with Flight Status Web App

## Overview

Flight Status Web App is a cutting-edge, real-time flight information dashboard designed to provide up-to-the-minute flight statuses for Indigo Airlines. This sophisticated web application offers a responsive and intuitive interface, ensuring seamless access to critical flight data across various devices.

Key Features:

1. Dynamic Flight Status Updates: Our system continuously monitors flight information, refreshing the dashboard every 30 seconds to display the most current data.
2. Instant Notifications: Users receive immediate alerts via email and SMS when flight statuses change, leveraging Spring Mail Service for email communications and Twilio for SMS functionality.
3. Mobile-Optimized Design: The responsive layout ensures a consistent and user-friendly experience across desktop and mobile platforms.
4. Sleek User Interface: A modern, cloud-themed design enhances readability and user engagement.

## Technologies Used

### Frontend
- React.js
- Styled-components for CSS-in-JS
- Axios for API requests

### Backend
- Java
- Springboot

### Database
- MongoDB

## Technical Implementation:
### Frontend:

- React.js: The core framework for building the user interface, enabling a component-based architecture for efficient rendering and state management.
- Styled-components: Utilized for CSS-in-JS styling, allowing for dynamic and scoped styling of components.
- Axios: Employed for making HTTP requests to the backend API, facilitating real-time data fetching.
- useEffect and useState Hooks: Implemented for managing component lifecycle and state, particularly for handling data fetching and updates.

### Backend:

- Spring Boot: Powers the server-side application, providing a robust framework for building and deploying Java-based services.
- RESTful API: Designed to serve flight data to the frontend, following REST principles for scalable and maintainable architecture.
- Spring Mail Service: Integrated for sending email notifications, configured to work with SMTP servers for reliable email delivery.

Our backend architecture comprises four robust Java-based APIs, designed to seamlessly integrate with the frontend via React and Axios:

- GET /api/flights: Retrieves comprehensive flight details, including unique identifiers, airline information, status, gate assignments, and scheduled times.
- POST /api/flights: Facilitates the addition of new flight entries to the system.
- PATCH /api/flights/update: Enables real-time updates to existing flight information.
- POST /api/customers: Manages customer data associated with specific flights, storing essential information such as name, email, and phone number.

These APIs are built with a focus on efficiency and reliability, ensuring smooth data flow between the frontend and backend. The customer registration feature (API #4) is particularly noteworthy, as it enables targeted notifications. Customers are associated with specific flights, allowing for personalized status updates via SMS or email. This tailored approach enhances user experience by providing relevant, timely information to each traveler.

### Notification System:

- Twilio API Integration: Implemented for SMS notifications, allowing real-time text message alerts to users' mobile devices.
- Asynchronous Processing: Notification sending is handled asynchronously to prevent delays in the main application flow.

### Data Management:

- Scheduled Tasks: Implemented using Spring's @Scheduled annotation to periodically fetch and update flight data from external sources.
- Caching Mechanism: Employed to optimize performance and reduce load on external APIs.

### Security:

- CORS Configuration: Implemented to secure cross-origin requests between the frontend and backend.
- API Key Authentication: Used for securing endpoints and managing access to sensitive operations.

This technical stack ensures a scalable, maintainable, and high-performance application capable of handling real-time data processing, instant notifications, and a responsive user interface. The architecture is designed to accommodate future expansions and integrations with minimal modifications to the existing codebase.

## What more can be added

1. Spring Actuator: Can integrate Actuator for application health monitoring and metrics collection.
2. ELK Stack (Elasticsearch, Logstash, Kibana): Can implement for centralized logging and log analysis.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Node.js (v14.0.0 or later)
- npm (v6.0.0 or later)
- Java 17

## Setup:

Frontend:
- Clone the repository.
- Install the dependencies.
- Do 'npm start'

Backend:
- Clone the repository.
- Build the project
- Run the project.

## Database Functionality
- Create a database with name 'flight'.
- Make two collections
  1. customers
  2. flights
- Add the data for flights, like flight no, status etc.
For eg:
   {
        "flight_id": "6E 2349",
        "airline": "Indigo",
        "status": "Delayed",
        "departure_gate": "A13",
        "arrival_gate": "B7",
        "scheduled_departure": "2024-07-26T14:00:00Z",
        "scheduled_arrival": "2024-07-26T18:00:00Z",
        "actual_departure": null,
        "actual_arrival": null
    }
- Add the data for customers.
For eg:
    {
       "flightId": "6E 2346",
       "name": "Sarthak",
       "email": "sample@email.com",
       "phone": "+919999999999"
     }

Please find below the basic layout and small functionality of the web app.

1. Frontend Design:
   
![image](https://github.com/user-attachments/assets/f92a4b89-2d58-4774-b4a7-49907ff1a0cd)


2. Change the status of the flight through Postman

![image](https://github.com/user-attachments/assets/92905004-38fd-403c-b602-a8894007db38)

3. Email Update Notification:

![Untitled](https://github.com/user-attachments/assets/78197d04-83d8-45d7-bb31-eb7692414734)

4. SMS Notification

![image](https://github.com/user-attachments/assets/e89ab7eb-0ed8-4239-aa5e-2076cc25ba2b)

5. Status update on site

![image](https://github.com/user-attachments/assets/8be2e68c-3f61-4a27-8d21-6d2f65148f4c)



  
