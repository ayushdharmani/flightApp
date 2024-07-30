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

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Node.js (v14.0.0 or later)
- npm (v6.0.0 or later)
- Java 17

##Technical Implementation:
###Frontend:

React.js: The core framework for building the user interface, enabling a component-based architecture for efficient rendering and state management.
Styled-components: Utilized for CSS-in-JS styling, allowing for dynamic and scoped styling of components.
Axios: Employed for making HTTP requests to the backend API, facilitating real-time data fetching.
useEffect and useState Hooks: Implemented for managing component lifecycle and state, particularly for handling data fetching and updates.

###Backend:

Spring Boot: Powers the server-side application, providing a robust framework for building and deploying Java-based services.
RESTful API: Designed to serve flight data to the frontend, following REST principles for scalable and maintainable architecture.
Spring Mail Service: Integrated for sending email notifications, configured to work with SMTP servers for reliable email delivery.

###Notification System:

Twilio API Integration: Implemented for SMS notifications, allowing real-time text message alerts to users' mobile devices.
Asynchronous Processing: Notification sending is handled asynchronously to prevent delays in the main application flow.

###Data Management:

Scheduled Tasks: Implemented using Spring's @Scheduled annotation to periodically fetch and update flight data from external sources.
Caching Mechanism: Employed to optimize performance and reduce load on external APIs.

###Security:

CORS Configuration: Implemented to secure cross-origin requests between the frontend and backend.
API Key Authentication: Used for securing endpoints and managing access to sensitive operations.

This technical stack ensures a scalable, maintainable, and high-performance application capable of handling real-time data processing, instant notifications, and a responsive user interface. The architecture is designed to accommodate future expansions and integrations with minimal modifications to the existing codebase.

## What more can be added

1. Spring Actuator: Can integrate Actuator for application health monitoring and metrics collection.
2. ELK Stack (Elasticsearch, Logstash, Kibana): Can implement for centralized logging and log analysis.

