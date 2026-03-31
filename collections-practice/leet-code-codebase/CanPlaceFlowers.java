import java.util.*;

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) {
            return true;
        }
        for(int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if(n == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] flowerBed = new int[size];

        System.out.print("Enter the elements in the array: ");
        for(int i=0; i<size; i++) {
            flowerBed[i] = sc.nextInt();
        }

        System.out.print("Enter the number of new flowers: ");
        int flowers = sc.nextInt();
        
        System.out.print("Can new flowers be painted in flowerbed? " + canPlaceFlowers(flowerBed, flowers));
    }
}
