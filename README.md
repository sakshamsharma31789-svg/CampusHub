# CampusHub

CampusHub is a console-based Java application for managing campus students and events.

## Features
- Add students
- Create events
- View students and events
- Register students for events
- Prevent duplicate registration
- Check event capacity
- Search events by title or venue
- View registration report
- Save important actions to a log file

## Technologies
- Java
- ArrayList
- Exception Handling
- File I/O
- Object-Oriented Programming

## How to Run

Open the project folder in VS Code and run:

```bash
javac *.java
java CampusHub
```

## Project Structure

- CampusHub.java - main menu and application workflow
- Student.java - student data
- Event.java - event data
- CampusException.java - custom exception
- RegistrationService.java - registration and searching logic
- FileLogger.java - file logging

## Testing

Test normal operations, duplicate students, invalid capacity, missing students/events, duplicate registration, full events, event search, and invalid numeric input.
