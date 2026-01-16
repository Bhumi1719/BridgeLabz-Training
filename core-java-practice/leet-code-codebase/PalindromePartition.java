import java.util.Scanner;

public class PalindromePartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String str = sc.next();

        part(str, ""); // Start palindrome partitioning
    }

    //Recursive function to generate palindrome partitions
    public static void part(String str, String ans){

	//Base case:if string becomes empty
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

	//Trying all possible prefixes and if prefix is palindrome then recurse for remaining string
        for(int i=1; i<=str.length(); i++){
            String p = str.substring(0, i);
            String r = str.substring(i);
            if(palin(p)){
                part(r, ans+p+"|");
            }
        }
    }

    //Method to check palidrome
    public static boolean palin(String str){
        int p1 = 0 ;
        int p2 = str.length()-1;
        while(p1<p2){
            if(str.charAt(p1) != str.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
