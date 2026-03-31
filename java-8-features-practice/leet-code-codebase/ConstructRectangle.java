import java.util.Scanner;

public class ConstructRectangle {
    public static int[] constructRectangle(int area) {
        int i = (int) Math.sqrt(area);
        while(i >= 1 && area % i != 0) {
            i--;
        }

        return new int[] { area / i, i };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the area of rectangle: ");
        int area = sc.nextInt();

        int[] parameter = constructRectangle(area);

        System.out.print("The length and width of rectangle with given area is: ");
        for(int i : parameter) {
            System.out.print(i + " ");
        }
    }
}