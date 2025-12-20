import java.util.*;

public class MeanHeight {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // Declaring an array of size 11 for taking height of the the players
        double[] height = new double[11];

        // Taking variable sum to keep track of the sum of elements
        int SUM = 0;

        System.out.print("Enter the height of the players: ");
        // Taking user input of heights 
        for(int i=0; i<height.length; i++){
            height[i] = sc.nextDouble();
        }

        // Finding and storing the sum of all elements
        for(int i=0; i<height.length; i++){
            SUM += height[i];
        }

        // Finding the mean of heights of all players
        double mean = SUM / 11;
        System.out.println("Mean height of the football team is " + mean);
    }
}