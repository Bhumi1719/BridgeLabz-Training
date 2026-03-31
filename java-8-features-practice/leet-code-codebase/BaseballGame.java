import java.util.Scanner;

public class BaseballGame {
    public static int calPoints(String[] operations) {

        int[] stack = new int[operations.length];
        int stackPointer = 0;

        for(String operation : operations) {
            switch (operation) {
                case "C" :
                    stackPointer--;
                    break;

                case "D" :
                    stack[stackPointer++] = stack[stackPointer - 2] << 1;
                    break;

                case "+" :
                    stack[stackPointer++] = stack[stackPointer - 2] + stack[stackPointer - 3];
                    break;  

                default :
                    stack[stackPointer++] = Integer.parseInt(operation);
            }
        }

        int totalSum = 0;

        for(int i=0; i<stackPointer; i++) {
            totalSum += stack[i];
        }

        return totalSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of operations: ");
        int n = sc.nextInt();

        String[] operations = new String[n];
        System.out.println("Enter the operations:");
        for(int i=0; i<n; i++) {
            operations[i] = sc.next();
        }
        
        int result = calPoints(operations);
        System.out.println("Total points: " + result);
    }
}
