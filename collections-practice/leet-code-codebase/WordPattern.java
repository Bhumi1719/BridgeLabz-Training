import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        if(pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashSet<String> seenWords = new HashSet<>();

        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if(charToWord.containsKey(c)) {
                if(!charToWord.get(c).equals(w)) {
                    return false;
                }
            } else {
                if(seenWords.contains(w)) {
                    return false;
                }
                charToWord.put(c, w);
                seenWords.add(w);}}
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine();

        System.out.print("Enter string: ");
        String s = scanner.nextLine();
        boolean result = wordPattern(pattern, s);
        System.out.println("Does the string follow the pattern? " + result);
    }
}