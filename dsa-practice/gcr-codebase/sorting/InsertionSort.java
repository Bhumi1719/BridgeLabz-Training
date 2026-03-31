import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    
    public static void insertionSort(int[] employee) {
        int SIZE = employee.length;
        for(int i=1; i<SIZE; i++) {
            int key = employee[i];
            int j = i - 1;
            // Moving elements that are greater than key to one position ahead
            while(j >= 0 && employee[j] > key) {
                employee[j + 1] = employee[j];
                j--;
            }
            employee[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of emplyees: ");
        int employee = sc.nextInt();

        int[] employeeId = new int[employee];

        System.out.print("Enter the IDs of employees: ");
        for(int i=0; i<employee; i++) {
            employeeId[i] = sc.nextInt();
        }

        insertionSort(employeeId);
        System.out.print("Employees IDs in ascending order are: " + Arrays.toString(employeeId));
    }
}
