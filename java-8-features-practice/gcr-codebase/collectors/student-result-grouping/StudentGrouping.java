import java.util.*;
import java.util.stream.Collectors;

public class StudentGrouping {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int number = sc.nextInt();
        sc.nextLine();

        for(int i=1; i<=number; i++) {

            System.out.println("\nStudent " + i);

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter grade: ");
            String grade = sc.nextLine();

            students.add(new Student(name, grade));
        }

        Map<String, List<String>> groupedStudents = students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.mapping(Student::getName, Collectors.toList())
                        ));

        System.out.println("\nStudents Grouped By Grade");

        groupedStudents.forEach((grade, names) -> System.out.println("Grade " + grade + " -> " + names));


        // Counting students per grade
        Map<String, Long> count = students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.counting()
                        ));

        System.out.println("\nStudent Count Per Grade");
        count.forEach((grade, total) -> System.out.println("Grade " + grade + " : " + total));

    }
}
