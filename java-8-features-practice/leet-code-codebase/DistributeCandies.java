import java.util.*;

public class DistributeCandies {
    public static int[] distributeCandies(int candies, int num_people) {
        int ans[] = new int[num_people];
        int i = 1;
        int pos = 0;
        while(candies > 0) {
            ans[pos++] += candies >= i ? i : candies;
            candies -= i;
            i++;

            pos %= num_people;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candies: ");
        int candies = sc.nextInt();

        System.out.print("Enter number of people: ");
        int people = sc.nextInt();

        int[] res = distributeCandies(candies, people);

        System.out.print("Final distribtuion of candies is: ");
        for(int candy : res) {
            System.out.print(candy + " ");
        }
    }
}
