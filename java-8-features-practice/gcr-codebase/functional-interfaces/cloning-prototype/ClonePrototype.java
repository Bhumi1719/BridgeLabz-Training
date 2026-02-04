import java.util.Scanner;

public class ClonePrototype {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            Student original = new Student(id, name);

            // Cloning object
            Student cloned = (Student) original.clone();

            System.out.println("\nOriginal Object:");
            original.display();

            System.out.println("Cloned Object:");
            cloned.display();

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported!");
        }
    }
}