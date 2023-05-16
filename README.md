<!-- # Web-Based-Mail-Server
## How to Run
  - Clone the repo
  - Open The backend folder as a Springboot project
  - run the project
  - Open the frontend folder as a Vue.js project
   ### Configure the app
     npm install
   ### Run the app
     npm run serve -->
# Web-Based Mail Application
This is a web-based mail application built using Vue.js framework for the front-end and Spring Boot Java for the back-end. The application includes the following features:

## Mails Manipulation
This section describes all the work needed for the mailing system.

Inbox Folder (default, priority)
Trash Folder: auto delete emails after 30 days.
Composing and Drafts.
Sent Mails Folder.
User Folders (Adding, Renaming, Deleting).
Filters: to filter mails according to subject or sender and direct them to a specific mail folder.
Searching and Sorting based on different attributes (Date, Sender, Receivers, Importance, Subject, Body, Attachments, . . . ).
Use the appropriate HTTP request types corresponding to the different CRUD operations for sending, retrieving and manipulating the emails. For example:

On creation, use POST request and send details in the request body.
On delete, use DELETE request, etc.
## Design
The application uses efficient JSON schema to store the email content and metadata required for retrieving emails and their folder organizations. The JSON schema will be evaluated for its efficiency and optimality.

The application uses the following design patterns:

* Filter design pattern to apply the filter feature
* Proxy design pattern for the sign-in
* Factory design pattern for different Binary search partitioning as the search based on different things such as subject, receiver, sender, etc.
* Facade design pattern to make handling the requests as clean as possible.
When sending an email to multiple receivers, a queue data structure is used to handle the sending to multiple receivers operation.

## Getting Started
To run the application, follow these steps:

1. Clone the repository
2. Navigate to the project directory
3. Run npm install to install the front-end dependencies
4. Run ./mvnw spring-boot:run to start the back-end server
5. Navigate to http://localhost:8080 in your browser to access the application.
## Contributing
If you would like to contribute to the project, please follow these steps:

1. Fork the repository
2. Create a new branch
3. Make your changes and commit them
4. Push your changes to your forked repository
5. Submit a pull request to the main repository for review.Web-Based Mail Application
