import java.util.*;

public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbours = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    islands++; 
                    if(i < grid.length - 1 && grid[i + 1][j] == 1) {
                        neighbours++; // count down neighbours
                    }

                    if(j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        neighbours++; // count right neighbours
                    }
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the rows of the array: ");
        int rows = sc.nextInt();

        System.out.print("Enter the columns of the array: ");
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        System.out.println("Enter the elements of the array:");
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int perimeter = islandPerimeter(grid);
        System.out.println("The perimeter of the island is: " + perimeter);
    }
}
