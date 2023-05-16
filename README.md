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

## Functionalities
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
## Design Patterns and Decisions
### Design Patterns Applied
The following design patterns have been applied in this web-based mail application:

1. Proxy design pattern to validate the user access to his email.
2. Factory design pattern to generate different instances from the type IPartition based on different types of sorting in the QSort class "Quick sort".
3. Immutable design pattern in the "Mail" class, so the user cannot modify the content of mail.
4. Facade design pattern to make it easier for the client code to deal with methods and classes.
5. Filter design pattern to search and filter.
### Design Decisions
The following design decisions were made in the development of this web-based mail application:

1. We used quick sort to sort the list of emails, as it is one of the most efficient sorting algorithms for large data sets.
2. Binary search was used to find the user data by their ID.
3. We used the filter design pattern for several purposes, including searching for an email based on different attributes, filtering messages by sender or receivers or both, searching for an existing contact, and searching for a contact to add.
4. Priority queue was used to sort mails by priority. The user sets the importance of the email message by clicking on the star symbol, and when the user decides to sort by importance, we use a priority queue.
5. JSON files were used to read and write a list of mails for each user from and to different folders, the list of users in our system, the contacts to each user folder, write the names of extra folders added by the user, and write the last ID of the last user signed up.
6. A queue was used to handle multiple receivers.
7. Auto-delete is supported, where messages in the trash folder are automatically deleted after 30 days.
By applying these design patterns and making these design decisions, the web-based mail application is efficient, secure, and user-friendly.
## User Guide
### Sign Up
To use the application, the user must sign up with a valid email address and password.
If the email address is already in use, the website will generate a warning message.
### Sign In
If the user is already in the database, they can sign in using their email address and password.
If either the email address or password is incorrect, the website will generate a warning message.
When the user signs in successfully, the webpage will display messages in the inbox folder.
### Folder Navigation
If the user clicks on any folder other than the inbox folder, the webpage will display the mails stored in that folder.
New folders can be created by clicking on the "Create new folder" button.
Existing folders can be renamed by clicking on the edit icon.
Folders can be deleted by clicking on the bin icon.
The extra folders are saved for each user.
### Sending Messages
To send a message, the user must click on the "New message" button and write their message in the window that appears.
The importance of each mail can be set by clicking on the star icon. Click on the star icon again to disable it.
If the message is not completed or not sent, it will automatically be moved to the draft folder.
To send a message to multiple recipients, enter their email addresses separated by commas.
### Managing Messages
If the user deletes a mail, it will automatically be moved to the trash folder.
After 30 days in the trash folder, the message will be deleted permanently.
To sort the mails, click on the sorting symbol and choose the type of sorting.
Filter is supported when the user clicks on the filter symbol. They must select the criteria they want to filter by.
Search by different attributes is supported, but the search is limited to the current folder only. To search, enter the search word next to the search symbol.
To move a mail to a different folder, click on the move icon.
By following this user guide, users can easily navigate and use the features of the web-based mail application.

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
