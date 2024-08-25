Meeting Room Management System

Project Overview
This project is a Meeting Room Management System designed to manage users, meeting rooms, and booked meetings in a company. It tracks the users who attend meetings and supports multiple roles: Admin, Manager, and Member. The project includes responsive web pages with a dynamic UI, using HTML, CSS, JavaScript, and Bootstrap for the frontend, Java for the backend, and SQL for the database.

Features
User Roles: Admin, Manager, and Member with specific access levels.
Admin: Create, edit, and manage meeting rooms.
Manager: Book meeting rooms, invite members, and manage credits.
Member: View upcoming meetings.
Responsive UI with Bootstrap and animations for a seamless user experience.
Automatic credit updates for managers every Monday.

Technologies Used

Frontend:
HTML: Structure of web pages.
CSS: Styling and animations (Bootstrap for responsive design).
JavaScript: Client-side scripting.

Backend:
Java: Handles business logic and server-side operations.

Database:
SQL: Manages user information, meeting rooms, bookings, and members.
Installation
Prerequisites
To run this project, ensure you have the following software installed:

Java Development Kit (JDK) 8 or higher: Download here
Apache Maven: For building and managing dependencies.
MySQL or PostgreSQL: For the database. Install and configure one as per your choice.
Git: To clone and manage the project repository.
Steps to Set Up
Clone the Repository

bash
Copy code
git clone https://github.com/your-username/meeting-room-management-system.git
cd meeting-room-management-system
Backend Setup (Java)

Navigate to the backend directory.
Build the project using Maven:
bash
Copy code
mvn clean install
Set up the database connection in application.properties (or similar config file), providing the credentials for your MySQL/PostgreSQL instance.
Database Setup (SQL)

Run the SQL scripts provided in the /database directory to create the necessary tables and populate initial data:
sql
Copy code
CREATE DATABASE meeting_management;
USE meeting_management;
-- Execute the provided SQL scripts
Frontend Setup

No additional setup is needed for the frontend. The static HTML, CSS, and JavaScript files are located in the /frontend directory.
Run the Project

Start the backend server (Java).
Access the frontend by opening index.html in your browser.
Database Schema
The project contains four primary tables:

Users: Stores information about all users (Admin, Manager, Member).
MeetingRooms: Manages details about available meeting rooms.
BookedMeetings: Tracks meetings that have been scheduled.
MeetingRoomMembers: Records which users are invited to which meetings.
Refer to the SQL scripts in the /database directory for detailed table structures.

Usage

Admin
Manage meeting rooms (create, edit, delete).
View all created meeting rooms.

Manager
Book meeting rooms.
Invite members to meetings.
View booked meetings and manage credit balance.

Member
View all meetings they are invited to.
Future Integration: Connecting Frontend and Backend

If in the future you want to connect the frontend with the backend, the following technologies and steps should be used:
Technologies:
REST API: Use Java’s Spring Boot framework to build RESTful APIs that will handle HTTP requests (GET, POST, PUT, DELETE) between the frontend and backend.
AJAX/Fetch API: Use JavaScript (Fetch API or Axios) to send requests from the frontend and handle responses from the backend.
JSON: Exchange data between frontend and backend in JSON format.
Integration Steps:
Build RESTful APIs in Java (Spring Boot):

Define endpoints for user authentication, meeting room management, bookings, etc.
Use Spring Boot controllers to expose these APIs.
Frontend API Calls:

Use JavaScript to send HTTP requests (GET, POST, etc.) to the backend API endpoints.
Implement error handling and display appropriate messages on the frontend based on the backend responses.
Connect Frontend and Backend:

Set up CORS in your Spring Boot project to allow requests from your frontend.
Integrate the frontend with backend endpoints by making API calls during user interactions (e.g., form submissions, page loads).
Testing:

Test the integration to ensure data flows correctly between frontend and backend.
Perform unit and integration tests for the APIs.
