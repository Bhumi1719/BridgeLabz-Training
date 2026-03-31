import java.util.*;

public class UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] arr={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<Character,String> map=new HashMap<>();
        int k=0;

        for(char i='a'; i<='z'; i++){
            map.put(i,arr[k]);
            k++;
        }

        Set<String> set1=new HashSet<>();

        for(int i=0;i<words.length;i++){
            String s="";
            for(int j=0; j<words[i].length(); j++){
                char c=words[i].charAt(j);
                s+=map.get(c)+"";
            } 

            set1.add(s);
        }

        return set1.size();
    }

    public static void main(String []args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the number of words: ");
        int n=sc.nextInt();

        String []words=new String[n];
        System.out.println("Enter the words:");
        for(int i=0; i<n; i++){
            words[i]=sc.next();
        }

        int result=uniqueMorseRepresentations(words);
        System.out.println("Number of unique Morse code representations: " + result);
    }
}