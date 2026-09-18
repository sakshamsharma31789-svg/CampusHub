import java.util.ArrayList;

public class Student {

    String id;
    String name;
    String department;
    ArrayList<Integer> events = new ArrayList<>();

    public Student(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public void show() {
        System.out.println(id + " | " + name + " | "
                + department + " | Events: " + events.size());
    }
}
