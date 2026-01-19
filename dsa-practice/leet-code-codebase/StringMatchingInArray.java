import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatchingInArray {
    
    public static List<String> stringMatching(String[] words) {
        List<String> ls = new ArrayList<>();
        for(int i=0; i<words.length ; i++){
            String str = words[i] ;
            for(int j=0; j<words.length ; j++){
                String check = words[j] ;
                if(j != i){
                    if(str.contains(check)){
                        if(!ls.contains(check)){
                            ls.add(check);
                        }
                    }
                }
            }
        }
        return ls ; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of words: ");
        int word = sc.nextInt();

        String[] words = new String[word];

        System.out.print("Enter the words: ");
        for(int i=0; i<word ; i++){
            words[i] = sc.next();
        }

        List<String> result = stringMatching(words);
        System.out.println("Matching substrings are: " + result);
    }
}
