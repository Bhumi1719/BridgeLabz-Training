import java.util.ArrayList;
import java.util.Scanner;

public class ReverseWords {
    
        public static String reverseWords(String s) {
        s = s.trim() ;
        int end = 0 ;
        String ans = "" ;
        String flag = "" ;
        ArrayList<String> ls = new ArrayList<>();
        while(end < s.length()){
            while(end < s.length() && s.charAt(end) != ' '){
                flag = flag + s.charAt(end);
                end++;
            }if(!flag.equals("")){
                ls.add(flag);
                flag = "" ;
            }
            end++ ;   
        }
        String res = "";
        int len = ls.size()-1;
        for(int i = len ; i > 0 ; i--){
            // System.out.println(ls.get(i));
            res += ls.get(i)+" ";
        }
        res +=ls.get(0);

        // System.out.println(res);
        return res ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = reverseWords(input);
        System.out.println("Reversed string is: " + result);    
    }
}
