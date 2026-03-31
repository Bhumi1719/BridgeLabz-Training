import java.util.*;

public class FrequencyCounter {

    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> freqMap = new HashMap<>();

        for(String item : list) {
            if(freqMap.containsKey(item)) {
                freqMap.put(item, freqMap.get(item) + 1);
            } else {
                freqMap.put(item, 1);
            }
        }
        return freqMap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();

        List<String> list = new ArrayList<>();

        System.out.print("Enter the strings: ");
        for(int i=0; i<n; i++) {
            list.add(sc.next());
        }

        Map<String, Integer> result = findFrequency(list);

        System.out.println("Frequency Map: " + result);
    }
}
