import java.util.ArrayList;
import java.util.Scanner;

public class CampusHub {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Event> events = new ArrayList<>();

    static int nextEventId = 1001;

    static RegistrationService service =
            new RegistrationService(students, events);

    public static void main(String[] args) {

        System.out.println("===== CAMPUSHUB =====");

        while (true) {

            showMenu();
            int choice = readInt();

            try {
                switch (choice) {

                    case 1:
                        addStudent();
                        break;

                    case 2:
                        createEvent();
                        break;

                    case 3:
                        viewStudents();
                        break;

                    case 4:
                        viewEvents();
                        break;

                    case 5:
                        registerStudent();
                        break;

                    case 6:
                        searchEvent();
                        break;

                    case 7:
                        report();
                        break;

                    case 8:
                        System.out.println("Bye!");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (CampusException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void showMenu() {
        System.out.println("\n1. Add Student");
        System.out.println("2. Create Event");
        System.out.println("3. View Students");
        System.out.println("4. View Events");
        System.out.println("5. Register Student");
        System.out.println("6. Search Event");
        System.out.println("7. Report");
        System.out.println("8. Exit");
        System.out.print("Choice: ");
    }

    static void addStudent() throws CampusException {

        System.out.print("ID: ");
        String id = sc.nextLine().trim();

        if (id.isEmpty())
            throw new CampusException("Student ID can't be empty!");

        if (service.findStudent(id) != null)
            throw new CampusException("Student already exists!");

        System.out.print("Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Department: ");
        String department = sc.nextLine().trim();

        students.add(new Student(id, name, department));

        FileLogger.log("Student added: " + id);

        System.out.println("Student added!");
    }

    static void createEvent() throws CampusException {

        System.out.print("Title: ");
        String title = sc.nextLine().trim();

        if (title.isEmpty())
            throw new CampusException("Title can't be empty!");

        System.out.print("Venue: ");
        String venue = sc.nextLine().trim();

        System.out.print("Capacity: ");
        int capacity = readInt();

        if (capacity <= 0)
            throw new CampusException("Capacity must be positive!");

        Event event = new Event(
                nextEventId++,
                title,
                venue,
                capacity
        );

        events.add(event);

        FileLogger.log("Event created: " + event.id);

        System.out.println("Event created with ID " + event.id);
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }

        System.out.println("\n--- STUDENTS ---");

        for (Student student : students)
            student.show();
    }

    static void viewEvents() {

        if (events.isEmpty()) {
            System.out.println("No events yet.");
            return;
        }

        System.out.println("\n--- EVENTS ---");

        for (Event event : events)
            event.show();
    }

    static void registerStudent() throws CampusException {

        System.out.print("Student ID: ");
        String studentId = sc.nextLine().trim();

        System.out.print("Event ID: ");
        int eventId = readInt();

        service.register(studentId, eventId);
    }

    static void searchEvent() {

        System.out.print("Search keyword: ");
        String keyword = sc.nextLine().trim().toLowerCase();

        boolean found = false;

        for (Event event : events) {

            if (event.title.toLowerCase().contains(keyword)
                    || event.venue.toLowerCase().contains(keyword)) {

                event.show();
                found = true;
            }
        }

        if (!found)
            System.out.println("Nothing matched.");
    }

    static void report() {

        int total = 0;

        for (Event event : events)
            total += event.registered;

        System.out.println("\n--- REPORT ---");
        System.out.println("Students: " + students.size());
        System.out.println("Events: " + events.size());
        System.out.println("Total registrations: " + total);
    }

    static int readInt() {

        while (true) {

            try {
                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
