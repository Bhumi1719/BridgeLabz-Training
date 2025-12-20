import java.util.*;

public class MultidimensionalArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for rows
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        // Taking user input for columns
        System.out.print("Enter the number of columns: ");
        int cols = sc.nextInt();

        // Declaring 1D array for copying elements of 2D array
        int[] arr = new int[rows*cols];

        // Initializing index to 0 for 1D array to copy elements
        int INDEX = 0;

        // Declaring 2D array of size row and column
        int[][] multiArray = new int[rows][cols];

        System.out.println("Enter the elements of 2D array: ");
        // Taking user input for 2D array
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                multiArray[i][j] = sc.nextInt();
            }
        }

        // Uding two for loops for copying elements of 2D array into 1D array
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                arr[INDEX] = multiArray[i][j];
                INDEX ++; // Increamenting index by 1
            }
        }

        System.out.print("The elements are: ");
        // For loop for printing the 1D array
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}