# Employee_Management_System

### Description <br />
This is a Core Java application integrated with MySQL for managing employee records. The system provides the following features: <br />

Add Employee: Create a new employee record with an auto-generated primary key.<br />
Edit Employee: Use the primary key to update existing employee details. If the employee doesn't exist, a new record is created.<br />
Delete Employee: Remove an employee's record from the database using the primary key.<br />
Read Employee: Retrieve and display employee details using the primary key.<br />

### Database Design <br />
The application uses two tables: <br />

Department: Stores department names and primary keys.<br />
Employee: This column stores employee details, including name, age, and department. The department column is a foreign key referencing the Department table.<br />

### Key Features <br />
Auto-generation of primary keys for employee records. <br />
The foreign key relationship between Employee and Department tables. <br />
Robust exception handling for database operations. <br />
Automatic creation of a new record if the primary key is not found during update operations. <br />

### Technologies Used <br />
Core Java for backend logic. <br />
MySQL for database storage. <br />
JDBC for database connectivity. <br />
