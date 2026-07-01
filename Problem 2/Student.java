import java.util.Scanner;

public class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        if (marks == null || marks.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter number of marks: ");
        int count = 0;
        if (scanner.hasNextInt()) {
            count = scanner.nextInt();
            scanner.nextLine();
        }

        int[] marks = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter mark " + (i + 1) + ": ");
            if (scanner.hasNextInt()) {
                marks[i] = scanner.nextInt();
            } else {
                marks[i] = 0;
                scanner.next();
            }
        }

        Student student = new Student(name, marks);
        System.out.println("Average score: " + student.calculateAverage());

        scanner.close();
    }
}
