import java.util.*;
import java.util.PriorityQueue;

class Student {
    private double cgpa;
    private String name;
    private int id;

    public Student(double cgpa, String name, int id) {
        this.cgpa = cgpa;
        this.name = name;
        this.id = id;
    }

    public double getCgpa() { return cgpa; }
    public String getName() { return name; }
    public int getId() { return id; }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        if (x.getCgpa() != y.getCgpa()) {
            if(x.getCgpa() > y.getCgpa()) return -1;
            return 1;
        }

        if(!x.getName().equals(y.getName())) {
            return x.getName().compareTo(y.getName());
        }
        return x.getId() - y.getId();
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
                int id = scanner.nextInt();
                pq.add(new Student(cgpa, name, id));
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