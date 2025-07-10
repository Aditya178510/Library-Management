
# 📚 Library Management System

The Library Management System is a console-based Java application built using Core Java, JDBC, PostgreSQL, and Apache Maven. It allows users to add, view, search, and delete books in a library database. The system is designed with multithreading for non-blocking logging and adheres to OOP principles and clean code practices.

---

## ✅ Features

- Add new books with ID, Title, Author, and Genre
- View all books in the library
- Search books by title or author
- Delete books by ID
- Multithreaded logging with timestamps
- Strict input validation for cleaner data
- JDBC-based DAO for database access
- Maven project structure for easy build and dependency management

---

## 🛠️ Technologies Used

- Java 17+
- PostgreSQL 15+
- JDBC 4.2
- Apache Maven 3.8.6+
- Multithreading (for logging)
- File I/O

---

## 📦 Project Structure

```
src/
└── main/
    └── java/
        └── com/
            └── aditya/
                └── library/
                    ├── Book.java              
                    ├── BookDBManager.java   
                    ├── BookLogger.java     
                    └── MainFile.java           
```

---

## 🗃️ Database Setup

### 1. Create Database

```sql
CREATE DATABASE librarydb;
```

### 2. Create Table

```sql
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(100) NOT NULL
);
```

---

## ⚙️ Configuration

In `BookDBManager.java`, update your PostgreSQL credentials:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/librarydb";
private static final String USER = "postgres";
private static final String PASSWORD = "12345";
```

---

## 🔧 How to Build and Run

1. Clone or download this repository.

2. Open in your favorite IDE (VS Code / IntelliJ / Eclipse).

3. Ensure Maven is properly configured and Java 17+ is installed.

4. Run this command in the project root directory (where `pom.xml` is located):

   ```bash
   mvn clean install
   ```

## 🧪 Sample Logs

Logs are saved in `library.log`:

```
[2025-07-09 23:18:23] Added book: Harry Potter
[2025-07-09 23:19:41] Deleted book ID: 1
```

> Logging runs in a separate thread to avoid UI blocking.

---

## 🔒 Input Validation

- Book ID: Must be a valid integer
- Title / Author / Genre: Cannot be empty or numeric
- Handles SQL and input exceptions gracefully

---

## 🧰 Dependency

Add this to your `pom.xml`:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.7</version>
</dependency>
```

---

## 👨‍💻 Developer Info

- Name: Aditya 
- Email: adityagundla08@gmail.com.com
- GitHub: Aditya178510

---

## 🙌 Contribution

Feel free to fork this project, suggest changes, and improve the system. Pull requests are welcome!

---

Happy Coding 📖
