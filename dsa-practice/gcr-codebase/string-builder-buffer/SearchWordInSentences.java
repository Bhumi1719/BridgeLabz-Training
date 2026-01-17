import java.util.*;

public class SearchWordInSentences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] sentences = new String[n];

        System.out.println("Enter sentences:");
        for(int i=0; i<n; i++) {
            System.out.print("Enter the sentence " + (i+1) + ": ");
            sentences[i] = sc.nextLine();
        }

        System.out.print("\nEnter the word to search: ");
        String word = sc.nextLine();

        String result = "Not Found";

        for(String sentence : sentences) {
            if(sentence.contains(word)) {
                result = sentence;
                break;
            }
        }

        System.out.println("Result: " + result);
    }
}
