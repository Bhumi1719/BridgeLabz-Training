import java.util.*;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix1 = createMatrix(rows, cols); // Calling the method to generate random matrix and storing it in matrix1
        int[][] matrix2 = createMatrix(rows, cols); // Calling the method to generate random matrix and storing it in matrix2

        System.out.println("Matrix 1:");
        printMatrix(matrix1); // Calling the method to display the matrix

        System.out.println("\nMatrix 2:");
        printMatrix(matrix2); // Calling the method to display the matrix

        System.out.println("\nAddition of matrices(A + B):");
        printMatrix(addMatrices(matrix1, matrix2)); // Calling the method to add and then display the matrix

        System.out.println("\nSubtraction of matrices(A - B):");
        printMatrix(subtractMatrices(matrix1, matrix2)); // Calling the method to subtract and then dispaly the matrix

        System.out.println("\nMultiplication of matrices(A x B):"); 
        printMatrix(multiplyMatrices(matrix1, matrix2)); // Calling the method to multiply and then display the matrix
    }

    // Method for creating a random matrix
    public static int[][] createMatrix(int rows, int cols) {
        // Creating a matrix to store the result
        int[][] matrix = new int[rows][cols];
        // Creating an object of the random
        Random random = new Random();

        // Loop for geneating the random matrix
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                matrix[i][j] = random.nextInt(10); 
            }
        }

        return matrix; // Returning the matrix
    }

    // Method for adding two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int ROWS = a.length;
        int COLS = a[0].length;

        // Creating a 2D array to store the addition of two matrices
        int[][] result = new int[ROWS][COLS];

        // Loop for adding the two matrices
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result; // Returning the resultant matrix
    }

    // Method for subtracting two matrices
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int ROWS = a.length;
        int COLS = a[0].length;

        // Creating a 2D array to store the subtraction of two matrices
        int[][] result = new int[ROWS][COLS];

        // Loop for subtracting the two matrices
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }

        return result; // REturning the resultant matrix
    }

    // Method for multiplying two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int ROWS = a.length;
        int COLS = b[0].length;
        int COMMON = b.length;

        // Creating a 2D array to store the multiplication of two matrices
        int[][] result = new int[ROWS][COLS];

        // Loop for multiplying the two arrays
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                for(int k=0; k<COMMON; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result; // Returning the resultant matrix
    }

    // Method for printing the matrix
    public static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for(int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
