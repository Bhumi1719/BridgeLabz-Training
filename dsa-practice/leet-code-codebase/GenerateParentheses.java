import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {

    public static void parenth(int n, int open, int close, String ans, List<String>arrayList){
        if(open == n && close == n){
            arrayList.add(ans);
            return;
        }

        if(open < n){
            parenth(n, open+1, close, ans+"(", arrayList);
        }
        if(close < open){
            parenth(n, open, close+1, ans+")", arrayList);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of pairs of parentheses: ");
        int n = sc.nextInt();
        
        List<String>arrayList = new ArrayList<>();
        String ans = "";
        parenth(n, 0, 0, ans, arrayList);

        System.out.println("All combinations of well-formed parentheses:");
        for(String s : arrayList){
            System.out.println(s);
        }
    }
}
