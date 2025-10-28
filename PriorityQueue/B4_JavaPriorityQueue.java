import java.util.*;
import java.util.PriorityQueue;

class Student {
    private double cgpa;
    private String name;
    private int token;

    public Student(double cgpa, String name, int token) {
        this.cgpa = cgpa;
        this.name = name;
        this.token = token;
    }

    public double getCgpa() { return cgpa; }
    public String getName() { return name; }
    public int getToken() { return token; }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        if (x.getCgpa() != y.getCgpa()) {
            return Double.compare(y.getCgpa(), x.getCgpa());
        }

        int nameCompare = x.getName().compareTo(y.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }

        return Integer.compare(x.getToken(), y.getToken());
    }
}

public class B4_JavaPriorityQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<Student> comparator = new StudentComparator();
        PriorityQueue<Student> pq = new PriorityQueue<>(10, comparator);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String command = scanner.next();
            if (command.equals("ENTER")) {
                String name = scanner.next();
                double cgpa = scanner.nextDouble();
                int token = scanner.nextInt();
                pq.add(new Student(cgpa, name, token));
            } else if (command.equals("SERVED")) {
                pq.poll();
            }
        }

        if (pq.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            while (!pq.isEmpty()) {
                Student s = pq.poll();
                System.out.println(s.getName());
            }
        }
        scanner.close();
    }
}
