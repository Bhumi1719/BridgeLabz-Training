import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MergeTwoMaps {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        System.out.print("Enter number of entries for Map1: ");
        int n1 = sc.nextInt();

        for(int i=0; i<n1; i++) {
            System.out.print("Enter key: ");
            String key = sc.next();

            System.out.print("Enter value: ");
            int value = sc.nextInt();
            map1.put(key, value);
        }

        System.out.print("\nEnter number of entries for Map2: ");
        int n2 = sc.nextInt();

        for(int i=0; i<n2; i++) {
            System.out.print("Enter key: ");
            String key = sc.next();

            System.out.print("Enter value: ");
            int value = sc.nextInt();
            map2.put(key, value);
        }

        Map<String, Integer> mergedMap = new HashMap<>(map1);

        for(Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.put(entry.getKey(), mergedMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        System.out.println("\nMerged Map:");
        System.out.println(mergedMap);
    }
}
