import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    
    public static void selectionSort(int[] marks) {
        for(int i=0; i<marks.length - 1; i++) {
            int minIndex = i;

            // Loop for finding minimum in unsorted part
            for(int j=i + 1; j<marks.length; j++) {
                if(marks[j] < marks[minIndex]) {
                    minIndex = j;
                }
            }

            // Swapping the elements
            int temp = marks[minIndex];
            marks[minIndex] = marks[i];
            marks[i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int students = sc.nextInt();

        int[] marks = new int[students];

        System.out.print("Enter the marks of each student: ");
        for(int i=0; i<students; i++) {
            marks[i] = sc.nextInt();
        }

        selectionSort(marks);
        System.out.print("The marks of each student in ascending order are: " + Arrays.toString(marks));
    }
}
