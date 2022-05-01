package queue.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
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

    private final PriorityQueue<Student> queue = new PriorityQueue<>(
        Comparator.comparing(Student::getCGPA)
            .reversed()
            .thenComparing(Student::getName)
            .thenComparing(Student::getId));

    public List<Student> getStudents(List<String> events) {
        events.forEach((event) -> {
            if (event.equals("SERVED")) {
                queue.poll();
            }
            else {
                String[] details = event.split(" ");

                queue.add(new Student(Integer.parseInt(details[3]), details[1], Double.parseDouble(details[2])));
            }
        });

        List<Student> students = new ArrayList<>();
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }

        return students;
    }
}

public class StudentGradesPriorityQueue {

    public static void main(String[] args) {
    }
}
