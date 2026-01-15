import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {

    public static void heapify(int[] salary, int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(left < size && salary[left] > salary[largest])
            largest = left;

        if(right < size && salary[right] > salary[largest])
            largest = right;

        if(largest != index) {
            int temp = salary[index];
            salary[index] = salary[largest];
            salary[largest] = temp;

            heapify(salary, size, largest);
        }
    }

    public static void heapSort(int[] salary) {
        int SIZE = salary.length;

        // Loop for building Max Heap
        for(int i=(SIZE / 2) - 1; i>=0; i--)
            heapify(salary, SIZE, i);

        // Loop for extractinig elements one by one
        for(int i=SIZE - 1; i>0; i--) {
            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;

            heapify(salary, i, 0);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of job applications: ");
        int applications = sc.nextInt();

        int[] salary = new int[applications];

        System.out.print("Enter the salary for each job application: ");
        for(int i=0; i<applications; i++) {
            salary[i] = sc.nextInt();
        }

        heapSort(salary);
        System.out.print("The salary for each job application in ascending order is: " + Arrays.toString(salary));
    }
}
