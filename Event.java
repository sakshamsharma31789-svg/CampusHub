public class Event {

    int id;
    String title;
    String venue;
    int capacity;
    int registered;

    public Event(int id, String title, String venue, int capacity) {
        this.id = id;
        this.title = title;
        this.venue = venue;
        this.capacity = capacity;
        this.registered = 0;
    }

    public void show() {
        System.out.println(id + " | " + title + " | "
                + venue + " | " + registered + "/" + capacity);
    }
}
