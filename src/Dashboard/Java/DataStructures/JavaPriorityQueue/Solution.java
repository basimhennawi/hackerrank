import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

class Student {
    private int token;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getToken() {
        return token;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        PriorityQueue<Student> q = new PriorityQueue<Student>(1000, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getCgpa() != s2.getCgpa()) {
                    return Double.compare(s2.getCgpa(), s1.getCgpa());
                } else if (s1.getFname() != s2.getFname()) {
                    return s1.getFname().compareTo(s2.getFname());
                } else {
                    return (int) (s1.getToken() - s2.getToken());
                }
            }
        });
        while (totalEvents > 0) {
            String event = in.next();
            switch (event) {
                case "ENTER": {
                    String name = in.next();
                    double cgpa = in.nextDouble();
                    int id = in.nextInt();
                    q.add(new Student(id, name, cgpa));
                    break;
                }
                case "SERVED": {
                    q.poll();
                    break;
                }
                default:
            }
            totalEvents--;
        }
        if (q.size() > 0) while (q.size() > 0) System.out.println(q.poll().getFname());
        else System.out.println("EMPTY");
    }
}
