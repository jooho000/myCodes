package Tree.Project6;

public class Project6Main {
    public static void main(String[] args) {
        SeparateChaining t = new SeparateChaining(5);
        t.insert(new Student(11,"Andrew"));
        t.insert(new Student(12,"Becky"));
        t.insert(new Student(21, "Chris"));
        t.insert(new Student(14,"Dog"));
        t.display();
        System.out.println("name of student with ID 21 is: " + t.search(21).data.getName());
    }
}
