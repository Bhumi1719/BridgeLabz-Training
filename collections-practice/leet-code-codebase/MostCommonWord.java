import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String low = paragraph.toLowerCase();
        
        String[] words = low.split("[^a-z]+");        
        String res = "";

        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words) {
            if(word.isEmpty()) {
                continue; 
            }
            
            boolean isBanned = false;
            for(String bannedWord : banned) {
                if(word.equals(bannedWord)) {
                    isBanned = true;
                    break;
                }
            }
            
            if(!isBanned) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        int maxCount = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the paragraph: ");
        String para = sc.nextLine();

        System.out.print("Enter the size of banned words: ");
        int size = sc.nextInt();
        sc.nextLine();

        String[] banned = new String[size];

        System.out.println("Enter the banned words: ");
        for(int i=0; i<size; i++) {
            banned[i] = sc.nextLine();
        }

        System.out.print("The most frequent word that is not banned is: " + mostCommonWord(para, banned));
    }
}

