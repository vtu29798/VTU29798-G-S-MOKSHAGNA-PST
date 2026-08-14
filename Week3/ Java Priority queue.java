import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(
            (a, b) -> {
                int c = Double.compare(b.getCGPA(), a.getCGPA());

                if (c != 0)
                    return c;

                c = a.getName().compareTo(b.getName());

                if (c != 0)
                    return c;

                return Integer.compare(a.getID(), b.getID());
            }
        );

        for (String event : events) {
            String[] parts = event.split(" ");

            if (parts[0].equals("ENTER")) {
                pq.add(new Student(
                    Integer.parseInt(parts[3]),
                    parts[1],
                    Double.parseDouble(parts[2])
                ));
            } else if (parts[0].equals("SERVED")) {
                if (!pq.isEmpty())
                    pq.poll();
            }
        }

        List<Student> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<String> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            events.add(sc.nextLine());
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }

        sc.close();
    }
}
