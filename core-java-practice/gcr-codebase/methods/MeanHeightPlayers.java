public class MeanHeightPlayers {
    public static void main(String[] args) {
        // Creating an array to store the generated heights
        int[] heights = generateHeightOfPlayers(11); // Calling the method to generate the heights randomly

        // Displaying the heights generated
        System.out.println("\nHeights of players in cm are:");
        for(int height : heights) {
            System.out.print(height + " ");
        }

        System.out.println("\n\nShortest Height among all players is: " + findShortestHeight(heights) + " cm");
        System.out.println("\nTallest Height among all players is: " + findTallestHeight(heights) + " cm");
        System.out.println("\nMean Height of all the players is: " + findMeanHeight(heights) + " cm");
    }

    // Method for generating random heights between 150–250
    public static int[] generateHeightOfPlayers(int size) {
        // Creating an integer array to store the heights
        int[] heights = new int[size];

        // Loop for generating random numbers
        for(int i=0; i<size; i++) {
            heights[i] = (int) (Math.random() * 101) + 150; // 150 to 250
        }

        return heights; // Returning array with heights
    }

    // Method for finding the sum of heights of players
    public static int findSumHeights(int[] heights) {
        // Variable to store the sum of heights of the players
        int SUM = 0;

        // Loop to add heights of eqach player
        for(int height : heights) {
            SUM += height;
        }

        return SUM; // Returning the sum of heights
    }

    // Method for finding the mean height
    public static double findMeanHeight(int[] heights) {
        double mean = (findSumHeights(heights) / heights.length); // Calling the method to find the the sum and calculating mean
        return mean; // Returning the calculated mean
    }

    // Method for finding the shortest height among all players
    public static int findShortestHeight(int[] heights) {
        // Variable to store the minimum height initialized to height of player at index 0
        int MIN_HEIGHT = heights[0];

        // Loop for finding the minimum height
        for(int height : heights) {
            if(height < MIN_HEIGHT) {
                MIN_HEIGHT = height;
            }
        }

        return MIN_HEIGHT; // Returning the shortest height
    }

    // Method for finding the tallest height among all players
    public static int findTallestHeight(int[] heights) {
        // Variable to store the maximum height initialized to height of the player at index 0
        int MAX_HEIGHT = heights[0];

        // Loop to find the tallest height
        for(int height : heights) {
            if(height > MAX_HEIGHT) {
                MAX_HEIGHT = height;
            }
        }

        return MAX_HEIGHT; // Returning the tallest height
    }
}
