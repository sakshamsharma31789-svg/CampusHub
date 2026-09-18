import java.util.ArrayList;

public class RegistrationService {

    private ArrayList<Student> students;
    private ArrayList<Event> events;

    public RegistrationService(ArrayList<Student> students,
                               ArrayList<Event> events) {
        this.students = students;
        this.events = events;
    }

    public Student findStudent(String id) {
        for (Student s : students) {
            if (s.id.equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public Event findEvent(int id) {
        for (Event e : events) {
            if (e.id == id) {
                return e;
            }
        }
        return null;
    }

    public void register(String studentId, int eventId)
            throws CampusException {

        Student student = findStudent(studentId);
        Event event = findEvent(eventId);

        if (student == null)
            throw new CampusException("Student not found!");

        if (event == null)
            throw new CampusException("Event not found!");

        if (student.events.contains(eventId))
            throw new CampusException("Already registered!");

        if (event.registered >= event.capacity)
            throw new CampusException("Event is full!");

        event.registered++;
        student.events.add(eventId);

        FileLogger.log(studentId + " registered for event " + eventId);

        System.out.println("Registered successfully!");
    }
}
