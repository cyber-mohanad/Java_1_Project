# Address Book Management System

## Overview

The Address Book Management System is a Java console-based application that allows users to manage their personal and professional contacts through an interactive, menu-driven interface. The project was built to demonstrate core object-oriented programming concepts along with the practical use of Java collections, specifically the ArrayList class, for storing and managing data in memory.

The application allows users to add, search, display, and delete contacts, while enforcing basic validation rules to keep the stored data consistent and reliable.

## Features

- Add a new contact.
- Assign a contact type (Family, Personal, Work, Other).
- Automatically validate contact type.
- Store multiple phone numbers for a single contact.
- Prevent duplicate phone numbers.
- Search contacts by name.
- Search contacts by phone number.
- Fuzzy name search that ignores vowels (for example, "Mohamed" and "Mohamad" can both be found).
- Delete contacts by name.
- Delete phone numbers individually.
- Automatically remove a contact if all of its phone numbers are deleted.
- Display all saved contacts.
- Simple menu-driven interface.

## Technologies Used

| Category             | Details                              |
|-----------------------|---------------------------------------|
| Language              | Java                                  |
| IDE                   | NetBeans                              |
| Data Structure        | ArrayList                             |
| Programming Paradigm  | Object-Oriented Programming (OOP)     |
| Interface             | Console                               |

## Project Structure

- **Contact class**: Represents a single contact entity. It stores the contact's name, contact type, and a list of associated phone numbers, along with the methods needed to manage that data.
- **Main class**: Contains the entry point of the application, the main menu logic, and the methods responsible for handling user input and calling the appropriate operations.
- **ArrayList<Contact>**: Acts as the in-memory storage for all contacts created during the program's execution. Since there is no database or file storage involved, this collection holds the entire state of the address book while the application is running.
- **Main menu**: A loop that continuously displays available options to the user and routes their choice to the corresponding operation.
- **CRUD operations**: The core functionality of the system, allowing contacts and phone numbers to be created, read, searched, and deleted.

## Program Workflow

1. Start the application.
2. Display the main menu.
3. The user selects an option from the menu.
4. The application performs the requested operation (add, search, delete, or display).
5. The program returns to the main menu, repeating the cycle until the user selects Exit.

## Object-Oriented Concepts

This project applies several fundamental object-oriented programming principles:

- **Classes**: The Contact class defines a blueprint for what a contact is and what data it holds.
- **Objects**: Each contact added by the user is created as an individual object of the Contact class.
- **Encapsulation**: Contact data, such as name, type, and phone numbers, is kept within the Contact class and accessed or modified through defined methods rather than direct manipulation.
- **Methods**: Behavior such as adding a phone number, removing a phone number, and validating contact type is implemented as methods within the relevant classes.
- **Collections**: The ArrayList is used both to store the list of contacts and to store the list of phone numbers within each contact, showcasing practical use of Java's Collections Framework.

## Search Algorithm

The application supports three different ways of locating a contact:

- **Direct phone number lookup**: Iterates through the list of contacts and their phone numbers to find an exact match.
- **Case-insensitive name search**: Compares the search input against stored contact names without considering letter casing, making the search more user-friendly.
- **Fuzzy search by removing vowels**: Before comparison, vowels are stripped from both the search term and the stored names. This allows the search to match names that are spelled slightly differently but sound similar, such as "Mohamed" and "Mohamad".

## Validation

To maintain data integrity, the application enforces the following rules:

- Duplicate phone numbers are not allowed within the same contact.
- If a contact type is entered incorrectly or does not match one of the predefined categories, it is automatically set to "Other".
- Contacts without at least one phone number are not saved, since a contact with no way to be reached is considered incomplete.

## Sample Menu

```
Welcome to our Address Book

1. Add new contact
2. Search by name
3. Search by number
4. Delete contact by name
5. Delete contact by number
6. Show all contacts
7. Exit
```

## Learning Outcomes

Building this project helped reinforce the following concepts:

- Java fundamentals
- OOP principles
- Working with ArrayList
- User input handling
- Search algorithms
- Data validation
- Console application design

## Future Improvements

- Save contacts to a file.
- Load contacts automatically on startup.
- Edit existing contacts.
- Sort contacts alphabetically.
- Search by contact type.
- Build a GUI version using JavaFX or Swing.
- Integrate a database for persistent storage.
- Export contacts to CSV.

## Author

**Name:** Mohanad Abu Ammar
**Major:** Cybersecurity Engineering Student
**GitHub:** https://github.com/mohanedaboemar123-lang
**LinkedIn:** https://www.linkedin.com/in/mohanad-abuammar
