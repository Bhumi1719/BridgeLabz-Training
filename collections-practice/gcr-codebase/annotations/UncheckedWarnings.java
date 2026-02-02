import java.util.ArrayList;
import java.util.Scanner;

public class UncheckedWarnings {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList list = new ArrayList();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for(int i=0; i<n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            String input = sc.nextLine();
            list.add(input); // This will uncheck warning suppressed
        }

        System.out.println("\nElements in ArrayList are:");
        for(Object obj : list) {
            System.out.println(obj);
        }
    }
}

