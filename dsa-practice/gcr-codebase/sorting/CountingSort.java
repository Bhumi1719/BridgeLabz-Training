import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    
    public static void countingSort(int[] ages) {
        int MIN_AGE = 10;
        int MAX_AGE = 18;
        int range = MAX_AGE - MIN_AGE + 1;

        int[] count = new int[range];

        // Loop for counting frequencies
        for(int age : ages) {
            count[age - MIN_AGE]++;
        }

        // Build sorted array
        int INDEX = 0;
        for(int i=0; i<range; i++) {
            while(count[i] > 0) {
                ages[INDEX++] = i + MIN_AGE;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int students = sc.nextInt();

        int[] ages = new int[students];

        System.out.println("Enter student ages (10 to 18):");
        for(int i=0; i<students; i++) {
            ages[i] = sc.nextInt();
        }

        countingSort(ages);

        System.out.print("Sorted ages in ascending order are: " + Arrays.toString(ages));
    }
}
