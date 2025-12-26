import java.util.*;

class Determinant {
    public static void main(String[] args) {
        System.out.println("Matrix is:");
        double[][] matrix = createMatrix(2, 2); // Calling the method to generate random matrix
        printMatrix(matrix); // Calling the method to display the matrix

        System.out.println("\nTranspose of matrix is:");
        printMatrix(findTranspose(matrix)); // Calling the method to find transpose of matrix

        double det2 = determinant2x2(matrix);
        System.out.println("\nDeterminant: " + det2);

        System.out.println("\nInverse:");
        double[][] inv2 = inverse2x2(matrix);
        if (inv2 != null)
            printMatrix(inv2);
        else
            System.out.println("Inverse not possible");

        System.out.println("\n---------------------------");

        System.out.println("3x3 Matrix:");
        double[][] m3 = createMatrix(3, 3);
        printMatrix(m3);

        System.out.println("\nTranspose:");
        printMatrix(findTranspose(m3));

        double det3 = determinant3x3(m3);
        System.out.println("\nDeterminant: " + det3);

        System.out.println("\nInverse:");
        double[][] inv3 = inverse3x3(m3);
        if (inv3 != null)
            printMatrix(inv3);
        else
            System.out.println("Inverse not possible");
    }

    // Method for creating a random matrix
    public static double[][] createMatrix(int rows, int cols) {
        // Creating a matrix to store the result
        double[][] matrix = new double[rows][cols];
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

    // Transpose of matrix
    public static double[][] findTranspose(double[][] m) {
        double[][] t = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                t[j][i] = m[i][j];
        return t;
    }

    // Determinant of 2x2 matrix
    public static double determinant2x2(double[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }

    // Determinant of 3x3 matrix
    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1]) - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0]) + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    // Inverse of 2x2 matrix
    public static double[][] inverse2x2(double[][] matrix) {
        double det = determinant2x2(matrix);
        if (det == 0) return null;

        double[][] inverse = new double[2][2];
        inverse[0][0] =  matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] =  matrix[0][0] / det;

        return inverse;
    }

    // Inverse of 3x3 matrix
    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;

        double[][] inverse = new double[3][3];

        inverse[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inverse[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / det;
        inverse[0][2] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;

        inverse[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / det;
        inverse[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inverse[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / det;

        inverse[2][0] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inverse[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / det;
        inverse[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;

        return inverse;
    }

    // Printing the matrix
    public static void printMatrix(double[][] matrix) {
        for(double[] row : matrix) {
            for(double value : row) {
                System.out.printf("%.2f\t", value);
            }
            System.out.println();
        }
    }
}
