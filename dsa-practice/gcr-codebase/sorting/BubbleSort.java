import java.util.*;

class BubbleSort {

    public static void bubbleSort(int[] marks) {
        final int SIZE = marks.length;
        boolean swapped;

        for(int i=0; i<SIZE - 1; i++) {
            swapped = false;
            for(int j=0; j<SIZE - i - 1; j++) {
                if(marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break; // Stop if no swaps occurred
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int students = sc.nextInt();

        int[] marks = new int[students];

        System.out.print("Enter the marks of students: ");
        for(int i=0; i<students; i++) {
            marks[i] = sc.nextInt();
        }

        bubbleSort(marks);
        System.out.println("Marks of each student in ascending order are: " + Arrays.toString(marks));
    }
}