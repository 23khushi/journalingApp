#Journaling Web Application

Welcome to the **Journaling Web Application**, a secure and private platform for storing personal journal entries. Built using **Spring Boot** and **MongoDB**, this app uses **End-to-End Encryption (E2EE)** to ensure that your notes are private and only accessible by you. Your journal entries are encrypted on the client-side (browser/app) before being sent to the server, so even the server cannot read them.

## Key Features

- **Add New Journal Entries** (POST): Add a new encrypted journal entry to your account.
- **View Saved Journal Entries** (GET): Retrieve all your encrypted journal entries.
- **Update Existing Entries** (PUT): Modify an existing journal entry and update its content.
- **Delete Entries** (DELETE): Remove journal entries permanently.

### **Secure Data Storage**:
All journal content is encrypted on the client-side and stored as encrypted data in MongoDB, ensuring that no one—including the server—can access the original content of your journal.

## Technologies Used

- **Spring Boot**: Backend framework for building RESTful APIs.
- **MongoDB**: NoSQL database used for storing encrypted journal entries.
- **End-to-End Encryption (E2EE)**: Ensures that journal data is encrypted on the client side, preventing unauthorized access.
- **RESTful API**: Used to interact with the application using HTTP methods like GET, POST, PUT, and DELETE.

## API Endpoints

### 1. **Add a New Journal Entry** (POST)
- **Endpoint**: `/api/journal`
- **Method**: `POST`
- **Description**: Add a new journal entry with encrypted content.
- **Request Body**:
  ```json
  {
    "title": "My first journal entry",
    "content": "Encrypted content here"
  }
