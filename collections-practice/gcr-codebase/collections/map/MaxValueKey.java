import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxValueKey {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.print("Enter key: ");
            String key = sc.next();

            System.out.print("Enter value: ");
            int value = sc.nextInt();

            map.put(key, value);
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        if(maxKey != null) {
            System.out.println("Key with highest value: " + maxKey);
        } else {
            System.out.println("Map is empty");
        }
    }
}
