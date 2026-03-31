import java.util.Scanner;

public class FrequencyArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        // Declaring frequency array to store the frequency of elements
        int[] frequency = new int[10];

        // Looping to find the frequency of each element
        while(number != 0) {
            frequency[number % 10] ++;
            number /= 10;
        }

        // Displaying the frequency array
        for (int i=0; i< 10; i++) {
            if(frequency[i] != 0) // Condition to display only the frequency of digits in number
                System.out.println(i + " occurs " + frequency[i] + " times");
        }
    }
}
