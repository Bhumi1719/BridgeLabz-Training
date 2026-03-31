import java.util.*;

public class NameUpperCase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int employees = sc.nextInt();
        sc.nextLine(); 

        for(int i=0; i<employees; i++) {
            System.out.print("Enter employee name " + (i + 1) + ": ");
            names.add(sc.nextLine());
        }

        System.out.println("\nEmployee Names in UPPERCASE:");
        // Use of Method Reference
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
