# Address Book Management System

## Overview

The Address Book Management System is a Java console-based application that allows users to manage their personal and professional contacts through an interactive, menu-driven interface. The project was built to demonstrate core object-oriented programming (OOP) concepts along with the practical use of Java collections, specifically the `ArrayList` class, for storing and managing data in memory.

The application allows users to add, search, display, delete, and edit contacts, while enforcing basic validation rules to keep the stored data consistent and reliable.

**Version 2 note:** the project was refactored from a single monolithic file into a proper two-class OOP design. See [What's New in v2](#whats-new-in-v2) below for the full list of changes.

## Features

- Add a new contact.
- Assign a contact type (Family, Personal, Work, Other).
- Automatically validate contact type.
- Store multiple phone numbers for a single contact.
- Prevent duplicate phone numbers — both against existing contacts **and** within the same contact being created.
- Search contacts by name.
- Search contacts by phone number (shows all numbers for the matched contact).
- Fuzzy name search that ignores vowels (for example, "Mohamed" and "Mohamad" can both be found).
- Delete an entire contact by name.
- Delete an entire contact by one of its phone numbers.
- Remove a single phone number from a contact without deleting the contact (unless it was the last number).
- Automatically remove a contact if all of its phone numbers are deleted.
- Display all saved contacts.
- Nested, menu-driven console interface (Search and Delete each open their own sub-menu).

## Technologies Used

| Category       | Details                              |
| -------------- | ------------------------------------ |
| Language       | Java                                  |
| IDE            | NetBeans                              |
| Data Structure | ArrayList                             |
| Interface      | Console                               |
| Design         | OOP — two-class structure (`Contact`, `Main`) |

## Project Structure

- **`Contact.java`**: Represents a contact entity and now also owns all contact-related logic. It holds the contact's name, type, and phone numbers, and exposes static methods for adding, searching, deleting, and displaying contacts. The in-memory `ArrayList<Contact>` that stores every contact is a static field of `Contact` itself, so the class fully encapsulates its own data and behavior.
- **`Main.java`**: Contains only the entry point, the menu-printing logic, and input routing. It calls into `Contact`'s static methods rather than manipulating contact data directly — this is the core separation of concerns introduced in the refactor.
- **`ArrayList`**: Acts as the in-memory storage for all contacts created during the program's execution. Since there is no database or file storage involved, this collection holds the entire state of the address book while the application is running.
- **Main menu**: A loop that continuously displays available options to the user and routes their choice to the corresponding operation, including two nested sub-menus (Search, Delete).
- **CRUD operations**: The core functionality of the system, allowing contacts and phone numbers to be created, read, searched, and deleted.

## Program Workflow

1. Start the application.
2. Display the main menu.
3. The user selects an option from the menu (Search and Delete open a sub-menu with a "back" option).
4. The application performs the requested operation (add, search, delete, remove a number, or display).
5. The program returns to the main menu, repeating the cycle until the user selects Exit.

## Search Algorithm

The application supports three different ways of locating a contact:

- **Direct phone number lookup**: Iterates through the list of contacts and their phone numbers to find an exact match.
- **Case-insensitive name search**: Compares the search input against stored contact names without considering letter casing, making the search more user-friendly.
- **Fuzzy search by removing vowels**: Before comparison, vowels are stripped from both the search term and the stored names using a dedicated `delete_aioeu()` utility method. This allows the search to match names that are spelled slightly differently but sound similar, such as "Mohamed" and "Mohamad".

## Validation

To maintain data integrity, the application enforces the following rules:

- Duplicate phone numbers are not allowed within the same contact — checked both against already-saved contacts and against the numbers already entered for the contact currently being created.
- If a contact type is entered incorrectly or does not match one of the predefined categories, it is automatically set to "Other".
- Contacts without at least one phone number are not saved, since a contact with no way to be reached is considered incomplete.

## Sample Menu

```
——————————————————————————————————————————————————————————————————
Welcome to our Address book 😃
1. Add new contact.
2. Search About Contact.
3. Delete contact.
4. Remove Number of Contact.
5. Show all contacts.
6. Exit.
——————————————————————————————————————————————————————————————————
Please enter your choice:
```

Selecting **2** or **3** opens a sub-menu (by name / by number / back).

## What's New in v2

The project was rewritten to apply OOP principles properly and to fix a few edge cases from the first version:

- **Split into two files**: the old single-file design (one class holding everything, including a nested `Contact` class) is now `Contact.java` + `Main.java`, with `Contact` owning its own data and operations and `Main` handling only the UI/menu flow.
- **Cleaner class name**: the previous auto-generated class name was replaced with clear, purposeful class names (`Contact`, `Main`).
- **New nested menu structure**: Search and Delete used to be flat, separate top-level options; they're now grouped into their own sub-menus with a "back" choice.
- **New "Remove Number" operation**: previously, deleting a number from a contact and deleting the whole contact by number were the same operation. Now they're split: "Delete contact" removes the entire contact, while "Remove Number of Contact" removes just that one number (and only drops the contact if it has no numbers left).
- **Fixed a duplicate-number gap**: in v1, the duplicate check only looked at contacts already saved to the list, so the same number could be entered twice while building a brand-new contact. The check now also looks at the numbers already added to the contact currently being created.
- **Removed shared mutable state in search**: the vowel-stripping fuzzy search used to rely on a static string field that had to be manually reset before every menu loop. It's now a plain, self-contained method that takes a string and returns the result — no shared state, no reset logic needed.
- **Search by number now shows all of a contact's numbers**, not just the one that matched.
- **Consistent, friendlier console output** with unified message formatting.

## Learning Outcomes

Building this project helped reinforce the following concepts:

- Java fundamentals
- Object-oriented design and separation of concerns
- Refactoring away from shared mutable state
- Working with ArrayList
- User input handling
- Search algorithms
- Data validation
- Console application design

## Future Improvements (Roadmap)

Ideas for future versions of this project:

### Data Persistence
- Save/load contacts to a local file (`.txt` or `.csv`) using Java I/O (`FileWriter` / `BufferedReader`) so data survives after the program closes.
- Serialize `Contact` objects (`Serializable` + `ObjectOutputStream` / `ObjectInputStream`) for a quick binary save/load.
- Move to a real database (e.g. SQLite via JDBC) for structured storage and easier querying, instead of a plain in-memory `ArrayList`.

### Error Handling & Robustness
- Wrap menu input in try-catch to handle `InputMismatchException` when the user types letters instead of a number, instead of crashing.
- Add custom exceptions (e.g. `DuplicateNumberException`, `InvalidContactTypeException`, `ContactNotFoundException`) instead of just printing a message.
- Validate phone number format with a regex (digits only, min/max length) instead of accepting any string.
- Guard against empty/blank name input.

### Graphical User Interface (GUI)
- Rebuild the console UI as a desktop app with JavaFX or Swing — forms, buttons, and a contact list view instead of typing menu numbers.
- Add a search bar and contact cards instead of plain text output.

### Other Ideas
- Edit/update an existing contact's name, type, or numbers.
- Sort contacts (alphabetically, by type, or by number of phone numbers).
- Filter/list contacts by type (e.g. show only "Work" contacts).
- Export contacts to CSV or vCard (`.vcf`), and import from the same formats.
- Mark contacts as "Favorite"/pinned.
- Soft delete: move removed contacts to a "Recently Deleted" list with an undo option, instead of deleting permanently.
- Add an email field and/or a free-text notes field per contact.
- Add unit tests with JUnit to verify the add/search/delete logic.
- Basic security layer: encrypt the saved contacts file, or require a password/PIN before opening the address book.
- Package the project as a runnable `.jar` for easier sharing.
- Longer-term: a client-server or mobile (Android) version with cloud sync.

## Developer

**Name:** Mohanad Abu Ammar <br>
**Major:** Cybersecurity Engineering Student<br>
**Contact:** [LinkedIn](https://www.linkedin.com/in/mohanad-abuammar)
