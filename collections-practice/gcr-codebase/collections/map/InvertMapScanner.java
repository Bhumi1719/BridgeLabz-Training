import java.util.*;

public class InvertMapScanner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> inputMap = new HashMap<>();

        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.print("Enter key: ");
            String key = sc.next();

            System.out.print("Enter value: ");
            int value = sc.nextInt();

            inputMap.put(key, value);
        }

        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for(Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        System.out.println("Inverted Map:");
        System.out.println(invertedMap);

    }
}
